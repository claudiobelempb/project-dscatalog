package br.com.surb.dscatalog.config;

import br.com.surb.dscatalog.components.JwtTokenEnhancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

  @Value("${security.oauth2.client.client-id}")
  private String clientId;

  @Value("${security.oauth2.client.client-secret}")
  private String clientSecret;

  @Value("${jwt.duration}")
  private Integer jwtDuration;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Autowired
  private JwtAccessTokenConverter jwtAccessTokenConverter;

  @Autowired
  private JwtTokenStore jwtTokenStore;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenEnhancer jwtTokenEnhancer;

  @Override
  public void configure(AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer) throws Exception {
    authorizationServerSecurityConfigurer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clientDetailsServiceConfigurer) throws Exception {
    clientDetailsServiceConfigurer
      .inMemory()
      .withClient(clientId)
      .secret(passwordEncoder.encode(clientSecret))
      .scopes("read", "write")
      .authorizedGrantTypes("password")
      .accessTokenValiditySeconds(jwtDuration);
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer authorizationServerEndpointsConfigurer) throws Exception {

    TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();

    tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtAccessTokenConverter, jwtTokenEnhancer));

    authorizationServerEndpointsConfigurer
      .authenticationManager(authenticationManager)
      .tokenStore(jwtTokenStore)
      .accessTokenConverter(jwtAccessTokenConverter)
      .tokenEnhancer(tokenEnhancerChain);
  }
}

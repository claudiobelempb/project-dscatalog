package br.com.surb.dscatalog.services;

import br.com.surb.dscatalog.repositories.ProductRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ProductServiceTests {

  @InjectMocks
  private ProductService productService;

  @Mock
  private ProductRepository productRepository;

  
}

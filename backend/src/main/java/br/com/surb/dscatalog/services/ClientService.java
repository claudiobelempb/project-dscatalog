package br.com.surb.dscatalog.services;

import br.com.surb.dscatalog.dto.ClientDTO;
import br.com.surb.dscatalog.entities.Client;
import br.com.surb.dscatalog.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

  @Autowired
  private ClientRepository repository;

  @Transactional(readOnly = true)
  public List<ClientDTO> index(){
    List<Client> cliets = repository.findAll();
    return cliets.stream().map(client -> new ClientDTO(client)).collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public ClientDTO show(Long id){
    Optional<Client> obj = repository.findById(id);
    Client client = obj.get();
    return new ClientDTO(client);
  }

}

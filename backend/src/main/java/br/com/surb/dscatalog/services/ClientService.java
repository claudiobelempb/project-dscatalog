package br.com.surb.dscatalog.services;

import br.com.surb.dscatalog.dto.ClientDTO;
import br.com.surb.dscatalog.entities.Client;
import br.com.surb.dscatalog.repositories.ClientRepository;
import br.com.surb.dscatalog.services.exceptions.DataBaseException;
import br.com.surb.dscatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  @Transactional(readOnly = true)
  public Page<ClientDTO> index(PageRequest pageRequest){
    Page<Client> cliets = clientRepository.findAll(pageRequest);
    return cliets.map(client -> new ClientDTO(client));
  }

  @Transactional(readOnly = true)
  public ClientDTO show(Long id){
    Optional<Client> obj = clientRepository.findById(id);
    Client client = obj.orElseThrow(() -> new ResourceNotFoundException("Client not found"));
    return new ClientDTO(client);
  }

  @Transactional
  public ClientDTO create(ClientDTO clientDTO) {
    Client client = new Client();
    client.setName(clientDTO.getName());
    client.setCpf(clientDTO.getCpf());
    client.setIncome(clientDTO.getIncome());
    client.setBirthDate(clientDTO.getBirthDate());
    client.setChildren(clientDTO.getChildren());
    client = clientRepository.save(client);
    return new ClientDTO(client);
  }

  @Transactional
  public ClientDTO update(Long id, ClientDTO clientDTO) {
    try {
      Client client = clientRepository.getOne(id);
      client.setName(clientDTO.getName());
      client.setCpf(clientDTO.getCpf());
      client.setIncome(clientDTO.getIncome());
      client.setBirthDate(clientDTO.getBirthDate());
      client.setChildren(clientDTO.getChildren());
      client = clientRepository.save(client);
      return new ClientDTO(client);
    }catch (EntityNotFoundException e) {
      throw new DataBaseException("Id not found" + id);
    }
  }

  public void delete(Long id) {
    try {
      clientRepository.deleteById(id);
    } catch (EmptyResultDataAccessException e){
      throw new ResourceNotFoundException("Id not found" + id);
    } catch (DataIntegrityViolationException e) {
      throw new DataBaseException("Integrity violation");
    }
  }

}

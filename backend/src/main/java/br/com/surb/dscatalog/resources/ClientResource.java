package br.com.surb.dscatalog.resources;

import br.com.surb.dscatalog.dto.ClientDTO;
import br.com.surb.dscatalog.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

  @Autowired
  private ClientService service;

  @GetMapping
  public ResponseEntity<List<ClientDTO>> index(){
    List<ClientDTO> clients = service.index();
    System.out.println(clients);
    return ResponseEntity.ok().body(clients);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<ClientDTO> show(@PathVariable Long id) {
    ClientDTO client = service.show(id);
    return ResponseEntity.ok().body(client);
  }
}

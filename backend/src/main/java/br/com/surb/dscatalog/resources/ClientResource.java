package br.com.surb.dscatalog.resources;

import br.com.surb.dscatalog.dto.ClientDTO;
import br.com.surb.dscatalog.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

  @Autowired
  private ClientService clientService;

  @GetMapping
  public ResponseEntity<Page<ClientDTO>> index(Pageable pageable){
    Page<ClientDTO> clientDTOS = clientService.index(pageable);
    System.out.println(clientDTOS);
    return ResponseEntity.ok().body(clientDTOS);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<ClientDTO> show(@PathVariable Long id) {
    ClientDTO clientDTO = clientService.show(id);
    return ResponseEntity.ok().body(clientDTO);
  }

  @PostMapping
  public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO clientDTO){
    clientDTO = clientService.create(clientDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(clientDTO.getId()).toUri();
    return ResponseEntity.created(uri).body(clientDTO);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<ClientDTO> update(@Valid @PathVariable Long id, @RequestBody ClientDTO clientDTO) {
    clientDTO = clientService.update(id, clientDTO);
    return ResponseEntity.ok().body(clientDTO);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    clientService.delete(id);
    return ResponseEntity.noContent().build();
  }

}

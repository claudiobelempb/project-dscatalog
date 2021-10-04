package br.com.surb.dscatalog.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.surb.dscatalog.Factory;
import br.com.surb.dscatalog.dto.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ProductResourceIT {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  private Long existingId;
  private Long nonExistingId;
  private Long countTotalProducts;
  private ProductDTO productDTO;

  @BeforeEach
  void setUp() throws Exception {
    existingId = 1L;
    nonExistingId = 1000L;
    countTotalProducts = 25L;

    productDTO = Factory.createProductDTO();
  }

  /*o index deve retornar uma página ordenada por nome*/
  @Test
  public void indexShouldReturnSortedPageWhenSortByName() throws Exception{

    ResultActions resultActions =
      mockMvc.perform(get("/products?page=0&size=12&sort=name,asc", existingId)
        .accept(MediaType.APPLICATION_JSON));
      resultActions.andExpect(status().isOk());

      resultActions.andExpect(jsonPath("$.totalElements").value(countTotalProducts));
      resultActions.andExpect(jsonPath("$.content").exists());

      resultActions.andExpect(jsonPath("$.content[0].name").value("Macbook Pro"));
      resultActions.andExpect(jsonPath("$.content[1].name").value("PC Gamer"));
      resultActions.andExpect(jsonPath("$.content[2].name").value("PC Gamer Alfa"));
  }

  /*o update deve retornar um productDTO quando id existir*/
  @Test
  public void updateShouldReturnProductDTOWhenIdExists() throws Exception{

    String jsonBody = objectMapper.writeValueAsString(productDTO);

    String expectedName = productDTO.getName();
    String expectedDescription = productDTO.getDescription();

    ResultActions resultActions =
      mockMvc.perform(put("/products/{id}", existingId)
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON));

    resultActions.andExpect(status().isOk());
    resultActions.andExpect(jsonPath("$.id").value(existingId));
    resultActions.andExpect(jsonPath("$.name").value(expectedName));
    resultActions.andExpect(jsonPath("$.description").value(expectedDescription));
  }

  /*o update deve retornar um productDTO quando id não existir*/
  @Test
  public void updateShouldReturnNotFoundWhenIdDoesNotExists() throws Exception{

    String jsonBody = objectMapper.writeValueAsString(productDTO);

    String expectedName = productDTO.getName();
    String expectedDescription = productDTO.getDescription();

    ResultActions resultActions =
      mockMvc.perform(put("/products/{id}", nonExistingId)
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON));

    resultActions.andExpect(status().isNotFound());

  }

}

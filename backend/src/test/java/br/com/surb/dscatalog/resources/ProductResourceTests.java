package br.com.surb.dscatalog.resources;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.surb.dscatalog.Factory;
import br.com.surb.dscatalog.dto.ProductDTO;
import br.com.surb.dscatalog.entities.Product;
import br.com.surb.dscatalog.services.ProductService;
import br.com.surb.dscatalog.services.exceptions.DataBaseException;
import br.com.surb.dscatalog.services.exceptions.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

@WebMvcTest(ProductResource.class)
public class ProductResourceTests {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ProductService productService;

  @Autowired
  private ObjectMapper objectMapper;

  private long existingId;
  private long nonExistingId;
  private long dependentId;
  private PageImpl<ProductDTO> page;
  private Product product;
  private ProductDTO productDTO;

  @BeforeEach
  void setUp() throws Exception {

    existingId = 1L;
    nonExistingId = 2L;
    dependentId = 3L;
    productDTO = Factory.createProductDTO();
    page = new PageImpl<>(List.of(productDTO));

    when(productService.create(any())).thenReturn(productDTO);

    when(productService.index(any())).thenReturn(page);

    when(productService.show(existingId)).thenReturn(productDTO);
    when(productService.show(nonExistingId)).thenThrow(ResourceNotFoundException.class);

    when(productService.update(eq(existingId), any())).thenReturn(productDTO);
    when(productService.update(eq(nonExistingId), any())).thenThrow(ResourceNotFoundException.class);

    doNothing().when(productService).delete(existingId);
    doThrow(ResourceNotFoundException.class).when(productService).delete(nonExistingId);
    doThrow(DataBaseException.class).when(productService).delete(dependentId);
  }

  /*insert deveria etornar “created” (código 201), bem com um ProductDTO*/
  @Test
  public void createShouldReturnProductDTO() throws Exception {
    String jsonBody = objectMapper.writeValueAsString(productDTO);
    ResultActions resultActions =
      mockMvc.perform(post("/products")
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON));
    resultActions.andExpect(status().isCreated());
    resultActions.andExpect(jsonPath("$.id").exists());
    resultActions.andExpect(jsonPath("$.name").exists());
    resultActions.andExpect(jsonPath("$.description").exists());
  }

  @Test
  public void indexShouldReturnPage() throws Exception{
    ResultActions resultActions =
      mockMvc.perform(get("/products")
        .accept(MediaType.APPLICATION_JSON));
    resultActions.andExpect(status().isOk());
  }

  /*findById deveria retornar um ProductDTO quando o id existir*/
  @Test
  public void showShouldReturnProductWhenIdExists() throws Exception{
    ResultActions resultActions =
      mockMvc.perform(get("/products/{id}", existingId)
        .accept(MediaType.APPLICATION_JSON));
    resultActions.andExpect(status().isOk());
    resultActions.andExpect(jsonPath("$.id").exists());
    resultActions.andExpect(jsonPath("$.name").exists());
    resultActions.andExpect(jsonPath("$.description").exists());
  }

  /*findById deveria lançar ResourceNotFoundException quando o id não existir*/
  @Test
  public void showShouldReturnNotFoundWhenIdDoesNotExists() throws Exception{
    ResultActions resultActions =
      mockMvc.perform(get("/products/{id}", nonExistingId)
        .accept(MediaType.APPLICATION_JSON));
      resultActions.andExpect(status().isNotFound());
  }

  /*update deveria (dica: você vai ter que simular o comportamento do getOne) retornar um ProductDTO quando o id existir*/
  @Test
  public void updateShouldReturnProductDTOWhenIdExists() throws Exception {
    String jsonBody = objectMapper.writeValueAsString(productDTO);
    ResultActions resultActions =
      mockMvc.perform(put("/products/{id}", existingId)
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON));
    resultActions.andExpect(status().isOk());
    resultActions.andExpect(jsonPath("$.id").exists());
    resultActions.andExpect(jsonPath("$.name").exists());
    resultActions.andExpect(jsonPath("$.description").exists());
  }

  /*update deveria (dica: você vai ter que simular o comportamento do getOne) ançar uma ResourceNotFoundException quando o id não existir*/
  @Test
  public void updateShouldReturnNotFoundWhenIdDoesNotExists() throws Exception {
    String jsonBody = objectMapper.writeValueAsString(productDTO);
    ResultActions resultActions =
      mockMvc.perform(put("/products/{id}", nonExistingId)
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON));
    resultActions.andExpect(status().isNotFound());
  }

  /*delete deveria retornar “no content” (código 204) quando o id existir*/
  @Test
  public void deleteShouldReturnNoContentWhenIdExists() throws Exception {
    ResultActions resultActions =
      mockMvc.perform(delete("/products/{id}", existingId)
        .accept(MediaType.APPLICATION_JSON));
    resultActions.andExpect(status().isNoContent());
  }

  /*delete deveria retornar “not found” (código 404) quando o id não existir*/
  @Test
  public void deleteShouldReturnNotFoundWhenIdDoesNotExists() throws Exception {
    ResultActions resultActions =
      mockMvc.perform(delete("/products/{id}", nonExistingId)
        .accept(MediaType.APPLICATION_JSON));
    resultActions.andExpect(status().isNotFound());
  }
}
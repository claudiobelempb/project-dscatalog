package br.com.surb.dscatalog.resources;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.surb.dscatalog.Factory;
import br.com.surb.dscatalog.dto.ProductDTO;
import br.com.surb.dscatalog.entities.Product;
import br.com.surb.dscatalog.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

@WebMvcTest(ProductResource.class)
public class ProductResourceTests {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ProductService productService;

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
    nonExistingId = 3L;
    productDTO = Factory.createProductDTO();
    page = new PageImpl<>(List.of(productDTO));

    when(productService.index(any())).thenReturn(page);
  }

  @Test
  public void indexShouldReturnPage() throws Exception{
    mockMvc.perform(get("/products")).andExpect(status().isOk());
  }

}

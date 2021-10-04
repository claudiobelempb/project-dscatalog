package br.com.surb.dscatalog.services;


import br.com.surb.dscatalog.dto.ProductDTO;
import br.com.surb.dscatalog.repositories.ProductRepository;
import br.com.surb.dscatalog.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ProductServiceIT {

  @Autowired
  private ProductService productService;

  @Autowired
  private ProductRepository productRepository;

  private Long existingId;
  private Long nonExistingId;
  private Long countTotalProducts;

  @BeforeEach
  void setUp() throws Exception {
    existingId = 1L;
    nonExistingId = 1000L;
    countTotalProducts = 25L;
  }

  @Test
  /*deve retornar um página com min 0 max 10*/
  public void indexShouldReturnWhenPage0Size10() {

    PageRequest pageRequest = PageRequest.of(0, 10);
    Page<ProductDTO> productDTOPage = productService.index(pageRequest);

    Assertions.assertFalse(productDTOPage.isEmpty());
    Assertions.assertEquals(0, productDTOPage.getNumber());
    Assertions.assertEquals(10, productDTOPage.getSize());
    Assertions.assertEquals(countTotalProducts, productDTOPage.getTotalElements());
  }

  @Test
  /*deve retornar um página vazia quando não existir*/
  public void indexShouldReturnEmptyWhenPageDoesNotExixts() {

    PageRequest pageRequest = PageRequest.of(50, 10);
    Page<ProductDTO> productDTOPage = productService.index(pageRequest);

    Assertions.assertTrue(productDTOPage.isEmpty());
  }

  @Test
  /*deve retornar um página sort order por nome */
  public void indexShouldReturnSortedPageWhenSortByName() {

    PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("name"));
    Page<ProductDTO> productDTOPage = productService.index(pageRequest);

    Assertions.assertFalse(productDTOPage.isEmpty());
    Assertions.assertEquals("Macbook Pro", productDTOPage.getContent().get(0).getName());
    Assertions.assertEquals("PC Gamer", productDTOPage.getContent().get(1).getName());
    Assertions.assertEquals("PC Gamer Alfa", productDTOPage.getContent().get(2).getName());
  }

  /*deve excluir um produto quando ir exixtir*/
  @Test
  public void deleteShouldDeleteResourceWhenIdExixts() {
    productService.delete(existingId);
    Assertions.assertEquals(countTotalProducts - 1, productRepository.count());
  }

  /*deve lancar uma exeção REsourceNotException quando o id não exixtir*/
  @Test
  public void deleteShouldThrowREsourceNotExceptionWhenIdDoesNotExixts() {
    Assertions.assertThrows(ResourceNotFoundException.class, () -> {
      productService.delete(nonExistingId);
    });
  }
}

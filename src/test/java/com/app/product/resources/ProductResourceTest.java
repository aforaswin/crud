package com.app.product.resources;

import com.app.product.entities.Product;
import com.app.product.services.ProductService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductResource.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @Test
    public void testGetAll() throws Exception {
        List<Product> products = new ArrayList<>();

        Product product1 = new Product("7ade670f6a4d4366016a4d465b650008", "Apple", "8ade670f6a4d4366016a4d465b650008",
                "8ade670f6a4d4366016a4d465b650008", "8ade670f6a4d4366016a4d465b650008", "8ade670f6a4d4366016a4d465b650008");
        products.add(product1);
        Product product2 = new Product("6ade670f6a4d4366016a4d465b650008", "Samsung", "5ade670f6a4d4366016a4d465b650008",
                "8ade670f6a4d4366016a4d465b650005", "8ade670f6a4d4366016a4d465b650005", "8ade670f6a4d4366016a4d465b650005");
        products.add(product2);

        BDDMockito.given(productService.getAllProducts()).willReturn(products);

        mvc.perform(
                get("/v1/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name").value(product1.getName()))
                .andExpect(jsonPath("$[1].name").value(product2.getName()));
    }

    @Test
    public void testGetProduct() throws Exception {

        Product product1 = new Product("7ade670f6a4d4366016a4d465b650008", "Apple", "8ade670f6a4d4366016a4d465b650008",
                "8ade670f6a4d4366016a4d465b650008", "8ade670f6a4d4366016a4d465b650008", "8ade670f6a4d4366016a4d465b650008");
        BDDMockito.given(productService.getProduct("7ade670f6a4d4366016a4d465b650008")).willReturn(product1);

        mvc.perform(
        get("/v1/products/7ade670f6a4d4366016a4d465b650008")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value(product1.getName()));
    }

}

package com.app.product.services;

import com.app.product.entities.Product;
import com.app.product.repos.ProductServiceRepository;
import com.app.product.services.ProductService;
import com.app.product.services.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class ProductServiceImplTest {

    @TestConfiguration
    static class PersonServiceImplTestContextConfiguration {
        @Bean
        public ProductService personService() {
            return new ProductServiceImpl();
        }
    }

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductServiceRepository productServiceRepository;

    @Before
    public void setup() {
        List<Product> products = new ArrayList<>();

        Product product1 = new Product("7ade670f6a4d4366016a4d465b650008", "Apple", "8ade670f6a4d4366016a4d465b650008",
                "8ade670f6a4d4366016a4d465b650008", "8ade670f6a4d4366016a4d465b650008", "8ade670f6a4d4366016a4d465b650008");
        products.add(product1);
        Product product2 = new Product("6ade670f6a4d4366016a4d465b650008", "Samsung", "5ade670f6a4d4366016a4d465b650008",
                "8ade670f6a4d4366016a4d465b650005", "8ade670f6a4d4366016a4d465b650005", "8ade670f6a4d4366016a4d465b650005");
        products.add(product2);

        Mockito.when(productServiceRepository.findById(product1.getId())).thenReturn(Optional.of(product1));
        Mockito.when(productServiceRepository.findAll()).thenReturn(products);
    }

    @Test
    public void testGetPerson() {

        Product product = productService.getProduct("7ade670f6a4d4366016a4d465b650008");
        Assert.assertEquals("Apple", product.getName());
    }

    @Test
    public void testGetAll() {

        List<Product> products = productService.getAllProducts();
        Assert.assertEquals("Apple", products.get(0).getName());
        Assert.assertEquals("Samsung", products.get(1).getName());
    }


}

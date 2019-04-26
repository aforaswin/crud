package com.app.product.repos;

import com.app.product.entities.Product;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductServiceRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductServiceRepository productServiceRepository;

    @Test
    public void a1findproductEmpty(){

        Iterable<Product> products = productServiceRepository.findAll();
        assertThat(products).isEmpty();
    }

    @Test
    public void a2saveProduct() {

        Product product1 = new Product( "Apple", "8ade670f6a4d4366016a4d465b650008",
                "8ade670f6a4d4366016a4d465b650008", "8ade670f6a4d4366016a4d465b650008", "8ade670f6a4d4366016a4d465b650008");

        productServiceRepository.save(product1);
        assertThat(product1).hasFieldOrPropertyWithValue("name","Apple");

        Iterable<Product> products = productServiceRepository.findAll();
        assertThat(products).hasSize(1).contains(product1);

    }

    @Test
    public void a3findById() {
        //To have ref
        Product product1 = new Product( "Apple", "8ade670f6a4d4366016a4d465b650008",
                "8ade670f6a4d4366016a4d465b650008", "8ade670f6a4d4366016a4d465b650008", "8ade670f6a4d4366016a4d465b650008");

        productServiceRepository.save(product1);

        Optional<Product> foundProduct = productServiceRepository.findById(product1.getId());

        assertThat(foundProduct).contains(product1);

    }

    @Test
    public void a5deleteAllPersons() {
        Product product1 = new Product( "Apple", "8ade670f6a4d4366016a4d465b650008",
                "8ade670f6a4d4366016a4d465b650008", "8ade670f6a4d4366016a4d465b650008", "8ade670f6a4d4366016a4d465b650008");

        Product product2 = new Product("Samsung", "5ade670f6a4d4366016a4d465b650008",
                "8ade670f6a4d4366016a4d465b650005", "8ade670f6a4d4366016a4d465b650005", "8ade670f6a4d4366016a4d465b650005");

        entityManager.persist(product1);
        entityManager.persist(product2);

        productServiceRepository.deleteAll();

        assertThat(productServiceRepository.findAll()).isEmpty();
    }



    @Test
    public void findAllProducts() {
        Product product1 = new Product( "Apple", "8ade670f6a4d4366016a4d465b650008",
                "8ade670f6a4d4366016a4d465b650008", "8ade670f6a4d4366016a4d465b650008", "8ade670f6a4d4366016a4d465b650008");

        Product product2 = new Product("Samsung", "5ade670f6a4d4366016a4d465b650008",
                "8ade670f6a4d4366016a4d465b650005", "8ade670f6a4d4366016a4d465b650005", "8ade670f6a4d4366016a4d465b650005");
        entityManager.persist(product1);


        entityManager.persist(product2);



        Iterable<Product> customers = productServiceRepository.findAll();

        assertThat(customers).hasSize(2).contains(product1, product2);
    }

}

package com.example.TucShopBackend;

import com.example.TucShopBackend.DTO.TransactionsDTO;
import com.example.TucShopBackend.Models.Category;
import com.example.TucShopBackend.Models.ProductTransaction;
import com.example.TucShopBackend.Models.Products;
import com.example.TucShopBackend.Models.Transactions;
import com.example.TucShopBackend.Repositories.CategoryRepository;
import com.example.TucShopBackend.Repositories.ProductsRepository;
import com.example.TucShopBackend.Repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@SpringBootApplication
public class TucShopBackendApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(TucShopBackendApplication.class, args);
	}

      @Autowired
	private  ProductsRepository productsRepository;
      @Autowired
	private  TransactionsRepository transactionsRepository;
@Autowired
private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) {

		Category category = new Category();
		category.setName("test");
		Category c = categoryRepository.save(category);

		Products product = new Products();
		product.setCategory(c);
		product.setName("Testcommand");
		Products p =productsRepository.save(product);

		Transactions transactionA = new Transactions();
		transactionA.setAmount(20d);
		transactionA.setCreatedBy("ADMIN");
		transactionA.setDate(LocalDate.now());
		transactionA.setUpdatedBy("ADMIN");
		Transactions tra = transactionsRepository.save(transactionA);
		Set<ProductTransaction> set = new HashSet<>();
		set.add(new ProductTransaction(p,20.2));
		tra.setProductTransactions(set);
		transactionsRepository.save(tra);


//
//		productsRepository.save(new Products("Products 1", new ProductTransaction(transactionA, new Quantity()), new ProductTransaction (transactionsB, new quantity())));
//		productsRepository.save(new Products("Products 2", new ProductTransaction(transactionA, new quantity())));
	}


}

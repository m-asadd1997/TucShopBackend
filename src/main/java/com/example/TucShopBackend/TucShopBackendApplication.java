package com.example.TucShopBackend;

import com.example.TucShopBackend.Models.Category;
import com.example.TucShopBackend.Models.ProductTransaction;
import com.example.TucShopBackend.Models.Product;
import com.example.TucShopBackend.Models.Transactions;
import com.example.TucShopBackend.Repositories.CategoryRepository;
import com.example.TucShopBackend.Repositories.ProductsRepository;
import com.example.TucShopBackend.Repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TucShopBackendApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductsRepository productsRepository;

	@Autowired
	private TransactionsRepository transactionsRepository;

	public static void main(String[] args) {
		SpringApplication.run(TucShopBackendApplication.class, args);
	}
	@Override
	public void run(String... args) {
		// Create a couple of Book, Publisher and BookPublisher
//		Category cat = new Category();
//		cat.setName("Test");
//		Category category = categoryRepository.save(cat);
//
//		Product product = new Product();
//		product.setCategory(category);
//		product.setName("testing12");
//
//		Transactions transaction = new Transactions();
//		transaction.setAmount(200.0);
//
//
//		Set<ProductTransaction> pt = new HashSet<>();
//		pt.add(new ProductTransaction(product,transaction,2L));
////
////		pt.setProduct(product);
////		pt.setTransaction(transaction);
////		pt.setQuantity(2L);
//
//		//product.getProductTransactions().add(pt);
//		transaction.setProductTransactions(pt);
//		productsRepository.save(product);
//		transactionsRepository.save(transaction);







	}
}

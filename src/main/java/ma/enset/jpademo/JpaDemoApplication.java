package ma.enset.jpademo;

import ma.enset.jpademo.entities.Product;
import ma.enset.jpademo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	/*
	*@autowired on demande a spring de nous injecter une instance(objet d'une classe)
	*  qui implémente l'interface ProductRepository
	 */
	@Autowired
	private ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product(null,"HP 8760", 9000, 12));
		productRepository.save(new Product(null,"SmartPhone", 7000, 8));
		productRepository.save(new Product(null,"Imprimante", 3000, 5));
		productRepository.save(new Product(null,"Scanner", 2000, 3));

		productRepository.findAll().forEach(p->{
			System.out.println(p.getName());
		});

		System.out.println("***********************");
		List<Product> products = productRepository.findByNameContainsIgnoreCase("M");
		products.forEach(System.out::println);

		System.out.println("***********************");
		List<Product> products1 = productRepository.search(1000, 5000);
		products1.forEach(System.out::println);
	}
}

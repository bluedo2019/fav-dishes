package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import dishes.Dish;
import repo.DishRepository;

@EnableMongoRepositories(basePackageClasses = DishRepository.class)
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private DishRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Dish("Alice", "Smith", "gg"));
		repository.save(new Dish("Bob", "Smith", "fff"));

		// fetch all customers
		System.out.println("Dishes found with findAll():");
		System.out.println("-------------------------------");
		for (Dish dish : repository.findAll()) {
			System.out.println(dish);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Dishes found with findByCategory('Smith'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByCategory("Smith"));

		System.out.println("Dishes found with findByType('gg'):");
		System.out.println("--------------------------------");
		for (Dish dish : repository.findByType("gg")) {
			System.out.println(dish);
		}

	}

}
package app;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import dishes.Dish;
import repo.DishRepository;


@RestController
public class DishesController {

	@Autowired
	private DishRepository repository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/dishes")
	public List<Dish> getAll() {
		return repository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/dishes/category/{category}")
	public List<Dish> getByCategory(@PathVariable String category) {
		return repository.findByCategory(category);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/dishes/type/{type}")
	public List<Dish> getByType(@PathVariable String type) {
		return repository.findByType(type);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/dishes/{id}")
	public Optional<Dish> getById(@PathVariable String id) {
		return repository.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/dishes")
	public Dish create(@RequestBody Dish input) {
		Dish dish = new Dish(input.getName(), input.getCategory(), input.getType());
		dish.setDescription(input.getDescription());
		return repository.save(dish);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/dishes")
	public Dish update(@RequestBody Dish input) {
		Dish dish = new Dish(input.getName(), input.getCategory(), input.getType());
		repository.deleteById(input.getId());
		return repository.save(dish);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/dishes/{id}")
	public List<Dish> delete(@PathVariable String id) {
		repository.deleteById(id);
		return repository.findAll();
	}
}

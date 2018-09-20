package repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import dishes.Dish;

@RepositoryRestResource
public interface DishRepository extends MongoRepository<Dish, String> {

    public Optional<Dish> findById(String id);
    public List<Dish> findByCategory(String category);
    public List<Dish> findByType(String type);

}
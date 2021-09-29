package recipes.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import recipes.domain.recipe.Recipe;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
	List<Recipe> findAllByNameContainingIgnoreCaseOrderByDateDesc(String name);

	List<Recipe> findAllByCategoryIgnoreCaseEqualsOrderByDateDesc(String category);
}

package net.sbaai.restoapp.repository;

import net.sbaai.restoapp.model.Category;
import net.sbaai.restoapp.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food,Long> {
    /*@Query("select f from Food f where f.name like :x")
    public List<Food> findFoodByName(@Param("x") String lastName);}*/
    public List<Food> findFoodByName(String name);
    public List<Food> findFoodByCategory_IdCategory(Long id);
    public List<Food> findFoodBySelected(Boolean b);
}


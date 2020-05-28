package net.sbaai.restoapp.repository;

import net.sbaai.restoapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Category,Long> {
}

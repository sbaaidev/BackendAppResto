package net.sbaai.restoapp.repository;

import net.sbaai.restoapp.model.Category;
import net.sbaai.restoapp.model.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaiterRepository extends JpaRepository<Waiter,Long> {
    @Query("select w from Waiter w where name like :x or code like :x or tel like :x")
    List<Waiter> findWaiterByMC(@Param("x") String mc);
}

package net.sbaai.restoapp.repository;

import net.sbaai.restoapp.model.Category;
import net.sbaai.restoapp.model.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TablesRepository extends JpaRepository<Tables,Long> {
    List<Tables> findTablesBySector_IdSector(Long id);
    List<Tables> findTablesByWaiter_IdWaiter(Long id);
    @Query("select t from Tables t where  t.waiter.name like :x or t.sector.name like :x")
    List<Tables> findTablesByMC(@Param("x") String mc);
}

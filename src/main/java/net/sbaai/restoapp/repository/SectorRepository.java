package net.sbaai.restoapp.repository;

import net.sbaai.restoapp.model.Category;
import net.sbaai.restoapp.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectorRepository extends JpaRepository<Sector,Long> {
    public List<Sector> findSectorByNameContaining(String mc);
}

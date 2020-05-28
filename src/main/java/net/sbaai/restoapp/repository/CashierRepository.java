package net.sbaai.restoapp.repository;

import net.sbaai.restoapp.model.Cashier;
import net.sbaai.restoapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashierRepository extends JpaRepository<Cashier,Long> {
    List<Cashier> findCashierByDateContaining(String date);
}

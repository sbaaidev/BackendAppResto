package net.sbaai.restoapp.repository;

import net.sbaai.restoapp.model.Category;
import net.sbaai.restoapp.model.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CommandRepository extends JpaRepository<Command,String> {
    @Query("SELECT c FROM Command c order by c.idCommand asc")
    List<Command> findAllOrderByIdCommandAsc();
    //List<Command> findByCommand_line();
    List<Command> findCommandByDtaeCommandContaining(String date);

}

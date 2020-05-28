package net.sbaai.restoapp.repository;

import net.sbaai.restoapp.model.Command;
import net.sbaai.restoapp.model.Command_line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandlineRepository extends JpaRepository<Command_line,Long> {

    public List<Command_line> getCommand_lineByCommand_NumCommand(String numCommande);
    @Query("select sum(cl.prix) as prix,cl.date from Command_line cl group by cl.date")
   List<Object[]> getSumPrixAndDate();
    @Query("select sum(cl.prix) as prix,cl.date from Command_line cl where cl.date like :date group by cl.date")
    List<Object> getSumPrixAndDateGroupByDate(@Param("date")String date);





}

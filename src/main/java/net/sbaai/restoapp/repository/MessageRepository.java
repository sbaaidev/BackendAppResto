package net.sbaai.restoapp.repository;

import net.sbaai.restoapp.model.Category;
import net.sbaai.restoapp.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
    @Query("select m from Message m order by m.idmsg")
    List<Message> findMessageAndOrderByIdmsg();
}

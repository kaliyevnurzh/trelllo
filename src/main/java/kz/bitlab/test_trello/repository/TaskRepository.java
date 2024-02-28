package kz.bitlab.test_trello.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.test_trello.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findTaskByFolderId(int folder_id);
}

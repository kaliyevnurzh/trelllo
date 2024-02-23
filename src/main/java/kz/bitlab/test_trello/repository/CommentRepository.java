package kz.bitlab.test_trello.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.test_trello.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}

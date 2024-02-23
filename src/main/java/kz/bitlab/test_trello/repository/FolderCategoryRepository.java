package kz.bitlab.test_trello.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.test_trello.model.FolderCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface FolderCategoryRepository extends JpaRepository<FolderCategory, Integer> {
}

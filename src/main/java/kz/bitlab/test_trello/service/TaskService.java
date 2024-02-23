package kz.bitlab.test_trello.service;

import kz.bitlab.test_trello.model.Comment;
import kz.bitlab.test_trello.model.Task;
import kz.bitlab.test_trello.repository.CommentRepository;
import kz.bitlab.test_trello.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task>getAllComments(){
        return taskRepository.findAll();
    }
}

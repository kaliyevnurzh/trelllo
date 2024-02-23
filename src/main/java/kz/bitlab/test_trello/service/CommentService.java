package kz.bitlab.test_trello.service;

import kz.bitlab.test_trello.model.Comment;
import kz.bitlab.test_trello.model.Folder;
import kz.bitlab.test_trello.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment>getAllComments(){
        return commentRepository.findAll();
    }
}

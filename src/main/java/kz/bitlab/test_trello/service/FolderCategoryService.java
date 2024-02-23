package kz.bitlab.test_trello.service;

import kz.bitlab.test_trello.model.FolderCategory;
import kz.bitlab.test_trello.repository.FolderCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FolderCategoryService {

    private final FolderCategoryRepository folderCategoryRepository;

    public List<FolderCategory>getAllCategories(){
        return folderCategoryRepository.findAll();
    }

    public FolderCategory getByID(int id){
        return folderCategoryRepository.findById(id).orElse(null);
    }
}

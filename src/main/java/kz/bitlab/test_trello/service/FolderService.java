package kz.bitlab.test_trello.service;

import kz.bitlab.test_trello.model.Folder;
import kz.bitlab.test_trello.repository.FolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FolderService {

    private final FolderRepository folderRepository;

    public List<Folder>getAllFolders(){
        return folderRepository.findAll();
    }
    public void addFolder(Folder folder){
        folderRepository.save(folder);
    }

    public Folder getFolder(int id){
       return folderRepository.findById(id).orElse(null);
    }
}

package kz.bitlab.test_trello.controller;

import kz.bitlab.test_trello.model.Folder;
import kz.bitlab.test_trello.model.FolderCategory;
import kz.bitlab.test_trello.model.Task;
import kz.bitlab.test_trello.service.CommentService;
import kz.bitlab.test_trello.service.FolderCategoryService;
import kz.bitlab.test_trello.service.FolderService;
import kz.bitlab.test_trello.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final FolderService folderService;
    private final CommentService commentService;
    private final FolderCategoryService folderCategoryService;
    private final TaskService taskService;


    @GetMapping(value = "/")
    public String mainPage(Model model){
        model.addAttribute("folders", folderService.getAllFolders());
        return "home-page";
    }

    @PostMapping(value = "/add-folder")
    public String addFolder(Folder folder){
        folderService.addFolder(folder);

        return "redirect:/";
    }

    @GetMapping(value = "/folder-details/{id}")
    public String detailsFolder(@PathVariable int id,
                                Model model){
        Folder folder = folderService.getFolder(id);
        model.addAttribute("folder",folder);
        model.addAttribute("tasks", taskService.getAllTasksByFolderId(folder.getId()));

        List<FolderCategory> folderCategories =  folderCategoryService.getAllCategories();
        folderCategories.removeAll(folder.getCategories());
        folderService.addFolder(folder);
        model.addAttribute("categories", folderCategories);
        return "folder-details";
    }

    @PostMapping(value = "/add-category")
    public String addCategory(@RequestParam int folder_id,
                              @RequestParam int category_id){
        Folder folder = folderService.getFolder(folder_id);
        FolderCategory folderCategory = folderCategoryService.getByID(category_id);
        folder.getCategories().add(folderCategory);
        folderService.addFolder(folder);

        return "redirect:folder-details/" +folder_id;
    }

    @PostMapping(value = "/delete-category")
    public String deleteCategory(@RequestParam int folder_id,
                              @RequestParam int category_id){
        Folder folder = folderService.getFolder(folder_id);
        FolderCategory folderCategory = folderCategoryService.getByID(category_id);
        folder.getCategories().remove(folderCategory);
        folderService.addFolder(folder);

        return "redirect:folder-details/" +folder_id;
    }

    @PostMapping(value = "/add-task")
    public String addTask(Task task,
                          @RequestParam int folder_id) {
        Folder folder = folderService.getFolder(folder_id);
        task.setFolder(folder);
        taskService.addTask(task);

        return "redirect:folder-details/" +task.getFolder().getId();
    }

    @GetMapping(value = "/task-details/{id}")
    public String taskDetails(@PathVariable int id,
                              Model model) {
        model.addAttribute("task", taskService.getTaskById(id));

        return "task-details-page";
    }

    @PostMapping(value = "/update-task")
    public String updateTask(Task task,
                             @RequestParam int folder_id) {
        Folder folder = folderService.getFolder(folder_id);
        task.setFolder(folderService.getFolder(folder_id));
        taskService.updateTask(task);

        return "redirect:folder-details/" +task.getFolder().getId();
    }

}

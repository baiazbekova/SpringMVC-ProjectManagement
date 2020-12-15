package com.cybertek.controller;


import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.enums.Status;
import com.cybertek.service.ProjectService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")

public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @GetMapping("/create")
    public String createProject(Model model){

        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());
        return "/project/create";
    }


    @PostMapping("/create")
    public String inserProject(ProjectDTO project){

        projectService.save(project);
        project.setProjectStatus(Status.OPEN);

        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectcode}")
    public String deleteProject(@PathVariable("projectcode") String projectcode){
        projectService.deleteByID(projectcode);
        return "redirect:/project/create";
    }



    @GetMapping("/complete/{projectcode}")
    public String completeUser(@PathVariable("projectcode") String projectcode ){
        projectService.complete(projectService.findByID(projectcode));
        return "redirect:/project/complete";
    }


    @GetMapping("/update/{projectcode}")
    public String editUser(@PathVariable("projectcode") String projectcode, Model model){
        model.addAttribute("project", projectService.findByID(projectcode));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());

        return "/project/update";
    }

    @PostMapping("/update/{projectcode}")
    public String updateUser(@PathVariable("projectcode") String projectcode,ProjectDTO projectDTO,  Model model){

        projectService.update(projectDTO);
        return "redirect:/project/create";

    }



}

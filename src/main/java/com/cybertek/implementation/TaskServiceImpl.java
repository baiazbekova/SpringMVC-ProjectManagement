package com.cybertek.implementation;

import com.cybertek.dto.TaskDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TaskServiceImpl extends AbstractMapService <TaskDTO, Long> implements TaskService {
    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(TaskDTO object) {
        super.delete(object);
    }

    @Override
    public TaskDTO findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public TaskDTO saveByID(Long id) {
        return null;
    }


    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);

    }

    @Override
    public TaskDTO save(TaskDTO object) {
        return super.save(object.getId(), object);
    }


    @Override
    public void update(TaskDTO object) {
        TaskDTO  foundProject = findByID(object.getId());
        object.setAssignedDate(foundProject.getAssignedDate());
        object.setTaskStatus(foundProject.getTaskStatus());

        super.update(object.getId(), object);
    }


    @Override
    public List<TaskDTO> findTasksByManager(UserDTO manager) {
        return super.findAll().stream().filter(task -> task.getProject().getAssignedManager().equals(manager)).collect(Collectors.toList());
    }
}

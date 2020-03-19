package com.example.wbdvonlinesp20jzhengserverjava.services;

import com.example.wbdvonlinesp20jzhengserverjava.models.Course;
import com.example.wbdvonlinesp20jzhengserverjava.models.Module;
import com.example.wbdvonlinesp20jzhengserverjava.repositories.CourseRepository;
import com.example.wbdvonlinesp20jzhengserverjava.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    CourseRepository courseRepository;

    public Module createModule(Integer cid, Module newModule) {
        Course course = courseRepository.findById(cid).get();
        newModule.setCourse(course);
        return moduleRepository.save(newModule);
    }

    public List<Module> findModulesForCourse(Integer cid) {
        return moduleRepository.findModulesForCourse(cid);
    }

    public int updateModule(Integer mid, Module updatedModule) {
        Module moduleToUpdate = moduleRepository.findModuleById(mid);
        moduleToUpdate.setTitle(updatedModule.getTitle());

        moduleRepository.save(moduleToUpdate);
        return 1;
    }

    public int deleteModule(Integer mid) {
        moduleRepository.deleteById(mid);
        return 1;
    }

    public List<Module> findAllModules() {
        return (List<Module>) moduleRepository.findAll();
    }

    public Module findModuleById(Integer mid) {
        return moduleRepository.findModuleById(mid);
    }
}

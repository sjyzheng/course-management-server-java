package com.example.wbdvonlinesp20jzhengserverjava.controller;

import com.example.wbdvonlinesp20jzhengserverjava.models.Module;
import com.example.wbdvonlinesp20jzhengserverjava.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ModuleController {

    @Autowired
    ModuleService moduleService;

    @PostMapping("/api/courses/{courseId}/modules")
    public Module createTopic(@PathVariable("courseId") Integer cid, @RequestBody Module module) {
        return moduleService.createModule(cid, module);
    }

    @GetMapping("/api/courses/{courseId}/modules")
    public List<Module> findModulesForCourse(@PathVariable("courseId") Integer cid) {
        return moduleService.findModulesForCourse(cid);
    }

    @PutMapping("/api/modules/{moduleId}")
    public int updateModule(@PathVariable("moduleId") Integer mid,
                           @RequestBody Module module) {
        return moduleService.updateModule(mid, module);
    }

    @DeleteMapping("/api/modules/{moduleId}")
    public int deleteTopic(@PathVariable("moduleId") Integer mid) {
        return moduleService.deleteModule(mid);
    }

    @GetMapping("/api/modules")
    public List<Module> findAllModules() {
        return moduleService.findAllModules();
    }

    @GetMapping("/api/modules/{moduleId}")
    public Module findModuleById (@PathVariable("moduleId") Integer mid) {
        return moduleService.findModuleById(mid);
    }
}

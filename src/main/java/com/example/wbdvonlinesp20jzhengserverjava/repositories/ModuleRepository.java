package com.example.wbdvonlinesp20jzhengserverjava.repositories;

import com.example.wbdvonlinesp20jzhengserverjava.models.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModuleRepository extends CrudRepository<Module, Integer> {

    @Query("SELECT module FROM Module module")
    public List<Module> findAllModules();

    @Query("SELECT module FROM Module module WHERE module.course.id=:cid")
    public List<Module> findModulesForCourse(@Param("cid") Integer courseId);

    @Query("SELECT module FROM Module module WHERE module.id=:mid")
    public Module findModuleById(@Param("mid") Integer moduleId);
}

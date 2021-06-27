package com.exen.logistic.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

public abstract class AbstractRestController<T, R extends JpaRepository<T, ?>> {
    protected R repo;

    public AbstractRestController(R repo) {
        this.repo = repo;
    }

    @GetMapping
    public Page<T> list(@PageableDefault Pageable pageable){
        return repo.findAll(pageable);
    }

    @GetMapping("{id}")
    public T getOne(@PathVariable("id") T obj){
        return obj;
    }

    @PostMapping
    public T add(@RequestBody T obj){
        return repo.save(obj);
    }

    @PutMapping("id")
    public T update(@PathVariable T DbObj, @RequestBody T obj){
        BeanUtils.copyProperties(obj, DbObj, "id");

        return repo.save(DbObj);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") T obj){
        repo.delete(obj);
    }
}

package com.exen.logistic.controller;

import com.exen.logistic.domain.Mark;
import com.exen.logistic.repo.MarkRepo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mark")
public class MarkRestController extends AbstractRestController<Mark, MarkRepo> {
    public MarkRestController(MarkRepo repo) {
        super(repo);
    }
}

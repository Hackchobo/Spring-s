package com.green.dotori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doto")
public class DotoriController {
    private final DotoriService service;

    @Autowired
    public DotoriController(DotoriService service) {
        this.service=service;
    }

    @PostMapping
    public int Postdoto(@RequestBody DotoriEntity entity) {
        return service.insdoto(entity);
    }

}

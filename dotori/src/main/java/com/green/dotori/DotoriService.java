package com.green.dotori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DotoriService {

    private final DotoriMapper mapper;

    @Autowired
    public DotoriService(DotoriMapper mapper) {
        this.mapper = mapper;
    }

    public int insdoto(DotoriEntity entity) {
        return mapper.insdoto(entity);
    }
}

package com.green.dotori;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DotoriMapper {
    int insdoto(DotoriEntity entity);
}

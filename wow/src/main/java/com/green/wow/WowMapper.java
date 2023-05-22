package com.green.wow;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WowMapper {
    int insWow(WowEntity entity);
    List<WowEntity> selWow();
    WowEntity selWowById(WowEntity entity);
    int updWow(WowEntity entity);
    int delWow(WowEntity entity);
}

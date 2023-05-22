package com.green.wow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 로직 담당
public class WowService {

    private final WowMapper mapper;

    @Autowired
    public WowService(WowMapper mapper) {
        this.mapper=mapper;
    }

    public int insWow(WowEntity entity) {
        System.out.println("service-insWow");
        return mapper.insWow(entity);
    }

    public List<WowEntity> selWow() {
        return mapper.selWow();
    }

    public WowEntity selWowById(WowEntity entity){
        return mapper.selWowById(entity);
    }

    public int updWow(WowEntity entity) {
        System.out.println("Servis-upsWow");
        return mapper.updWow(entity);
    }

    public int delWow(WowEntity entity) {
        return mapper.delWow(entity);
    }
}

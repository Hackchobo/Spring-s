package com.green.mimi.cmt;

import com.green.mimi.cmt.model.CmtEntity;
import com.green.mimi.cmt.model.CmtInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CmtService {
    private CmtMapper mapper;

    @Autowired
    public CmtService(CmtMapper mapper){
        this.mapper=mapper;
    }

    public int insBoardCmt(CmtInsDto dto){
        CmtEntity entity = new CmtEntity(); // Entity 는 개체이다 테이블과 1:1 매칭 시킬수있는 것이 필요해서
        entity.setIboard(dto.getIboard());
        entity.setIuser(dto.getIuser());
        entity.setCtnt(dto.getCtnt());
        int result = mapper.insBoardCmt(entity);
        if (result ==1) {
            return entity.getIboardCmt();
        }
        return result;
    }
}

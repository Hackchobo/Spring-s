package com.green.mimi.cmt;

import com.green.mimi.cmt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtService {
    private CmtMapper mapper;

    @Autowired
    public CmtService(CmtMapper mapper) {
        this.mapper = mapper;
    }

    public int insBoardCmt(CmtEntity entity) {
        // Entity 는 개체이다 테이블과 1:1 매칭 시킬수있는 것이 필요해서
        try {
            int result = mapper.insBoardCmt(entity);
            if (result == 1) {
                return entity.getIboardCmt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public CmtRes selBoardCmt(CmtSelDto dto){
        int startIdx = (dto.getPage()-1) * dto.getRow();
        dto.setStartIdx(startIdx);
        List<CmtVo> list= mapper.selBoardCmt(dto);

//        int rowCnt = mapper.selBoardCmtRowCountByIboard(dto.)


        /*int isMore = 1;
        int max=(int)Math.ceil(list.size()/(double)dto.getRow());
        if (dto.getPage()>max){
            isMore = 0;
        }*/

        int rowCnt = mapper.selBoardCmtRowCountByIBoard(dto.getIboard());
        int maxPage = (int)Math.ceil((double)rowCnt / dto.getRow());
        int isMore = maxPage > dto.getPage() ? 1 : 0;

        return CmtRes.builder()
                .list(list)
                .isMore(isMore)
                .maxPage(maxPage)
                .row(dto.getRow())
                .build();
    }

    public int updBoardCmt(CmtEntity entity) {
        return mapper.updBoardCmt(entity);
    }

    public int delBoardCmt(CmtDelDto dto) {
        return mapper.delBoardCmt(dto);
    }
}

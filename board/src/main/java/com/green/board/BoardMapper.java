package com.green.board;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 마이바티스에서 제공하는 맵퍼임
// xml 은 쿼리문 저장, interface는 메소드를 만드는 선언문 리턴타입과 파라미터 보고 문구를 만들어 줌
// xml 이랑 interface 연결점이 DAO
@Mapper
public interface BoardMapper {
    int insBoard(BoardEntity entity); // 메소드값이 insert id 값 이랑 동일해야함!
    List<BoardEntity> selBoardAll(); // 한레코드가 담길수있는 파일을 적어준다.
    BoardEntity selBoardById(BoardEntity entity); // 한레코드를 담으려면 객체하나를 변수로 선언 해준다.
    int updBoard(BoardEntity entity); // int를 적어주면 자동으로 영향 받은 행을 리턴해준다.
    int delBoard(BoardEntity iboard);
}

package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	public List<BoardVO> getList(); //전체조회
	public List<BoardVO> getListWithPaging(Criteria cri); // 한번에 조회할 건수
	public int getTotalCount(Criteria cri);
 	public void insert(BoardVO board); //생성된 pk값의 반환이 필요없는경우
	public void insertSelectKey(BoardVO board); //생성된 pk값의 반환이 필요한 경우
	public BoardVO read(Long bno); //단건조회
	public int delete(Long bno); //삭제
	public int update(BoardVO board); //수정
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}

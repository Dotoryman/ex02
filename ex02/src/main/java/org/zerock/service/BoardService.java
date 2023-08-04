package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

// 업무를 반영하는능력 : 서비스로직
public interface BoardService {
	public void register(BoardVO board); //등록
	public BoardVO get(Long bno); //단건조회
	public boolean modify(BoardVO board); //수정
	public boolean remove(Long bno); //삭제
	public List<BoardVO> getList(Criteria cri); //전체조회
}

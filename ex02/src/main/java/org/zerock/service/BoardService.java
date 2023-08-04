package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

// ������ �ݿ��ϴ´ɷ� : ���񽺷���
public interface BoardService {
	public void register(BoardVO board); //���
	public BoardVO get(Long bno); //�ܰ���ȸ
	public boolean modify(BoardVO board); //����
	public boolean remove(Long bno); //����
	public List<BoardVO> getList(Criteria cri); //��ü��ȸ
}

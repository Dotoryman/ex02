package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	public List<BoardVO> getList(); //��ü��ȸ
	public List<BoardVO> getListWithPaging(Criteria cri); // �ѹ��� ��ȸ�� �Ǽ�
	public int getTotalCount(Criteria cri);
 	public void insert(BoardVO board); //������ pk���� ��ȯ�� �ʿ���°��
	public void insertSelectKey(BoardVO board); //������ pk���� ��ȯ�� �ʿ��� ���
	public BoardVO read(Long bno); //�ܰ���ȸ
	public int delete(Long bno); //����
	public int update(BoardVO board); //����
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}

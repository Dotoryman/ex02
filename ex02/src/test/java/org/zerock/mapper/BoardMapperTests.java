package org.zerock.mapper;

import java.util.function.Consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
//	@Test
	public void testRead() {
		
		BoardVO vo = mapper.read(3L);
		log.info(vo);
		
	}
//	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(3L);
		board.setTitle("수정테스트 제목");
		board.setContent("수정테스트 내용");
		mapper.update(board);
		
		BoardVO vo = mapper.read(3L);
		log.info(vo);
	}
	@Test
	public void testDelete() {
		BoardVO board = new BoardVO();
		board.setBno(2L);
		mapper.delete(2L);
		int r = mapper.delete(2L);
		log.info(r + "건 삭제완료");
		
		BoardVO vo = mapper.read(2L);
		if( vo == null) {
			log.info("조회불가");
			
		}else {
			log.info(vo);
		}
	}
//	@Test
	public void testInsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("인서트테스트 제목");
		vo.setContent("인서트테스트 내용");
		vo.setWriter("user-");
		
		mapper.insertSelectKey(vo);
		
		log.info(vo);
	}
	
//	@Test
	public void testGetList() {
//		mapper.getList().forEach(new Consumer<BoardVO> () {
//			@Override
//			public void accept(BoardVO board) {
//				log.info(board);
//			}
//		}); // 이걸 람다표현식으로 줄이면 아래처럼
		mapper.getList().forEach(board ->log.info(board));
			
}
}

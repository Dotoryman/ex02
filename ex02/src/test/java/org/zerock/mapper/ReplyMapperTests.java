package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	ReplyMapper mapper;
	
	@Test
	public void mapperTests() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(294L);
		vo.setReply("294번글에 달린 댓글입니다123");
		vo.setReplyer("집가고싶은사람");
		vo.setRno(7L);
		
		mapper.update(vo);
		
		Criteria cri = new Criteria();
		mapper.getListWithPaging(cri, 294L).forEach(reply -> {
			log.info(reply.toString());
		});
	}
}

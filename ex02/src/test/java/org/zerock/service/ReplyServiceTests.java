package org.zerock.service;

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
public class ReplyServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private ReplyService service;
	
	@Test
	public void serviceTest() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(294L);
		vo.setReply("2서비스테스트댓글");
		vo.setReplyer("2서비스테스트맨");
		vo.setRno(9L);
		service.modify(vo);
		
		service.getList(new Criteria(), 294L).forEach(reply -> log.info(reply));
		
	}
}

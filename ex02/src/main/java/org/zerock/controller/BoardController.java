package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	
	private BoardService service; // �����ڰ� ȣ��ɶ� ��ü�� �����ϰڴ�
	
	//��ü��ȸ
	@GetMapping("/list")
	public void list(Model model, Criteria cri) { 
		int totalCnt = 365;
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, totalCnt));
	}
	
	//���
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		service.register(board);
		
		rttr.addFlashAttribute("�Խñ� " + board.getBno() + "���� ��ϵǾ����ϴ�."); //flash�� ���� ó����û �ѹ��� ������
		
		return "redirect:/board/list";
	}
	
	//���������
	@GetMapping("/register")
	public void register() {
		
	}
	
	//�ܰ���ȸ + ����������
	@GetMapping({"/get", "/modify"}) //void= url���� ��������
	public void get(@RequestParam("bno") Long bno, Model model) {
		model.addAttribute("board", service.get(bno));	
	}
	
	//����
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	//����
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
}

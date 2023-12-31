package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.CodeVO;
import org.zerock.domain.CodeVOList;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

// jsp페이지 생성 (X) -> json 데이터 생성을 위한 컨트롤러

@RestController //@ResponseBody 포함
@RequestMapping("/sample")
@Log4j
public class SampleController {

	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		return "저녁 뭐먹지";
	}

	@PostMapping(value = "/getSample", produces = { MediaType.APPLICATION_JSON_VALUE })
	public SampleVO getSample() {
		return new SampleVO(100, "조지", "부시");
	}

	@GetMapping(value="/getList")
	public List<SampleVO> getList() {
//		return IntStream.range(1, 10)
//				.mapToObj(i -> new SampleVO(i, "first"+i, "last"+i))
//				.collect(Collectors.toList());
		
		List<SampleVO> list = new ArrayList<>();
			for(int i = 1 ; i < 10 ; i++) {
				list.add(new SampleVO(i, "first"+i, "last"+i));
			}
			return list;
	}
	
	@GetMapping(value="/getMap")
	public Map<String, SampleVO> getMap() {
		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(1001, "first", "last"));
		return map;
	}
	
	@GetMapping(value="/check", params = {"height", "weight"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		SampleVO vo = new SampleVO (1001, "조지", "부시");
		ResponseEntity<SampleVO> result = null;
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}else { 
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
	}
	// http://localhost:8081/sample/product?cat=coffee&pid=353235
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {
		return new String[] {"category : " + cat , "product : " + pid };
		
	}
	
	@GetMapping("/code")
	public ModelAndView code() {
		ModelAndView mv =new ModelAndView();
		mv.setViewName("code");
//		mv.addObject("key", value)
		return mv;
	}
	
	//맵핑 줄이기, 하나만 쓸땐 value = 생략가능
	@GetMapping(value = "/param")
	@ResponseBody
	public List<CodeVO> param(@RequestParam(required = false,
									  defaultValue = "Reign of fire") String name,
									  CodeVOList codeVOList) {
		log.info(codeVOList);
		return codeVOList.getList();
	}
	
	
	@PostMapping("addlist")
	public List<CodeVO> addlist(@RequestBody List<CodeVO> list){
		log.info(list);
		return list;
	}
}

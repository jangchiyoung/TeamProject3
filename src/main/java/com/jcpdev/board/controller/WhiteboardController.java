package com.jcpdev.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcpdev.board.entity.WhiteboardEntity;
import com.jcpdev.board.model.Whiteboard;
import com.jcpdev.board.service.WhiteboardService;
import com.jcpdev.board.repository.WhiteboardRepository;

@Controller
public class WhiteboardController {

	//20211118
	@Autowired
	WhiteboardRepository repository;
	
	@Autowired
	WhiteboardService service;
	
	@RequestMapping(value = "/starting/board")
	public String board() {
		return "board";
	}
	
	
	@GetMapping("/instagram/board")
	public String boardinsert() {
		Whiteboard board = new Whiteboard(2, "test", "test.png", null, null, "contex", null, 0, 0);
		WhiteboardEntity entity = service.toEntity(board);
		System.out.println(repository.save(entity));
		return "test";
	}
	
	@RequestMapping("/test")
	public String getList(Model model){
		List<WhiteboardEntity> list = repository.findAll();
		List<Whiteboard> result = new ArrayList<Whiteboard>();
		list.forEach(item-> {
			result.add(service.toDto(item));
		});
		model.addAttribute("list", result);
		System.out.println(result);
		return "test";
	}
	
	@RequestMapping("/save")
	public String insert(Whiteboard dto) {
		WhiteboardEntity entity = service.toEntity(dto);
		repository.save(entity);
		return "redirect:test";
	}
	
	@RequestMapping("/update")
	public String update(Whiteboard dto) {
		WhiteboardEntity entity = service.toEntity(dto);
		repository.save(entity);
		return "test";
	}
	
	
	@RequestMapping("/delete")
	public String delete(int whiteboard_no) {
		repository.deleteById(whiteboard_no);
		return "redirect:test";
	}
	
	@RequestMapping("board_test")
	public void board_test() {
		
	}
	
//	@RequestMapping("/getOne")
//	public String getOne() {
//		WhiteboardEntity entity=repository.getById(1);
//		return null;
//	}
	
	
	
}

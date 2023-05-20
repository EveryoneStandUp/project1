package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Comment;
import com.example.demo.service.CommentService;

@Controller
@RequestMapping("comment")
public class CommentController {
	
	@Autowired
	private CommentService service;
	
	@PutMapping("update")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> update(@RequestBody Comment comment) {
		Map<String, Object> res = service.update(comment);
		
		return ResponseEntity.ok().body(res);
	}

	@GetMapping("id/{id}")
	@ResponseBody
	public Comment get(@PathVariable("id") Integer id) {
		return service.get(id);
	}
//	@RequestMapping(path = "id/{id}", method = RequestMethod.DELETE)
	@DeleteMapping("id/{id}")
	@ResponseBody	
	public ResponseEntity<Map<String, Object>> remove(@PathVariable("id") Integer id) { 
		Map<String, Object> res = service.remove(id);
		
		return ResponseEntity.ok().body(res);
		
	}
	
	@PostMapping("add")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> add(@RequestBody Comment comment) {
		
		Map<String, Object> res = service.add(comment);
		
		return ResponseEntity.ok().body(res);
	}
	
	@GetMapping("list")
	@ResponseBody
	public List<Comment> list(@RequestParam("board") Integer boardId) {
		
//		return List.of("댓1", "댓2", "댓3");
		return service.list(boardId);
	}
}

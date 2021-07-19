package com.hcc.controller;

import java.util.HashMap;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {
	@Autowired
	MongoTemplate mongoTemplate;
	
	@GetMapping("/get/all")
	public List<Document> getAll(){
		return mongoTemplate.findAll(Document.class, "TestCollection");
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add() {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("Test No", 1);
		mongoTemplate.insert(map, "TestCollection");
		return ResponseEntity.ok().body("Inserted");
	}
	
	@GetMapping("/get/test")
	public ResponseEntity<?> getMsg(){
		return ResponseEntity.ok().body("hello world Test");
		
	}

}

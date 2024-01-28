package com.example.BookStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookStore.Entity.BookData;
import com.example.BookStore.Service.BookService;

import jakarta.validation.Valid;

@RestController
public class Controller {
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/add-book")
	public ResponseEntity<?> addBook(@Valid @RequestBody BookData bookData) {
		bookService.addBook(bookData.getId(), bookData);
		return ResponseEntity.ok("Book data entered successfully");
	}
	
	@GetMapping("/get-book/{id}")
	public ResponseEntity<?> getBook(@PathVariable("id") int id) {
		return ResponseEntity.ok(bookService.getBook(id));
	}
}

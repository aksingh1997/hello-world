package com.example.BookStore.Dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.example.BookStore.Entity.BookData;

@Repository
public class BookDao {
	private static HashMap<Integer, BookData> bookMap = new HashMap<>();
	
	public void addBookData(int id, BookData bookData) {
		bookMap.put(id, bookData);
	}
	
	public BookData getBookData(int id) throws Exception {
		if(!bookMap.containsKey(id))
			throw new Exception("Cannot find book with id = " + id);
		return bookMap.get(id);
	}
}

package com.example.BookStore.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.BookStore.Dao.BookDao;
import com.example.BookStore.Entity.BookData;

@Service
public class BookService {
	final String className = "BookService";
	@Autowired
	BookDao bookDao;
	
	@Value("${book.discount}")
	double discount;
	
	final static Logger logger = LoggerFactory.getLogger(BookService.class);
	
	public void addBook(int id, BookData bookData) {
		final String methodName = "addBook";
			bookDao.addBookData(id, bookData);
		logger.info(className + ", " + methodName +  ", Got the book data");
	}
	
	public BookData getBook(int id) {
		final String methodName = "getBook";
		BookData bookData = null;
		try {
			bookData = bookDao.getBookData(id);
			logger.info("Got the discount amount = " + discount);
			double price = bookData.getPrice();
			double discountedPrice = price - price*(discount/100);
			bookData.setPrice(discountedPrice);
		} catch(Exception ex) {
			logger.error(className + " " + methodName + " no book record found for id provided, "+ ex.getMessage());
		}
		return bookData;
	}
}

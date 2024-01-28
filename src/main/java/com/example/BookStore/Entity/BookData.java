package com.example.BookStore.Entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookData {
	@NotNull(message = "Book Id cannot be null")
	private int id;
	private String name;
	private double price;
	
}

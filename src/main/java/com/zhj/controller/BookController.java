package com.zhj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhj.bean.Book;
import com.zhj.bean.ResultBook;
import com.zhj.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
//	获取柱状图、折线图
	@RequestMapping("/getbook1")
	@ResponseBody
	public List<Book> getAllBook(){
		return bookService.getAllBook();
	}
	
	@RequestMapping("/getbook2")
	@ResponseBody
	public List<ResultBook> getBook(){
		List<Book> allBook = bookService.getAllBook();
		List<ResultBook> list=new ArrayList<>();
		for (Book book : allBook) {
			ResultBook rb=new ResultBook();
			rb.setName(book.getBookName());
			rb.setValue(book.getPrice());
			list.add(rb);
		}
		return list;
	}
}

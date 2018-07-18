package com.zhj.service;

import java.lang.annotation.Target;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhj.bean.Book;
import com.zhj.dao.BookMapper;

@Service
public class BookService {

	@Autowired
	private BookMapper bookMapper;
	
	@Transactional(readOnly=true)
	public List<Book> getAllBook(){
		return bookMapper.getAllBooks();
	}
}

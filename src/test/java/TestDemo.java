import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhj.bean.Book;
import com.zhj.dao.BookMapper;
import com.zhj.service.BookService;

public class TestDemo {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		BookService bean = ac.getBean(BookService.class);
		List<Book> allBooks = bean.getAllBook();
		for (Book book : allBooks) {
			System.out.println(book.getBookName());
		}
		
	}

}

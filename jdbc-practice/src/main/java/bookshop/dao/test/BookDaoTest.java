package bookshop.dao.test;

import bookshop.example.Book;
import bookshop.main.BookDao;
import bookshop.main.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		testInsert();
	}

	private static void testInsert() {
		BookVo vo = null;
		BookDao dao = new BookDao();

		vo = new BookVo();
		vo.setTitle("트와일라잇");
		vo.setAuthorNo((long) 1);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("뉴문");
		vo.setAuthorNo((long) 1);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("이클립스");
		vo.setAuthorNo((long) 1);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("브레이킹던");
		vo.setAuthorNo((long) 1);
		dao.insert(vo);

		vo = new BookVo();
		vo.setTitle("아리랑");
		vo.setAuthorNo((long) 2);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("젊은그들");
		vo.setAuthorNo((long) 3);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("아프니깐 청춘이다");
		vo.setAuthorNo((long) 4);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("귀천");
		vo.setAuthorNo((long) 5);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("태백산맥");
		vo.setAuthorNo((long) 2);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("풀하우스");
		vo.setAuthorNo((long) 5);
		dao.insert(vo);

	}

}
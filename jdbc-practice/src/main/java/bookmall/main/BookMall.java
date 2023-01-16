package bookmall.main;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.OrderDao;
import bookmall.dao.UserDao;

public class BookMall {
	public static void main(String[] args) {
		System.out.println("## 회원리스트");
		UserDao.findAll();
		
		System.out.println("## 카테고리");
		CategoryDao.findAll();
		
		System.out.println("## 상품리스트");
		BookDao.findAll();
		
		System.out.println("## 카트");
		CartDao.findAll();
		//조인해서 이름, 수량, 책제목, 카테고리 다가져올것
		
		System.out.println("## 주문");
		OrderDao.findAll();

		System.out.println("## 주문 도서 리스트");
		//1개만 들어가게 하세요
	}
}

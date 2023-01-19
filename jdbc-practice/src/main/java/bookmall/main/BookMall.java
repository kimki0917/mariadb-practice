package bookmall.main;

import bookmall.dao.test.BookDaoTest;
import bookmall.dao.test.CartDaoTest;
import bookmall.dao.test.CategoryDaoTest;
import bookmall.dao.test.OrderBookDaoTest;
import bookmall.dao.test.OrderDaoTest;

public class BookMall {
	public static void main(String[] args) {
		System.out.println("## 회원리스트");
		//BookDaoTest.testInsert();
		BookDaoTest.testFindAll();
		
		System.out.println("## 카테고리");
		//CategoryDaoTest.testInsert();
		CategoryDaoTest.testFindAll();
		
		System.out.println("## 상품리스트");
		//BookDaoTest.testInsert();
		BookDaoTest.testFindAll();
		
		
		System.out.println("## 카트");
		//CartDaoTest.testInsert();
		CartDaoTest.testFindAll();
		
		System.out.println("## 주문");
		//OrderDaoTest.testInsert();
		OrderDaoTest.testFindAll();

		System.out.println("## 주문 도서 리스트");
		//OrderBookDaoTest.testInsert();
		OrderBookDaoTest.testFindAll();		
		
	}
}

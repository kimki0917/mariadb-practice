package bookmall.dao.test;


import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

import java.util.List;

public class BookDaoTest {

	public static void main(String[] args) {
		testInsert();
		testFindAll();
	}

	private static void testFindAll() {
		List<BookVo> result = new BookDao().findAll();
		for (BookVo vo : result) {
			System.out.println(vo.getNo() +". 카테고리 : "+ vo.getCategory() + " , 제목 : " + vo.getTitle()+ " , 가격 : " + vo.getPrice()+ " , 재고: " + vo.getQuantity());
		}
	}

	private static void testInsert() {
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
	}

}

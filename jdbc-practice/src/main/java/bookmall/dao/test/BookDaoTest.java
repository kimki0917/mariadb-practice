package bookmall.dao.test;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

import java.util.List;

public class BookDaoTest {

	public static void main(String[] args) {
		testInsert();
		testFindAll();
	}

	public static void testFindAll() {
		List<BookVo> result = new BookDao().findAll();
		for (BookVo vo : result) {
			System.out.println(vo.getNo() + ". 카테고리 : " + vo.getCategory() + " , 제목 : " + vo.getTitle() + " , 가격 : "
					+ vo.getPrice() + " , 재고: " + vo.getQuantity());
		}
	}

	public static void testInsert() {
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();

		vo.setTitle("트와일라잇");
		vo.setPrice(11700);
		vo.setCategoryNo(1);
		vo.setQuantity(100);
		dao.insert(vo);
		vo.setTitle("아프니깐 청춘이다");
		vo.setPrice(12600);
		vo.setCategoryNo(2);
		vo.setQuantity(100);
		dao.insert(vo);
		vo.setTitle("이것이자바다");
		vo.setPrice(32400);
		vo.setCategoryNo(3);
		vo.setQuantity(100);
		dao.insert(vo);
	}

}

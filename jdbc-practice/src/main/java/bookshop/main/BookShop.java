package bookshop.main;

import java.util.List;
import java.util.Scanner;

import bookshop.dao.test.AuthorDao;
import bookshop.dao.test.AuthorVo;

public class BookShop {

	public static void main(String[] args) {
		displayBookInfo();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("대여 하고 싶은 책의 번호를 입력하세요:");
		Long no = scanner.nextLong();
		scanner.close();
		
		BookVo vo = new BookVo();
		vo.setNo(no);
		vo.setRent("Y");
		
		boorRental(vo);
		
		
		displayBookInfo();
	}

	private static void boorRental(BookVo vo) {
		new BookDao().update(vo);
		displayBookInfo();
	}

	private static void displayBookInfo() {

		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			System.out.println(vo.getNo() + ". "+ vo.getTitle() +" - " + vo.getAuthorName()+ " : " + vo.getRent());
		}
	}
}
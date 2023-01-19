package bookmall.dao.test;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

import java.util.List;

public class CartDaoTest {

	public static void main(String[] args) {
		testInsert();
		testFindAll();
	}

	public static void testFindAll() {
		List<CartVo> result = new CartDao().findAll();
		for (CartVo vo : result) {
			System.out.println(vo.getNo() + "."+ vo.getUserName() + "의 장바구니 - 카테고리 : " + vo.getBookCategory() + " , 책 제목 : " + vo.getBooktitle() + " , 가격 : " + vo.getBookPrice()
					+ " , 수량 : " + vo.getQuantity());
		}
	}

	public static void testInsert() {
		CartDao dao = new CartDao();
		CartVo vo = new CartVo();
		vo.setQuantity(1);
		vo.setUserNo(1);
		vo.setBookNo(1);
		dao.insert(vo);
	}

}

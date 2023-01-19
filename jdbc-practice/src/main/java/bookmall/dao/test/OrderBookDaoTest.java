package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrderBookDao;
import bookmall.vo.OrderBookVo;

public class OrderBookDaoTest {

	public static void main(String[] args) {
		//testInsert();
		testFindAll();
		
	}

	public static void testFindAll() {
		List<OrderBookVo> result = new OrderBookDao().findAll();
		for (OrderBookVo vo : result) {
			System.out.println(" 주문자 : " + vo.getName()+", 주문번호 : "+ vo.getOrderNum() + ", 책 제목 : "+vo.getTitle() + ", 책 가격 : "+ vo.getPrice() + ", 수량 : " + vo.getQuantity());
		}
	}

	public static void testInsert() {
		OrderBookVo vo = new OrderBookVo();
		OrderBookDao dao = new OrderBookDao();
		
		vo.setQuantity(1);
		vo.setOrdersNo(1);
		vo.setBookNo(1);
		dao.insert(vo);
	}
}

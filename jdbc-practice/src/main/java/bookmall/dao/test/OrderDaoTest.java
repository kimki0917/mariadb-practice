package bookmall.dao.test;

import bookmall.dao.OrderDao;
import bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		testInsert();
		testFindAll();
	}

	private static void testFindAll() {
		// TODO Auto-generated method stub

	}

	private static void testInsert() {
		OrderVo vo = new OrderVo();
		OrderDao dao = new OrderDao();
		
		vo.setOrderNum("20230113-01");
		vo.setPayment(24300);
		vo.setAddress("부산광역시 해운대구 센텀동로 41 센텀벤처타운 701호");
		vo.setUserNo(1);
		dao.insert(vo);
		
		vo.setOrderNum("20230113-02");
		vo.setPayment(32400);
		vo.setAddress("부산광역시 해운대구 센텀동로 41 센텀벤처타운 601호");
		vo.setUserNo(2);
		dao.insert(vo);
	}

}

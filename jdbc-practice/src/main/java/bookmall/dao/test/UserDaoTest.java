package bookmall.dao.test;

import java.util.List;

import bookmall.dao.UserDao;
import bookmall.vo.UserVo;

public class UserDaoTest {
	public static void main(String[] args) {
		testInsert();
		testFindAll();
	}

	private static void testFindAll() {
		List<UserVo> result = UserDao.findAll();
		for (UserVo vo : result) {
			System.out.println(vo.getNo() + ". " + vo.getName() + " : " + vo.getPhone() + " , " + vo.getEmail() + " "
					+ vo.getPassword());
		}
	}

	private static void testInsert() {
		UserDao dao = new UserDao();
		UserVo vo = new UserVo();

		vo.setName("김철수");
		vo.setPhone("010-1234-5678");
		vo.setEmail("cs123@naver.com");
		vo.setPassword("1111");
		dao.insert(vo);

		vo.setName("이영희");
		vo.setPhone("010-2345-6789");
		vo.setEmail("yh123@naver.com");
		vo.setPassword("2222");
		dao.insert(vo);

	}
}

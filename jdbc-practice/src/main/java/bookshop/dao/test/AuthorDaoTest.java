package bookshop.dao.test;

import java.util.List;

import hr.dao.EmployeeDao;
import hr.vo.EmployeeVo;

public class AuthorDaoTest {

	public static void main(String[] args) {
		 testInsert();
		testFindAll();
	}

	private static void testInsert() {
		AuthorVo vo = null;
		AuthorDao dao = new AuthorDao();

		vo = new AuthorVo();
		vo.setName("스테파니메이어");
		dao.insert(vo);

		vo = new AuthorVo();
		vo.setName("김난도");
		dao.insert(vo);

		vo = new AuthorVo();
		vo.setName("천상변");
		dao.insert(vo);

		vo = new AuthorVo();
		vo.setName("원수연");
		dao.insert(vo);

		vo = new AuthorVo();
		vo.setName("조정래");
		dao.insert(vo);
	}

	private static void testFindAll() {

		List<AuthorVo> list = new AuthorDao().findAll();
		for (AuthorVo vo : list) {
			System.out.println(vo.getNo() + vo.getName());
		}
	}

}

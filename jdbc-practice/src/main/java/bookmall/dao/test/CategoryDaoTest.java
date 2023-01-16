package bookmall.dao.test;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

import java.util.List;

public class CategoryDaoTest {

	public static void main(String[] args) {
		testInsert();
		testFindAll();
	}

	private static void testFindAll() {
		List<CategoryVo> result = new CategoryDao().findAll();
		for (CategoryVo vo : result) {
			System.out.println(vo.getNo() + ". " + vo.getCategory());
		}
	}

	private static void testInsert() {
		CategoryDao dao = new CategoryDao();
		CategoryVo vo = new CategoryVo();
		
		vo.setCategory("소설");
		dao.insert(vo);
		
		vo.setCategory("수필");
		dao.insert(vo);
		
		vo.setCategory("인문");
		dao.insert(vo);
	}

}

package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;

public class CartDao {
	public void insert(CartVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into cart values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getQuantity());
			pstmt.setInt(2, vo.getUserNo());
			pstmt.setInt(3, vo.getBookNo());
			pstmt.setInt(4, vo.getBookCategoryNo());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<CartVo> findAll() {
		List<CartVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select a.no, b.name, c.title, c.price, a.quantity, d.category from cart a join user b join book c join category d on a.user_no = b.no and a.book_no = c.no and a.book_category_no =d.no;\r\n"
					+ "";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				CartVo vo = new CartVo();
				vo.setNo(rs.getInt(1));
				vo.setUserName(rs.getString(2));
				vo.setBooktitle(rs.getString(3));
				vo.setBookPrice(rs.getInt(4));
				vo.setQuantity(rs.getInt(5));
				vo.setBookCategory(rs.getString(6));
				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		for (CartVo vo : result) {
			System.out.println(vo.getNo() + "."+ vo.getUserName() + "의 장바구니 - 카테고리 : " + vo.getBookCategory() + " , 책 제목 : " + vo.getBooktitle() + " , 가격 : " + vo.getBookPrice()
					+ " , 수량 : " + vo.getQuantity());
		}
		return result;
	}

	private static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.10.122:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
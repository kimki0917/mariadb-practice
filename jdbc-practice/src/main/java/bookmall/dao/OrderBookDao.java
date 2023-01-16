//package bookmall.dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import bookmall.vo.OrderBookVo;
//
//public class OrderBookDao {
//	public void insert(OrderBookVo vo) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			conn = getConnection();
//
//			String sql = "insert into order_book values(null, ?, ?, ?, ?)";
//			pstmt = conn.prepareStatement(sql);
//
//			pstmt.setInt(1, vo.getQuantity());
//			pstmt.setInt(2, vo.getOrderNo());
//			pstmt.setInt(3, vo.getBookNo());
//			pstmt.setInt(4, vo.getBookCategoryNo());
//			pstmt.executeUpdate();
//
//		} catch (SQLException e) {
//			System.out.println("error:" + e);
//		} finally {
//			try {
//				if (pstmt != null) {
//					pstmt.close();
//				}
//
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public static List<OrderBookVo> findAll() {
//		List<OrderBookVo> result = new ArrayList<>();
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			conn = getConnection();
//
//			String sql = "select no, category from order_book order by no asc";
//			pstmt = conn.prepareStatement(sql);
//
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				OrderBookVo vo = new OrderBookVo();
//				vo.setNo(rs.getInt(1));
//				vo.setCategory(rs.getString(2));
//				result.add(vo);
//			}
//
//		} catch (SQLException e) {
//			System.out.println("error:" + e);
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//
//				if (pstmt != null) {
//					pstmt.close();
//				}
//
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		for (OrderBookVo vo : result) {
//			System.out.println(vo.getNo() + ". " + vo.getCategory());
//		}
//
//		return result;
//	}
//
//	private static Connection getConnection() {
//		Connection conn = null;
//
//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//			String url = "jdbc:mariadb://192.168.10.122:3307/bookmall?charset=utf8";
//			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로딩 실패:" + e);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//
//}
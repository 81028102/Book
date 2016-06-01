package cn.jbit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 任锯东
 * @date 2016-3-23 上午11:13:53
 */
public class BaseDao {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";//加载驱动字符串
	private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";//连接数据库URL
	private static final String user = "scott";//数据库用户名
	private static final String password = "orcl";//数据库密码
	private static Connection conn;
	//建立数据库连接
	public static Connection getConnection(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//关闭数据库连接conn.pstmt,rs
	public static void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
		try {
			if(conn!=null){ 
				conn.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(rs!=null){
				rs.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

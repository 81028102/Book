package cn.jbit.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.jbit.db.BaseDao;

/**
 * @author 任锯东
 * @date 2016-3-24 下午5:15:35
 */
@SuppressWarnings("serial")
public class UpdateServlet extends HttpServlet {

	private String id;
	private String name;
	private String author;
	private String type;
	private String intro;
	private String price;
	private String publishdate;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private int i;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {	
			//获取数据
			id=request.getParameter("id");
			name = request.getParameter("name");
			author = request.getParameter("author");
			type = request.getParameter("type");
			intro = request.getParameter("intro");
			price = request.getParameter("price");
			publishdate = request.getParameter("publishdate");
			//打开数据库连接
			conn = BaseDao.getConnection();
			//sql语句
			String sql="update bookk set name=?,author=?,type=?,intro=?,price=?,publishdate=? where id=?";
			//创建一个prepareStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, author);
			pstmt.setString(3, type);
			pstmt.setString(4, intro);
			pstmt.setInt(5,Integer.parseInt(price));
			pstmt.setString(6, publishdate);
			pstmt.setInt(7,Integer.parseInt(id));
			i = pstmt.executeUpdate();
			if(i>0){
				response.getWriter().write("修改成功");	
			}else{
				response.getWriter().write("修改失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭数据库连接
			BaseDao.closeAll(conn, pstmt, null);
		}
	}
}

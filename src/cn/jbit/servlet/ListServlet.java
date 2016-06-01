package cn.jbit.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.jbit.db.BaseDao;
import cn.jbit.entity.Bookk;

/**
 * @author 任锯东
 * @date 2016-3-24 下午2:55:07
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {

	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//将Book放进List集合中
			List<Bookk> list=new ArrayList<Bookk>();
			//打开数据库连接
			conn = BaseDao.getConnection();
			//sql语句
			String sql="select * from bookk";
			//创建一个prepareStatement对象
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new Bookk(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7)));
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("List.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭数据库连接
			BaseDao.closeAll(conn, pstmt, rs);
		}
	}
}

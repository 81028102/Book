package cn.jbit.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import cn.jbit.db.BaseDao;
import cn.jbit.entity.Bookk;

/**
 * @author 任锯东
 * @date 2016-3-24 下午5:22:30
 */
@SuppressWarnings("serial")
public class ToUpdateServlet extends HttpServlet {

	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private JSONObject json;
	private String id;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//获取数据
			id = request.getParameter("id");
			//打开数据库连接
			conn = BaseDao.getConnection();
			//sql语句
			String sql="select * from bookk where id=?";
			//创建一个prepareStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(id));
			Bookk bookk=null;
			rs = pstmt.executeQuery();
			while(rs.next()){
				bookk=new Bookk(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7));
			}
			json = JSONObject.fromObject(bookk);
			response.getWriter().print(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭数据库连接
			BaseDao.closeAll(conn, pstmt, rs);
		}
	}
}

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
 * @date 2016-3-24 下午3:29:03
 */
@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet {

	private String id;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private int i;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//获取数据
			id = request.getParameter("id");
			//打开数据库连接
			conn = BaseDao.getConnection();
			String sql="delete from bookk where id in("+id+")";
			pstmt = conn.prepareStatement(sql);
			i = pstmt.executeUpdate();
			if(i>0){
				response.getWriter().write("删除成功");
			}else{
				response.getWriter().write("删除失败");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭数据库连接
			BaseDao.closeAll(conn, pstmt,null);
		}
	}
}

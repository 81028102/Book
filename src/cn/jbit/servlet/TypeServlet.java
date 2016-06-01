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
import net.sf.json.JSONArray;
import cn.jbit.db.BaseDao;

/**
 * @author 任锯东
 * @date 2016-3-24 下午3:43:27
 */
@SuppressWarnings("serial")
public class TypeServlet extends HttpServlet {

	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private JSONArray json;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<String> bList=new ArrayList<String>();
			//打开数据库连接
			conn = BaseDao.getConnection();
			//sql语句
			String sql="select distinct type from bookk";
			//创建一个prepareStatement对象
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				bList.add(rs.getString(1));
			}
			json = JSONArray.fromObject(bList);
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

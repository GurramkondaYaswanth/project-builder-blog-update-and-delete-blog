package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface{

	@Override
	public void insertBlog(Blog blog) throws SQLException {
		// TODO Auto-generated method stub
		String BlogInsertion = "insert into BLOGS(	BLOD_ID,BLOG_TITLE,BLOG_DESCRIPTION) VALUES (?,?,?)";

		Connection c = null;
		c = ConnectionManager.getConnection();
		//access the string
		PreparedStatement ps = c.prepareStatement(BlogInsertion);
		ps.setInt(1, blog.getBlogId());
		ps.setString(2,blog.getBlogTitle());
		ps.setString(3,blog.getBlogDescription());
		
	}

	@Override
	public Blog selectBlog(int blogid) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM BLOGS where blog_id = blogid");
		Blog blog = new Blog();
//		while(rs.next())
//		{
//			if(rs.getInt(1) == blogid) {
		LocalDate date= LocalDate.now();
		
		blog.setBlogId(rs.getInt(1));
		blog.setBlogTitle(rs.getString(2));
		blog.setBlogDescription(rs.getString(3));
		blog.setPostedOn(date);
			
		return blog;
		
	}

	@Override
	public List<Blog> selectAllBlogs() throws SQLException {
		// TODO Auto-generated method stub
		List<Blog> list=new ArrayList<Blog>();
		
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM BLOGS");
		while(rs.next())
		{
			int id= rs.getInt(1);
			String name=rs.getString(2);
			String description =rs.getString(3);
			LocalDate date= LocalDate.now();
			Blog blog = new Blog();
			
			list.add(blog);
		}
		
		return list;
	}

	@Override
	public boolean deleteBlog(int id) throws SQLException {
		// TODO Auto-generated method stub
		String Blogdeletion = "DELETE FROM BLOGS WHERE BLOG_ID = id";
		Connection c = ConnectionManager.getConnection();
		//access the string
		PreparedStatement ps = c.prepareStatement(Blogdeletion);
		
		System.out.println("deleting..");
		int status = ps.executeUpdate();
		if(status > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBlog(Blog blog) throws SQLException, Exception {
		// TODO Auto-generated method stub
		int blogId = blog.getBlogId();
		String blogTitle = blog.getBlogTitle();
		String blogDescription = blog.getBlogDescription();
		LocalDate postedOn = blog.getPostedOn();
		String Blogdeletion = "	UPDATE BLOGS SET BLOG_TITLE = blogTitle, BLOG_DESCRIPTION = blogDescription WHERE BLOG_ID = blogId";
		Connection c = ConnectionManager.getConnection();
		//access the string
		PreparedStatement ps = c.prepareStatement(Blogdeletion);
		System.out.println("updating..");
		int status = ps.executeUpdate();
		if(status > 0) {
			return true;
		}
		return false;
	}
	
}
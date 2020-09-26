package dao;

import java.sql.SQLException;
import java.util.List;

import model.Blog;

public interface BlogDaoInterface {
	
		void insertBlog(Blog blog) throws SQLException;
		Blog selectBlog(int blogid) throws SQLException;
	    List<Blog> selectAllBlogs() throws SQLException;
		boolean deleteBlog(int id) throws SQLException;
		boolean updateBlog(Blog blog) throws SQLException, Exception;
	
}

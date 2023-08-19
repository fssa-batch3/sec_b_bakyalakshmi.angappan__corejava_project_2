package in.fssa.myfashionstudioapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.fssa.myfashionstudioapp.exception.PersistenceException;
import in.fssa.myfashionstudioapp.model.Category;
import in.fssa.myfashionstudioapp.model.Gender;
import in.fssa.myfashionstudioapp.util.ConnectionUtil;

public class CategoryDAO {

	/**
	 * 
	 * @param id
	 * @return
	 * @throws PersistenceException
	 */
	public List<Category> findAllCatgegoryByGenderId(int id) throws PersistenceException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Category> categoryList = new ArrayList<>();

		try {
			con = ConnectionUtil.getConnection();
			String query = "Select * From categories where genders_id = ?";

			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {

				Category category = new Category();

				category.setId(rs.getInt("id"));
				category.setName(rs.getString("category_name"));

				Gender gender = new Gender();
				gender.setId(id);

				category.setGender(gender);

				categoryList.add(category);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return categoryList;

	}

	////

	/**
	 * 
	 * @param id
	 * @return
	 * @throws PersistenceException
	 */
	public Category findCategoryByCategoryId(int id) throws PersistenceException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Category category = null;

		try {
			con = ConnectionUtil.getConnection();
			String query = "Select * From categories where id = ?";
			ps = con.prepareStatement(query);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {

				category = new Category();

				category.setId(id);
				category.setName(rs.getString("category_name"));
				category.getGender().setId(rs.getInt("genders_id"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return category;

	}

	// business validation

//	connect with db
// check the category aldready exists

	/**
	 * 
	 * @param id
	 * @return
	 * @throws PersistenceException
	 */
	public boolean categoryAlreadyExists(int id) throws PersistenceException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;

		try {
			String query = "Select * from categories where id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
			throw new PersistenceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps);
		}

		return flag;

	}

}

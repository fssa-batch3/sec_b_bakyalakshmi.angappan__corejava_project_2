package in.fssa.myfashionstudioapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import in.fssa.myfashionstudioapp.exception.PersistenceException;
import in.fssa.myfashionstudioapp.model.Price;
import in.fssa.myfashionstudioapp.util.ConnectionUtil;

public class PriceDAO {

	/**
	 * 
	 * @param price
	 * @throws PersistenceException
	 */
	public void createPrice(Price price) throws PersistenceException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String Query = "Insert into prices (products_id, sizes_id, price) values(?,?,?)";

			con = ConnectionUtil.getConnection();

			ps = con.prepareStatement(Query);

			ps.setInt(1, price.getProduct().getId());
			ps.setInt(2, price.getSize().getId());
			ps.setDouble(3, price.getPrice());

			ps.executeUpdate();

			System.out.println("created price");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
			throw new PersistenceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps);
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws PersistenceException
	 */
	public Price FindFirstPriceByProductId(int id) throws PersistenceException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Price price = null;

		try {
			String Query = "Select * from prices where products_id = ? and ended_at IS NULL order by sizes_id asc limit 1";

			con = ConnectionUtil.getConnection();

			ps = con.prepareStatement(Query);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				// There is at least one row
				price = new Price();

				price.setId(id);
				price.getProduct().setId(rs.getInt("products_id"));
				price.getSize().setId(rs.getInt("sizes_id"));
				price.setPrice(rs.getDouble("price"));
				price.setStartedAt(rs.getTimestamp("started_at"));
				price.setEndedAt(rs.getTimestamp("ended_at"));

				System.out.println("Retrieved price details");
			} else {
				System.out.println("No price details found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
			throw new PersistenceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return price;
	}

//	doubt on exception handling

	/**
	 * 
	 * @param id
	 * @return
	 * @throws PersistenceException
	 */
	public List<Price> FindAllPricesByProductId(int id) throws PersistenceException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Price> priceList = new ArrayList<>();

		try {
			String Query = "Select * from prices where products_id = ? and ended_at is null";

			con = ConnectionUtil.getConnection();

			ps = con.prepareStatement(Query);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				Price price = new Price();

				price.setId(id);
				price.getProduct().setId(rs.getInt("products_id"));
				price.getSize().setId(rs.getInt("sizes_id"));
				price.setPrice(rs.getDouble("price"));
				price.setStartedAt(rs.getTimestamp("started_at"));
				price.setEndedAt(rs.getTimestamp("ended_at"));

				priceList.add(price);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print(e.getMessage());

//			is this correct or wrong
			throw new PersistenceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return priceList;
	}

	/**
	 * 
	 * @param priceId
	 * @param dateTime
	 * @throws PersistenceException
	 */
	public void updateprice(int priceId, Timestamp dateTime) throws PersistenceException {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			String Query = "update prices set ended_at = ? where id = ?";

			con = ConnectionUtil.getConnection();

			ps = con.prepareStatement(Query);

			ps.setTimestamp(1, dateTime);
			ps.setInt(2, priceId);

			ps.executeUpdate();

			System.out.println("updated end date to current date");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
			throw new PersistenceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps);
		}

	}

	/**
	 * 
	 * @param productId
	 * @param sizeId
	 * @return
	 * @throws PersistenceException
	 */

	public Price findPriceBypProductIdAndSizeId(int productId, int sizeId) throws PersistenceException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Price price = null;

		try {
			String Query = "Select * from prices where products_id = ? and sizes_id = ? and ended_at is null";

			con = ConnectionUtil.getConnection();

			ps = con.prepareStatement(Query);

			ps.setInt(1, productId);
			ps.setDouble(2, sizeId);

			rs = ps.executeQuery();

			if (rs.next()) {
				price = new Price();

				price.setId(rs.getInt("id"));
				price.setPrice(rs.getDouble("price"));
				price.getProduct().setId(rs.getInt("products_id"));
				price.getSize().setId(rs.getInt("sizes_id"));

				System.out.println(price);

				System.out.println("found the price with end date null");
			} else {
				System.out.println("price not found with end date null");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
			throw new PersistenceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		System.out.println("find:" + price);

		return price;
	}

	// business validation - price Aldready Exists // enddate is null

	// {price , enddate : null} ==> true

	/**
	 * 
	 * @param productId
	 * @param sizeId
	 * @return
	 */
	public boolean priceAldreadyExists(int productId, int sizeId) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;

		try {
			String query = "Select * from prices where products_id = ? and sizes_id = ? and ended_at is null";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

			ps.setInt(1, productId);
			ps.setInt(2, sizeId);

			rs = ps.executeQuery();

			System.out.println(rs.next());

			if (rs.next()) {

				System.out.println("price exists with end date null ");
				flag = true; // price aldready exist if false
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return flag;
	}

}

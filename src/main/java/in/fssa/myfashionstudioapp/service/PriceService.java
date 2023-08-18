package in.fssa.myfashionstudioapp.service;

import java.util.List;

import com.google.protobuf.ServiceException;

import in.fssa.myfashionstudioapp.dao.PriceDAO;
import in.fssa.myfashionstudioapp.exception.PersistenceException;
import in.fssa.myfashionstudioapp.exception.ValidationException;
// cannot import the service exception
//import in.fssa.myfashionstudioapp.exception.ServiceException;
import in.fssa.myfashionstudioapp.model.Price;
import in.fssa.myfashionstudioapp.validator.PriceValidator;

public class PriceService {
	/**
	 * 
	 * @param price
	 * @throws ValidationException
	 * @throws ServiceException
	 */
	public void createPrice(Price price) throws ValidationException, ServiceException {

		System.out.println("in create ");
		try {
			PriceValidator.Validate(price);

			PriceDAO priceDao = new PriceDAO();
			priceDao.createPrice(price);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new ValidationException(e.getMessage());
		} catch (PersistenceException e) {

			e.printStackTrace();
			throw new ServiceException(e);
		}

	}

	// check this method

	/**
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public Price FindFirstPriceByProductId(int id) throws ServiceException {
		Price price = null;
		try {
			PriceDAO priceDao = new PriceDAO();
			price = priceDao.FindFirstPriceByProductId(id);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}

		return price;
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */

	public List<Price> FindAllPricesByProductId(int id) throws ServiceException {

		try {
			PriceDAO priceDao = new PriceDAO();
			return priceDao.FindAllPricesByProductId(id);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * 
	 * @param priceId
	 * @throws ServiceException
	 */

	public void updateprice(int priceId) throws ServiceException {

		// ask - need for form validation
		// ask - is there any need to again check whether the product and size exists in
		// their tables or not

		try {

			// again checking form validation

			PriceDAO priceDao = new PriceDAO();
			System.out.println("in update price service way to dao");
			priceDao.updateprice(priceId);

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException("Error update price :" + e.getMessage());
		}

	}

	/**
	 * 
	 * @param productId
	 * @param sizeId
	 * @return
	 * @throws ServiceException
	 */
	public Price findPriceBypProductIdAndSizeId(int productId, int sizeId) throws ServiceException {
		Price price = null;

		try {

			// need to check the productid in product table

//			ProductValidator.rejectIfInvalidproduct(productId); // change

			// need to check the sizeid in size table
//
//			SizeValidator.rejectIfSizeNotExists(sizeId);

			PriceDAO priceDao = new PriceDAO();
			price = priceDao.findPriceBypProductIdAndSizeId(productId, sizeId);
			System.out.println("found the price with the given product id and size id");

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException("Error update price :" + e.getMessage());
		}

		return price;
	}

}

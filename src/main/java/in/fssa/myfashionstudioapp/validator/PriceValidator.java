package in.fssa.myfashionstudioapp.validator;

import java.util.List;

import in.fssa.myfashionstudioapp.model.Price;

public class PriceValidator {

	// rejectIfInvalidPrice

	/**
	 * 
	 * @param price
	 * @throws RuntimeException
	 */
	public static void rejectIfInvalidPrice(Double price) throws RuntimeException {
		if (price <= 0.0d || price >= 10000.0d) {
			throw new RuntimeException("Invalid price input");
		}

	}

	// validate price for creating price

	/**
	 * 
	 * @param price
	 */
	public static void Validate(Price price) { // {} => { price, size }

		PriceValidator.rejectIfInvalidPrice(price.getPrice());

	}

	public static void ValidateAll(List<Price> priceList) {

		for (Price price : priceList) { // [ {}, {}, {} ]
			PriceValidator.rejectIfInvalidPrice(price.getPrice()); // {} => { price size }

			// business validation - reject If Size Not Exists
			SizeValidator.rejectIfSizeNotExists(price.getSize().getId());
		}
	}

////	check if price not end date = null 
//	public static boolean checkIfPriceAldreadyExists(int productId, int sizeId) {
//		PriceDAO priceDao = new PriceDAO();
//		return priceDao.priceAldreadyExists(productId, sizeId);
//
//	}
//
////	id {products_id : 1 , sizes_id = 2 , end_date = 23/04/2023} ==> false
//	public static void rejectIfPriceNotFound(int productId, int sizeId) {
//
//		if (!(checkIfPriceAldreadyExists(productId, sizeId))) {
//			throw new RuntimeException(
//					"price not found with end date as null for this product id " + productId + "and size id " + sizeId);
//		}
//
//	}

}

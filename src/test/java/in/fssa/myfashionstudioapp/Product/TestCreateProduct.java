package in.fssa.myfashionstudioapp.Product;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import in.fssa.myfashionstudioapp.dto.ProductDTO;
import in.fssa.myfashionstudioapp.exception.ValidationException;
import in.fssa.myfashionstudioapp.model.Category;
import in.fssa.myfashionstudioapp.model.Price;
import in.fssa.myfashionstudioapp.model.Size;
import in.fssa.myfashionstudioapp.service.ProductService;

public class TestCreateProduct {

	@Test
	public void createProductWithValidInput() {

		// create the dto instance

		ProductDTO productDto = new ProductDTO();

		List<Price> priceList = productDto.getPriceList();

		//
		Price price1 = new Price();

		Size size1 = new Size();
		size1.setId(1);

		price1.setSize(size1);
		price1.setPrice(600.00d);
		//

		//
		Price price2 = new Price();

		Size size2 = new Size();
		size2.setId(2);

		price2.setSize(size2);
		price2.setPrice(290.00d);
		//

		priceList.add(price1);
		priceList.add(price2);

		//

		productDto.setPriceList(priceList);

		Category category = new Category();
		category.setId(1);

		productDto.setCategory(category);
		productDto.setName("v-neck neck T-shirt");
		productDto.setDescription("v-neck typography printed navy blue color T-shirt ");

		ProductService productService = new ProductService();

		assertDoesNotThrow(() -> {
			productService.createProductWithPrices(productDto);
		});
	}

	@Test
	public void createProductWithInvalidInput() {

		ProductService productService = new ProductService();

		Exception exception = assertThrows(ValidationException.class, () -> {

			productService.createProductWithPrices(null);

		});

		String ExpectedMessage = "Validation error: Product cannot be Null";
		String actualMessage = exception.getMessage();

		System.out.println(actualMessage);

		assertTrue(ExpectedMessage.equals(actualMessage));
	}

	@Test
	public void createProductNameWithNull() {

		// create the dto instance

		ProductDTO productDto = new ProductDTO();

		List<Price> priceList = productDto.getPriceList();

		//
		Price price1 = new Price();

		Size size1 = new Size();
		size1.setId(1);

		price1.setSize(size1);
		price1.setPrice(600.00d);
		//

		//
		Price price2 = new Price();

		Size size2 = new Size();
		size2.setId(2);

		price2.setSize(size2);
		price2.setPrice(290.00d);
		//

		priceList.add(price1);
		priceList.add(price2);

		//

		productDto.setPriceList(priceList);

		Category category = new Category();
		category.setId(1);

		productDto.setCategory(category);
		productDto.setName(null);
		productDto.setDescription("v-neck typography printed navy blue color T-shirt ");

		ProductService productService = new ProductService();

		Exception exception = assertThrows(ValidationException.class, () -> {

			productService.createProductWithPrices(productDto);

		});

		String ExpectedMessage = "Validation error: Product name cannot be null or empty";
		String actualMessage = exception.getMessage();

		System.out.println(actualMessage);

		assertTrue(ExpectedMessage.equals(actualMessage));

	}

	@Test
	public void createProductNameWithEmpty() {

		// create the dto instance

		ProductDTO productDto = new ProductDTO();

		List<Price> priceList = productDto.getPriceList();

		//
		Price price1 = new Price();

		Size size1 = new Size();
		size1.setId(1);

		price1.setSize(size1);
		price1.setPrice(600.00d);
		//

		//
		Price price2 = new Price();

		Size size2 = new Size();
		size2.setId(2);

		price2.setSize(size2);
		price2.setPrice(290.00d);
		//

		priceList.add(price1);
		priceList.add(price2);

		//

		productDto.setPriceList(priceList);

		Category category = new Category();
		category.setId(1);

		productDto.setCategory(category);
		productDto.setName("");
		productDto.setDescription("v-neck typography printed navy blue color T-shirt ");

		ProductService productService = new ProductService();

		Exception exception = assertThrows(ValidationException.class, () -> {

			productService.createProductWithPrices(productDto);

		});

		String ExpectedMessage = "Validation error: Product name cannot be null or empty";
		String actualMessage = exception.getMessage();

		System.out.println(actualMessage);

		assertTrue(ExpectedMessage.equals(actualMessage));

	}

	@Test
	public void createProductDescriptionWithNull() {

		// create the dto instance

		ProductDTO productDto = new ProductDTO();

		List<Price> priceList = productDto.getPriceList();

		//
		Price price1 = new Price();

		Size size1 = new Size();
		size1.setId(1);

		price1.setSize(size1);
		price1.setPrice(600.00d);
		//

		//
		Price price2 = new Price();

		Size size2 = new Size();
		size2.setId(2);

		price2.setSize(size2);
		price2.setPrice(290.00d);
		//

		priceList.add(price1);
		priceList.add(price2);

		//

		productDto.setPriceList(priceList);

		Category category = new Category();
		category.setId(1);

		productDto.setCategory(category);
		productDto.setName("v-neck neck T-shirt");
		productDto.setDescription(null);

		ProductService productService = new ProductService();

		Exception exception = assertThrows(ValidationException.class, () -> {

			productService.createProductWithPrices(productDto);

		});

		String ExpectedMessage = "Validation error: Product description cannot be null or empty";
		String actualMessage = exception.getMessage();

		System.out.println(actualMessage);

		assertTrue(ExpectedMessage.equals(actualMessage));

	}

	@Test
	public void createProductDescriptionWithEmpty() {

		// create the dto instance

		ProductDTO productDto = new ProductDTO();

		List<Price> priceList = productDto.getPriceList();

		//
		Price price1 = new Price();

		Size size1 = new Size();
		size1.setId(1);

		price1.setSize(size1);
		price1.setPrice(600.00d);
		//

		//
		Price price2 = new Price();

		Size size2 = new Size();
		size2.setId(2);

		price2.setSize(size2);
		price2.setPrice(290.00d);
		//

		priceList.add(price1);
		priceList.add(price2);

		//

		productDto.setPriceList(priceList);

		Category category = new Category();
		category.setId(1);

		productDto.setCategory(category);
		productDto.setName("v-neck neck T-shirt");
		productDto.setDescription("");

		ProductService productService = new ProductService();

		Exception exception = assertThrows(ValidationException.class, () -> {

			productService.createProductWithPrices(productDto);

		});

		String ExpectedMessage = "Validation error: Product description cannot be null or empty";
		String actualMessage = exception.getMessage();

		System.out.println(actualMessage);

		assertTrue(ExpectedMessage.equals(actualMessage));

	}

	@Test
	public void createProductWithInvalidCategory() {

		// create the dto instance

		ProductDTO productDto = new ProductDTO();

		List<Price> priceList = productDto.getPriceList();

		//
		Price price1 = new Price();

		Size size1 = new Size();
		size1.setId(1);

		price1.setSize(size1);
		price1.setPrice(600.00d);
		//

		//
		Price price2 = new Price();

		Size size2 = new Size();
		size2.setId(2);

		price2.setSize(size2);
		price2.setPrice(290.00d);
		//

		priceList.add(price1);
		priceList.add(price2);

		//

		productDto.setPriceList(priceList);

		int invalidCategoryId = -1;
		Category category = new Category();
		category.setId(invalidCategoryId);

		productDto.setCategory(category);

		productDto.setName("v-neck neck T-shirt");
		productDto.setDescription("v-neck typography printed navy blue color T-shirt");

		ProductService productService = new ProductService();

		Exception exception = assertThrows(ValidationException.class, () -> {

			productService.createProductWithPrices(productDto);

		});

		String ExpectedMessage = "Validation error: Invalid catgeory input";
		String actualMessage = exception.getMessage();

		System.out.println(actualMessage);

		assertTrue(ExpectedMessage.equals(actualMessage));

	}

	@Test
	public void createProductCategoryDoesNotExist() {

		// create the dto instance

		ProductDTO productDto = new ProductDTO();

		List<Price> priceList = productDto.getPriceList();

		//
		Price price1 = new Price();

		Size size1 = new Size();
		size1.setId(1);

		price1.setSize(size1);
		price1.setPrice(600.00d);
		//

		//
		Price price2 = new Price();

		Size size2 = new Size();
		size2.setId(2);

		price2.setSize(size2);
		price2.setPrice(290.00d);
		//

		priceList.add(price1);
		priceList.add(price2);

		//

		productDto.setPriceList(priceList);

		int invalidCategoryId = 15;
		Category category = new Category();
		category.setId(invalidCategoryId);

		productDto.setCategory(category);

		productDto.setName("v-neck neck T-shirt");
		productDto.setDescription("v-neck typography printed navy blue color T-shirt");

		ProductService productService = new ProductService();

		Exception exception = assertThrows(ValidationException.class, () -> {

			productService.createProductWithPrices(productDto);

		});

		String ExpectedMessage = "Validation error: Category with ID " + invalidCategoryId + " does not exist";
		String actualMessage = exception.getMessage();

		System.out.println(actualMessage);

		assertTrue(ExpectedMessage.equals(actualMessage));

	}

	// testing the gender_id forign key

	@Test
	public void createProductwithInvalidPriceNull() {

		// create the dto instance

		ProductDTO productDto = new ProductDTO();

		List<Price> priceList = productDto.getPriceList();

		//
		Price price1 = new Price();

		Size size1 = new Size();
		size1.setId(1);

		price1.setSize(size1);
		price1.setPrice(700.00d);
		//

		//
		Price price2 = new Price();

		Size size2 = new Size();
		size2.setId(2);

		price2.setSize(size2);
		price2.setPrice(290.00d);
		//

		priceList.add(null);
		priceList.add(price2);

		//

		productDto.setPriceList(priceList);
		productDto.getCategory().setId(1);
		productDto.setName("v-neck neck T-shirt");
		productDto.setDescription("v-neck typography printed navy blue color T-shirt");

		ProductService productService = new ProductService();

		Exception exception = assertThrows(ValidationException.class, () -> {

			productService.createProductWithPrices(productDto);

		});

		String ExpectedMessage = "Validation error: price cannot be null";
		String actualMessage = exception.getMessage();

		System.out.println(actualMessage);

		assertTrue(ExpectedMessage.equals(actualMessage));

	}

	@Test
	public void createProductWithInvalidPricebelow100() {

		// create the dto instance

		ProductDTO productDto = new ProductDTO();

		List<Price> priceList = productDto.getPriceList();

		//
		Price price1 = new Price();

		Size size1 = new Size();
		size1.setId(1);

		price1.setSize(size1);
		price1.setPrice(0.0);
		//

		//
		Price price2 = new Price();

		Size size2 = new Size();
		size2.setId(2);

		price2.setSize(size2);
		price2.setPrice(290.00d);
		//

		priceList.add(price1);
		priceList.add(price2);

		//

		productDto.setPriceList(priceList);
		int CategoryId = 1;

		productDto.setPriceList(priceList);
		Category category = new Category();
		category.setId(CategoryId);

		productDto.setCategory(category);
		productDto.setName("v-neck neck T-shirt");
		productDto.setDescription("v-neck typography printed navy blue color T-shirt");

		ProductService productService = new ProductService();

		Exception exception = assertThrows(ValidationException.class, () -> {

			productService.createProductWithPrices(productDto);

		});

		String ExpectedMessage = "Validation error: Invalid price input , price must be between 100 to 10000";
		String actualMessage = exception.getMessage();

		System.out.println(actualMessage);

		assertTrue(ExpectedMessage.equals(actualMessage));

	}

	@Test
	public void createProductWithInvalidPriceAbove10000() {

		// create the dto instance

		ProductDTO productDto = new ProductDTO();

		List<Price> priceList = productDto.getPriceList();

		//
		Price price1 = new Price();

		Size size1 = new Size();
		size1.setId(1);

		price1.setSize(size1);
		price1.setPrice(120.00d);
		//

		//
		Price price2 = new Price();

		Size size2 = new Size();
		size2.setId(2);

		price2.setSize(size2);
		price2.setPrice(100000.00);
		//

		priceList.add(price1);
		priceList.add(price2);

		//

		productDto.setPriceList(priceList);
		int CategoryId = 1;

		productDto.setPriceList(priceList);
		Category category = new Category();
		category.setId(CategoryId);

		productDto.setCategory(category);
		productDto.setName("v-neck neck T-shirt");
		productDto.setDescription("v-neck typography printed navy blue color T-shirt");

		ProductService productService = new ProductService();

		Exception exception = assertThrows(ValidationException.class, () -> {

			productService.createProductWithPrices(productDto);

		});

		String ExpectedMessage = "Validation error: Invalid price input , price must be between 100 to 10000";
		String actualMessage = exception.getMessage();

		System.out.println(actualMessage);

		assertTrue(ExpectedMessage.equals(actualMessage));

	}

	@Test
	public void createProductWithInvalidSizeInput() {

		// create the dto instance

		ProductDTO productDto = new ProductDTO();

		List<Price> priceList = productDto.getPriceList();

		//
		Price price1 = new Price();

		Size size1 = new Size();
		size1.setId(-1);

		price1.setSize(size1);
		price1.setPrice(700);
		//

		//
		Price price2 = new Price();

		Size size2 = new Size();
		size2.setId(2);

		price2.setSize(size2);
		price2.setPrice(290.00d);
		//

		priceList.add(price1);
		priceList.add(price2);

		//

		int invalidCategoryId = 1;

		productDto.setPriceList(priceList);
		int CategoryId = 1;

		productDto.setPriceList(priceList);
		Category category = new Category();
		category.setId(CategoryId);

		productDto.setCategory(category);
		productDto.setName("v-neck neck T-shirt");
		productDto.setDescription("v-neck typography printed navy blue color T-shirt");

		ProductService productService = new ProductService();

		Exception exception = assertThrows(ValidationException.class, () -> {

			productService.createProductWithPrices(productDto);

		});

		String ExpectedMessage = "Validation error: Invalid size input";
		String actualMessage = exception.getMessage();

		System.out.println(actualMessage);

		assertTrue(ExpectedMessage.equals(actualMessage));

	}

	@Test
	public void createProductSizeDoesNotExist() {

		// create the dto instance

		ProductDTO productDto = new ProductDTO();

		List<Price> priceList = productDto.getPriceList();

		//
		Price price1 = new Price();

		int invalidSizeInput = 19;

		Size size1 = new Size();
		size1.setId(invalidSizeInput);

		price1.setSize(size1);
		price1.setPrice(600.00);
		//

		//
		Price price2 = new Price();

		Size size2 = new Size();
		size2.setId(2);

		price2.setSize(size2);
		price2.setPrice(290.00);
		//

		priceList.add(price1);
		priceList.add(price2);

		//

		int CategoryId = 1;

		productDto.setPriceList(priceList);
		Category category = new Category();
		category.setId(CategoryId);

		productDto.setCategory(category);
		productDto.setName("v-neck neck T-shirt");
		productDto.setDescription("v-neck typography printed navy blue color T-shirt");

		ProductService productService = new ProductService();

		Exception exception = assertThrows(ValidationException.class, () -> {

			productService.createProductWithPrices(productDto);

		});

		String ExpectedMessage = "Validation error: Size with ID " + invalidSizeInput + " does not exist";
		String actualMessage = exception.getMessage();

		System.out.println(actualMessage);

		assertTrue(ExpectedMessage.equals(actualMessage));

	}

}

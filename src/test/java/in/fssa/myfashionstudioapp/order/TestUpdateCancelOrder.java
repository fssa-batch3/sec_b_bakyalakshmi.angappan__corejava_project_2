package in.fssa.myfashionstudioapp.order;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.fssa.myfashionstudioapp.service.OrderService;

public class TestUpdateCancelOrder {

	@Test
	public void updateCancelOrder() {

		OrderService orderService = new OrderService();

		assertDoesNotThrow(() -> {
			orderService.cancelOrder(18, "ordered by mistake");
		});

	}

}

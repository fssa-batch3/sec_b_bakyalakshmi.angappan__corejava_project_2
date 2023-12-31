package in.fssa.myfashionstudioapp.dto;

import java.util.ArrayList;
import java.util.List;

import in.fssa.myfashionstudioapp.model.Price;
import in.fssa.myfashionstudioapp.model.Product;

public class ProductDTO extends Product {

	protected List<Price> priceList = new ArrayList<>();

	public List<Price> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<Price> priceList) {
		this.priceList = priceList;
	}

	@Override
	public String toString() {
		return "ProductDTO [priceList=" + priceList + ", id=" + id + ", image=" + image + ", name=" + name
				+ ", pattern=" + pattern + ", fit=" + fit + ", material=" + material + ", length=" + length
				+ ", riseType=" + riseType + ", closureType=" + closureType + ", sleeveType=" + sleeveType
				+ ", necklineType=" + necklineType + ", occasion=" + occasion + ", care=" + care + ", description="
				+ description + ", color=" + color + ", category=" + category + ", status=" + status + "]";
	}

}

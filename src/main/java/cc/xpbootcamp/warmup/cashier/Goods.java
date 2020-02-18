package cc.xpbootcamp.warmup.cashier;

public class Goods {
	private String name;
	private double price;
	private int quantity;

	public Goods(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    double getTotalAmount() {
        return price * quantity;
    }
}
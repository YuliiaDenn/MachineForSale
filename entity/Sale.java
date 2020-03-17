package entity;

import entity.Product.Name;

public class Sale {

	int idSale;
	Name name;
	int amount;

	public int getIdSale() {
		return idSale;
	}

	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + idSale;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		if (amount != other.amount)
			return false;
		if (idSale != other.idSale)
			return false;
		if (name != other.name)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sale [idSale=" + idSale + ", name=" + name + ", amount=" + amount + "]";
	}
}

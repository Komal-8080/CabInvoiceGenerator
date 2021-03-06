package InvoiceService;

public class InvoiceSummary {

	private int numberOfRides;
	private double totalFare;
	private double averageFare;

	public InvoiceSummary(int numberOfRides, double totalFare) {
		this.numberOfRides = numberOfRides;
		this.totalFare = totalFare;
		this.averageFare = this.totalFare/this.numberOfRides;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(averageFare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + numberOfRides;
		temp = Double.doubleToLongBits(totalFare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		InvoiceSummary other = (InvoiceSummary) obj;
		if (Double.doubleToLongBits(averageFare) != Double.doubleToLongBits(other.averageFare))
			return false;
		if (numberOfRides != other.numberOfRides)
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InvoiceSummary [numberOfRides=" + numberOfRides + ", totalFare=" + totalFare + ", averageFare="
				+ averageFare + "]";
	}	
}

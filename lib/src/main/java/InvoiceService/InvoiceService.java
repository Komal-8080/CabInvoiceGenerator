package InvoiceService;

public class InvoiceService {

	public static final double MINIMUM_COST_PER_KILOMETER = 10.0;
	public static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5;
	
	public static final double MINIMUM_COST_PER_KILOMETER_PREMIUM = 15.0;
	public static final int COST_PER_TIME_PREMIUM = 2;
	private static final double MINIMUM_FARE_PREMIUM = 20;
	
	
	public enum RideMode {NORMAL, PREMIUM};
	private RideRepository rideRepository;

	public InvoiceService() {
		this.rideRepository = new RideRepository();
	}

	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
		return Math.max(totalFare, MINIMUM_FARE);
	}
	
	public double calculateFarePremium(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KILOMETER_PREMIUM + time * COST_PER_TIME_PREMIUM;
		return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			if (ride.rideMode.equals(RideMode.NORMAL))
			totalFare += this.calculateFare(ride.distance, ride.time);
			else if(ride.rideMode.equals(RideMode.PREMIUM))
				totalFare += this.calculateFarePremium(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRides(userId, rides);
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));
	}
}

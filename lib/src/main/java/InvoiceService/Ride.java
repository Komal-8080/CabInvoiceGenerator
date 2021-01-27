package InvoiceService;

import InvoiceService.InvoiceService.RideMode;

public class Ride {
	
	
	public double distance;
	public int time;
	public static InvoiceService.RideMode rideMode;

	public Ride(double distance, int time, InvoiceService.RideMode rideMode) {
		this.distance = distance;
		this.time = time;
		this.rideMode = rideMode;
	}

}

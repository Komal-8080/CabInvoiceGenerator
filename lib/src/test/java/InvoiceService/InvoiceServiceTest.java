package InvoiceService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {

	@Before
	public void setUp() throws Exception {
	InvoiceService invoiceService = new InvoiceService();
	}
	
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceService invoiceService = new InvoiceService();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
		InvoiceService invoiceService = new InvoiceService();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}
	
	/*@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {		
		InvoiceService invoiceService = new InvoiceService();
		Ride[] rides = {new Ride(2.0, 5),
						new Ride(0.1, 1)};
		InvoiceSummary summary = invoiceService.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	
	}*/
	
	/*@Test
	public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
		InvoiceService invoiceService = new InvoiceService();
		String userId = "a@b.com";
		Ride[] rides = {new Ride(2.0, 5),
				new Ride(0.1, 1)};
	invoiceService.addRides(userId, rides);
	InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);	
	InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
	Assert.assertEquals(expectedInvoiceSummary, summary);
	}*/
	
	@Test
	public void givenUserIdAndRides_ShouldReturn_InvoiceSummary() {
		InvoiceService invoiceService = new InvoiceService();
		String userId = "a@b.com";
		Ride[] rides = {new Ride(2.0, 5, InvoiceService.RideMode.NORMAL),
				new Ride(0.1, 1, InvoiceService.RideMode.NORMAL)};
		invoiceService.addRides(userId, rides);
	InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);	
	InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
	Assert.assertEquals(expectedInvoiceSummary, summary);
	
	}
	
	@Test
	public void givenUserIdAndPremiumRides_ShouldReturn_InvoiceSummary() {
		InvoiceService invoiceService = new InvoiceService();
		String userId = "a@b.com";
		Ride[] rides1 = {new Ride(2.0, 5, InvoiceService.RideMode.PREMIUM),
				new Ride(0.1, 1, InvoiceService.RideMode.PREMIUM)};
		invoiceService.addRides(userId, rides1);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
	
	@Test
	public void givenUserIdAndBothModeOfRides_ShouldReturn_InvoiceSummary() {
		InvoiceService invoiceService = new InvoiceService();
		String userId = "a@b.com";
		Ride[] rides2 = {new Ride(2.0, 5, InvoiceService.RideMode.PREMIUM),
				new Ride(0.1, 1, InvoiceService.RideMode.NORMAL)};
		invoiceService.addRides(userId, rides2);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
}
package manytomany;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class ManyToManyTest2 {

	
	BaseRepository baseRepo = new BaseRepository();
	
	@Test
	public void addCustomersAddSubscriptions()
	{
		Customer2 cust1 = new Customer2();
		cust1.setCustName("SEETA");
		cust1.setCustEmail("seeta@gmai.com");
		
		Customer2 cust2 = new Customer2();
		cust2.setCustName("GEETA");
		cust2.setCustEmail("geeta@gmai.com");
		
		Customer2 cust3 = new Customer2();
		cust3.setCustName("REETA");
		cust3.setCustEmail("reeta@gmai.com");
		
		Subscription2 sub1 = new Subscription2();
		sub1.setSubscriptionName("Magazines");
		sub1.setSubscriptionDuration("1 month");
		
		Subscription2 sub2 = new Subscription2();
		sub2.setSubscriptionName("CDs");
		sub2.setSubscriptionDuration("2 months");
		
		
		
		baseRepo.persist(cust1);
		baseRepo.persist(cust2);
		baseRepo.persist(cust3);
	
		baseRepo.persist(sub1);
		baseRepo.persist(sub2);
		
	}
	
	
	
	@Test
	public void assignExistingSubscriptionsToExistingCustomers()
	{
		Customer2 cust = baseRepo.find(Customer2.class, 26);
		
		//Subscription2 sub1 = baseRepo.find(Subscription2.class, 29);
		Subscription2 sub2 = baseRepo.find(Subscription2.class, 30);
		
		CustomerSubscriptionLink custSubLink = new CustomerSubscriptionLink();
		custSubLink.setSubscriptionDate(LocalDate.now());
		custSubLink.setCustomer(cust);
		custSubLink.setSubscription(sub2);
		
		baseRepo.merge(custSubLink); //save or update
		
		
	}
}

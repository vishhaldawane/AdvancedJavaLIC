package manytomany;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class ManyToManyTest {

	
	BaseRepository baseRepo = new BaseRepository();
	
	@Test
	public void addCustomers()
	{
		Customer cust1 = new Customer();
		cust1.setCustName("Jack");
		cust1.setCustEmail("jack@gmai.com");
		
		Customer cust2 = new Customer();
		cust2.setCustName("Jane");
		cust2.setCustEmail("jane@gmai.com");
		
		Customer cust3 = new Customer();
		cust3.setCustName("Julie");
		cust3.setCustEmail("julie@gmai.com");
		
		baseRepo.persist(cust1);
		baseRepo.persist(cust2);
		baseRepo.persist(cust3);
	
	}
	
	@Test
	public void addSubscriptions() {
		
		Subscription sub1 = new Subscription();
		sub1.setSubscriptionName("Books");
		sub1.setSubscriptionDuration("6 months");
		
		Subscription sub2 = new Subscription();
		sub2.setSubscriptionName("DVDs");
		sub2.setSubscriptionDuration("3 months");
		
		
		baseRepo.persist(sub1);
		baseRepo.persist(sub2);
		
	}
	
	@Test
	public void assignExistingSubscriptionsToExistingCustomers()
	{
		Customer cust = baseRepo.find(Customer.class, 22);
		Subscription sub1 = baseRepo.find(Subscription.class, 24);
		Subscription sub2 = baseRepo.find(Subscription.class, 25);
		
		/*
		 * 
		cust.getSubscriptions().add(sub1);
		cust.getSubscriptions().add(sub2);
		*/
		
		Set<Subscription> mySet = new HashSet<Subscription>();
		mySet.add(sub1);
		mySet.add(sub2);
		
		cust.setSubscriptions(mySet);
		baseRepo.merge(cust);
		
	}
}

package manytomany;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CustomerSubscriptionLink")
public class CustomerSubscriptionLink {
	
	@Id
	@GeneratedValue
	private int customerSubscriptionId;
	
	@ManyToOne
	private Customer2 customer;
	
	@ManyToOne
	private Subscription2 subscription;
	
	@Column(name="sub_date")
	private LocalDate subscriptionDate;

	public int getCustomerSubscriptionId() {
		return customerSubscriptionId;
	}

	public void setCustomerSubscriptionId(int customerSubscriptionId) {
		this.customerSubscriptionId = customerSubscriptionId;
	}

	public Customer2 getCustomer() {
		return customer;
	}

	public void setCustomer(Customer2 customer) {
		this.customer = customer;
	}

	public Subscription2 getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription2 subscription) {
		this.subscription = subscription;
	}

	public LocalDate getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(LocalDate subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	
	

}

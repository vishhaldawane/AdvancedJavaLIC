package manytomany;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity //Named 
@Table(name="customer1") //SQL  - select * from customer1 where cust_id  
public class Customer { //HQL - select * from Customer c where c.customerId

	@Id //EmbeddedId <-- STD+DIV+ROLLNO
	@GeneratedValue
	@Column(name="cust_id")
	int customerId;
	
	@Column(name="cust_name")
	String custName;
	
	@Column(name="cust_email")
	String custEmail;
	
	@ManyToMany
	@JoinTable(name="CustomerSubscriptionLink2", 
	joinColumns={@JoinColumn(name="cid")},
	inverseJoinColumns={@JoinColumn(name="sid")})
	Set<Subscription> subscriptions = new HashSet<Subscription>();; 
}

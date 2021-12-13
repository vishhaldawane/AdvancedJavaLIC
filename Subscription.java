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

@Entity
@Table(name="subscription1")
public class Subscription {

	@Id
	@GeneratedValue
	@Column(name="sub_id")
	int subscriptionId;
	
	@Column(name="sub_name")
	String subscriptionName;
	
	@Column(name="sub_duration")
	String subscriptionDuration;
	
	
	@ManyToMany
	@JoinTable(name="CustomerSubscriptionLink2", 
	joinColumns={@JoinColumn(name="sid")},
	inverseJoinColumns={@JoinColumn(name="cid")})

	Set<Customer> customers = new HashSet<Customer>();;
}




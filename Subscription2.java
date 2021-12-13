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
@Table(name="subscription2")
public class Subscription2 {

	@Id
	@GeneratedValue
	@Column(name="sub_id")
	private int subscriptionId;
	
	@Column(name="sub_name",length=20)
	private String subscriptionName;
	
	@Column(name="sub_duration",length=20)
	private String subscriptionDuration;
	
	
	
	public int getSubscriptionId() {
		return subscriptionId;
	}


	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}


	public String getSubscriptionName() {
		return subscriptionName;
	}


	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}


	public String getSubscriptionDuration() {
		return subscriptionDuration;
	}


	public void setSubscriptionDuration(String subscriptionDuration) {
		this.subscriptionDuration = subscriptionDuration;
	}


	

	
}





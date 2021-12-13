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
@Table(name="customer2") //SQL  - select * from customer1 where cust_id  
public class Customer2 { //HQL - select * from Customer c where c.customerId

	@Id //EmbeddedId <-- STD+DIV+ROLLNO
	@GeneratedValue
	@Column(name="cust_id")
	private int customerId;
	
	@Column(name="cust_name", length=20)
	private String custName;
	
	@Column(name="cust_email",length=20)
	private String custEmail;
	
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}


	

	
}

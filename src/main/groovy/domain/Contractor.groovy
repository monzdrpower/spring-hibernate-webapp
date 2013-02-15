package domain;

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity(name = "CRM_CONTRACTORS")
class Contractor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Long id;

	@Column(name = "CUSTOMER_NAME")
	String customerName;

	@Column(name = "APPROVED")
	Boolean approved;
	
	@Column(name = "START_DATE")
	Calendar startDate;

}

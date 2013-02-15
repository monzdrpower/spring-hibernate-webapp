package service;

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import domain.Contractor


@Service('contractorService')
public class ContractorServiceImpl implements ContractorService {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		sessionFactory.getCurrentSession()
	}
	
	@Transactional
	Contractor create(String customerName) {
		Contractor contractor = new Contractor()
		contractor.customerName = customerName
		contractor.approved  = false
		contractor.startDate = Calendar.getInstance()
		
		currentSession.persist(contractor)
		contractor
	}

	@Transactional(readOnly = true)
	Contractor get(Long id) {
		currentSession.find(Contractor.class, id);
	}

	@Transactional
	void delete(Long id) {
		Contractor contractor = currentSession.find(Contractor.class, id);
		currentSession.createQuery("delete from ${Contractor.class.name} c where c.id = $contractor.id").executeUpdate()
	}

	@Transactional(readOnly = true)
	List<Contractor> list() {
		currentSession.createQuery("select c from ${Contractor.class.name} c").list();
	}

}

package serviceimport java.util.List;

import domain.Contractor;

interface ContractorService {

	Contractor create(String customerName)
	Contractor get(Long id)
	void delete(Long id)
	List<Contractor> list()}

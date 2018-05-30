package com.sas.sanction.service;

import com.sas.sanction.entities.SanctionCustomer;

public interface SanctionCustomerService {
	public SanctionCustomer getSanctionCustomerByCustomerId(String customerId);
	public SanctionCustomer insertSanctionCustomer(SanctionCustomer sanctionCustomer);
}

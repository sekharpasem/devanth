package com.expenner.devanth.partner.dao;

import com.expenner.devanth.partner.model.Partner;
import com.expenner.devanth.partner.model.PartnerMenu;

public interface PartnerDao {

	boolean isAlreadyRegisterPartner(String username);

	Partner save(Partner partner);

	PartnerMenu getPartnerMenu(String partnerId);

	PartnerMenu savePartnerMenu(PartnerMenu partnerMenu);

	Partner getPartner(String partnerId);

}

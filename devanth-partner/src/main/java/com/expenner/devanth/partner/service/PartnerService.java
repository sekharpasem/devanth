package com.expenner.devanth.partner.service;

import com.expenner.devanth.partner.bean.RegisterPartner;
import com.expenner.devanth.partner.exception.PartnerAlreadyExist;
import com.expenner.devanth.partner.exception.PartnerNotFoundException;
import com.expenner.devanth.partner.model.Partner;
import com.expenner.devanth.partner.model.PartnerMenu;

public interface PartnerService {

	Partner register(RegisterPartner regPartner) throws PartnerAlreadyExist;

	PartnerMenu getPartnerMenu(String partnerId) throws PartnerNotFoundException;

	PartnerMenu savePartnerMenu(PartnerMenu partnerMenu);

	PartnerMenu updatePartnerMenu(String partnerId, PartnerMenu partnerMenu) throws PartnerNotFoundException;

	Partner getPartner(String partnerId);

}

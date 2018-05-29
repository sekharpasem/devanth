package com.expenner.devanth.partner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenner.devanth.partner.bean.RegisterPartner;
import com.expenner.devanth.partner.dao.PartnerDao;
import com.expenner.devanth.partner.exception.PartnerAlreadyExist;
import com.expenner.devanth.partner.exception.PartnerNotFoundException;
import com.expenner.devanth.partner.model.Partner;
import com.expenner.devanth.partner.model.PartnerMenu;

@Service
public class PartnerServiceImpl implements PartnerService {
	@Autowired
	PartnerDao partnerDao;

	@Override
	public Partner register(RegisterPartner regPartner) throws PartnerAlreadyExist {
		Partner partner = null;
		if (regPartner != null) {
			if (partnerDao.isAlreadyRegisterPartner(regPartner.getUsername()))
				throw new PartnerAlreadyExist("Partner already exists with partnername " + regPartner.getUsername());
			else
				return registerPartner(regPartner);

		}
		return partner;
	}

	private Partner registerPartner(RegisterPartner regPartner) {
		Partner partner = new Partner(regPartner.getName(), regPartner.getUsername(), regPartner.getPassword(),
				regPartner.getPhone());
		return partnerDao.save(partner);
	}

	@Override
	public PartnerMenu getPartnerMenu(String partnerId) throws PartnerNotFoundException {
		PartnerMenu partnerMenu = null;
		if (partnerId != null) {
			partnerMenu = partnerDao.getPartnerMenu(partnerId);
			if (partnerMenu == null)
				throw new PartnerNotFoundException();
		}
		return partnerMenu;
	}

	@Override
	public PartnerMenu savePartnerMenu(PartnerMenu partnerMenu) {
		PartnerMenu model = null;
		if (partnerMenu != null) {
			model = partnerDao.savePartnerMenu(partnerMenu);
		}
		return model;
	}

	@Override
	public PartnerMenu updatePartnerMenu(String partnerId, PartnerMenu partnerMenu) throws PartnerNotFoundException {

		PartnerMenu model = null;
		if (partnerMenu != null && partnerId != null) {
			PartnerMenu dbModel = getPartnerMenu(partnerId);
			partnerMenu.setId(dbModel.getId());
			model = partnerDao.savePartnerMenu(partnerMenu);
		}
		return model;
	}

	@Override
	public Partner getPartner(String partnerId) {
		Partner partner = null;
		if (partnerId != null) {
			partner=partnerDao.getPartner(partnerId);
		}
		return partner;
	}

}

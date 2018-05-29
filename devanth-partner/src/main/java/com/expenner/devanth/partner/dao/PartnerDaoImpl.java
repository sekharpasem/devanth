package com.expenner.devanth.partner.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.expenner.devanth.partner.model.Partner;
import com.expenner.devanth.partner.model.PartnerMenu;
import com.expenner.devanth.partner.repo.PartnerMenuRepository;
import com.expenner.devanth.partner.repo.PartnerRepository;

@Repository
public class PartnerDaoImpl implements PartnerDao {
	@Autowired
	PartnerRepository partnerRepository;
	@Autowired
	PartnerMenuRepository partnerMenuRepository;

	@Override
	public boolean isAlreadyRegisterPartner(String username) {
		if (username != null) {
			Partner partner = partnerRepository.findByUsernameAndDeleted(username, false);
			if (partner != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Partner save(Partner partner) {
		if (partner != null) {
			return partnerRepository.save(partner);
		}
		return null;
	}

	@Override
	public PartnerMenu getPartnerMenu(String partnerId) {
		PartnerMenu partnerMenu = null;
		if (partnerId != null) {
			partnerMenu = partnerMenuRepository.findByPartnerIdAndDeleted(partnerId, false);
		}
		return partnerMenu;
	}

	@Override
	public PartnerMenu savePartnerMenu(PartnerMenu partnerMenu) {
		PartnerMenu model = null;
		if (partnerMenu != null) {
			model = partnerMenuRepository.save(partnerMenu);
		}
		return model;
	}

	@Override
	public Partner getPartner(String partnerId) {
		Partner partner = null;
		if (partnerId != null) {
			partner = partnerRepository.findByIdAndDeleted(partnerId, false);
		}
		return partner;
	}

}

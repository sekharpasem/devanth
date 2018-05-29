package com.expenner.devanth.partner.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.expenner.devanth.partner.model.PartnerMenu;

public interface PartnerMenuRepository extends MongoRepository<PartnerMenu, String> {

	PartnerMenu findByPartnerIdAndDeleted(String partnerId, boolean deleted);

}

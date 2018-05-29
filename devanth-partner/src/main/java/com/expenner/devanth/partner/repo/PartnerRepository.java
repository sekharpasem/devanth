package com.expenner.devanth.partner.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.expenner.devanth.partner.model.Partner;

public interface PartnerRepository extends MongoRepository<Partner, String> {

	Partner findByUsernameAndDeleted(String username, boolean deleted);

	Partner findByIdAndDeleted(String partnerId, boolean deleted);

}

package com.expenner.devanth.partner.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenner.devanth.partner.bean.RegisterPartner;
import com.expenner.devanth.partner.exception.PartnerAlreadyExist;
import com.expenner.devanth.partner.exception.PartnerNotFoundException;
import com.expenner.devanth.partner.model.Partner;
import com.expenner.devanth.partner.model.PartnerMenu;
import com.expenner.devanth.partner.service.PartnerService;
import com.expenner.devanth.partner.util.response.DataResult;
import com.expenner.devanth.partner.util.response.ResponseWrapper;

@RestController
@RequestMapping("/partners")
@SuppressWarnings("rawtypes")
public class PartnerController {
	@Autowired
	PartnerService partnerService;

	@PostMapping("/register")
	public ResponseEntity<DataResult> register(@RequestBody RegisterPartner registerPartner)
			throws PartnerAlreadyExist {
		ResponseEntity<DataResult> response = null;
		if (registerPartner != null) {
			Partner partner = partnerService.register(registerPartner);
			response = partner == null ? ResponseWrapper.wrapBadRequestResponse("Partner registration is failed.")
					: ResponseWrapper.wrapSuccessResponse("Partner registration is successfull.");
		}
		return response;
	}

	@GetMapping("/{partnerId}")
	public ResponseEntity<DataResult> getPartnerDetails(@PathParam(value = "partnerId") String partnerId)
			throws PartnerNotFoundException {
		ResponseEntity<DataResult> response = null;
		if (partnerId != null) {
			Partner partner = partnerService.getPartner(partnerId);
			response = partner != null ? ResponseWrapper.wrapSuccessResponse(partner)
					: ResponseWrapper.wrapNoContentResponse();
		}
		return response;
	}

	@GetMapping("/{partnerId}/menu")
	public ResponseEntity<DataResult> getPartnerMenu(@PathParam(value = "partnerId") String partnerId)
			throws PartnerNotFoundException {
		ResponseEntity<DataResult> response = null;
		if (partnerId != null) {
			PartnerMenu menu = partnerService.getPartnerMenu(partnerId);
			response = menu != null ? ResponseWrapper.wrapSuccessResponse(menu)
					: ResponseWrapper.wrapNoContentResponse();
		}
		return response;
	}

	@PostMapping("/menu")
	public ResponseEntity<DataResult> savePartnerMenu(@RequestBody PartnerMenu partnerMenu) {
		ResponseEntity<DataResult> response = null;
		if (partnerMenu != null) {
			PartnerMenu model = partnerService.savePartnerMenu(partnerMenu);
			response = model != null ? ResponseWrapper.wrapSuccessResponse(model)
					: ResponseWrapper.wrapNoContentResponse();
		}
		return response;
	}

	@PutMapping("/{partnerId}/menu")
	public ResponseEntity<DataResult> updatePartnerMenu(@PathVariable("partnerId") String partnerId,
			@RequestBody PartnerMenu partnerMenu) throws PartnerNotFoundException {
		ResponseEntity<DataResult> response = null;
		if (partnerMenu != null) {
			PartnerMenu model = partnerService.updatePartnerMenu(partnerId, partnerMenu);
			response = model != null ? ResponseWrapper.wrapSuccessResponse(model)
					: ResponseWrapper.wrapNoContentResponse();
		}
		return response;
	}
}

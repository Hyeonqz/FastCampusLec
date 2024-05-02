package org.example.api.domain.storemenu.controller;

import java.util.List;

import org.example.api.common.api.Api;
import org.example.api.domain.storemenu.business.StoreMenuBusiness;
import org.example.api.domain.storemenu.controller.model.StoreMenuResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/store-menu")
@RestController
public class StoreMenuApiController {
	private final StoreMenuBusiness storeMenuBusiness;

	@GetMapping("/search")
	public Api<List<StoreMenuResponse>> search(@RequestParam Long storeId) {
		List<StoreMenuResponse> search = storeMenuBusiness.search(storeId);
		return Api.OK(search);
	}
}

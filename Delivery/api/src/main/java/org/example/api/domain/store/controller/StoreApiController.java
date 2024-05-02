package org.example.api.domain.store.controller;

import java.util.List;

import org.example.api.common.api.Api;
import org.example.api.domain.store.business.StoreBusiness;
import org.example.api.domain.store.controller.model.StoreResponse;
import org.example.db.store.enums.StoreCategory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/store")
@RequiredArgsConstructor
@RestController
public class StoreApiController {
	private final StoreBusiness storeBusiness;

	// 가맹점 조회는 로그인한 경우만 가능하게
	@GetMapping("/search")
	public Api<List<StoreResponse>> search(@RequestParam(required = false)StoreCategory storeCategory) {
		List<StoreResponse> storeResponses = storeBusiness.searchCategory(storeCategory);
		return Api.OK(storeResponses);
	}


}

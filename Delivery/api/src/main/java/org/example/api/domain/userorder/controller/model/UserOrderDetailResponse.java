package org.example.api.domain.userorder.controller.model;

import java.util.List;

import org.example.api.domain.store.controller.model.StoreResponse;
import org.example.api.domain.storemenu.controller.model.StoreMenuResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UserOrderDetailResponse {

	private UserOrderResponse userOrderResponse;
	private StoreResponse storeResponse;
	private List<StoreMenuResponse> storeMenuResponseList;

}

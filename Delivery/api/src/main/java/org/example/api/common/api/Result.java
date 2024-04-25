package org.example.api.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {

	private Integer resultCode;
	private String resultMessage;
	private String resultDescription;

	// Result 가 OK 일시 반환하는 메소드
	public static Result OK() {
		return Result.builder()
			.resultCode(200)
			.resultMessage("OK")
			.resultDescription("성공")
			.build();
	}
}

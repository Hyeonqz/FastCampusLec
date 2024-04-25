package org.example.api.common.api;

import org.example.api.common.error.ErrorCode;
import org.example.api.common.error.ErrorCodeInterface;

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
			.resultCode(ErrorCode.OK.getErrorCode())
			.resultMessage(ErrorCode.OK.getDescription())
			.resultDescription("성공") // 상세 메세지
			.build();
	}

	// 어떠한 에러코드가 넘어올지 모르니 인터페이스를 파라미터로 받아서 처리하는 로직
	public static Result ERROR(ErrorCodeInterface errorCodeInterface) {
		return Result.builder()
			.resultCode(errorCodeInterface.getErrorCode())
			.resultMessage(errorCodeInterface.getDescription())
			.resultDescription("Error 발생") // 상세 메세지
			.build();
	}

	// 에러코드 인터페이스와, 최상위 예외를 받아서 에러를 처리하는 로직
	public static Result ERROR(ErrorCodeInterface errorCodeInterface, Throwable throwable) {
		return Result.builder()
			.resultCode(errorCodeInterface.getErrorCode())
			.resultMessage(errorCodeInterface.getDescription())
			.resultDescription(throwable.getLocalizedMessage()) // 상세 메세지 -> 위험할 수도 있는 로직이다. -> Server 에 모든 Stack trace 가 내려간다.
			.build();
	}

	// 보통 제일 많이 쓰는 로직 -> 에러 코드와 어떤 상황이다 를 넘겨줌
	public static Result ERROR(ErrorCodeInterface errorCodeInterface, String message) {
		return Result.builder()
			.resultCode(errorCodeInterface.getErrorCode())
			.resultMessage(errorCodeInterface.getDescription())
			.resultDescription(message) // 메세지 description
			.build();
	}
}

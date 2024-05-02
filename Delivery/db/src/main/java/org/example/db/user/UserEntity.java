package org.example.db.user;

import java.time.LocalDateTime;

import org.example.db.BaseEntity;
import org.example.db.user.enums.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder // 상속 받을 때는 SuperBuilder 사용
@EqualsAndHashCode(callSuper = true) // 상속 받는게 있을 때는 위 어노테이션을 사용한다.
@Getter
// @Table(name="user") // 클래스 이름이 뭐든 어노테이션에 명시해둔 이름 으로 테이블을 생성한다.
@Entity(name = "user") // entity 어노테이션이 있으면 데이터베이스에선 카멜케이스가 아닌, 스네이크 케이스로 바꿔서 테이블을 찾게 된다.
public class UserEntity extends BaseEntity {

	@Column(length = 50, nullable = false)
	private String name;
	@Column(length = 100, nullable = false)
	private String email;
	@Column(length = 100, nullable = false)
	private String password;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	@Column(length = 150, nullable = false)
	private String address;

	private LocalDateTime registeredAt;
	private LocalDateTime unregisteredAt;
	private LocalDateTime lastLoginAt;

	// 회원가입시 데이터를 미리 넣기 위한 메소드
	public void register () {
		this.status = UserStatus.REGISTERED;
		this.registeredAt = LocalDateTime.now();
	}

}

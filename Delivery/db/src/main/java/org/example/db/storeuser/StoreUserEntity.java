package org.example.db.storeuser;

import java.time.LocalDateTime;

import org.example.db.BaseEntity;
import org.example.db.storeuser.enums.StoreUserRole;
import org.example.db.storeuser.enums.StoreUserStatus;

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
@Getter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity(name="store_user")
public class StoreUserEntity extends BaseEntity {

	@Column(nullable = false)
	private Long storeId;

	@Column(nullable = false, length = 100)
	private String password;

	@Column(nullable = false, length = 100)
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "varchar(50)", nullable = false)
	private StoreUserStatus status;

	@Column(columnDefinition = "varchar(50)",nullable = false)
	@Enumerated(EnumType.STRING)
	private StoreUserRole role;


	private LocalDateTime registeredAt;
	private LocalDateTime unregisteredAt;
	private LocalDateTime lastLoginAt;
}

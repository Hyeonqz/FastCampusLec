package org.example.db.userordermenu;

import org.example.db.BaseEntity;
import org.example.db.userordermenu.enums.UserOrderMenuStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Getter
@Entity(name="user_order_menu")
public class UserOrderMenuEntity extends BaseEntity {
	private Long userOrderId; // 1:n (user 와 1:n)
	private Long storeMenuId; // 1:n (store 와 1:n)

	@Column(columnDefinition = "varchar(50)", nullable = false)
	@Enumerated(EnumType.STRING)
	private UserOrderMenuStatus status;

}

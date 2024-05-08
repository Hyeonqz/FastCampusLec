package org.example.db.store;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.example.db.BaseEntity;
import org.example.db.store.enums.StoreCategory;
import org.example.db.store.enums.StoreStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
@SuperBuilder
@EqualsAndHashCode
@Getter
@Entity(name="store")
public class StoreEntity extends BaseEntity {

	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 150, nullable = false)
	private String address;

	@Column(columnDefinition = "varchar(50)")
	@Enumerated(EnumType.STRING)
	private StoreStatus status;

	@Column(columnDefinition = "varchar(50)")
	@Enumerated(EnumType.STRING)
	private StoreCategory category;

	// default 0 으로 설정해둔건 자동으로 들어간다?
	private double star;

	@Column(length = 200, nullable = false)
	private String thumbnailUrl;

	@Column(precision = 11, scale = 4, nullable = false)
	private BigDecimal minimumAmount;

	@Column(precision = 11, scale = 4, nullable = false)
	private BigDecimal minimumDeliveryAmount;

	@Column(length = 20)
	private String phoneNumber;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	public void register() {
		this.star = 0;
		this.status = StoreStatus.REGISTERED;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}

}

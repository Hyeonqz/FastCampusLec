package org.example.db.storemenu;

import java.math.BigDecimal;

import org.example.db.BaseEntity;
import org.example.db.storemenu.enums.StoreMenuStatus;

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
@Entity(name="store_menu")
public class StoreMenuEntity extends BaseEntity {

	@Column(nullable = false)
	private Long storeId;
	@Column(length = 100,nullable = false)
	private String name;
	@Column(precision = 11, scale = 4, nullable = false)
	private BigDecimal amount;

	@Column(columnDefinition = "varchar(50)", nullable = false)
	@Enumerated(EnumType.STRING)
	private StoreMenuStatus status;
	@Column(length = 200,nullable = false)
	private String thumbnailUrl;
	private Integer likeCount;
	private Integer sequence;

	public void setRegister () {
		this.status = StoreMenuStatus.REGISTERED;
	}
}

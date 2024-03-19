package com.delivery.db.account;

import com.delivery.db.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@SuperBuilder //부모로 부터 받은 변수도 포함 시키겠다.
@EqualsAndHashCode(callSuper = true) // 객체 비교할 때 사용한다. -> 부모에 있는 값까지 포함해서 비교할지 안할지를 말한다.
@Data
@Entity
@Table(name="account")
public class AccountEntity extends BaseEntity {




}

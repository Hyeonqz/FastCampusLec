package org.example.db.account;

import org.example.db.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder // 부모로 부터 상속받는 변수도 포함시킬 경우 사용
@EqualsAndHashCode(callSuper = true) // 객체 비교할 때 사용 -> true -> 부모에 있는 값까지 포함해서 비교할 것인지 현재만 비교할 것인지
@AllArgsConstructor
@Getter
@Table(name="account")
@Entity
public class AccountEntity extends BaseEntity {

}

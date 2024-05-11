package org.delivery.storeadmin.domain.authorization.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.example.db.storeuser.enums.StoreUserRole;
import org.example.db.storeuser.enums.StoreUserStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSession implements UserDetails {
	// 인터페이스를 구현받아서 재정의를 하면은 내 입맛대로 만들 수 있다.

	// user
	private Long userId;
	private String password;
	private String email;
	private StoreUserStatus status;
	private StoreUserRole role;
	private LocalDateTime registeredAt;
	private LocalDateTime unregisteredAt;
	private LocalDateTime lastLoginAt;

	// store
	private Long storeId;
	private String storeName;


	// 현재 권한을 넘겨주는 로직
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities () {
		return List.of(new SimpleGrantedAuthority(this.role.toString()));
	}

	@Override
	public String getPassword () {
		return this.password;
	}

	@Override
	public String getUsername () {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired () {
		return this.status == StoreUserStatus.REGISTERED;
	}

	@Override
	public boolean isAccountNonLocked () {
		return this.status == StoreUserStatus.UNREGISTERED;
	}

	@Override
	public boolean isCredentialsNonExpired () {
		return this.status == StoreUserStatus.REGISTERED;
	}

	@Override
	public boolean isEnabled () {
		return true;
	}

}

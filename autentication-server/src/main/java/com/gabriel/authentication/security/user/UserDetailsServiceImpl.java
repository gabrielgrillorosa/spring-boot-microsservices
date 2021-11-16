package com.gabriel.authentication.security.user;

import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gabriel.authentication.model.ApplicationUser;
import com.gabriel.authentication.repository.ApplicationUserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailsServiceImpl implements UserDetailsService {
	private final ApplicationUserRepository applicationUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		log.info("Searching in the DB the user by username '{}'", username);

		ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);

		log.info("ApplicationUser found '{}'", applicationUser);

		if (applicationUser == null)
			throw new UsernameNotFoundException(String.format("Application user '%s' not found", username));

		return new CustomUserDetails(applicationUser);
	}

	private static final class CustomUserDetails extends ApplicationUser implements UserDetails {

		private static final long serialVersionUID = 1L;

		public CustomUserDetails(ApplicationUser applicationUser) {
			super(applicationUser);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return commaSeparatedStringToAuthorityList("ROLE_".concat(getRole()));
		}

		@Override
		public boolean isAccountNonExpired() {

			return true;
		}

		@Override
		public boolean isAccountNonLocked() {

			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {

			return true;
		}

		@Override
		public boolean isEnabled() {

			return true;
		}
	}
}

package com.example.demo.webSecurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails{
		
	    private Long id;
	    
	    private String name;
	    
	    private int age;
	    
	    private String phone;
	    
	    private String loc;

	    private String email;

	    private String password;
	    
	    private String roles;
	    
	    //@Builder.Default
	    private List<GrantedAuthority> role = new ArrayList<GrantedAuthority>();

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	    	role.add(new SimpleGrantedAuthority(roles));
	    	return role;
	    }
//	        return this.roles.stream()
//	                .map(SimpleGrantedAuthority::new)
//	                .collect(Collectors.toList());
//	    }

	    public String getUsername() {
	        return email;
	    }

	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    public boolean isEnabled() {
	        return true;
	    }


}

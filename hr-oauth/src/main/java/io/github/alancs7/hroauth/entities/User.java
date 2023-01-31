package io.github.alancs7.hroauth.entities;

import java.util.HashSet;
import java.util.Set;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	private Long id;
	private String name;
	private String email;
	private String password;

	@Setter(value = AccessLevel.NONE)
	private final Set<Role> roles = new HashSet<>();
}

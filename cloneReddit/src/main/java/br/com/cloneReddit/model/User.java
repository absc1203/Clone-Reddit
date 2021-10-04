package br.com.cloneReddit.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("deprecation")
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long userId;
	@NotBlank(message = "Usuário obrigatório")
	private String username;
	@NotBlank(message = "Senha obrigatória")
	private String password;
	@Email
	@NotEmpty(message = "Email obrigatório")
	private String email;
	private Instant created;
	private Boolean enabled;
	
	

}

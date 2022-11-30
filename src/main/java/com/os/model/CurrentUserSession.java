package com.os.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class CurrentUserSession {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer currSessionId;

	@NotNull(message = "Email is require")
	@Email
	private String email;

	@NotNull(message = "Date time is require")
	private LocalDateTime loginDateTime;

	@NotNull(message = "Role is require")
	private String role;

	private String privateKey;

}

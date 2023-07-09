package domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Role {

	// Идентификатор должности
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	// Наименование должности
	@NotNull
	@Size(min=5, message="Имя должно содержать не менее 5 символов")
	private String namerole;
}
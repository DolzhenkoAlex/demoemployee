package domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Person {
	
	// Идентификатор сотрудника
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    
    // Имя
	@NotNull
	@Size(min=5, message="Имя должно содержать не менее 3 символов")
    private String firstName;
    
    // Фамилия
	@NotNull
	@Size(min=5, message="Имя должно содержать не менее 5 символов")
	private String lastName;
    
    // Телефон
    private String phone;
    
    // email
    private String email;
    
    // Внешний ключ -ссылка на сущность Role
    //private Long idRole;
    
 // Навигационное свойства - ссылка на должность
    @ManyToOne
    @JoinColumn(name = "RoleId")
    private Role role;
}

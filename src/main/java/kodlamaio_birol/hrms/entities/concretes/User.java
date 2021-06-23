package kodlamaio_birol.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import kodlamaio_birol.hrms.core.utilities.UniqueEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @javax.validation.constraints.NotNull
    private int id;

    @javax.validation.constraints.NotNull(message = "{mx.constraint.email.NotNull.message}")
    @Column(name = "email")
    @UniqueEmail
    private String email;

    @javax.validation.constraints.NotNull
    @Column(name = "password")
    @Size(min = 8, max=255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",message="{mx.constrain.password.Pattern.message}")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


}

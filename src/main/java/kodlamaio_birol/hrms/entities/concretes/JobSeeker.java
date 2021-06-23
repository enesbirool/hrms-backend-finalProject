package kodlamaio_birol.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobseekers", uniqueConstraints = {@UniqueConstraint(columnNames = {"identity_number"})})
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "curriculaVitaes"})
public class JobSeeker extends User {

    @Column(name = "first_name")
    @Size(min=3,max=255)
    @javax.validation.constraints.NotNull(message = "{mx.constraint.firstName.NotNull.message}")
    private String firstName;

    @Column(name = "last_name")
    @javax.validation.constraints.NotNull(message = "{mx.constraint.lastName.NotNull.message}")
    @Size(min=2,max=255)
    private String lastName;

    @Column(name = "identity_number")
    @javax.validation.constraints.NotNull
    private String identityNumber;

    @Column(name = "birth_date")
    @javax.validation.constraints.NotNull
    private LocalDate birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL)
    private List<CurriculaVitae> curriculaVitaes;
}
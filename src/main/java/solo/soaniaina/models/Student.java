package solo.soaniaina.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="firstname")
    String firstname;

    @Column(name="lastname")
    String lastname;

    @Column(name="address")
    String address;

    @Column(name="telephone")
    String telephone;

    @Column(name="matricule")
    String matricule;

    @Column(name="email")
    @Email
    String email;

    @Column(name="niveau")
    String niveau;

    @Column(name="mention")
    @Max(value = 4)
    @Min(value = 3)
    String mention;
}

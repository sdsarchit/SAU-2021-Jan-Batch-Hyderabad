package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PersonalDetails implements Serializable {
    private String email;
    private String mobile;

    @Id
    @OneToOne
    @MapsId
    private Employee employee;

    public PersonalDetails(String email, String mobile, Employee employee) {
        this.email = email;
        this.mobile = mobile;
        this.employee = employee;
    }
}

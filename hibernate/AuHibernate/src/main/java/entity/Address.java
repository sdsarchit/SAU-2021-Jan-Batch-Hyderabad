package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int aId;
    private String area;
    private String district;
    private int pincode;
    private int employeeId;

    public Address(String area, String district, int pincode) {
        this.area = area;
        this.district = district;
        this.pincode = pincode;
    }
}

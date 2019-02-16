package com.adv.abizera.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@Entity
public class Child {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String fatherNames;
    private String motherNames;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private long nationalId;
    private int age;

    @OneToMany(mappedBy = "child",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Umwizera_Child> umwizeraChildren = new HashSet<>();

    public int getAge() {
        int age=0;
        if (dateOfBirth != null) {
            LocalDate dob = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            age = Period.between(dob, LocalDate.now()).getYears();
        }
        return age;
    }

}

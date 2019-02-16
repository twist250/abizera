package com.adv.abizera.domain;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Builder
@Entity
public class Umwizera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String phoneNumber;
    private String email;
    private long nationalId;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Transient
    private int age;

    @Embedded
    private Location residence;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private MartialStatus martialStatus;

    @OneToMany(mappedBy = "umwizera", cascade = CascadeType.ALL)
    private Set<Umwizera_Child> umwizeraChildren = new HashSet<>();

    @OneToMany(mappedBy = "umwizera",cascade = CascadeType.ALL)
    private Set<Umwizera_Out> umwizeraOuts = new HashSet<>();

    @OneToMany(mappedBy = "umwizera",cascade = CascadeType.ALL)
    private Set<Umwizera_In> umwizeraIns = new HashSet<>();


    public int getAge() {
        int age=0;
        if (dateOfBirth != null) {
            LocalDate dob = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            age = Period.between(dob, LocalDate.now()).getYears();
        }
        return age;
    }
}

package com.adv.abizera.domain;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
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

    @Enumerated(EnumType.STRING)
    private Gender gender;

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

}

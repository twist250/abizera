package com.adv.abizera.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private long nid;

    @OneToMany(mappedBy = "child",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Umwizera_Child> umwizeraChildren = new HashSet<>();
}

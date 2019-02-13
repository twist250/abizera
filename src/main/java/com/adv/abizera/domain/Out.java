package com.adv.abizera.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Data
@NoArgsConstructor
public class Out {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date when;
    private boolean withMembership;

    @Embedded
    private Location where;

    @OneToMany(mappedBy = "out", fetch = FetchType.EAGER)
    private Set<Umwizera_Out> umwizeraOuts = new HashSet<>();

}

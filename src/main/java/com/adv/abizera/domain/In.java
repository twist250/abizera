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
public class In {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date when;

    @Embedded
    private Location from;

    @OneToMany(mappedBy = "in",cascade = CascadeType.ALL)
    private Set<Umwizera_In> umwizeraIns = new HashSet<>();
}

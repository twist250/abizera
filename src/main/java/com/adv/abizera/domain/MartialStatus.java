package com.adv.abizera.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Builder
@Entity
public class MartialStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(value = TemporalType.DATE)
    private Date date;

    private String partnerNames;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "martialStatus")
    private Set<Umwizera> abizera = new HashSet<>();
}

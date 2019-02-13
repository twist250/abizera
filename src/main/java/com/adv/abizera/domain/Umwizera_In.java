package com.adv.abizera.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@Entity
public class Umwizera_In {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn
    private Umwizera umwizera;

    @ManyToOne
    @JoinColumn
    private In in;

}

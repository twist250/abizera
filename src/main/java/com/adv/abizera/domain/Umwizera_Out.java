package com.adv.abizera.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
public class Umwizera_Out {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "umwizera")
    private Umwizera umwizera;

    @ManyToOne
    @JoinColumn(name = "umwizera")
    private Out out;
}

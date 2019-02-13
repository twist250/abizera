package com.adv.abizera.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@Entity
public class Umwizera_Child {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "umwizera")
    private Umwizera umwizera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child")
    private Child child;

    private String RelationShip;
}

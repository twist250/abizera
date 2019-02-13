package com.adv.abizera.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@Builder
@Embeddable
public class Location {
    private String village;
    private String sector;
    private String cell;
    private String district;
    private String houseNumber;
}

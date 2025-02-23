package com.ZooAp.LombokInSpringBoot.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Animal {
    private int id;
    private String name;
    private double weight;
    private Gender gender;
}

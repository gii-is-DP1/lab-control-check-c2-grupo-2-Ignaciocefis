package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Care {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    @Column(unique = true)
    @NotNull
    @NotEmpty
    @Min(3)
    @Max(40)
    String name;

    @Min(1)
    @Max(120)
    @Column(name = "care_duration")
    int careDuration;

    @NotEmpty
    @NotNull
    @ManyToMany(cascade = CascadeType.ALL)
    Set<PetType> compatiblePetTypes;
}

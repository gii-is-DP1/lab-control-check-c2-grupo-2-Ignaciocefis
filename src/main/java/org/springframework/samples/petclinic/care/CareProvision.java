package org.springframework.samples.petclinic.care;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "care_provision")
public class CareProvision {   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "user_rating")
    @Formula("^Care rated with [0-9] stars.*$")
    String userRating;

    @ManyToOne(optional = true)
    Visit visit;   
    
    @ManyToOne(optional = false)
    Care care;   
}

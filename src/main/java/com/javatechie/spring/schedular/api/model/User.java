package com.javatechie.spring.schedular.api.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User
{
    @Id
    @GeneratedValue
    private int id;


    private String name;


    public void setName(String s)
    {
        name = s;
    }


}

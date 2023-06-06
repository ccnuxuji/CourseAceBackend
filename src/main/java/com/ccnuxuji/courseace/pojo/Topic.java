package com.ccnuxuji.courseace.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "topic")
@Data
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    private Integer ord;
    private String name;
}

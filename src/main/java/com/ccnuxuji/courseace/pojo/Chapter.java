package com.ccnuxuji.courseace.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "chapter")
@Data
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Transient
    @JsonProperty("pid")
    private Integer product_id;
    private Integer ord;

    @ManyToOne
    @JoinColumn(name="pid")
    private Product product;

    private String name;
    private String color;
    private String description;
}

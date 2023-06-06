package com.ccnuxuji.courseace.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Transient
    @JsonProperty("tid")
    private Integer topic_id;

    private Integer ord;
    private String thumbnail;

    @ManyToOne
    @JoinColumn(name = "tid")
    private Topic topic;

    private String name;
    private String description;
}

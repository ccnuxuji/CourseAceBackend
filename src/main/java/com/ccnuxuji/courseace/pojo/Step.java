package com.ccnuxuji.courseace.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "step")
@Data
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Transient
    @JsonProperty("cid")
    private Integer chapter_id;

    @ManyToOne
    @JoinColumn(name="cid")
    private Chapter chapter;

    private Integer ord;
    private String name;
    private String description;
    private String content;
}

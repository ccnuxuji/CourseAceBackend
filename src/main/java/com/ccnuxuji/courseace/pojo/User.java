package com.ccnuxuji.courseace.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String password;
    private String name;
    private String salt;

    @Transient
    private String anonymousName;

    public String getAnonymousName() {
        if (null != anonymousName)
            return anonymousName;
        if (null == name)
            anonymousName = null;
        else if (name.length() <= 1)
            anonymousName = "*";
        else if (name.length() == 2)
            anonymousName = name.charAt(0) + "*";
        else {
            char[] cs = name.toCharArray();
            for (int i = 1; i < cs.length - 1; i++) {
                cs[i] = '*';
            }
            anonymousName = new String(cs);
        }
        return anonymousName;
    }

    public void setAnonymousName(String anonymousName) {
        this.anonymousName = anonymousName;
    }
}

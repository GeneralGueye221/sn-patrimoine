package com.sen.patrimoine.snpatrimoine.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "feature")
public class Feature {
    @Id
    private Long id;

    @ManyToOne
    private Heritage heritage;

    @ManyToOne
    private TypeFeature typeFeature;

    private String value;

    public Long getId() {
        return id;
    }

    public Heritage getHeritage() {
        return heritage;
    }

    public TypeFeature getTypeFeature() {
        return typeFeature;
    }

    public String getValue() {
        return value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTypeFeature(TypeFeature typeFeature) {
        this.typeFeature = typeFeature;
    }

    public void setHeritage(Heritage heritage) {
        this.heritage = heritage;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

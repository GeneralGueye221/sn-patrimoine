package com.sen.patrimoine.snpatrimoine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "heritage")
public class Heritage {

    @Id
    private Long id;

    private String title;
    private String description;
    private String img;
    private int latitude;
    private int longitude;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Feature feature;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImg() {
        return img;
    }

    public Category getCategory() {
        return category;
    }

    public Feature getFeature() {
        return feature;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImg(String img){
        this.img = img;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;

    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Heritage{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", category=" + category +
                ", feature=" + feature +
                '}';
    }


}

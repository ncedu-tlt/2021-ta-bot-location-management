package com.netcracker.edu.location.model;

import com.netcracker.edu.location.model.ui.UiPlace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
    @Column(name = "name")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;


    public Place(UiPlace uiPlace, Category category) {
        setCity(uiPlace.getCity());
        setAddress(uiPlace.getAddress());
        setCategory(category);
        setName(uiPlace.getName());
    }


}

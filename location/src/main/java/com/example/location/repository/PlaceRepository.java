package com.example.location.repository;

import com.example.location.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Integer> {

    List<Place> findPlaceByCategoryId(int categoryId);

}

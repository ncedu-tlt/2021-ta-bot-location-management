package com.netcracker.edu.location.repository;

import com.netcracker.edu.location.model.Place;
import com.netcracker.edu.location.model.ui.UiPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {

    List<Place> findPlaceByName(String categoryName);

    Place findPlaceByAddressAndCity(String address, String city);

    @Query(value = "select * from place pl where pl.id in :placeId", nativeQuery = true)
    List<Place> findPlaceId(@Param("placeId") int[] placeId);

    Place findPlaceByNameAndCity(String name, String city);
}

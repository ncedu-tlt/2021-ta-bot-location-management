package com.netcracker.edu.location.controller;

import com.netcracker.edu.location.model.Category;
import com.netcracker.edu.location.model.Place;
import com.netcracker.edu.location.model.ui.UiPlace;
import com.netcracker.edu.location.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping
    public ResponseEntity<Iterable<Place>> getAllPlaces() {
        return ResponseEntity.ok(placeService.getPlaces());
    }

    @PostMapping("/address")
    public ResponseEntity<Place> getPlaceByAddress(@RequestBody UiPlace uiPlace) {
        return ResponseEntity.ok(placeService.getPlaceByAddress(uiPlace));
    }

    @PostMapping("/name")
    public ResponseEntity<Place> getPlaceByName(@RequestBody UiPlace uiPlace) {
        return ResponseEntity.ok(placeService.getPlaceByName(uiPlace));
    }

    @PostMapping
    public ResponseEntity<Place> createPlace(@RequestBody UiPlace uiPlace) {
        return ResponseEntity.ok(placeService.createPlace(uiPlace));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Place> deletePlace(@PathVariable("id") int id) {
        placeService.deletePlace(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/category")
    public ResponseEntity<List<Place>> findPlaceByCategory(@RequestBody Category category){
        return ResponseEntity.ok(placeService.findPlaceByName(category));
    }

    @PostMapping("/placeId")
    public ResponseEntity <List<Place>> getPlaceId(@RequestBody int[] placeId) {
        return ResponseEntity.ok(placeService.getPlaceId(placeId));
    }
}

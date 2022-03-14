package com.example.location.controller;

import com.example.location.model.Category;
import com.example.location.model.Place;
import com.example.location.model.ui.UiPlace;
import com.example.location.service.CategoryService;
import com.example.location.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @Autowired
    public CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Place>> getAllPlaces() {
        return ResponseEntity.ok(placeService.getPlaces());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Place>> getPlaceById(@PathVariable("id") int id) {
        return ResponseEntity.ok(placeService.getPlaceById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Place> createPlace(@RequestBody UiPlace uiPlace) {
        Category category = categoryService.findCategoryByName(uiPlace.getCategoryName());
        return ResponseEntity.ok(placeService.createPlace(uiPlace, category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Place> updatePlace(@PathVariable("id") int id, @RequestBody Place place) {
        return ResponseEntity.ok(placeService.updatePlaceById(id, place));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Place> deletePlace(@PathVariable("id") int id) {
        placeService.deletePlace(id);
        return ResponseEntity.accepted().build();
    }

}

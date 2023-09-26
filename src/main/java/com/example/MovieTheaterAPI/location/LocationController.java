package com.example.MovieTheaterAPI.location;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/locations")
public class LocationController {
  LocationService locationService;

  @GetMapping
  public ResponseEntity<List<Location>> getAllLocations() {
    List<Location> locations = locationService.getAllLocations();
    return new ResponseEntity<>(locations, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
    Location location = locationService.getLocationById(id);
    if (location != null) {
      return new ResponseEntity<>(location, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Location>> searchLocationsByStateAndCity(
          @RequestParam String state, @RequestParam String city) {
      List<Location> locations = locationService.searchLocationsByStateAndCity(state, city);
      return new ResponseEntity<>(locations, HttpStatus.OK);
  }
    
  @PostMapping
  public ResponseEntity<Location> createLocation(@RequestBody Location location) {
    Location createdLocation = locationService.createLocation(location);
    return new ResponseEntity<>(createdLocation, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location location) {
    Location updatedLocation = locationService.updateLocation(id, location);
    if (updatedLocation != null) {
      return new ResponseEntity<>(updatedLocation, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
    locationService.deleteLocation(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  
}

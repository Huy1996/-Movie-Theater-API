package com.example.MovieTheaterAPI.location;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface LocationService {
  List<Location> getAllLocations();
  List<Location> searchLocationsByStateAndCity(String state, String city);
  Location getLocationById(Long id);
  Location createLocation(Location location);
  Location updateLocation(Long id, Location location);
  void deleteLocation(Long id);
}

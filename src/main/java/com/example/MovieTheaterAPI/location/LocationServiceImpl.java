package com.example.MovieTheaterAPI.location;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LocationServiceImpl implements LocationService{
  LocationRepository locationRepository;

  @Override
  public List<Location> getAllLocations() {
    return locationRepository.findAll();
  }

  @Override
  public Location getLocationById(Long id){
    return locationRepository.findById(id).orElse(null);

  }

  @Override
  public List<Location> searchLocationsByStateAndCity(String state, String city) {
      return locationRepository.findByStateAndCity(state, city);
  }

  @Override
  public Location createLocation(Location location) {
    return locationRepository.save(location);
  }

  @Override
  public Location updateLocation(Long id, Location updatedLocation){

    Location existingLocation = locationRepository.findById(id).orElse(null);

    if (existingLocation != null) {
      existingLocation.setCity(updatedLocation.getCity());
      existingLocation.setState(updatedLocation.getState());
      existingLocation.setTheater(updatedLocation.getTheater());
      return locationRepository.save(existingLocation);
    }
    return null; 
  }

  @Override
  public void deleteLocation(Long id){
    locationRepository.deleteById(id);
  }

}

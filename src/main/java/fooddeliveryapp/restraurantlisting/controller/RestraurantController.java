package fooddeliveryapp.restraurantlisting.controller;


import fooddeliveryapp.restraurantlisting.dto.RestraurantDTO;
import fooddeliveryapp.restraurantlisting.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@Slf4j
public class RestraurantController {

    @Autowired
    RestaurantService restaurantService;


    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestraurantDTO>> fetchAllRestaurants() {
        List<RestraurantDTO> allRestaurants = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestraurantDTO> addRestaurant(@RequestBody RestraurantDTO restraurantDTO) {

        log.info("REST request to save Restraurant : {}", restraurantDTO);
       RestraurantDTO restaurantadded =  restaurantService.addRestaurant(restraurantDTO);
       log.info("Restaurant added successfully:{}" + restaurantadded);
        return new ResponseEntity<>(restaurantadded, HttpStatus.CREATED);
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<RestraurantDTO> fetchRestaurantById(@PathVariable int id) {
      return restaurantService.fetchRestaurantById(id);
    }
}

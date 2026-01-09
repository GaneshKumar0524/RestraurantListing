package fooddeliveryapp.restraurantlisting.service;


import fooddeliveryapp.restraurantlisting.dto.RestraurantDTO;
import fooddeliveryapp.restraurantlisting.entity.Restraurant;
import fooddeliveryapp.restraurantlisting.mapper.RestaurantMapper;
import fooddeliveryapp.restraurantlisting.repository.RestraurantRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RestaurantService {

    @Autowired
    RestraurantRepo restaurantRepo;

    @Autowired
    RestaurantMapper restaurantMapper;

    public List<RestraurantDTO> findAllRestaurants() {
       List<Restraurant> restraurants = restaurantRepo.findAll();
        return restraurants.stream()
                 .map(restaurantMapper::toDTO)
                 .toList();
    }

    public RestraurantDTO addRestaurant(RestraurantDTO restraurantDTO) {
        log.info("REST request to save Restraurant Service Method : {}", restraurantDTO);
        Restraurant savedEntity = restaurantRepo.save(restaurantMapper.toEntity(restraurantDTO));
        log.info("Restaurant saved successfully:{}" + savedEntity);
        return restaurantMapper.toDTO(savedEntity);
    }

    public ResponseEntity<RestraurantDTO> fetchRestaurantById(Integer id) {
        Optional<Restraurant> restraurantOptioanal = restaurantRepo.findById(id);

        if (restraurantOptioanal.isPresent()) {
            return new ResponseEntity<>(restaurantMapper.toDTO(restraurantOptioanal.get()),HttpStatus.OK);
        }
            return new ResponseEntity<>(null ,HttpStatus.NOT_FOUND);
    }
}

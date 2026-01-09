package fooddeliveryapp.restraurantlisting.mapper;


import fooddeliveryapp.restraurantlisting.dto.RestraurantDTO;
import fooddeliveryapp.restraurantlisting.entity.Restraurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    // Define mapping methods here
    RestraurantDTO toDTO(Restraurant restraurant);
    Restraurant toEntity(RestraurantDTO restraurantDTO);
}

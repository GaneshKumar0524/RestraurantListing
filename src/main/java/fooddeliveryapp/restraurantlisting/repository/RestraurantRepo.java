package fooddeliveryapp.restraurantlisting.repository;

import fooddeliveryapp.restraurantlisting.entity.Restraurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestraurantRepo extends JpaRepository<Restraurant,Integer> {
}

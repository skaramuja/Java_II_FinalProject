package travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import travel.beans.Traveller;

@Repository
public interface TravellerRepository extends JpaRepository<Traveller, Long> {

}
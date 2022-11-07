package travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import travel.beans.Traveler;

@Repository
public interface TravelerRepository extends JpaRepository<Traveler, Long> {

}
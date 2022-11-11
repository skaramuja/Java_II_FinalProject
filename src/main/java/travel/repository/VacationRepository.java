package travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import travel.beans.Vacation;

@Repository
public interface VacationRepository extends JpaRepository<Vacation, Integer> {

}

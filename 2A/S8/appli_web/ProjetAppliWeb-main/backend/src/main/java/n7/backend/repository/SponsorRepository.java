package n7.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import n7.backend.entites.Sponsor;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, Integer> {
    
}
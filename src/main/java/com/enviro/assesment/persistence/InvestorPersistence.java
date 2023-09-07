package com.enviro.assesment.persistence;

import com.enviro.assesment.models.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Integer> {
    // You can add custom query methods here if needed
}

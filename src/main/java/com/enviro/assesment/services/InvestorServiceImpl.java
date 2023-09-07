package com.enviro.assesment.services;

import com.enviro.assesment.models.Investor;
import com.enviro.assesment.persistence.InvestorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional // Adding transactional annotation for service methods
public class InvestorServiceImpl implements InvestorService {

    private final InvestorPersistence investorPersistence;

    @Autowired
    public InvestorServiceImpl(InvestorPersistence investorPersistence) {
        this.investorPersistence = investorPersistence;
    }

    @Override
    public void makeInvestors() {
        List<Investor> investors = new ArrayList<>();

        investors.add(new Investor("Hope", "Boshielo", "1998-02-03", "Sunnyhill", "+27725412265", "userH2025@mail.com"));
        investors.add(new Investor("Sindi", "Bosh", "1978-01-01", "Japan", "+1234567890", "sindi.hope@mail.com"));
        investors.add(new Investor("Leo", "Davidson", "1975-02-15", "Mexico", "+9876543210", "Davidson@mail.com"));
        investors.add(new Investor("Tumelo", "Alaba", "1950-01-01", "New Jersey", "+1234567890", "tumelo@mail.com"));
        investors.add(new Investor("Steve", "Smith", "1945-08-22", "Los Angeles", "+9876543210", "Steve2@mail.com"));

        investorPersistence.saveAll(investors);
    }

    @Override
    public Investor getInvestorInfo(int investorId) {
        return investorPersistence.findById(investorId).orElse(null); // Handle if the investor is not found
    }

    @Override
    public List<Investor> getAllInvestors() {
        return investorPersistence.findAll();
    }
}

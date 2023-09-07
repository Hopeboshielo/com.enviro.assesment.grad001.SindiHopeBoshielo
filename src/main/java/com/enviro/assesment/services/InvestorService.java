package com.enviro.assesment.services;

import com.enviro.assesment.models.Investor;
import java.util.List;

public interface InvestorService {

    /**
     * Creates investors.
     */
    void makeInvestors();

    /**
     * Retrieves information about an investor by their ID.
     *
     * @param investorId The ID of the investor to retrieve.
     * @return The investor information.
     */
    Investor getInvestorInfo(int investorId);

    /**
     * Retrieves a list of all investors.
     *
     * @return A list of all investors.
     */
    List<Investor> getAllInvestors();
}

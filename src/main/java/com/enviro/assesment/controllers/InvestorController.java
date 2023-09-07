package com.enviro.assesment.controllers;

import com.enviro.assesment.models.Investor;
import com.enviro.assesment.services.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investors")
public class InvestorController {

    private final InvestorService investorService;

    @Autowired
    public InvestorController(InvestorService investorService) {
        this.investorService = investorService;
    }

    @PostMapping("/create")
    public void createInvestors() {
        investorService.createInvestors();
    }

    @GetMapping("/{investorId}")
    public Investor getInvestorById(@PathVariable int investorId) {
        return investorService.getInvestorById(investorId);
    }

    @GetMapping("/all")
    public List<Investor> getAllInvestors() {
        return investorService.getAllInvestors();
    }
}

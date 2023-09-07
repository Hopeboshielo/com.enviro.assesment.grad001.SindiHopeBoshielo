package com.enviro.assesment.managers;
import com.enviro.assesment.models.Investor;
import com.enviro.assesment.models.Product;
import com.enviro.assesment.persistence.InvestorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.Period;

@Component
public class ProductManager {

    private final InvestorPersistence investorPersistence;

    @Autowired
    public ProductManager(InvestorPersistence investorPersistence) {
        this.investorPersistence = investorPersistence;
    }

    public String makeWithdrawal(Product product, double amount, Investor investor) {
        return handleWithdrawal(product, amount, investor);
    }

    private String handleWithdrawal(Product product, double amount, Investor investor) {
        double productBalance = product.getCurrentBalance();

        if (product.getType().equalsIgnoreCase("retirement")) {
            return handleRetirement(investor);
        }

        if (amount > productBalance) {
            return "Amount Requested is greater than the current balance.";
        } else if (amount > (productBalance * 0.9)) {
            return "The Amount is greater than 90% of balance.";
        } else {
            return "Successful withdrawal of " + amount;
        }
    }

    private String handleRetirement(Investor investor) {
        int age = calculateAge(investor.getDob());

        if (age < 65) {
            return "You are Too Young";
        } else {
            return "Success";
        }
    }

    private int calculateAge(String dob) {
        LocalDate currentDate = LocalDate.now();
        LocalDate convertedDob = LocalDate.parse(dob);

        return Period.between(convertedDob, currentDate).getYears();
    }
}

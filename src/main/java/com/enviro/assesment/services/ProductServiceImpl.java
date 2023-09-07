package com.enviro.assesment.services;

import com.enviro.assesment.managers.ProductManager;
import com.enviro.assesment.models.Investor;
import com.enviro.assesment.models.Product;
import com.enviro.assesment.persistence.ProductPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional // Adding transactional annotation for service methods
public class ProductServiceImpl implements ProductService {

    private final ProductPersistence productPersistence;
    private final InvestorService investorService;

    @Autowired
    public ProductServiceImpl(ProductPersistence productPersistence, InvestorService investorService) {
        this.productPersistence = productPersistence;
        this.investorService = investorService;
    }

    @Override
    public void createProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "RETIREMENT", "My Ret", 500));
        products.add(new Product(1, "SAVINGS", "My Savings", 5000));
        products.add(new Product(2, "RETIREMENT", "My Ret", 500));
        productPersistence.saveAll(products);
    }

    @Override
    public List<Product> getInvestorProducts(int investorId) {
        return productPersistence.findByInvestorId(investorId);
    }

    @Override
    public String makeWithdrawal(int productId, double amount) {
        Product product = productPersistence.findById(productId).orElse(null);
        if (product == null) {
            return "This Product is not found";
        }

        Investor investor = investorService.getInvestorInfo(product.getInvestorId());
        String result = ProductManager.makeWithdrawal(product, amount, investor);

        if (result.toLowerCase().contains("Successful")) {
            product.setCurrentBalance(product.getCurrentBalance() - amount);
            productPersistence.save(product);
            return String.valueOf(product.getCurrentBalance());
        }

        return result;
    }
}

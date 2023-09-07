package com.enviro.assesment.services;

import com.enviro.assesment.models.Product;

import java.util.List;

public interface ProductService {

    /**
     * Create products.
     */
    void createProducts();

    /**
     * Retrieve products for a specific investor.
     *
     * @param investorId The ID of the investor.
     * @return A list of products associated with the investor.
     */
    List<Product> getInvestorProducts(int investorId);

    /**
     * Withdraw a specified amount from a product.
     *
     * @param productId The ID of the product to withdraw from.
     * @param amount    The amount to withdraw.
     * @return A message indicating the result of the withdrawal.
     */
    String makeWithdrawal(int productId, double amount);
}

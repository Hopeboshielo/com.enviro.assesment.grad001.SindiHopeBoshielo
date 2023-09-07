package com.enviro.assesment.controllers;
import com.enviro.assesment.models.Product;
import com.enviro.assesment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public void createProducts() {
        productService.createProducts();
    }

    @GetMapping("/investor")
    public List<Product> getInvestorProducts(@RequestParam(name = "investorId") int investorId) {
        return productService.getInvestorProducts(investorId);
    }

    @PostMapping("/withdraw")
    public String makeWithdrawal(
            @RequestParam(name = "productId") int productId,
            @RequestParam(name = "amount") double amount) {
        return productService.makeWithdrawal(productId, amount);
    }
}

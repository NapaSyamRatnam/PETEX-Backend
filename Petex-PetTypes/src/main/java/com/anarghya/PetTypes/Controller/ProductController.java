package com.anarghya.PetTypes.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.anarghya.PetTypes.Entity.Product;
import com.anarghya.PetTypes.Repo.ProductRepository;
import com.anarghya.PetTypes.Service.ProductService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepositry;

    @Autowired
    private ProductService productService;

    @GetMapping("/listProduct")
    public List<Product> listProduct() {
        return productRepositry.findAll();
    }
    
    @GetMapping("/categories")
    public List<String> getAllCategories() {
        return productService.getAllCategories();
    }


    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

//    @GetMapping("/products/vegetarian")
//    public List<Product> getVegetarianProducts() {
//        return productService.getVegetarianProducts();
//    }

//    @GetMapping("/products/nonvegetarian")
//    public List<Product> getNonVegetarianProducts() {
//        return productService.getNonVegetarianProducts();
//    }

    @PostMapping(path = "/addpet", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveProduct(@RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") int price,
            @RequestParam("category") String category,
    		@RequestParam("breed") String breed,
    		@RequestParam("color") String color,
    		@RequestParam("weight") double weight,
    		@RequestParam("height") double height,
    		@RequestParam("vaccinated") String vaccinated,
            @RequestParam("discount") double discount){
        try {
            productService.saveProductToDB(file, name, description, price, color, weight,category, breed, height,vaccinated, discount);
            return ResponseEntity.ok().body("Product saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving product: " + e.getMessage());
        }
    }

}

package com.items.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.items.entity.Product;
import com.items.service.ProductService;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/products")

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/save/{vendord}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveProduct(@PathVariable("vendord") Long vendord, 
            @RequestParam("file") MultipartFile file,
            @RequestParam("price") int price,
            @RequestParam("brand") String brand,
            @RequestParam("stock") int stock,
            @RequestParam("category") String category,
            @RequestParam("name") String name,
            @RequestParam("feature") String feature,
    @RequestParam("type") String type,
            @RequestParam("descrption") String descrption) {

        try {
            productService.savePetToDB( category,file,  name,vendord, price, brand, descrption, stock,feature,type);
            return ResponseEntity.ok().body("Data saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving data: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
    
    
    @PutMapping("/{id}/name")
    public ResponseEntity<Void> changeProductName(@PathVariable String id, @RequestParam String name) {
        productService.changeProductName(id, name);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/price")
    public ResponseEntity<Void> changeProductPrice(@PathVariable String id, @RequestParam int price) {
        productService.changeProductPrice(id, price);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }
    @GetMapping("{category}/brand/{brand}")
    public List<Product> getProductsByCategoryAndBrand(@PathVariable String category, @PathVariable String brand) {
        return productService.getProductsByCategoryAndBrand(category, brand);
    }

    @GetMapping("{category}/{vendord}")
    public ResponseEntity<List<Product>> getProductsByCategoryAndVendorId(
            @PathVariable String category,
            @PathVariable Long vendord
    ) {
        try {
            List<Product> products = productService.getProductsByCategoryAndVendorId(category, vendord);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        Product product = productService.updateProduct(id, updatedProduct);
        return ResponseEntity.ok(product);
    }
    
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") String productId) {
        Product product = productService.getById(productId);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/category/{category}/type/{type}")
    public ResponseEntity<List<Product>> getProductsByCategoryAndType(
            @PathVariable String category,
            @PathVariable String type) {
        List<Product> products = productService.getProductsByCategoryAndType(category, type);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}

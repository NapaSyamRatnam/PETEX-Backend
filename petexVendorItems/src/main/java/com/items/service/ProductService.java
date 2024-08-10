package com.items.service;


import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.items.entity.Product;
import com.items.repo.ProductRepository;

@Service
public class ProductService {
	
    @Autowired
    private ProductRepository productRepo;


    
    public void savePetToDB(String category, MultipartFile file, String name, Long vendord, int price, String brand, String descrption, int stock,String feature,String type)
{
        if (file == null || file.isEmpty() || price <= 0) {
            throw new IllegalArgumentException("Invalid Pet data");
        }

        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            if (fileName.contains("..")) {
                throw new IllegalArgumentException("Invalid file name");
            }
            Product pet = new Product();
            pet.setCategory(category);
            pet.setName(name);
            pet.setPrice(price);
            pet.setBrand(brand);
            pet.setVendord(vendord);
            pet.setDescrption(descrption);
            pet.setStock(stock);
            pet.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
            pet.setFeature(feature);
            pet.setType(type);

            productRepo.save(pet);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save product", e);
        }
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public void deleteProductById(String productId) {
        productRepo.deleteById(productId);
    }

    public void changeProductName(String productId, String name) {
        updateProduct(productId, product -> product.setName(name));
    }

    public void changeProductPrice(String productId, int price) {
        updateProduct(productId, product -> product.setPrice(price));
    }
    
    

    private void updateProduct(String productId, ProductUpdateFunction updateFunction) {
        Optional<Product> productOptional = productRepo.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            updateFunction.update(product);
            productRepo.save(product);
        } else {
            throw new IllegalArgumentException("Product not found with id: " + productId);
        }
    }

    @FunctionalInterface
    private interface ProductUpdateFunction {
        void update(Product product);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepo.findByCategory(category);
    }

    public List<Product> getVegetarianProducts() {
        // Implement logic to fetch vegetarian products
        // For now, returning null
        return null;
    }

    public List<Product> getNonVegetarianProducts() {
        // Implement logic to fetch non-vegetarian products
        // For now, returning null
        return null;
    }

    public List<String> getAllCategories() {
        return productRepo.getAllCategories();
    }
    

    public List<Product> getProductsByCategoryAndVendorId(String category, Long vendord) {
        return productRepo.findByCategoryAndVendord(category, vendord);
    }

	public List<Product> getProductsByCategoryAndBrand(String category, String brand) {
		return productRepo.findByCategoryAndBrand(category, brand);
	}
	

    public List<Product> getProductsByCategoryAndType(String category, String type) {
        return productRepo.findByCategoryAndType(category, type);
    }
    
    public Product getById(String productId) {
        return productRepo.findById(productId).orElse(null);
    }

    public Product updateProduct(String productId, Product updatedProduct) {
        Optional<Product> optionalProduct = productRepo.findById(productId);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            if (updatedProduct.getCategory() != null) {
                existingProduct.setCategory(updatedProduct.getCategory());
            }
            if (updatedProduct.getName() != null) {
                existingProduct.setName(updatedProduct.getName());
            }
            if (updatedProduct.getPrice() != 0) {
                existingProduct.setPrice(updatedProduct.getPrice());
            }
            if (updatedProduct.getBrand() != null) {
                existingProduct.setBrand(updatedProduct.getBrand());
            }
            if (updatedProduct.getDescrption() != null) {
                existingProduct.setDescrption(updatedProduct.getDescrption());
            }
            if (updatedProduct.getStock() != 0) {
                existingProduct.setStock(updatedProduct.getStock());
            }
            if (updatedProduct.getImage() != null) {
                existingProduct.setImage(updatedProduct.getImage());
            }
            return productRepo.save(existingProduct);
        } else {
            throw new IllegalArgumentException("Product not found with ID: " + productId);
        }
    }
}

package com.anarghya.PetTypes.Service;

//package com.halim.web.service;
//
//import java.io.IOException;
//import java.util.Base64;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.halim.web.dto.ProductRepositry;
//import com.halim.web.model.Product;
//
//@Service
//public class ProductService {
//	@Autowired
//	private ProductRepositry productRepo;
//	
//	public void  saveProductToDB(MultipartFile file,String name,String description
//			,int price)
//	{
//		Product p = new Product();
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		if(fileName.contains(".."))
//		{
//			System.out.println("not a a valid file");
//		}
//		try {
//			p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		p.setDescription(description);
//		
//      p.setName(name);
//      p.setPrice(price);
//      
//      productRepo.save(p);
//	}
//	public List<Product> getAllProduct()
//	{
//		return productRepo.findAll();
//	}
//  public void deleteProductById(Long id)
//  {
//  	productRepo.deleteById(id);
//  }
//  public void chageProductName(Long id ,String name)
//  {
//  	Product p = new Product();
//  	p = productRepo.findById(id).get();
//  	p.setName(name);
//  	productRepo.save(p);    
//  }
//  public void changeProductDescription(Long id , String description)
//  {
//  	Product p = new Product();
//  	p = productRepo.findById(id).get();
//  	p.setDescription(description);
//  	productRepo.save(p);
//  }
//  public void changeProductPrice(Long id,int price)
//  {
//  	Product p = new Product();
//  	p = productRepo.findById(id).get();
//  	p.setPrice(price);
//  	productRepo.save(p);
//  }
//}



import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.anarghya.PetTypes.Entity.Product;
import com.anarghya.PetTypes.Repo.ProductRepository;



@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepo;

  public void saveProductToDB(MultipartFile file, String name, String description, int price,String color, double weight, String category, String breed, double height,String vaccinated, double discount) {
      if (file == null || file.isEmpty() || name == null || name.isEmpty() || price <= 0) {
          throw new IllegalArgumentException("Invalid product data");
      }

      try {
          String fileName = StringUtils.cleanPath(file.getOriginalFilename());
          if (fileName.contains("..")) {
              throw new IllegalArgumentException("Invalid file name");
          }

          Product product = new Product();
          product.setName(name);
          product.setDescription(description);
          product.setPrice(price);
          product.setColor(color);
          product.setVaccinated(vaccinated);
          product.setWeight(weight);
          product.setHeight(height);
          product.setCategory(category);
          product.setBreed(breed);
          product.setDiscount(discount);
          product.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
          
//          product.setVegetarian(vegetarian);

          productRepo.save(product);
      } catch (IOException e) {
          throw new RuntimeException("Failed to save product", e);
      }
  }

  public List<Product> getAllProducts() {
      return productRepo.findAll();
  }

  public void deleteProductById(Long id) {
      productRepo.deleteById(id);
  }

  public void changeProductName(Long id, String name) {
      updateProduct(id, product -> product.setName(name));
  }

  public void changeProductDescription(Long id, String description) {
      updateProduct(id, product -> product.setDescription(description));
  }

  public void changeProductPrice(Long id, int price) {
      updateProduct(id, product -> product.setPrice(price));
  }
  public void changeProductColor(Long id, String color) {
      updateProduct(id, product -> product.setColor(color));
  }
  public void changeProductWeight(Long id, double weight) {
      updateProduct(id, product -> product.setWeight(weight));
  }
  public void changeProductHeight(Long id, double height) {
      updateProduct(id, product -> product.setHeight(height));
  }
  public void changeProductVaccinated(Long id, String vaccinated) {
      updateProduct(id, product -> product.setVaccinated(vaccinated));
  }

  private void updateProduct(Long id, ProductUpdateFunction updateFunction) {
      Optional<Product> productOptional = productRepo.findById(id);
      if (productOptional.isPresent()) {
          Product product = productOptional.get();
          updateFunction.update(product);
          productRepo.save(product);
      } else {
          throw new IllegalArgumentException("Product not found with id: " + id);
      }
  }

  @FunctionalInterface
  private interface ProductUpdateFunction {
      void update(Product product);
  }

	
	
	public List<Product> getProductsByCategory(String category) {
      return productRepo.findByCategory(category);
  }

//	public List<Product> getVegetarianProducts() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<Product> getNonVegetarianProducts() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

    public List<String> getAllCategories() {
        return productRepo.getAllCategories();
    }

  

}

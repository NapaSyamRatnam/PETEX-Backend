package com.example.pet.Service;


import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.pet.Entity.PetEntity;
import com.example.pet.Repo.PetRepo;

@Service
public class PetService {

  @Autowired
  private PetRepo petrepo;

  public void savePetToDB(MultipartFile file, String name, String description, int price,String color, double weight, String category, String breed, double height,String vaccinated, double discount) {
      if (file == null || file.isEmpty() || name == null || name.isEmpty() || price <= 0) {
          throw new IllegalArgumentException("Invalid Pet data");
      }

      try {
          String fileName = StringUtils.cleanPath(file.getOriginalFilename());
          if (fileName.contains("..")) {
              throw new IllegalArgumentException("Invalid file name");
          }

          PetEntity pet = new PetEntity();
          pet.setName(name);
          pet.setDescription(description);
          pet.setPrice(price);
          pet.setColor(color);
          pet.setVaccinated(vaccinated);
          pet.setWeight(weight);
          pet.setHeight(height);
          pet.setCategory(category);
          pet.setBreed(breed);
          pet.setDiscount(discount);
          pet.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
          
//          product.setVegetarian(vegetarian);

          petrepo.save(pet);
      } catch (IOException e) {
          throw new RuntimeException("Failed to save product", e);
      }
  }

  public List<PetEntity> getAllPets() {
      return petrepo.findAll();
  }

  public void deletePetById(Long id) {
	  petrepo.deleteById(id);
  }

  public void changePetName(Long id, String name) {
      updatePet(id, pet -> pet.setName(name));
  }

  public void changePetDescription(Long id, String description) {
      updatePet(id, pet -> pet.setDescription(description));
  }

  public void changePetPrice(Long id, int price) {
      updatePet(id, pet -> pet.setPrice(price));
  }
  public void changePetColor(Long id, String color) {
      updatePet(id, pet -> pet.setColor(color));
  }
  public void changePetWeight(Long id, double weight) {
      updatePet(id, pet -> pet.setWeight(weight));
  }
  public void changePetHeight(Long id, double height) {
      updatePet(id, pet -> pet.setHeight(height));
  }
  public void changePetVaccinated(Long id, String vaccinated) {
      updatePet(id, pet -> pet.setVaccinated(vaccinated));
  }

  private void updatePet(Long id, PetUpdateFunction updateFunction) {
      Optional<PetEntity> productOptional = petrepo.findById(id);
      if (productOptional.isPresent()) {
          PetEntity pet = productOptional.get();
          updateFunction.update(pet);
          petrepo.save(pet);
      } else {
          throw new IllegalArgumentException("Product not found with id: " + id);
      }
  }

  @FunctionalInterface
  private interface PetUpdateFunction {
      void update(PetEntity pet);
  }

	
	
	public List<PetEntity> getPetsByCategory(String category) {
      return petrepo.findByCategory(category);
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
        return petrepo.getAllCategories();
    }

  

}

package com.example.pet.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import com.example.pet.Entity.PetEntity;
import com.example.pet.Repo.PetRepo;
import com.example.pet.Service.PetService;

@RestController
@CrossOrigin(origins = "*")
public class PetController {

    @Autowired
    private PetRepo petrepo;

    @Autowired
    private PetService petservice;

    @GetMapping("/listpet")
    public List<PetEntity> listPet() {
        return petrepo.findAll();
    }
    
    @GetMapping("/categories")
    public List<String> getAllCategories() {
        return petservice.getAllCategories();
    }


    @GetMapping("/pets")
    public List<PetEntity> getAllPets() {
        return petservice.getAllPets();
    }

    @GetMapping("/pets/{category}")
    public List<PetEntity> getPetsByCategory(@PathVariable String category) {
        return petservice.getPetsByCategory(category);
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
            petservice.savePetToDB(file, name, description, price, color, weight,category, breed, height,vaccinated, discount);
            return ResponseEntity.ok().body("Product saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving product: " + e.getMessage());
        }
    }

}
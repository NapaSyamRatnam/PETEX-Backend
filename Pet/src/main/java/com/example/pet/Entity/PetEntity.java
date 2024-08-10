package com.example.pet.Entity;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

// PetexPets

@Entity
@Table(name = "Pets_table")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int price;
    private String color;
    private String vaccinated;
    private double weight;
    private double height;
    private String category; 
    private String breed;
    private double discount;
    private double afterdiscountprice;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;
    


    public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
        updateAfterdiscountprice();
    }

    public double getAfterdiscountprice() {
        return afterdiscountprice;
    }

    public void setAfterdiscountprice(double afterdiscountprice) {
        this.afterdiscountprice = afterdiscountprice;
    }

    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public MultipartFile getFile() {
        // TODO Auto-generated method stub
        return null;
    }
//
//    public String  isVegetarian() {
//        return vegetarian;
//    }
//
//    public void setVegetarian(String  vegetarian) {
//        this.vegetarian = vegetarian;
//    }





	private void updateAfterdiscountprice() {
        this.afterdiscountprice = (int) (price - (price * (discount / 100.0)));
    }

	public PetEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", color="
				+ color + ", vaccinated=" + vaccinated + ", weight=" + weight + ", height=" + height + ", category="
				+ category + ", breed=" + breed + ", discount=" + discount + ", afterdiscountprice="
				+ afterdiscountprice + ", image=" + image + "]";
	}

	public PetEntity(Long id, String name, String description, int price, String color, String vaccinated, double weight,
		double height, String category, String breed, double discount, double afterdiscountprice, String image) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.price = price;
	this.color = color;
	this.vaccinated = vaccinated;
	this.weight = weight;
	this.height = height;
	this.category = category;
	this.breed = breed;
	this.discount = discount;
	this.afterdiscountprice = afterdiscountprice;
	this.image = image;
}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getVaccinated() {
		return vaccinated;
	}

	public void setVaccinated(String vaccinated) {
		this.vaccinated = vaccinated;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}

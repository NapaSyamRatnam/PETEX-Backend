package com.petshow.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lowagie.text.DocumentException;
import com.petshow.entity.AdminSingUpEntity;
import com.petshow.entity.AdminshowEntity;
import com.petshow.repo.AdminloginRepository;
import com.petshow.repo.AdminshowRepository;

@Service
public class AdminshowService {

	@Autowired
	private AdminshowRepository productRepo;
	
	@Autowired
	private AdminloginRepository adminRepo;
	
	
	public Boolean AdminshowEntity(AdminshowEntity admin,Long adminId,MultipartFile imageFile)throws DocumentException, IOException {
		Optional<AdminSingUpEntity> optionalAdminId = adminRepo.findById(adminId);
		if (optionalAdminId.isPresent()) {
			AdminSingUpEntity adminEntity = optionalAdminId.get();
			admin.setAdminshow(adminEntity);
			productRepo.save(admin);
			return true;
			
		}
		return false;
	}

	/*
	 * public void saveProductToDB(MultipartFile file, String EventName, int price,
	 * String Location, LocalDate date, LocalTime time) { if (file == null ||
	 * file.isEmpty() || EventName == null || EventName.isEmpty() || price <= 0) {
	 * throw new IllegalArgumentException("Invalid show data"); }
	 * 
	 * try { String fileName = StringUtils.cleanPath(file.getOriginalFilename()); if
	 * (fileName.contains("..")) { throw new
	 * IllegalArgumentException("Invalid file name"); }
	 * 
	 * AdminshowEntity product = new AdminshowEntity();
	 * product.setEventname(EventName);
	 * 
	 * product.setPrice(price);
	 * 
	 * product.setFile(Base64.getEncoder().encodeToString(file.getBytes()));
	 * product.setLocation(Location); product.setDate(date); product.setTime(time);
	 * 
	 * productRepo.save(product); } catch (IOException e) { throw new
	 * RuntimeException("Failed to save show", e); } }
	 */

	public List<AdminshowEntity> getAllProducts() {
		return productRepo.findAll();
	}

	public void deleteProductById(Integer id) {
		productRepo.deleteById(id);
	}

	public void changeEventName(Integer id, String eventname) {
		updateProduct(id, product -> product.setEventname(eventname));
	}

	public void changeProductPrice(Integer id, int price) {
		updateProduct(id, product -> product.setPrice(price));
	}

	private void updateProduct(Integer id, ProductUpdateFunction updateFunction) {
		Optional<AdminshowEntity> productOptional = productRepo.findById(id);
		if (productOptional.isPresent()) {
			AdminshowEntity product = productOptional.get();
			updateFunction.update(product);
			productRepo.save(product);
		} else {
			throw new IllegalArgumentException("Product not found with id: " + id);
		}
	}

	@FunctionalInterface
	private interface ProductUpdateFunction {
		void update(AdminshowEntity product);
	}

	public List<AdminshowEntity> getProductsByCategory(String location) {
		return productRepo.findByLocation(location);
	}

	public List<AdminshowEntity> getVegetarianProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AdminshowEntity> getNonVegetarianProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getAllLocation(String location) {
		return productRepo.getAllByLocation(location);
	}


    public Boolean saveAdminShow(AdminshowEntity adminshow, Long adminId, MultipartFile image) throws IOException, DocumentException {
        Optional<AdminSingUpEntity> optionalAdmin = adminRepo.findById(adminId);
        if (optionalAdmin.isPresent()) {
            AdminSingUpEntity admin = optionalAdmin.get();
            adminshow.setAdminshow(admin);
            adminshow.setImage(image.getBytes());
            productRepo.save(adminshow);
            return true;
        }
        return false;
    }

    

}

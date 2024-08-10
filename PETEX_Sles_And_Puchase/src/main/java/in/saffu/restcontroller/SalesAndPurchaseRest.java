package in.saffu.restcontroller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lowagie.text.DocumentException;

import in.saffu.entity.PurchaseEntity;
import in.saffu.entity.SalesEntity;
import in.saffu.entity.UserEntity;
import in.saffu.repository.UserRepository;
import in.saffu.service.SalesAndPurchaseService;

@RestController
@RequestMapping("/petex")
@CrossOrigin(origins = "*")
public class SalesAndPurchaseRest {

	@Autowired
	private SalesAndPurchaseService services;

	@Autowired
	private UserRepository userRepo;


	@PostMapping(value = "/sales/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> saveSalesData(@PathVariable Long userId,
	                                            @ModelAttribute SalesEntity sales,
	                                            MultipartHttpServletRequest request) {
	    try {
	        Optional<UserEntity> optionalUser = userRepo.findById(userId);
	        
	        if (!optionalUser.isPresent()) {
	            return new ResponseEntity<>("User not found with ID: " + userId, HttpStatus.NOT_FOUND);
	        }

	        UserEntity user = optionalUser.get();

	        sales.setUsers(user);

	        Iterator<String> fileNames = request.getFileNames();
	        if (fileNames.hasNext()) {
	            String fileName = fileNames.next();
	            MultipartFile file = request.getFile(fileName);
	            if (file != null && !file.isEmpty()) {
	                byte[] fileBytes = file.getBytes();
	                sales.setImage(fileBytes);
	            }
	        }

	        SalesEntity savedSalesEntity = services.saveSalesEntity(sales, userId);

	        if (savedSalesEntity != null) {
	            return new ResponseEntity<>("Sales saved successfully", HttpStatus.CREATED);
	        } else {
	            return new ResponseEntity<>("Failed to save sales", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        return new ResponseEntity<>("Failed to save sales", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


	
	/*
	 * @PostMapping("/sales/{userId}") public ResponseEntity<String>
	 * saveSalesData(@RequestBody SalesEntity entity,@PathVariable Long userId)
	 * throws DocumentException, IOException{ Boolean salesStatus =
	 * services.saveSales(entity, userId);
	 * 
	 * if (salesStatus) { return new
	 * ResponseEntity<String>("sallening successfully",HttpStatus.CREATED); }else {
	 * return new ResponseEntity<String>("sallening not successfully",HttpStatus.
	 * INTERNAL_SERVER_ERROR); } }
	 */

	@GetMapping("/getsales")
	public ResponseEntity<List<SalesEntity>> getAllSales() {
		List<SalesEntity> allSales = services.getAllSales();
		return new ResponseEntity<List<SalesEntity>>(allSales, HttpStatus.OK);
	}

	@GetMapping("/getpurchase")
	public ResponseEntity<List<PurchaseEntity>> getAllPurchase() {
		List<PurchaseEntity> allpurchase = services.getAllPurchase();
		return new ResponseEntity<List<PurchaseEntity>>(allpurchase, HttpStatus.OK);
	}

	@PostMapping("/purchase/{userId}")
	public ResponseEntity<String> savePurchaseData(@RequestBody PurchaseEntity entity, @PathVariable Long userId)
			throws DocumentException, IOException {
		Boolean salesStatus = services.savePurchase(entity, userId);

		if (salesStatus) {
			return new ResponseEntity<String>("Purchaseing successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Purchaseing not successfully", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getsales/{id}")
	public ResponseEntity<?> getSalesById(@PathVariable Integer id) {
		SalesEntity sales = services.getSalesById(id);
		if (sales != null) {
			return new ResponseEntity<>(sales, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Sales with id " + id + " not found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getpurchase/{id}")
	public ResponseEntity<?> getPurchaseById(@PathVariable Integer id) {
		PurchaseEntity purchasesById = services.getPurchasesById(id);
		if (purchasesById != null) {
			return new ResponseEntity<>(purchasesById, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("purchase with id " + id + " not found", HttpStatus.NOT_FOUND);
		}
	}

}

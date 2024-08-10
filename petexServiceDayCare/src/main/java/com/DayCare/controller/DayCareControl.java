package com.DayCare.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.DayCare.entity.DayCareEntity;
import com.DayCare.service.DayCareService;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/daycare")
public class DayCareControl {
    private final DayCareService serviceService;

	   
    public DayCareControl(DayCareService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/all")
    public List<DayCareEntity> getAllServices() {
        return serviceService.getAllServices();
    }

    @GetMapping("/{daycareId}")
    public ResponseEntity<DayCareEntity> getServiceById(@PathVariable Long daycareId) {
        Optional<DayCareEntity> service = serviceService.getServiceById(daycareId);
        return service.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @PostMapping("/save/{vendorId}")
//    public ResponseEntity<String> saveHousingBoard(@RequestBody DayCareEntity grooming,@PathVariable Long vendorId, @RequestPart("image") MultipartFile image) {
//        try {
//            Boolean status = serviceService.save(grooming,vendorId, image);
//            if (status) {
//                return new ResponseEntity<>("DayCare data saved successfully", HttpStatus.CREATED);
//            }
//            return new ResponseEntity<>("DayCare data not saved successfully", HttpStatus.INTERNAL_SERVER_ERROR);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Failed to save DayCare data", HttpStatus.BAD_REQUEST);
//        }
//    }
    @PutMapping("/{id}")
    public ResponseEntity<DayCareEntity> updateService(@PathVariable Long id, @RequestBody DayCareEntity entity) {
    	DayCareEntity result = serviceService.updateService(id, entity);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{vendorId}")
    public ResponseEntity<Void> deleteServiceById(@PathVariable Long vendorId) {
        serviceService.deleteServiceById(vendorId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(path = "/save/{vendorId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveProduct(@PathVariable("vendorId") Long vendorId, 
            @RequestParam("file") MultipartFile file,
            @RequestParam("serviceCost") double serviceCost,
            @RequestParam("serviceType") String serviceType,
            @RequestParam("petType") String petType,
            @RequestParam("location") String location,
            @RequestParam("description") String description) {
        try {
            serviceService.savePetToDB(vendorId, file, serviceCost, serviceType, petType, location, description);
            return ResponseEntity.ok().body("Data saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving data: " + e.getMessage());
        }
    }


    @GetMapping("/daycares/{serviceType}/{vendorId}")
    public ResponseEntity<List<DayCareEntity>> getDayCaresByServiceTypeAndVendorId(
            @PathVariable String serviceType,
            @PathVariable Long vendorId) {
        List<DayCareEntity> dayCares = serviceService.findByServiceTypeAndVendorId(serviceType, vendorId);
        return ResponseEntity.ok().body(dayCares);
    }
//    @GetMapping("/vendor/{vendorId}")
//    public ResponseEntity<List<DayCareEntity>> getServicesByVendorId(@PathVariable Long vendorId) {
//        List<DayCareEntity> services = serviceService.getServicesByVendorId(vendorId);
//        if (!services.isEmpty()) {
//            return ResponseEntity.ok(services);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
    
    @GetMapping("/serviceType/{serviceType}")
    public List<DayCareEntity> findByServiceType(@PathVariable String serviceType) {
        return serviceService.findByServiceType(serviceType);
    }

    @GetMapping("/serviceType/{serviceType}/location/{location}")
    public List<DayCareEntity> findByServiceTypeAndLocation(@PathVariable String serviceType, @PathVariable String location) {
        return serviceService.findByServiceTypeAndLocation(serviceType, location);
    } 
}

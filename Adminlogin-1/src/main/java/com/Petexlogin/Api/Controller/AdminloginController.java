package com.Petexlogin.Api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Petexlogin.Api.Entity.AdminLogin;
import com.Petexlogin.Api.Entity.AdminSingUpEntity;
import com.Petexlogin.Api.Service.AdminloginServices;

@RestController
@RequestMapping("/petex")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminloginController {

    @Autowired
    private AdminloginServices services;

    @PostMapping("/sign")
    public ResponseEntity<String> saveAdminlogin(@RequestBody AdminSingUpEntity entity) {
        Boolean status = services.adminlogin(entity);
        if (status) {
            return new ResponseEntity<>("Adminlogin successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Adminlogin not successfully", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/login")
    public ResponseEntity<String> adminLogin(@RequestBody AdminLogin login) {
        String adminLogin = services.adminLogin(login);
        if (adminLogin.equals("login Successfully")) {
            return new ResponseEntity<>(adminLogin, HttpStatus.OK);
        }
        return new ResponseEntity<>(adminLogin, HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/forgetPassword/{email}")
    public ResponseEntity<String> updatePassword(@PathVariable String email, @RequestParam String password) {
        String result = services.forgetPassword(email, password);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/getdata/{adminId}")
    public ResponseEntity<AdminSingUpEntity> getById(@PathVariable Long adminId) {
        AdminSingUpEntity adminSingUpEntity = services.getById(adminId);
        if (adminSingUpEntity != null) {
            return new ResponseEntity<>(adminSingUpEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/getdata")
    public ResponseEntity<List<AdminSingUpEntity>> getAllAdmins() {
        List<AdminSingUpEntity> admins = services.getdata();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }
    
    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<AdminSingUpEntity> getUserByEmail(@PathVariable String email) {
        AdminSingUpEntity user = services.getAdminSingUpEntityByEmail(email);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

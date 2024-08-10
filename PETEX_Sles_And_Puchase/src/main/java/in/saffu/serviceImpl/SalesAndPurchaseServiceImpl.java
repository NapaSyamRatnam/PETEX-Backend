package in.saffu.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lowagie.text.DocumentException;

import in.saffu.entity.PurchaseEntity;
import in.saffu.entity.SalesEntity;
import in.saffu.entity.UserEntity;
import in.saffu.repository.PurchaseRepo;
import in.saffu.repository.SalesRepo;
import in.saffu.repository.UserRepository;
import in.saffu.service.SalesAndPurchaseService;
import in.saffu.utils.EmailUtils;
import in.saffu.utils.PurchasePdfGenerator;
import in.saffu.utils.SalesPdfGenerator;
import jakarta.transaction.Transactional;

@Service
public class SalesAndPurchaseServiceImpl implements SalesAndPurchaseService {

	@Autowired
	private SalesRepo salesRepo;

	@Autowired
	private PurchaseRepo purchaseRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EmailUtils emailUtils;

	@Autowired
	private SalesPdfGenerator salesPdfGenerator;

	@Autowired
	private PurchasePdfGenerator pdfGenerator;

	@Override
	public SalesEntity saveSalesEntity(SalesEntity salesEntity, Long userId) {
	    Optional<UserEntity> optionalUser = userRepo.findById(userId); // Corrected userId
	    if (optionalUser.isPresent()) {
	        UserEntity user = optionalUser.get();
	        return salesRepo.save(salesEntity);
	    }
	    throw new IllegalArgumentException("User with ID " + userId + " not found");
	}

	    
	@Override
	public List<SalesEntity> getAllSales() {
		return salesRepo.findAll();
	}

	@Override
	public Boolean savePurchase(PurchaseEntity purchase, Long userid) throws DocumentException, IOException {

		Optional<UserEntity> optinalUser = userRepo.findById(userid);
		if (optinalUser.isPresent()) {
			UserEntity user = optinalUser.get();
			purchase.setUser(user);
			PurchaseEntity save = purchaseRepo.save(purchase);

			File f = new File("Purchase.pdf");

			pdfGenerator.generate(save, f);

			String subject = "Purchase Booking Report";
			String body = "Purchase";
			String to = user.getEmail();

			emailUtils.sendEmail(subject, body, to, f);
			f.delete();

			return true;
		}
		return false;
	}

	@Override
	public List<PurchaseEntity> getAllPurchase() {
		return purchaseRepo.findAll();
	}

	public SalesEntity getSalesById(Integer id) {
	    Optional<SalesEntity> optionalId = salesRepo.findById(id);
	    return optionalId.orElse(null);
	}

	@Override
	public PurchaseEntity getPurchasesById(Integer id) {
		Optional<PurchaseEntity> optinalId = purchaseRepo.findById(id);
		if (optinalId.isPresent()) {
			return optinalId.get();
		}
		return null;
	}

}

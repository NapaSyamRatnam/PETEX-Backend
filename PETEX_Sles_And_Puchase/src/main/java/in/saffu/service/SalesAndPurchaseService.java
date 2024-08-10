package in.saffu.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.lowagie.text.DocumentException;

import in.saffu.entity.PurchaseEntity;
import in.saffu.entity.SalesEntity;

public interface SalesAndPurchaseService  {
	
	public SalesEntity saveSalesEntity(SalesEntity salesEntity, Long userId);
	
	public List<SalesEntity> getAllSales();
	
	public SalesEntity getSalesById(Integer id);
	
	public Boolean savePurchase(PurchaseEntity purchase,Long userid)throws DocumentException, IOException;
	
	public List<PurchaseEntity> getAllPurchase();
	
	public PurchaseEntity getPurchasesById(Integer id);


}

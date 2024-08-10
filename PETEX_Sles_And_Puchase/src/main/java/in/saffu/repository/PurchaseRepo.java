package in.saffu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.saffu.entity.PurchaseEntity;

public interface PurchaseRepo extends JpaRepository<PurchaseEntity, Integer> {

}

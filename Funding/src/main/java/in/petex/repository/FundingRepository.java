package in.petex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.petex.entity.FundingEntity;

public interface FundingRepository extends JpaRepository<FundingEntity, Long> {

}

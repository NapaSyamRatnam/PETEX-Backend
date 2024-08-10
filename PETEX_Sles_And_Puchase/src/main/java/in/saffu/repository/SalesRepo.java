package in.saffu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.saffu.entity.SalesEntity;

public interface SalesRepo extends  JpaRepository<SalesEntity, Integer>{

}

package com.petex.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petex.entity.CommentsEntity;

public interface CommentsRepo  extends JpaRepository<CommentsEntity, Long>{

}

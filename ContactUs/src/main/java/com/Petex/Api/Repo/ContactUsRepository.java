package com.Petex.Api.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Petex.Api.Entity.ContactUsentity;


@Repository
public interface ContactUsRepository extends JpaRepository <ContactUsentity, Long >  {



}

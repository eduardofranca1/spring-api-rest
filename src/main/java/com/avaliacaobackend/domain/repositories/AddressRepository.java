package com.avaliacaobackend.domain.repositories;

import com.avaliacaobackend.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {


}

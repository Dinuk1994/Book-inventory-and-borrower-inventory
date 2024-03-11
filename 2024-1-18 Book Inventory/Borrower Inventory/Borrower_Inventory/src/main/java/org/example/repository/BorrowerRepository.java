package org.example.repository;

import org.example.entity.BorrowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<BorrowerEntity,Long> {
    BorrowerEntity findByName(String name);
}

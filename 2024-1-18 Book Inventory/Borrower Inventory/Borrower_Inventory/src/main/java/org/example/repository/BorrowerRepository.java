package org.example.repository;

import org.example.entity.BorrowerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends CrudRepository<BorrowerEntity,Long> {
}

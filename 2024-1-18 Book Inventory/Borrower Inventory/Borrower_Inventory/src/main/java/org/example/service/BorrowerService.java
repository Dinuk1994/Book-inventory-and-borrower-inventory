package org.example.service;

import org.example.dto.Borrower;
import org.example.entity.BorrowerEntity;

import java.util.List;

public interface BorrowerService {
    public void addBorrower(Borrower borrower);

    public List<BorrowerEntity> getBorrower();

    public boolean deleteBorrower(Long id);

    public Borrower findByName(String name);

}


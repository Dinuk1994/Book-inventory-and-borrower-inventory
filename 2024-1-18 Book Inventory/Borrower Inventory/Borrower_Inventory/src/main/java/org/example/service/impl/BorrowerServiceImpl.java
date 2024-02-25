package org.example.service.impl;

import org.example.dto.Borrower;
import org.example.entity.BorrowerEntity;
import org.example.repository.BorrowerRepository;
import org.example.service.BorrowerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerServiceImpl implements BorrowerService {
    @Autowired
    BorrowerRepository borrowerRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public void addBorrower(Borrower borrower) {
        BorrowerEntity entity = modelMapper.map(borrower, BorrowerEntity.class);
        borrowerRepository.save(entity);

    }

    @Override
    public List<BorrowerEntity> getBorrower() {
        return (List<BorrowerEntity>) borrowerRepository.findAll();
    }

    @Override
    public boolean deleteBorrower(Long id) {
      if (borrowerRepository.existsById(id)){
          borrowerRepository.deleteById(id);
          return true;
      }
        return false;
    }
}

package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Borrower;
import org.example.entity.BorrowerEntity;
import org.example.repository.BorrowerRepository;
import org.example.service.BorrowerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowerServiceImpl implements BorrowerService {

   final BorrowerRepository borrowerRepository;
    final ModelMapper modelMapper;
    @Override
    public void addBorrower(Borrower borrower) {
        BorrowerEntity entity = modelMapper.map(borrower, BorrowerEntity.class);
        borrowerRepository.save(entity);

    }

    @Override
    public List<BorrowerEntity> getBorrower() {
        return  borrowerRepository.findAll();
    }

    @Override
    public boolean deleteBorrower(Long id) {
      if (borrowerRepository.existsById(id)){
          borrowerRepository.deleteById(id);
          return true;
      }
        return false;
    }

    @Override
    public Borrower findByName(String name) {
        BorrowerEntity entity = borrowerRepository.findByName(name);
        return modelMapper.map(entity, Borrower.class);
    }


}

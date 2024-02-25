package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Borrower;
import org.example.entity.BorrowerEntity;
import org.example.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrower")
@CrossOrigin
@RequiredArgsConstructor
public class BorrowerController {

     private final BorrowerService borrowerService;

    @PostMapping("/add")
    public void addBorrower(@RequestBody Borrower borrower){
        borrowerService.addBorrower(borrower);
    }

    @GetMapping("/get")
    public List<BorrowerEntity> getAll(){
        return borrowerService.getBorrower();
    }

    @DeleteMapping("/{id}")
    public String deleteByID(@PathVariable Long id){
        borrowerService.deleteBorrower(id);
        return "Deleted";
    }
}

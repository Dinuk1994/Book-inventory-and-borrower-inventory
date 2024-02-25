package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Borrower {
    private Long borrowerId;
    private String name;
    private String nic;
    private String address;
    private String date;
}

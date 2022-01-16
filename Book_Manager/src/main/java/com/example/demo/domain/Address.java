package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    //@Id
    //private Long id;
	
	private String city;    // 시

    private String district;    // 구

    @Column(name = "address_detail")
    private String detail;  // 상세주소

    private String zipCode; // 우편번호
}
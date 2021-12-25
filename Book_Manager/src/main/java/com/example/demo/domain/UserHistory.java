package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.demo.domain.listener.Auditable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @ManyToOne
    private User user;
    
    //Auditable 인터페이스가 구현되있는데 @Overide가 없는 이유
    //1. Auditable 인터페이스에 구현되있는 것은 createdAt과 updatedAt에 대한 getter/setter다.
    //2. createdAt과 updatedAt에 대한 getter/setter는 어차피 @Data가 자동으로 만들어 주기 때문에 중복되서 오류가 발생하지 않는다.
    //+ Book Entity에 없는 createdAt과 updatedAt는 BaseEntity Class에 작성되어 있다.
}
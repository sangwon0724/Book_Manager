package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Set<User> findByName(String name);

    Set<User> findUserByNameIs(String name);
    Set<User> findUserByName(String name);
    Set<User> findUserByNameEquals(String name);

    //단순 검색
    User findByEmail(String email);
    User getByEmail(String email);
    User readByEmail(String email);
    User queryByEmail(String email);
    User searchByEmail(String email);
    User streamByEmail(String email);
    
    //단순 검색
    //JpaRepository의 파라미터로 있는 User떄문에 기본적으로 User 테이블로 지정되어있다.
    //가독성을 위해 실행문과 By 사이에 이름을 작성할수는 있어도 결과적으로는 무시된다.
    User findUserByEmail(String email);
    User findSomethingByEmail(String email);
    List<User> findLast1ByName(String name);
    
    //첫 데이터부터 n개의 데이터를 가져온다.
    List<User> findFirst2ByName(String name);
    List<User> findTop2ByName(String name);

    //조건문
    List<User> findByEmailAndName(String email, String name); //where User.Email = email and User.Name = name
    List<User> findByEmailOrName(String email, String name); //where User.Email = email or User.Name = name
    List<User> findByCreatedAtAfter(LocalDateTime yesterday); //where User.CreatedAt > yesterday
    List<User> findByIdAfter(Long id); //where User.Id > id
    List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday); //where User.CreatedAt > yesterday
    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday); //where User.CreatedAt >= yesterday
    List<User> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow); //where User.CreatedAt between yesterday and tomorrow
    List<User> findByIdBetween(Long id1, Long id2); //where User.Id between id1 and id2
    List<User> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2); //where User.Id >= id1 and User.Id <= id2
    List<User> findByIdIsNotNull(); //where User.Id is not null
    //List<User> findByAddressIsNotEmpty();   //오류 발생
    List<User> findByNameIn(List<String> names); //where User.Name In (...)
    List<User> findByNameStartingWith(String name);//where User.Name like 'name%'
    List<User> findByNameEndingWith(String name);//where User.Name like '%name'
    List<User> findByNameContains(String name);//where CONTAINS(User.Name, name)
    List<User> findByNameLike(String name); //where User.Name like name
    
    //정렬
    List<User> findTop1ByName(String name);
    List<User> findTopByNameOrderByIdDesc(String name);
    List<User> findFirstByNameOrderByIdDescEmailAsc(String name);
    List<User> findFirstByName(String name, Sort sort);
    
    //페이징 처리
    Page<User> findByName(String name, Pageable pageable);
}
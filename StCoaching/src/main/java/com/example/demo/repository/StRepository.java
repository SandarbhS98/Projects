package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.StDetails;

public interface StRepository extends JpaRepository<StDetails, Integer> {
	
	StDetails findByRollno(int rollno) ;

	List<StDetails> findAll();
	
	List<StDetails> sort = new ArrayList<>();
	List<StDetails> sortByrollno = sort.stream().sorted(Comparator.comparing(StDetails:: getRollno)).collect(Collectors.toList());
	
//			List<User> sortedList = userList.stream()
//	        .sorted(Comparator.comparingInt(User::getAge))
//	        .collect(Collectors.toList());
//
//	sortedList.forEach(System.out::println);

}

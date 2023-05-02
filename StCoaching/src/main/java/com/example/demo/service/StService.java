package com.example.demo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.StDetails;
import com.example.demo.repository.StRepository;

@Service
public class StService {

	@Autowired
	private StRepository repository;

	@Autowired
	private RestTemplate template;

	// private StDetails ;

	public StDetails saveDetails(StDetails details) {
		// return repository.save(details);
		// StDetails validation = repository.findByRollno(details.getRollno());
		if (repository.findByRollno(details.getRollno()) != null) {

			return null;
		} else {
			return repository.save(details);
		}
	}

	public StDetails getByid(int id) {
		return repository.findById(id).orElse(null);
	}

	public StDetails updateRecharge(int id, StDetails dto) {
		StDetails details = repository.findById(id).orElse(null);
		if (details != null) {
			details.setName(dto.getName());
			return repository.save(dto);
		} else {
			return null;
		}

	}

	public StDetails deleteStudent(int id) {
		StDetails detailss = repository.findById(id).orElse(null);
		if (detailss != null) {
			repository.delete(detailss);
			return detailss;
		} else {
			return null;
		}
	}
// all list 
//	public List<StDetails> getAllDetls() {
//	//	 List<StDetails> stdetails = new ArrayList<>();
//		// repository.findAll().forEach(stdetai-> stdetails.add(stdetai) );
//		
//		return repository.findAll();
//	}
	// Sorting By %
//	public List<StDetails> getAllDetls( StDetails details) {
//		
//		return repository.findAll(Sort.by("percentage").descending());
//	}

	public List<StDetails> getAllDetls( ) {

//		List<Tutorial> tutorials =
//			     tutorialRepository.findAll(Sort.by("published").descending().and(Sort.by("title")));
		return repository.findAll(Sort.by("percentage").descending().and(Sort.by("rollno")));
	}
	
	
	//                    Sorting Without Java 8 feat
	public List<StDetails> getAllStByRoll(String field) {
		// TODO Auto-generated method stub
		return repository.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	public Page<StDetails> getStudentPagination(Integer pagenumber, Integer pagesize, String sortProperty) {
		Pageable pageable = null;
		if (null != sortProperty) {
			pageable = PageRequest.of(pagenumber, pagesize, Sort.Direction.ASC, sortProperty);
		} else {
			pageable = PageRequest.of(pagenumber, pagesize, Sort.Direction.ASC, "rollno");
		}
		return repository.findAll(pageable);
	}
	//                    Sorting With Java 8 feat
	public List<StDetails> sortByjavaEi() {
		Iterable<StDetails> liss= repository.findAll();
		List<StDetails> sort = new ArrayList<>();
		liss.forEach(sort:: add);
		List<StDetails> sortByrollno = sort.stream().sorted(Comparator.comparing(StDetails:: getRollno)).collect(Collectors.toList());
		
//		sortByrollno.forEach(System.out::println);
		return sortByrollno;
	}

	public List<StDetails> sortBypercent() {
		// TODO Auto-generated method stub
		Iterable<StDetails> kisa = repository.findAll();
		List<StDetails> dss = new ArrayList<>();
		kisa.forEach(dss:: add);
	//	List<StDetails> collect = dss.stream().sorted(Comparator.comparing(StDetails:: getPercentage)).collect(Collectors.toList());
		
	//	List<StDetails> collect2 = dss.stream().sorted((ji,sa)-> ji.getName().compareTo(sa.getName())).collect(Collectors.toList());
		List<StDetails> collect3 = dss.stream().sorted((ji,sa)-> sa.getRollno().compareTo(ji.getRollno())).collect(Collectors.toList());
		
		return collect3;
	}
	
//	public Page<StDetails> getStudentPagination(Integer pagenumber, Integer pagesize) {
//		
//		//	Sort sort = Sort.by(Sort.Direction.ASC,"rollno");
//			Pageable pageable = PageRequest.of(pagenumber, pagesize, Sort.Direction.ASC,"rollno");
//			return repository.findAll(pageable);
//		}

}

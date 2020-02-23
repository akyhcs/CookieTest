package com.example.demo.Service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.CafeService;
import com.example.demo.dto.CafeDto;
import com.example.demo.entity.Cafe;
import com.example.demo.repository.CafeRepository;

@Service
public class CafeServiceImpl implements CafeService{

	ModelMapper modelMapper=new ModelMapper();
	@Autowired
	CafeRepository cafeRepository;
	
	@Override
	public List<CafeDto> getAllCafe() {
		List<Cafe> cafeList=cafeRepository.findAll();
		List<CafeDto> cafeDtoList=cafeList.stream().map(entity->convertEntityToDto(entity)).collect(Collectors.toList());
		return cafeDtoList;
	}
	
	public CafeDto convertEntityToDto(Cafe cafe) {
		return modelMapper.map(cafe,CafeDto.class);
	}
	
}

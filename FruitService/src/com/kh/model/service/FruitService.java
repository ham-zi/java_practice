package com.kh.model.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.model.dto.FruitBoxDto;
import com.kh.model.vo.FruitBox;

public class FruitService {
	
	private List<FruitBox>fruitBoxes = new ArrayList<>();
	
	{
		fruitBoxes.add(new FruitBox("111", "수박", 12.3,2,33000));
		fruitBoxes.add(new FruitBox("222", "복숭아",16, 5,13000));
		fruitBoxes.add(new FruitBox("333", "귤", 11, 33,23000));
		fruitBoxes.add(new FruitBox("444", "황금사과", 15,12,76000));
		fruitBoxes.add(new FruitBox("555", "샤인머스켓", 21,2,18000));
		
	}
	
	public FruitBox createFruitBox(FruitBoxDto dto) {
		if(isId(dto.getProductId()) != null) {
			FruitBox fruitbox = new FruitBox(dto.getProductId(), dto.getFruitName(), dto.getFruitBrix(), dto.getFruitStock(), dto.getProductPrice());
			fruitBoxes.add(fruitbox);
			return fruitbox;
		} else {
			return null;
		}
	}
	
	public List<FruitBox> selectAll() {
		return fruitBoxes;
	}
	
	public List<FruitBox> findByName(String Name) {
		List<FruitBox>list = fruitBoxes.stream()
				  .filter(f -> f.getFruitName().equals(Name))
				  .toList();
		return list;
	}
	
	public List<FruitBox> findByBrix(double brix) {
		List<FruitBox>list = fruitBoxes.stream()
				  .filter(f -> f.getFruitBrix() == brix)
				  .toList();
		return list;		
	}
	
	public List<FruitBox> findByPrice(int price) {
		List<FruitBox>list = fruitBoxes.stream()
				  .filter(f -> f.getProductPrice() == price)
				  .toList();
		return list;
	}
	
	public List<FruitBox> findByStock(int stock) {
		List<FruitBox>list = fruitBoxes.stream()
				.filter(f -> f.getFruitStock() == stock)
				.toList();
		return list;		
	}

	public FruitBox updateFruitBox(FruitBoxDto dto) {
		int fruitIndex = findIndexById(dto.getProductId());
		if(fruitIndex != -1) {
			fruitBoxes.remove(fruitIndex);
			FruitBox newFruitBox = new FruitBox(dto.getProductId(), dto.getFruitName(), dto.getFruitBrix(), dto.getFruitStock(), dto.getProductPrice());
			fruitBoxes.add(newFruitBox);
			return newFruitBox;
			
		} else {
			return null;
		}
	}
	
	
	public FruitBox deleteFruitBox(String id) {
		int fruitIndex = findIndexById(id);
		if(fruitIndex != -1) {
			return fruitBoxes.remove(fruitIndex);
			
		}else {
			return null;
		}
	}

	public int findIndexById(String id) {
		for(int i=0; i<fruitBoxes.size(); i++) {
			if(id.equals(fruitBoxes.get(i).getProductId())) {
				return i;
			}
		}
		return -1;
	}
	
	public FruitBox isId(String id) {
		FruitBox fruitBox = fruitBoxes.stream()
				  .filter(f -> f.getProductId().equals(id))
				  .findFirst()
				  .orElse(null);
		return fruitBox;
	}
	
}

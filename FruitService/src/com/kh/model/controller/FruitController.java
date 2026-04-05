package com.kh.model.controller;

import java.util.List;

import com.kh.model.dto.FruitBoxDto;
import com.kh.model.service.FruitService;
import com.kh.model.vo.FruitBox;

public class FruitController {

	private FruitService fs = new FruitService();
	
	public FruitBox createFruitBox(FruitBoxDto dto) {
		return fs.createFruitBox(dto);
	}
	
	public List<FruitBox> selectAll() {
		return fs.selectAll();
	}
	
	public List<FruitBox> findByName(String Name) {
		return fs.findByName(Name);
	}
	
	public List<FruitBox> findByBrix(double brix) {
		return fs.findByBrix(brix);
	}
	
	public List<FruitBox> findByPrice(int price) {
		return fs.findByPrice(price);
	}
	
	public List<FruitBox> findByStock(int stock){
		return fs.findByStock(stock);
	}
	
	public FruitBox updateFruitBox(FruitBoxDto dto) {
		return fs.updateFruitBox(dto);
	}
	
	public FruitBox deleteFruitBox(String id) {
		return fs.deleteFruitBox(id);
	}
	
	public FruitBox isId(String id) {
		return fs.isId(id);
	}
}

package com.kh.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.kh.model.vo.FruitBox;

public class FileFruitBox {
	
	public void outputFruitBoxes(List<FruitBox>list) {

		try(FileWriter fw = new FileWriter("FruitBoxes" )) {
			String info = list.stream()
							  .map(f -> "[상품번호:" + f.getProductId() + ", 과일:" + f.getFruitName() + ", 당도:" + f.getFruitBrix()
						 		+ ", 과일개수:" + f.getFruitStock() + ", 상품가격:" + f.getProductPrice() + "]\n")
							  .collect(Collectors.joining());
			fw.write(info);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}

package com.kh.chap04.run;

import com.kh.chap04.model.dao.BufferDao;
import com.kh.chap04.model.dao.ObjectDao;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferDao bd = new BufferDao();
		
		//bd.inputFile();
		
		ObjectDao od = new ObjectDao();
		//od.outputFile();
		od.intputFile();
	}

}

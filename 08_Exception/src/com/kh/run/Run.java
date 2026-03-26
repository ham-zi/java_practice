package com.kh.run;

import com.kh.controller.CheckedException;
import com.kh.controller.UncheckedException;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 예외(Exception)
		 * 
		 * 
		 * 
		 */
		UncheckedException ue = new UncheckedException();
		//ue.divZero();
		//ue.multiCatch();
		//ue.orderByCatch();
		CheckedException ux = new CheckedException();
		ux.readString();
	}

}

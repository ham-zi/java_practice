package com.kh.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.model.controller.FruitController;
import com.kh.model.dto.FruitBoxDto;
import com.kh.model.vo.FruitBox;

public class FruitView {
	private FruitController fc = new FruitController();
	private Scanner sc = new Scanner(System.in);

	public void menu() {
		while(true) {
			System.out.println();
			System.out.println("=======================");
			System.out.println(" 과일상품 서비스");
			System.out.println("1 : 상품 전체 조회 ");
			System.out.println("2 : 상품 필터 조회");
			System.out.println("3 : 과일 상품 추가");
			System.out.println("4 : 과일 상품 수정");
			System.out.println("5 : 과일 상품 삭제");
			System.out.println("6 : 상품 파일 출력");
			System.out.println("7 : 프로그램 종료");
			System.out.println("=======================");
			System.out.println();
			System.out.print("메뉴 선택 >");
			String menuNum = sc.nextLine();
	
			switch (menuNum) {
			case "1":
				selectAll();
				break;
			case "2":
				findFruitBoxes();
				break;
			case "3":
				createFruitBox();
				break;
			case "4":
				updateFruitBox();
				break;
			case "5":
				deleteFruitBox();
				break;
			case "6":
				break;
			case "7":
				sc.close();
				return;
			}
		}
	}
	
	private void selectAll() {
		System.out.println();
		System.out.println("======상품 전체 조회======");
		List<FruitBox>list = fc.selectAll();
		if( !(list.isEmpty()) ) {
			list.stream()
				.map(f -> "[상품번호:" + f.getProductId() +
						", 과일:" + f.getFruitName() +
						", 당도:" + f.getFruitBrix() +
						", 과일개수:" + f.getFruitStock() +
						", 상품가격:" + f.getProductPrice() +
						"]")
				.forEach(System.out::println);
			System.out.println("======================");
		} else {
			System.out.println("상품이 존재하지 않습니다.");
		}
	}
	
	private void findFruitBoxes() {
		while(true) {
			System.out.println();
			System.out.println("======상품 필터 조회======");
		}
	}
	
	private void createFruitBox() {
		String ProductNo;
		String FruitName;
		double FruitBrix;
		int FruitStock;
		int ProductPrice;
		try {
			System.out.println();
			System.out.println("======상품 정보 입력======");
			System.out.print("상품번호 입력 >");
			ProductNo = sc.nextLine();
			System.out.print("과일이름 입력 >");
			FruitName = sc.nextLine();
			System.out.print("당도 입력 >");
			FruitBrix = sc.nextDouble();
			System.out.print("과일개수 입력 >");
			FruitStock = sc.nextInt();
			System.out.print("상품가격 입력 >");
			ProductPrice = sc.nextInt();
			sc.nextLine();
			FruitBoxDto dto = new FruitBoxDto(ProductNo, FruitName, FruitBrix, FruitStock, ProductPrice);
			fc.createFruitBox(dto);
			selectAll();
		} catch (InputMismatchException e) {
			System.out.println("당도/과일개수/상품가격에는 숫자를 입력해주세요.");
			return;
		}
	}
	
	private void updateFruitBox() {
		String ProductNo;
		String FruitName;
		double FruitBrix;
		int FruitStock;
		int ProductPrice;
		System.out.println();
		selectAll();
		try {
			System.out.println();
			System.out.println("======과일 상품 수정======");
			
			System.out.print("상품번호 입력 >");
			ProductNo = sc.nextLine();
			if(fc.isId(ProductNo)==null ) {
				System.out.println("존재하지 않는 상품번호입니다.");
				return;
			}
			
			System.out.println("===새로운 상품 정보 입력===");			
			System.out.print("과일이름 입력 >");
			FruitName = sc.nextLine();
			System.out.print("당도 입력 >");
			FruitBrix = sc.nextDouble();
			System.out.print("과일개수 입력 >");
			FruitStock = sc.nextInt();
			System.out.print("상품가격 입력 >");
			ProductPrice = sc.nextInt();
			sc.nextLine();
			FruitBoxDto dto = new FruitBoxDto(ProductNo, FruitName, FruitBrix, FruitStock, ProductPrice);
			FruitBox fruitBox = fc.updateFruitBox(dto);
			if(fruitBox!=null) {
				System.out.println("상품 수정 성공했습니다.");
				selectAll();
			}else {
				System.out.println("상품 수정 실패했습니다.");
				System.out.println("관리자에게 문의하십시오.");
			}
		} catch (InputMismatchException e) {
			System.out.println("당도/과일개수/상품가격에는 숫자를 입력해주세요.");
			return;
		}
	}
	
	private void deleteFruitBox() {
		selectAll();
		System.out.println();
		System.out.println("======과일 상품 삭제======");
		System.out.print("상품번호 입력 >");
		String ProductNo = sc.nextLine();
		if(fc.isId(ProductNo)==null ) {
			System.out.println("존재하지 않는 상품번호입니다.");
			return;
		}
		FruitBox fruitBox = fc.deleteFruitBox(ProductNo);
		if(fruitBox!=null) {
			System.out.println("상품 삭제 성공했습니다.");
			selectAll();
		}else {
			System.out.println("상품 삭제 실패했습니다.");
			System.out.println("관리자에게 문의하십시오.");
		}
	}
	
}

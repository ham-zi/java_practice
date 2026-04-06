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
		while (true) {
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
				fc.outputFruitBoxes();
				break;
			case "7":
				sc.close();
				return;
			default :
				System.out.println("잘못된 번호를 선택하셨습니다.");
				break;
			}
		}
	}

	private void selectAll() {
		System.out.println();
		System.out.println("======상품 전체 조회======");
		List<FruitBox> list = fc.selectAll();
		if (!(list.isEmpty())) {
			listInfo(list);
			System.out.println("======================");
		} else {
			System.out.println("상품이 존재하지 않습니다.");
		}
	}

	private void findFruitBoxes() {
		while (true) {
			System.out.println();
			System.out.println("======상품 필터 조회======");
			System.out.println("1 : 과일 이름 검색");
			System.out.println("2 : 당도 범위 검색");
			System.out.println("3 : 가격 범위 검색");
			System.out.println("4 : 개수 범위 검색");
			System.out.println("5 : 상품 조회 종료");
			System.out.println("======================");
			
			System.out.print("메뉴 선택 >");
			String menuNo = sc.nextLine();
			
			try {
				switch(menuNo) {
				
					case "1" : 
						findByName();
						break;
					case "2" : 
						findByBrix();
						break;
					case "3" : 
						findByPrice();
						break;
					case "4" :
						findByStock();
						break;
					case "5" : 
						return;
					default : 
						System.out.println("잘못된 메뉴를 선택하셨습니다.");
						break;
				}
			} catch(InputMismatchException e) {
				System.out.println("과일가격/과일개수/당도에는 숫자를 입력하세요.");
				}
		}
		
	}
	
	
	private void findByName() {
		System.out.println("======과일 이름 검색======");
		System.out.print("과일 이름 >");
		String name = sc.nextLine();
		List<FruitBox>names = fc.findByName(name);
		if(names.isEmpty()) {
			System.out.println("해당 조건에 존재하는 상품이 없습니다.");
		} else {
			listInfo(names);
		}
		System.out.println("======================");
	}
	
	private void findByBrix() {
		System.out.println("======당도 범위 검색======");
		System.out.print("lowBrix >");
		double lowBrix = sc.nextDouble();
		System.out.print("highBrix>");
		double highBrix = sc.nextDouble();
		sc.nextLine();
		List<FruitBox>brix = fc.findByBrix(lowBrix, highBrix);
		if(brix.isEmpty()) {
			System.out.println("해당 조건에 존재하는 상품이 없습니다.");
		}else {
			listInfo(brix);
		}
		System.out.println("======================");
		
	}
	
	private void findByPrice() {
		System.out.println("======가격 범위 검색======");
		System.out.print("lowPrice >");
		int lowPrice = sc.nextInt();
		System.out.print("highPrice>");
		int highPrice = sc.nextInt();
		sc.nextLine();
		List<FruitBox>price = fc.findByPrice(lowPrice, highPrice);
		if(price.isEmpty()) {
			System.out.println("해당 조건에 존재하는 상품이 없습니다.");
		}else {
			listInfo(price);
		}
		System.out.println("======================");
	}
	
	private void findByStock() {
		System.out.println("======개수 범위 검색======");
		System.out.print("lowStock >");
		int lowStock = sc.nextInt();
		System.out.print("highStock>");
		int highStock = sc.nextInt();
		sc.nextLine();
		List<FruitBox>stock = fc.findByStock(lowStock, highStock);
		if(stock.isEmpty()) {
			System.out.println("해당 조건에 존재하는 상품이 없습니다.");
		}else {
			listInfo(stock);
		}
		System.out.println("======================");

	}
	
	private void listInfo(List<FruitBox>list) {
		list.stream()
		 .map(f -> "[상품번호:" + f.getProductId() + ", 과일:" + f.getFruitName() + ", 당도:" + f.getFruitBrix()
	 		+ ", 과일개수:" + f.getFruitStock() + ", 상품가격:" + f.getProductPrice() + "]")
	 .forEach(System.out::println);
	}
	

	private void createFruitBox() {

		try {
			System.out.println();
			System.out.println("======상품 정보 입력======");
			System.out.print("상품번호 입력 >");
			String ProductNo = sc.nextLine();
			System.out.print("과일이름 입력 >");
			String FruitName = sc.nextLine();
			System.out.print("당도 입력 >");
			double FruitBrix = sc.nextDouble();
			System.out.print("과일개수 입력 >");
			int FruitStock = sc.nextInt();
			System.out.print("상품가격 입력 >");
			int ProductPrice = sc.nextInt();
			sc.nextLine();
			FruitBoxDto dto = new FruitBoxDto(ProductNo, FruitName, FruitBrix, FruitStock, ProductPrice);
			FruitBox fruitBox = fc.createFruitBox(dto);
			if (fruitBox == null) {
				System.out.println("상품 등록에 실패했습니다.");
				System.out.println("상품번호가 같은지 확인해주세요.");
			}else { System.out.println("상품 등록에 성공했습니다.");}
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
			if (fc.isId(ProductNo) == null) {
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
			if (fruitBox != null) {
				System.out.println("상품 수정 성공했습니다.");
				selectAll();
			} else {
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
		if (fc.isId(ProductNo) == null) {
			System.out.println("존재하지 않는 상품번호입니다.");
			return;
		}
		FruitBox fruitBox = fc.deleteFruitBox(ProductNo);
		if (fruitBox != null) {
			System.out.println("상품 삭제 성공했습니다.");
			selectAll();
		} else {
			System.out.println("상품 삭제 실패했습니다.");
			System.out.println("관리자에게 문의하십시오.");
		}
	}
	
	
	
	
}

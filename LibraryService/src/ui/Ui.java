package ui;

public class Ui {
	
	public void printLogin(boolean login) {
		if(login) {
			System.out.println("아이디 혹은 비밀번호 입력이 잘못되었습니다.");
		}
		if(login){
			System.out.println("로그인 성공하셨습니다.\n");
			//while 메뉴시작
		}
	}

}

package service;

import domain.Member;
import repository.MemberRepository;
import ui.Ui;

public class MemberService {

	private MemberRepository repo;
	Ui ui = new Ui();

	public void signUp(String id, String password) {
		if (repo.isAvailableId(id) == true) {
			repo.addMember(Member.member(id, password));
		} else {
			System.out.println("중복된 아이디입니다.");
		}

	}

	public void login(String id, String password) {
		ui.printLogin(repo.getMember(id, password) == null);
	}
}

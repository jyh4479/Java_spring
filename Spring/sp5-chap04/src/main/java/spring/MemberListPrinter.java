package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberListPrinter {
	
	private MemberDao memberDao;
	private MemberPrinter printer;

	public MemberListPrinter() {
	}
	
	//-->생성자에는 @Autowired를 사용할수 없음
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}

	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m->printer.print(m)); //lambda표현식 --> 객체를 생성하지 않아도 메소드를 사용할수 있다
	}
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Autowired
	public void setMemberPrinter(MemberSummaryPrinter printer) {
		this.printer = printer;
	}
}

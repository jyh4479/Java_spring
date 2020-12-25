package Assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;
//////////////////////////////////
import spring.MemberViewService;

public class Assembler {

	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	/////////////////////////////////////
	private MemberViewService viewSvc;

	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
		////////////////////////////////
		viewSvc=new MemberViewService(memberDao);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}

	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}
	////////////////////////////////////////////////////////////
	public MemberViewService getMemberViewService() {
		return viewSvc;
	}

}

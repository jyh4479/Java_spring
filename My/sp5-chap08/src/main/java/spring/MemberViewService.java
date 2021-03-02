package spring;

import java.util.Map;

public class MemberViewService {
	private MemberDao memberDao;
	
	public MemberViewService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void view_all() {
		Map<String, Member> info = memberDao.getAll();
		if (info.isEmpty()) {
			System.out.println("정보가 없습니다.");
		}
		else {
			for (Map.Entry<String, Member> entry : info.entrySet()) {
				System.out.println("[key]:" + entry.getKey() + ", [value]:" + entry.getValue().getName());
			}
		}
	}
}

package com.example.demo3;
import lombok.Data;

@Data
public class Member {
	private String id;
	private String name;

	/* --> lombok을 사용하면서 선언하지 않아도됌
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}*/
}

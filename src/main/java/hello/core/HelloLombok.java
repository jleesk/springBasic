package hello.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class HelloLombok {

	private String name;
	private int age;

	public static void main(String[] arg){
		HelloLombok helloLombok =new HelloLombok();
		helloLombok.setName("name1");
		String name = helloLombok.getName();
		System.out.println("name = " + name);

	}

}

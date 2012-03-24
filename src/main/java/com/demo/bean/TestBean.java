package com.demo.bean;

import org.springframework.context.ApplicationContext;

public class TestBean {
	private String testString;

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}
	
	public static TestBean getFromApplicationContext(ApplicationContext ctx){
		return (TestBean) ctx.getBean("TestBean");
	}
}

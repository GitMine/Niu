package com.example.niu;

public class Cow {

	private int age = 0;

	/**
	 * 是否可以生产小牛
	 * 
	 * @return True | False
	 */
	public boolean isCreatSmallCow() {
		return this.age >= 3 ? true : false;
	}

	/**
	 * 过年了，年龄又大了一岁
	 */
	public void addYear() {
		this.age += 1;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

}
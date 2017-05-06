package com.ltchen.ssm.demo.bean;

public enum Gender {
	// 枚举定义需要在第一行 需要利用构造函数传参,否则编译出错
    MAN("man"), WOMAN("woman");

    // 定义私有变量
    private String gender ;

    // 构造函数，枚举类型只能为私有
    private Gender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.valueOf(this.gender);
    }
}


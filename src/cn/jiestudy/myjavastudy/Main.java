package cn.jiestudy.myjavastudy;

import cn.jiestudy.myjavastudy.pojo.Students;

public class Main {
    public static void main(String[] args){
        Students students = new Students();
        students.setName("Test");
        System.out.println(students.getName());
    }
}

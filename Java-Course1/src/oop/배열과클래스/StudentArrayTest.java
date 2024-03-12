package oop.배열과클래스;

public class StudentArrayTest {
    public static void main(String[] args) {
        // Q.[객체배열]을 이용하여 4명의 학생(Student) 데이터를 저장하고 출력하세요
        StudentArrayEx[] sa = new StudentArrayEx[4];
        sa[0] = new StudentArrayEx("진현규",25,"1234-5678","경기도");
        sa[1] = new StudentArrayEx("현규",24,"5678","경기도1");
        sa[2] = new StudentArrayEx("규",23,"14-5678","경기도2");
        sa[3] = new StudentArrayEx("진규",22,"124-578","경기도3");



        // 프로젝트 진행시 배열이 아닌, List 를 사용한다.
    }
}

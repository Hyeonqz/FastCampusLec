package Day1;

public class VDATest {
	public static void main(String[] args) {
		//Q1
		int a;
		a=10;
		System.out.println("a = " + a); //soutv 단축키

		//Q2
		int b = 10;
		b=a;
		int c = a*b;
		System.out.println("c = " + c);

		//Q3 (1부터 5까지 더하라)
		//initialize 초기화
		//지역변수는 꼭 초기화를 하고 사용해야 한다.
		int sum = 1;
		sum+=2;
		sum+=3;
		sum+=4;
		sum+=5;
		System.out.println("sum = " + sum);

		//Q4
		int x = 10;
		int y = 20;
		System.out.println("x : " + x + " y : " + y);
		int tmp;
		tmp = y;
		y=x;
		x= tmp;
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}
}

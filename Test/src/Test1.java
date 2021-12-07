import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
//		TestOut to=new TestOut();
//		FirstTest ft=new FirstTest();		
//		to.n=10;  // set(<-write 변수에 값을 쓰는것)
		// TestOut에서 private로 접근제한해서 찾을 수 없음.
//		System.out.println(to.n);  //get(<-read 변수 값을 읽는것)
//		to.setN(10); // private 필드(변수)를 불러오기 위한 메소드
//		int k=to.getN();  // 직접 변수를 쓰고싶거나, 재사용하고싶은경우
//		System.out.println(k); // == System.out.println(to.getN());
		
		Scanner s=new Scanner(System.in);
		// if else 로 하면 에러가 날 수 있는 곳에 다 넣다보니 길어짐.
		// 그래서 try ~ catch 사용
		try {
			int n=10;
			int x=s.nextInt();
			System.out.println(n/x);
		} catch(Exception e) {
			System.out.println("오류 발생");
		}
	}
	
}

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
//		TestOut to=new TestOut();
//		FirstTest ft=new FirstTest();		
//		to.n=10;  // set(<-write ������ ���� ���°�)
		// TestOut���� private�� ���������ؼ� ã�� �� ����.
//		System.out.println(to.n);  //get(<-read ���� ���� �д°�)
//		to.setN(10); // private �ʵ�(����)�� �ҷ����� ���� �޼ҵ�
//		int k=to.getN();  // ���� ������ ����Ͱų�, �����ϰ�������
//		System.out.println(k); // == System.out.println(to.getN());
		
		Scanner s=new Scanner(System.in);
		// if else �� �ϸ� ������ �� �� �ִ� ���� �� �ִٺ��� �����.
		// �׷��� try ~ catch ���
		try {
			int n=10;
			int x=s.nextInt();
			System.out.println(n/x);
		} catch(Exception e) {
			System.out.println("���� �߻�");
		}
	}
	
}

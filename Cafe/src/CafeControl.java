import java.util.Scanner;

public class CafeControl {

	public static void main(String[] args) {
		Menu menu=new Menu();
		Order order=new Order();
		// Scanner�� ���� Ÿ���� ���� ����!!!!!!!!!!!
		Scanner scan=new Scanner(System.in);
		System.out.println("���α׷� ����");
		System.out.println("�۾��� �����Ͻÿ�. (X:����,M:�޴�����,O:�ֹ�����,S:��������)");
		String str=scan.nextLine();
		while(!str.equals("X")) {
			if(str.equals("M")) {
				menu.Handling();
			} else if(str.equals("O")) {
				System.out.println("�ֹ�����");
				order.Handling(menu); //�Ű����� �ν��Ͻ����ް���
			} else if(str.equals("S")) {
				System.out.println("��������");
			}
			System.out.println("�۾��� �����Ͻÿ�. (X:����,M:�޴�����,O:�ֹ�����,S:��������)");
			str=scan.nextLine();
		}
		scan.close();
		System.out.println("���α׷� ����");				
	}

}

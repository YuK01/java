import java.util.Scanner;

public class CafeControl {

	public static void main(String[] args) {
		Menu menu=new Menu();
		Order order=new Order();
		// Scanner는 여러 타입을 받지 못함!!!!!!!!!!!
		Scanner scan=new Scanner(System.in);
		System.out.println("프로그램 시작");
		System.out.println("작업을 선택하시오. (X:종료,M:메뉴관리,O:주문관리,S:실적관리)");
		String str=scan.nextLine();
		while(!str.equals("X")) {
			if(str.equals("M")) {
				menu.Handling();
			} else if(str.equals("O")) {
				System.out.println("주문관리");
				order.Handling(menu); //매개변수 인스턴스전달가능
			} else if(str.equals("S")) {
				System.out.println("실적관리");
			}
			System.out.println("작업을 선택하시오. (X:종료,M:메뉴관리,O:주문관리,S:실적관리)");
			str=scan.nextLine();
		}
		scan.close();
		System.out.println("프로그램 종료");				
	}

}

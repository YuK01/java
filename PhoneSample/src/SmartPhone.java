
public class SmartPhone extends Phone { // 추상클래스의 자식클래스

	public SmartPhone(String owner) {
		super(owner);
	}

	public void InternetSearch() {
		System.out.println("인터넷 검색을 합니다.");
		super.Serch();
	}
	
	// 오버라이딩
//	@Override
//	public void turnOn() {
//		System.out.println("스마트폰 전원을 켭니다.");
//	}
//	@Override
//	public void turnOff() {
//		System.out.println("스마트폰 전원을 끕니다.");
//	}	

	// 추상 메소드 사용
	public void turnOn() {
		System.out.println("스마트폰 전원을 켭니다.");
	}
	public void turnOff() {
		System.out.println("스마트폰 전원을 끕니다.");
	}
}

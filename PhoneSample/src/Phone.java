
public abstract class Phone {//추상클래스
	public String owner;
	
	public Phone(String owner) {
		this.owner=owner;
	}
	
	// 일반 메소드도 가질 수 있음
	
	public void Serch() {
		System.out.println("검색합니다.");
	}
	
//	public void turnOn() {
//		System.out.println("폰 전원을 켭니다.");
//	}
//	public void turnOff() {
//		System.out.println("폰 전원을 끕니다.");
//	}
	
	public abstract void turnOn(); // 추상 메소드
	public abstract void turnOff();
}

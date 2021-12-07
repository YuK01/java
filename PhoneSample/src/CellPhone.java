
public class CellPhone extends Phone {

	public CellPhone(String owner) {
		super(owner);
	}
	
	public void YoutubeSearch() {
		System.out.println("유튜브 검색을 합니다.");
	}
	
	// 오버라이딩
//	@Override
//	public void turnOn() {
//		System.out.println("셀폰 전원을 켭니다.");
//	}
//	@Override
//	public void turnOff() {
//		System.out.println("셀폰 전원을 끕니다.");
//	}	

	
	// 추상메소드 사용
	public void turnOn() {
		System.out.println("셀폰 전원을 켭니다.");
	}
	public void turnOff() {
		System.out.println("셀폰 전원을 끕니다.");
	}
}	

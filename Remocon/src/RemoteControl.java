
public interface RemoteControl {
	// new 연산자를 사용할  수 없다. (생성자가 없기때문)
	
	// 상수 필드 선언 ( 변수 선언과 같음 / 사실상 변수 )
	int MAX_VOLUME=10;  // 생략되었지만 static임
	int MIN_VOLUME=0;
	
	// 메소드 (추상메소드/디폴트메소드/정적메소드)
	// 추상 메소드
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	// 디폴트 메소드 (일반 클래스의 일반 메소드 형태)
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
		} else {
			System.out.println("무음 해제합니다.");
		}
	}
	
	// 정적 메소드
	static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}
	
}

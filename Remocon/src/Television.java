
public class Television implements RemoteControl {
	// 상속 받은게 아니라, 클래스 안에 인터페이스가 구현되는것.
	// 추상 메소드 사용하지 않으면 에러표시생김.
	
	// 필드 생성
	private int volume;
	
	// 추상 메소드의 실체 메소드
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}
	public void setVolume(int v) {
		if(v>RemoteControl.MAX_VOLUME) {
			// 인터페이스에 선언한 상수는 static이기 때문에 super를 쓰지 않음.
			this.volume=RemoteControl.MAX_VOLUME;
		} else if(v<RemoteControl.MIN_VOLUME) {
			this.volume=RemoteControl.MIN_VOLUME;
		} else {
			this.volume=v;
		}
		System.out.println("현재 TV 볼륨 : "+this.volume);
	}
}

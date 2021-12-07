
public class Audio implements RemoteControl {
	private int volume;
	
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}
	public void turnOff() {
		System.out.println("Audio를 끕니다.");
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
		System.out.println("현재 Audio 볼륨 : "+this.volume);
	}
}

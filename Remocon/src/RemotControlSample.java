
public class RemotControlSample {

	public static void main(String[] args) {
//		Television tv=new Television();  //유형클래스 존재할경우
//		RemoteControl tv=new Television();  // 유형클래스 존재할경우(자동형변환)
		
		// 구현 클래스가 없으면 -> 익명 구현 객체(클래스)
		RemoteControl tv=new RemoteControl() {
			private int volume;

			public void turnOn() {
				System.out.println("TV를 켭니다.");
			}
			public void turnOff() {
				System.out.println("TV를 끕니다.");
			}
			public void setVolume(int v) {
				if(v>RemoteControl.MAX_VOLUME) {
					this.volume=RemoteControl.MAX_VOLUME;
				} else if(v<RemoteControl.MIN_VOLUME) {
					this.volume=RemoteControl.MIN_VOLUME;
				} else {
					this.volume=v;
				}
				System.out.println("현재 TV 볼륨 : "+this.volume);
			}
			@Override
			public void setMute(boolean b) {
				System.out.println("boolean "+b);
			}
		};
		
		tv.turnOn();
		tv.setVolume(7);
		// @Override 안하면 인터페이스에 있는 기본메소드 불러옴
		// 구현클래스에서 오버라이딩하면 구현클래스에 있는 것을 우선으로 함.
		tv.setMute(true);
		tv.turnOff();
		
		Audio audio=new Audio();
//		RemoteControl audio=new Audio();		
		audio.turnOn();
		audio.setVolume(6);
		audio.setMute(true);
		audio.turnOff();
		
		RemoteControl.changeBattery();
		
	}

}

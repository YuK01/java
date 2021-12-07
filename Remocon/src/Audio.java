
public class Audio implements RemoteControl {
	private int volume;
	
	public void turnOn() {
		System.out.println("Audio�� �մϴ�.");
	}
	public void turnOff() {
		System.out.println("Audio�� ���ϴ�.");
	}
	public void setVolume(int v) {
		if(v>RemoteControl.MAX_VOLUME) {
			// �������̽��� ������ ����� static�̱� ������ super�� ���� ����.
			this.volume=RemoteControl.MAX_VOLUME;
		} else if(v<RemoteControl.MIN_VOLUME) {
			this.volume=RemoteControl.MIN_VOLUME;
		} else {
			this.volume=v;
		}
		System.out.println("���� Audio ���� : "+this.volume);
	}
}

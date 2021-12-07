
public class Television implements RemoteControl {
	// ��� ������ �ƴ϶�, Ŭ���� �ȿ� �������̽��� �����Ǵ°�.
	// �߻� �޼ҵ� ������� ������ ����ǥ�û���.
	
	// �ʵ� ����
	private int volume;
	
	// �߻� �޼ҵ��� ��ü �޼ҵ�
	public void turnOn() {
		System.out.println("TV�� �մϴ�.");
	}
	public void turnOff() {
		System.out.println("TV�� ���ϴ�.");
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
		System.out.println("���� TV ���� : "+this.volume);
	}
}


public class RemotControlSample {

	public static void main(String[] args) {
//		Television tv=new Television();  //����Ŭ���� �����Ұ��
//		RemoteControl tv=new Television();  // ����Ŭ���� �����Ұ��(�ڵ�����ȯ)
		
		// ���� Ŭ������ ������ -> �͸� ���� ��ü(Ŭ����)
		RemoteControl tv=new RemoteControl() {
			private int volume;

			public void turnOn() {
				System.out.println("TV�� �մϴ�.");
			}
			public void turnOff() {
				System.out.println("TV�� ���ϴ�.");
			}
			public void setVolume(int v) {
				if(v>RemoteControl.MAX_VOLUME) {
					this.volume=RemoteControl.MAX_VOLUME;
				} else if(v<RemoteControl.MIN_VOLUME) {
					this.volume=RemoteControl.MIN_VOLUME;
				} else {
					this.volume=v;
				}
				System.out.println("���� TV ���� : "+this.volume);
			}
			@Override
			public void setMute(boolean b) {
				System.out.println("boolean "+b);
			}
		};
		
		tv.turnOn();
		tv.setVolume(7);
		// @Override ���ϸ� �������̽��� �ִ� �⺻�޼ҵ� �ҷ���
		// ����Ŭ�������� �������̵��ϸ� ����Ŭ������ �ִ� ���� �켱���� ��.
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

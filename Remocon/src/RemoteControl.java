
public interface RemoteControl {
	// new �����ڸ� �����  �� ����. (�����ڰ� ���⶧��)
	
	// ��� �ʵ� ���� ( ���� ����� ���� / ��ǻ� ���� )
	int MAX_VOLUME=10;  // �����Ǿ����� static��
	int MIN_VOLUME=0;
	
	// �޼ҵ� (�߻�޼ҵ�/����Ʈ�޼ҵ�/�����޼ҵ�)
	// �߻� �޼ҵ�
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	// ����Ʈ �޼ҵ� (�Ϲ� Ŭ������ �Ϲ� �޼ҵ� ����)
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("���� ó���մϴ�.");
		} else {
			System.out.println("���� �����մϴ�.");
		}
	}
	
	// ���� �޼ҵ�
	static void changeBattery() {
		System.out.println("�������� ��ȯ�մϴ�.");
	}
	
}

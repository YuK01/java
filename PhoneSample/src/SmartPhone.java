
public class SmartPhone extends Phone { // �߻�Ŭ������ �ڽ�Ŭ����

	public SmartPhone(String owner) {
		super(owner);
	}

	public void InternetSearch() {
		System.out.println("���ͳ� �˻��� �մϴ�.");
		super.Serch();
	}
	
	// �������̵�
//	@Override
//	public void turnOn() {
//		System.out.println("����Ʈ�� ������ �մϴ�.");
//	}
//	@Override
//	public void turnOff() {
//		System.out.println("����Ʈ�� ������ ���ϴ�.");
//	}	

	// �߻� �޼ҵ� ���
	public void turnOn() {
		System.out.println("����Ʈ�� ������ �մϴ�.");
	}
	public void turnOff() {
		System.out.println("����Ʈ�� ������ ���ϴ�.");
	}
}

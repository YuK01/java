
public abstract class Phone {//�߻�Ŭ����
	public String owner;
	
	public Phone(String owner) {
		this.owner=owner;
	}
	
	// �Ϲ� �޼ҵ嵵 ���� �� ����
	
	public void Serch() {
		System.out.println("�˻��մϴ�.");
	}
	
//	public void turnOn() {
//		System.out.println("�� ������ �մϴ�.");
//	}
//	public void turnOff() {
//		System.out.println("�� ������ ���ϴ�.");
//	}
	
	public abstract void turnOn(); // �߻� �޼ҵ�
	public abstract void turnOff();
}

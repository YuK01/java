
public class CellPhone extends Phone {

	public CellPhone(String owner) {
		super(owner);
	}
	
	public void YoutubeSearch() {
		System.out.println("��Ʃ�� �˻��� �մϴ�.");
	}
	
	// �������̵�
//	@Override
//	public void turnOn() {
//		System.out.println("���� ������ �մϴ�.");
//	}
//	@Override
//	public void turnOff() {
//		System.out.println("���� ������ ���ϴ�.");
//	}	

	
	// �߻�޼ҵ� ���
	public void turnOn() {
		System.out.println("���� ������ �մϴ�.");
	}
	public void turnOff() {
		System.out.println("���� ������ ���ϴ�.");
	}
}	

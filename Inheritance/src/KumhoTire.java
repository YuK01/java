
public class KumhoTire extends Tire {

	public KumhoTire(int maxRotation, String location) {
		super(maxRotation, location);
	}
	
	@Override
	public boolean roll() {
		++pastRotation;
		if(pastRotation<maxRotation) { // �ִ�ȸ�������� �� �޷�����
			System.out.println("��ȣŸ�̾� ��������: "+(this.maxRotation-this.pastRotation)+"ȸ");
			return true;  
		} else { // �ִ�ȸ�������� �� �޷�����
			System.out.println(this.location+" ��ȣŸ�̾���ũ");
			return false; 
		}
	}
}


public class HankookTire extends Tire {

	public HankookTire(int maxRotation, String location) {
		super(maxRotation, location);
	}
	
	@Override
	public boolean roll() {// �ִ�ȸ�������� �� �޷�����
		++pastRotation;
		if(pastRotation<maxRotation) {
			System.out.println("�ѱ�Ÿ�̾� ��������: "+(this.maxRotation-this.pastRotation)+"ȸ");
			return true;  
		} else {// �ִ�ȸ�������� �� �޷�����
			System.out.println(this.location+" �ѱ�Ÿ�̾���ũ");
			return false; 
		}
	}
}

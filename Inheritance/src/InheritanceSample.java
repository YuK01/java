
public class InheritanceSample {

	public static void main(String[] args) {
		Car car=new Car();
		
		for(int i=0; i<5; i++) {
			int punk=car.run();
			
			switch(punk) {
			case 1:
				System.out.println("�� ���� �ѱ�Ÿ�̾�� ��ü");
				 // �ڵ�����ȯ (�ڽ�->�θ�Ŭ����)
				car.tires[punk-1]=new HankookTire(15,"�� ����");
//				car.frontLeftTire=new HankookTire(15,"�� ����");
				break;
			case 2:
				System.out.println("�� ������ ��ȣŸ�̾�� ��ü");
				car.tires[punk-1]=new KumhoTire(13,"�� ������");
//				car.frontRightTire=new HankookTire(15,"�� ����");
				break;
			case 3:
				System.out.println("�� ���� �ѱ�Ÿ�̾�� ��ü");
				car.tires[punk-1]=new HankookTire(14,"�� ����");
//				car.backLeftTire=new HankookTire(15,"�� ����");
				break;
			case 4:
				System.out.println("�� ������ ��ȣŸ�̾�� ��ü");
				car.tires[punk-1]=new KumhoTire(17,"�� ������");
//				car.backRightTire=new HankookTire(15,"�� ����");
				break;
			}
			System.out.println("---------------------------------------");
		}
	}

}

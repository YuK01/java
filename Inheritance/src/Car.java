
public class Car {
//	Tire frontLeftTire;
//	Tire frontRightTire;
//	Tire backLeftTire;
//	Tire backRightTire;
	Tire[] tires;
//	Tire[] tires= {
//			new Tire(6,"�� ����"),
//			new Tire(2,"�� ������"),
//			new Tire(3,"�� ����"),
//			new Tire(4,"�� ������")
//	};
	
	public Car() {
		tires= new Tire[]{
				new Tire(6,"�� ����"),
				new Tire(2,"�� ������"),
				new Tire(3,"�� ����"),
				new Tire(4,"�� ������")
		};
//		frontLeftTire=new Tire(6,"�տ���");
//		frontRightTire=new Tire(2,"�տ�����");
//		backLeftTire=new Tire(3,"�ڿ���");
//		backRightTire=new Tire(4,"�ڿ�����");
	}
	
	
	
	void stop() {
		System.out.println("�ڵ����� ����ϴ�.");
	}
	int run() {
		System.out.println("�ڵ����� �޸��ϴ�.");
		
//		if(!tires[0].roll()) {stop(); return 1;}  // Ÿ�̾��ȣ return
//		if(!tires[1].roll()) {stop(); return 2;}
//		if(!tires[2].roll()) {stop(); return 3;}
//		if(!tires[3].roll()) {stop(); return 4;}
		for(int i=0; i<tires.length; i++) {
			if(!tires[i].roll()) {stop(); return i+1;}
		}
		return 0;
	}
}

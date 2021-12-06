
public class InheritanceSample {

	public static void main(String[] args) {
		Car car=new Car();
		
		for(int i=0; i<5; i++) {
			int punk=car.run();
			
			switch(punk) {
			case 1:
				System.out.println("앞 왼쪽 한국타이어로 교체");
				 // 자동형변환 (자식->부모클래스)
				car.tires[punk-1]=new HankookTire(15,"앞 왼쪽");
//				car.frontLeftTire=new HankookTire(15,"앞 왼쪽");
				break;
			case 2:
				System.out.println("앞 오른쪽 금호타이어로 교체");
				car.tires[punk-1]=new KumhoTire(13,"앞 오른쪽");
//				car.frontRightTire=new HankookTire(15,"앞 왼쪽");
				break;
			case 3:
				System.out.println("뒤 왼쪽 한국타이어로 교체");
				car.tires[punk-1]=new HankookTire(14,"뒤 왼쪽");
//				car.backLeftTire=new HankookTire(15,"앞 왼쪽");
				break;
			case 4:
				System.out.println("뒤 오른쪽 금호타이어로 교체");
				car.tires[punk-1]=new KumhoTire(17,"뒤 오른쪽");
//				car.backRightTire=new HankookTire(15,"앞 왼쪽");
				break;
			}
			System.out.println("---------------------------------------");
		}
	}

}

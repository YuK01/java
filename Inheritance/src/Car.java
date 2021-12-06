
public class Car {
//	Tire frontLeftTire;
//	Tire frontRightTire;
//	Tire backLeftTire;
//	Tire backRightTire;
	Tire[] tires;
//	Tire[] tires= {
//			new Tire(6,"앞 왼쪽"),
//			new Tire(2,"앞 오른쪽"),
//			new Tire(3,"뒤 왼쪽"),
//			new Tire(4,"뒤 오른쪽")
//	};
	
	public Car() {
		tires= new Tire[]{
				new Tire(6,"앞 왼쪽"),
				new Tire(2,"앞 오른쪽"),
				new Tire(3,"뒤 왼쪽"),
				new Tire(4,"뒤 오른쪽")
		};
//		frontLeftTire=new Tire(6,"앞왼쪽");
//		frontRightTire=new Tire(2,"앞오른쪽");
//		backLeftTire=new Tire(3,"뒤왼쪽");
//		backRightTire=new Tire(4,"뒤오른쪽");
	}
	
	
	
	void stop() {
		System.out.println("자동차가 멈춥니다.");
	}
	int run() {
		System.out.println("자동차가 달립니다.");
		
//		if(!tires[0].roll()) {stop(); return 1;}  // 타이어번호 return
//		if(!tires[1].roll()) {stop(); return 2;}
//		if(!tires[2].roll()) {stop(); return 3;}
//		if(!tires[3].roll()) {stop(); return 4;}
		for(int i=0; i<tires.length; i++) {
			if(!tires[i].roll()) {stop(); return i+1;}
		}
		return 0;
	}
}

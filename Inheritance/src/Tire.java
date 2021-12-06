
public class Tire {
	int maxRotation;  //최대회전횟수
	int pastRotation;  // 누적회전횟수
	String location;   // 타이어 위치
	
	
	public Tire() {}

	public Tire(int maxRotation, String location) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	
	boolean roll() { //boolean은 논리연산
		++pastRotation;
		if(pastRotation<maxRotation) {
			System.out.println("Tire 남은수명: "+(this.maxRotation-this.pastRotation)+"회");
			return true;  // 최대회전수보다 덜 달렸으면
		} else {
			System.out.println(this.location+" 타이어펑크");
			return false; // 최대회전수보다 더 달렸으면
		}
	}
}

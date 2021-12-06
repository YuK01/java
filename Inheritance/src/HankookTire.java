
public class HankookTire extends Tire {

	public HankookTire(int maxRotation, String location) {
		super(maxRotation, location);
	}
	
	@Override
	public boolean roll() {// 최대회전수보다 덜 달렸으면
		++pastRotation;
		if(pastRotation<maxRotation) {
			System.out.println("한국타이어 남은수명: "+(this.maxRotation-this.pastRotation)+"회");
			return true;  
		} else {// 최대회전수보다 더 달렸으면
			System.out.println(this.location+" 한국타이어펑크");
			return false; 
		}
	}
}

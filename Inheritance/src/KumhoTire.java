
public class KumhoTire extends Tire {

	public KumhoTire(int maxRotation, String location) {
		super(maxRotation, location);
	}
	
	@Override
	public boolean roll() {
		++pastRotation;
		if(pastRotation<maxRotation) { // 최대회전수보다 덜 달렸으면
			System.out.println("금호타이어 남은수명: "+(this.maxRotation-this.pastRotation)+"회");
			return true;  
		} else { // 최대회전수보다 더 달렸으면
			System.out.println(this.location+" 금호타이어펑크");
			return false; 
		}
	}
}

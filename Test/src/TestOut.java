
public class TestOut { // 외부에서 제한없이 사용가능한 클래스
	// private 선언한 클래스 밖에서는 접근할 수 없다.(write/read 불가)
	// private를 쓰면 TestOut클래스 밖에서 보이지 않음.
//	private int n;
//	int x; // 아무것도 안쓰면 default int x;
//	public int y; // 외부에서 제한없이 사용 가능
//	private String str;
//	private float realnumber;
	// private 필드(변수)에 접근하는 방법 : 메소드를 통해서 접근가능. 
//	void setN(int x) { // write
//		this.n=x;   // 이렇게 메소드를 만들어서 외부에서 private 접근가능하게함.
//	}
//	int getN() { // read
//		return this.n;  // 이렇게 메소드를 만들어서 외부에서 private 접근가능하게함.
//	}
//	public String getStr() {
//		return str;
//	}
//	public void setStr(String str) {
//		this.str = str;
//	}
//	public float getRealnumber() {
//		return realnumber;
//	}
//	public void setRealnumber(float realnumber) {
//		this.realnumber = realnumber;
//	}
//	TestOut(){
//		this.n=0;  // 같은 클래스라서 여기서는 private로 선언한 필드 사용이 가능하다.
//	}
	
}

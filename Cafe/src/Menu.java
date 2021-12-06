import java.io.BufferedReader; // JDK 안에 있는 클래스
import java.io.File;		// java(패키지)\\io(패키지)\\File.class
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;  

public class Menu {
	private ArrayList<String> alMenu;
	private ArrayList<Integer> alPrice;
		
	public Menu(){ 
		this.alMenu=new ArrayList<String>();
		this.alPrice=new ArrayList<Integer>();
		
		File f=new File("D:\\k20211022\\temp\\menu.txt"); // 데이터 파일에 넣어서 불러오는 방법
		try { // 파일을 제대로 읽는지 중간정검하기위함.
			FileReader fr=new FileReader(f); //이건 지역변수라 접근제한 쓸 필요 없음.
			BufferedReader br=new BufferedReader(fr);
			try {
				String line=br.readLine(); // 파일 데이터를 한 줄 읽어서 line에 넣음
				while(line!=null) {
					String[] ar=line.split(","); // line 데이터에서 , 을 기준으로 잘라서 ar배열에 넣음
					this.alMenu.add(ar[0]);
					this.alPrice.add(Integer.parseInt(ar[1]));
					line=br.readLine(); //한줄씩 읽기
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getAlMenu(int ndx) {
		return this.alMenu.get(ndx);
	}
	public int getAlPrice(int ndx) {
		return this.alPrice.get(ndx);
	}
	
	public void display() {  //R(Read)
		for(int i=0; i<this.alMenu.size(); i++) {
			System.out.println((i+1)+"."+this.alMenu.get(i)+","+this.alPrice.get(i));
		}
	}
	private void guide() { //추가기능
		System.out.println("메뉴관리 (X:종료,C:메뉴추가,U:메뉴수정,D:메뉴삭제)");		
	}
	private void add(String menu,int price) {// Create
		this.alMenu.add(menu);
		this.alPrice.add(price);
		this.saveMenu();// 파일에 쓰기 < 반복되니 메소드를 만들어서 호출하기		
	}
	private void update(int menu_num,String menu,int price) { // R(Remove)
		this.alMenu.set(menu_num-1, menu); // .set(index number, 값);
		this.alPrice.set(menu_num-1, price);
		this.saveMenu();//파일에 쓰기
	}
	private void remove(int menu_num) { //Delete
		this.alMenu.remove(menu_num-1);  // .remove(index number);
		this.alPrice.remove(menu_num-1);
		this.saveMenu();// 파일에 쓰기
	}
	private void saveMenu() {// 변경된 내용을 파일에 쓰기
		File f=new File("D:\\k20211022\\temp\\menu.txt");
		try {
			FileWriter fw=new FileWriter(f);
			PrintWriter pw=new PrintWriter(fw);
			for(int i=0; i<this.alMenu.size(); i++) {
				pw.print(this.alMenu.get(i)+","+this.alPrice.get(i)+"\n");
				// \n  줄바꿈 
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	public void Handling() {
		Scanner scan=new Scanner(System.in); // 이거 안 쓰고 다른 곳에 쓰인걸 가져오면 무거움.
		Scanner menu1=new Scanner(System.in);  // 문자열만 받기
		this.display();
		this.guide();
		String str=scan.nextLine();  //이게 없으면 while문을 헛바퀴 한 번 돈다.
		while(!str.equals("X")) {
			if(str.equals("C")) {
				System.out.println("메뉴추가");
				System.out.println("메뉴명을 입력하세요.");
				String menu_name=menu1.nextLine();
				System.out.println("가격을 입력하세요.");
				int price=Integer.parseInt(menu1.nextLine());
				this.add(menu_name, price);
			} else if(str.equals("U")) {
				System.out.println("메뉴수정");
				System.out.println("수정(변경)할 메뉴번호를 입력하세요.");
				int menu_num=Integer.parseInt(menu1.nextLine());
				System.out.println("새 메뉴명을 입력하세요.");
				String menu_name=menu1.nextLine();
				System.out.println("새 가격을 입력하세요.");
				int price=Integer.parseInt(menu1.nextLine());
				this.update(menu_num, menu_name, price);
			} else if(str.equals("D")) {
				System.out.println("메뉴삭제");
				System.out.println("삭제할 메뉴 번호를 입력하세요.");
				int menu_num=Integer.parseInt(menu1.nextLine());
				this.remove(menu_num);
			}
			this.display();
			this.guide();
			str=scan.nextLine();
		}
	}
}

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
	private ArrayList<String> alMobile;
	private ArrayList<String> alMenu;
	private ArrayList<Integer> alQty;
	private ArrayList<Integer> alSum;
//	private int total;
	
	public Order(){
		this.alMobile=new ArrayList<String>();
		this.alMenu=new ArrayList<String>();
		this.alQty=new ArrayList<Integer>();
		this.alSum=new ArrayList<Integer>();
//		this.total=0;
	}
	
	private void add(String menu,int qty,int sum) {
		this.alMenu.add(menu);
		this.alQty.add(qty);
		this.alSum.add(sum);
	}
	
	private void remove(int num) {
		num--;
		this.alMobile.remove(num);
		this.alMenu.remove(num);
		this.alQty.remove(num);
		this.alSum.remove(num);
	}
	
	private void update(int num,String mobile,String menu,int qty,int price) {
		num--;
		this.alMobile.set(num,mobile);			
		this.alMenu.set(num, menu);
		this.alQty.set(num, qty);
		this.alSum.set(num, qty*price);
	}
	
	public void display() {
		for(int i=0; i<this.alMenu.size(); i++) {
			System.out.println(this.alMobile.get(i)+","+this.alMenu.get(i)+","+this.alQty.get(i)+","+this.alSum.get(i));			
//			this.total+=this.alSum.get(i);
		}
//		System.out.println("�� �Ǹž�: "+this.total);
	}
	public void Handling(Menu menu) {//�Ű������� Ŭ���� ���� ����
		Scanner scan=new Scanner(System.in);
		
		int menuNum=this.getInput(menu); //�޴�ǥ��, �޴���ȣ ����
		while(menuNum!=0) {
			System.out.println("�޴��� ������ �Է��ϼ���.");
			int qty=Integer.parseInt(scan.nextLine());
			menuNum--;
			this.add(menu.getAlMenu(menuNum), qty, menu.getAlPrice(menuNum)*qty);
			this.showOrder();
			
			menuNum=this.getInput(menu); //�޴�ǥ��, �޴���ȣ ����
		}
		int start_ndx=this.addMobile();
		int sum=0;
		for(int i=start_ndx; i<this.alMenu.size(); i++) {
			System.out.println((i+1)+"."+this.alMobile.get(i)+","+this.alMenu.get(i)+","+this.alQty.get(i)+","+this.alSum.get(i));			
			sum+=this.alSum.get(i);
		}
		System.out.println("���ֹ��ݾ�:"+sum);
		System.out.println("-----------------------");
	}
	void showOrder() {
		int n=this.alMenu.size()-1;
		System.out.println(this.alMenu.get(n)+" x"+this.alQty.get(n)+", "+this.alSum.get(n));
	}
	int getInput(Menu m) {
		Scanner s_input=new Scanner(System.in);
		m.display();
		System.out.println("�ֹ��� �޴���ȣ�� �Է��ϼ���. (0:�ֹ�����)");
		return Integer.parseInt(s_input.nextLine());
	}
	int addMobile() {
		Scanner s_mobile=new Scanner(System.in);
		System.out.println("����� ��ȣ�� �Է��ϼ���.");
		String mobile=s_mobile.nextLine();
		if(mobile.equals("")) mobile="-";
		int start_ndx=this.alMobile.size();
		for(int i=this.alMobile.size(); i<this.alMenu.size(); i++) {
			this.alMobile.add(mobile);
		}
		return start_ndx;
	}
}

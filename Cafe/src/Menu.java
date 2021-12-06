import java.io.BufferedReader; // JDK �ȿ� �ִ� Ŭ����
import java.io.File;		// java(��Ű��)\\io(��Ű��)\\File.class
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
		
		File f=new File("D:\\k20211022\\temp\\menu.txt"); // ������ ���Ͽ� �־ �ҷ����� ���
		try { // ������ ����� �д��� �߰������ϱ�����.
			FileReader fr=new FileReader(f); //�̰� ���������� �������� �� �ʿ� ����.
			BufferedReader br=new BufferedReader(fr);
			try {
				String line=br.readLine(); // ���� �����͸� �� �� �о line�� ����
				while(line!=null) {
					String[] ar=line.split(","); // line �����Ϳ��� , �� �������� �߶� ar�迭�� ����
					this.alMenu.add(ar[0]);
					this.alPrice.add(Integer.parseInt(ar[1]));
					line=br.readLine(); //���پ� �б�
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
	private void guide() { //�߰����
		System.out.println("�޴����� (X:����,C:�޴��߰�,U:�޴�����,D:�޴�����)");		
	}
	private void add(String menu,int price) {// Create
		this.alMenu.add(menu);
		this.alPrice.add(price);
		this.saveMenu();// ���Ͽ� ���� < �ݺ��Ǵ� �޼ҵ带 ���� ȣ���ϱ�		
	}
	private void update(int menu_num,String menu,int price) { // R(Remove)
		this.alMenu.set(menu_num-1, menu); // .set(index number, ��);
		this.alPrice.set(menu_num-1, price);
		this.saveMenu();//���Ͽ� ����
	}
	private void remove(int menu_num) { //Delete
		this.alMenu.remove(menu_num-1);  // .remove(index number);
		this.alPrice.remove(menu_num-1);
		this.saveMenu();// ���Ͽ� ����
	}
	private void saveMenu() {// ����� ������ ���Ͽ� ����
		File f=new File("D:\\k20211022\\temp\\menu.txt");
		try {
			FileWriter fw=new FileWriter(f);
			PrintWriter pw=new PrintWriter(fw);
			for(int i=0; i<this.alMenu.size(); i++) {
				pw.print(this.alMenu.get(i)+","+this.alPrice.get(i)+"\n");
				// \n  �ٹٲ� 
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	public void Handling() {
		Scanner scan=new Scanner(System.in); // �̰� �� ���� �ٸ� ���� ���ΰ� �������� ���ſ�.
		Scanner menu1=new Scanner(System.in);  // ���ڿ��� �ޱ�
		this.display();
		this.guide();
		String str=scan.nextLine();  //�̰� ������ while���� ����� �� �� ����.
		while(!str.equals("X")) {
			if(str.equals("C")) {
				System.out.println("�޴��߰�");
				System.out.println("�޴����� �Է��ϼ���.");
				String menu_name=menu1.nextLine();
				System.out.println("������ �Է��ϼ���.");
				int price=Integer.parseInt(menu1.nextLine());
				this.add(menu_name, price);
			} else if(str.equals("U")) {
				System.out.println("�޴�����");
				System.out.println("����(����)�� �޴���ȣ�� �Է��ϼ���.");
				int menu_num=Integer.parseInt(menu1.nextLine());
				System.out.println("�� �޴����� �Է��ϼ���.");
				String menu_name=menu1.nextLine();
				System.out.println("�� ������ �Է��ϼ���.");
				int price=Integer.parseInt(menu1.nextLine());
				this.update(menu_num, menu_name, price);
			} else if(str.equals("D")) {
				System.out.println("�޴�����");
				System.out.println("������ �޴� ��ȣ�� �Է��ϼ���.");
				int menu_num=Integer.parseInt(menu1.nextLine());
				this.remove(menu_num);
			}
			this.display();
			this.guide();
			str=scan.nextLine();
		}
	}
}

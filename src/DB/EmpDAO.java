package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.util.Scanner;

public class EmpDAO {
	private static Scanner sc = new Scanner(System.in);
	/**
	 * emp���̺��� ����� ��� �̸� �˻�
	 * select ename from emp
	 */
	
	public static void selectAllEname() {
		
		Connection con= null;
		Statement st=null;
		ResultSet rs= null;
		
		try {
			
		con = DBUtil.getConnection();
		st = con.createStatement();
	
		//rs = st.executeQuery("insert into ����� values(3,'test','test',18,'21.08.26',1,2)");
		rs = st.executeQuery("select �����_������ȣ,���̵�,��й�ȣ,����,ȸ����������,�±׹�ȣ,�帣��ȣ from �����");
		while(rs.next()) {
			String ename = String.format("%10s", rs.getString("�����_������ȣ")) ;
			String empno = String.format("%10s", rs.getString("���̵�")) ;
			String job = String.format("%10s", rs.getString("��й�ȣ")) ;
			String hiredate = String.format("%10s", rs.getString("����")) ;
			String sal = String.format("%10s", rs.getString("ȸ����������")) ;
			String teg = String.format("%10s", rs.getString("�±׹�ȣ")) ;
			String jnum = String.format("%10s", rs.getString("�帣��ȣ")) ;
		
		System.out.println(empno+" | "+ename+" | "+job+" | "+sal+" | "+hiredate+" | "+teg+" | "+jnum);
	}	
		System.out.println("****�Ϸ�****");
		
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			DBUtil.dbClose(con, st, rs);
			
		}
		}
	
	
public static void empInsert() {
	
		
		Connection con= null;
		Statement st=null;
		ResultSet rs= null;
		
		try {
			
				System.out.println("����� ��ȣ�� �Է����ּ���");
				 int empno = Integer.parseInt(sc.nextLine());
				 System.out.println("���̵� �Է����ּ���");
				 String enames = sc.nextLine();
				 System.out.println("��й�ȣ�� �Է����ּ���");
				String job = sc.nextLine();
				System.out.println("���̸� �Է����ּ���");
				int sal = Integer.parseInt(sc.nextLine());
				System.out.println("ȸ���������ڸ� �Է����ּ���");
				String hiredate = sc.nextLine();
				System.out.println("�±׹�ȣ�� �Է����ּ���");
				int teg =  Integer.parseInt(sc.nextLine());
				System.out.println("�帣��ȣ�� �Է����ּ���");
				int jnum  = Integer.parseInt(sc.nextLine());
				
		
			
		con = DBUtil.getConnection();
		st = con.createStatement();
		rs = st.executeQuery("insert into ����� values("+empno+",'"+enames+"','"+job+"',"+sal+",'"+hiredate+"',"+teg+","+jnum+")");
		

		System.out.println("****���ڵ� ���� �Ϸ�****");
		
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			DBUtil.dbClose(con, st, rs);
			
		}
		}

	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		 while(true){

	           System.out.println("---------------------------------------------------------------");
	           System.out.println("1.���ڵ� Ȯ��  2.���ڵ� ����   3. �ߺ�üũ   4.���ڵ� �˻�   5.���ڵ� ����   6.������� ����   9.����   ");
			   System.out.println("---------------------------------------------------------------");

			   System.out.print("�޴� ���� > ");
			    int menuChoice = Integer.parseInt(sc.nextLine());
				switch(menuChoice){
	                case 1 : 
						 //���ڵ� Ȯ��
	                	EmpDAO.selectAllEname();
					 break;
	                case 2 : 
						 //���ڵ� ����
	                	EmpDAO.empInsert();
					 break;
	                case 3 : 
						 //�ߺ�üũ
					    
					 break;
	                case 4 : 
						 //���ڵ� �˻�
					     
					 break;
					 case 5 : 
						 //���ڵ� ����
					     
					 break;
					 case 6 : 
						 //������� ����
					     
					 break;
					 case 9 : 
						 System.out.println("���α׷� ����˴ϴ�.^^");
						 System.exit(0);
					 break;
					 default: 
						 System.out.println("�޴��� (1~6) �Ǵ� 9 �� �Է��ϼ���.");

				}

		   }
		
		
	}

}

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
	 * emp테이블의 사원의 모든 이름 검색
	 * select ename from emp
	 */
	
	public static void selectAllEname() {
		
		Connection con= null;
		Statement st=null;
		ResultSet rs= null;
		
		try {
			
		con = DBUtil.getConnection();
		st = con.createStatement();
	
		//rs = st.executeQuery("insert into 사용자 values(3,'test','test',18,'21.08.26',1,2)");
		rs = st.executeQuery("select 사용자_고유번호,아이디,비밀번호,나이,회원가입일자,태그번호,장르번호 from 사용자");
		while(rs.next()) {
			String ename = String.format("%10s", rs.getString("사용자_고유번호")) ;
			String empno = String.format("%10s", rs.getString("아이디")) ;
			String job = String.format("%10s", rs.getString("비밀번호")) ;
			String hiredate = String.format("%10s", rs.getString("나이")) ;
			String sal = String.format("%10s", rs.getString("회원가입일자")) ;
			String teg = String.format("%10s", rs.getString("태그번호")) ;
			String jnum = String.format("%10s", rs.getString("장르번호")) ;
		
		System.out.println(empno+" | "+ename+" | "+job+" | "+sal+" | "+hiredate+" | "+teg+" | "+jnum);
	}	
		System.out.println("****완료****");
		
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
			
				System.out.println("사용자 번호를 입력해주세요");
				 int empno = Integer.parseInt(sc.nextLine());
				 System.out.println("아이디를 입력해주세요");
				 String enames = sc.nextLine();
				 System.out.println("비밀번호를 입력해주세요");
				String job = sc.nextLine();
				System.out.println("나이를 입력해주세요");
				int sal = Integer.parseInt(sc.nextLine());
				System.out.println("회원가입일자를 입력해주세요");
				String hiredate = sc.nextLine();
				System.out.println("태그번호를 입력해주세요");
				int teg =  Integer.parseInt(sc.nextLine());
				System.out.println("장르번호를 입력해주세요");
				int jnum  = Integer.parseInt(sc.nextLine());
				
		
			
		con = DBUtil.getConnection();
		st = con.createStatement();
		rs = st.executeQuery("insert into 사용자 values("+empno+",'"+enames+"','"+job+"',"+sal+",'"+hiredate+"',"+teg+","+jnum+")");
		

		System.out.println("****레코드 삽입 완료****");
		
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
	           System.out.println("1.레코드 확인  2.레코드 삽입   3. 중복체크   4.레코드 검색   5.레코드 삭제   6.사원정보 수정   9.종료   ");
			   System.out.println("---------------------------------------------------------------");

			   System.out.print("메뉴 선택 > ");
			    int menuChoice = Integer.parseInt(sc.nextLine());
				switch(menuChoice){
	                case 1 : 
						 //레코드 확인
	                	EmpDAO.selectAllEname();
					 break;
	                case 2 : 
						 //레코드 삽입
	                	EmpDAO.empInsert();
					 break;
	                case 3 : 
						 //중복체크
					    
					 break;
	                case 4 : 
						 //레코드 검색
					     
					 break;
					 case 5 : 
						 //레코드 삭제
					     
					 break;
					 case 6 : 
						 //사원정보 수정
					     
					 break;
					 case 9 : 
						 System.out.println("프로그램 종료됩니다.^^");
						 System.exit(0);
					 break;
					 default: 
						 System.out.println("메뉴는 (1~6) 또는 9 를 입력하세요.");

				}

		   }
		
		
	}

}

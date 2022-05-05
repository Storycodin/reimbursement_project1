package test;


import java.sql.Date;
import java.time.LocalDate;

import services.ReimbursService;

@SuppressWarnings("unused")
public class Test {

	public static void main(String[] args) {
		
		ReimbursService reimSer = new ReimbursService();
		
//		reimbursId=0, amount=125, submitted=null, resulved=null, description=test, receipt=false, authorId=0, resolver=0, statusId=0, typeId=0, author=null, status=null, type=null
		
		Date sumDate = Date.valueOf(LocalDate.now());
		
		System.out.println(reimSer.addReimburs(125, sumDate, null, "test", false, 3, 1, 4));
//		System.out.println(reimSer.getReimburs(5));
		System.out.println("test");
		
		
	}		
}

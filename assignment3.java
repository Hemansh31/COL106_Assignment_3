import java.io.*;
public class assignment3{
	public static void main(String[] args) throws Exception {
		int hash_table_size=Integer.parseInt(args[0]);
		String hashapproach=args[1];
		hashapproach.trim();
		File testfile= new File(args[2]);
		BufferedReader br=new BufferedReader(new FileReader(testfile));
		String st;
		if(hashapproach.equals("DH")){
			dhtable<Tupple<String>,student> hashtable=new dhtable<Tupple<String>,student>(hash_table_size);
			while ((st = br.readLine()) != null){ 
   			 st.trim();
   			 String[] splitline=st.split(" ");
   			 switch(splitline[0]){
   			 	case "insert":
   			 		Tupple<String> insertkey=new Tupple<String>(splitline[1],splitline[2]);
   			 		student insertthis=new student(splitline[1],splitline[2],splitline[3],splitline[4],splitline[5]);
   			 		int printthis=hashtable.insert(insertkey,insertthis);
   			 		if(printthis==-1){
   			 			System.out.println("E");
   			 		}
   			 		else{
   			 			System.out.println(printthis);
   			 		}
   			 		break;
   			 	case "update":
   			 		Tupple<String> checkkey=new Tupple<String>(splitline[1],splitline[2]);
   			 		student updatethis=new student(splitline[1],splitline[2],splitline[3],splitline[4],splitline[5]);
   			 		int checkthis=hashtable.update(checkkey,updatethis);
   			 		if(checkthis==-1){
   			 			System.out.println("E");
   			 		}
   			 		else{
   			 			System.out.println(checkthis);
   			 		}
   			 		break;
   			 	case "delete":
   			 		Tupple<String> deletekey=new Tupple<String>(splitline[1],splitline[2]);
   			 		int deletethis=hashtable.delete(deletekey);
   			 		if(deletethis==-1){
   			 			System.out.println("E");
   			 		}
   			 		else{
   			 			System.out.println(deletethis);
   			 		}
   			 		break;
   			 	case "contains":
   			 		Tupple<String> checkkey1=new Tupple<String>(splitline[1],splitline[2]);
   			 		boolean checkpresence=hashtable.contains(checkkey1);
   			 		if(checkpresence){
   			 			System.out.println("T");
   			 		}
   			 		else{
   			 			System.out.println("F");
   			 		}
   			 		break;
   			 	case "get":
   			 		Tupple<String> getkey=new Tupple<String>(splitline[1],splitline[2]);
   			 		try{
   			 			student printdetails=hashtable.get(getkey);
   			 			System.out.println(printdetails.fname()+" "+printdetails.lname()+" "+printdetails.hostel()+" "+printdetails.department()+" "+printdetails.cgpa());
   			 		}
   			 		catch(NotFoundException ex){
   			 			System.out.println("E");
   			 		}
   			 		break;
   			 	case "address":
   			 		Tupple<String> getkey1=new Tupple<String>(splitline[1],splitline[2]);
   			 		try{
   			 			String printthis1=hashtable.address(getkey1);
   			 			System.out.println(printthis1);
   			 		}
   			 		catch(NotFoundException ex){
   			 			System.out.println("E");
   			 		}
   			 		break;
   			 }

		 }
		}
		else{
			sctable<Tupple<String>,student> hashtable=new sctable<Tupple<String>,student>(hash_table_size);
			while ((st = br.readLine()) != null){ 
   			 	st.trim();
   			 	String[] splitline=st.split(" ");
   			 	switch(splitline[0]){
   			 		case "insert":
   			 			Tupple<String> insertkey=new Tupple<String>(splitline[1],splitline[2]);
   			 			student insertthis=new student(splitline[1],splitline[2],splitline[3],splitline[4],splitline[5]);
   			 			int printthis=hashtable.insert(insertkey,insertthis);
   			 			if(printthis==-1){
   			 				System.out.println("E");
   			 			}
   			 			else{
   			 				System.out.println(printthis);
   			 			}   			 			
   			 			break;
   			 		case "update":
	   			 		Tupple<String> checkkey=new Tupple<String>(splitline[1],splitline[2]);
	   			 		student updatethis=new student(splitline[1],splitline[2],splitline[3],splitline[4],splitline[5]);
	   			 		int checkthis=hashtable.update(checkkey,updatethis);
	   			 		if(checkthis==-1){
	   			 			System.out.println("E");
	   			 		}
	   			 		else{
	   			 			System.out.println(checkthis);
	   			 		}
   			 			break;
   			 		case "delete":
   			 			Tupple<String> deletekey=new Tupple<String>(splitline[1],splitline[2]);
   			 			int deletethis=hashtable.delete(deletekey);
	   			 		if(deletethis==-1){
	   			 			System.out.println("E");
	   			 		}
	   			 		else{
	   			 			System.out.println(deletethis);
	   			 		}
   			 			break;
   			 		case "contains":
   			 			Tupple<String> checkkey1=new Tupple<String>(splitline[1],splitline[2]);
	   			 		boolean checkpresence=hashtable.contains(checkkey1);
	   			 		if(checkpresence){
	   			 			System.out.println("T");
	   			 		}
	   			 		else{
	   			 			System.out.println("F");
	   			 		}
   			 			break;
   			 		case "get":
	   			 		Tupple<String> getkey=new Tupple<String>(splitline[1],splitline[2]);
	   			 		try{
	   			 			student printdetails=hashtable.get(getkey);
	   			 			System.out.println(printdetails.fname()+" "+printdetails.lname()+" "+printdetails.hostel()+" "+printdetails.department()+" "+printdetails.cgpa());
	   			 		}
	   			 		catch(NotFoundException ex){
	   			 			System.out.println("E");
	   			 		}
   			 			break;
   			 		case "address":
   			 			Tupple<String> getkey1=new Tupple<String>(splitline[1],splitline[2]);
	   			 		try{
	   			 			String printthis1=hashtable.address(getkey1);
	   			 			System.out.println(printthis1);
	   			 		}
	   			 		catch(NotFoundException ex){
	   			 			System.out.println("E");
	   			 		}
   			 			break;
   			 	}
		 }
		}		 
 		
		
	}
}


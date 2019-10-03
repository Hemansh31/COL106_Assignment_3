import java.lang.*;
public class Tupple<U extends Comparable<U>> implements Comparable<Tupple<U>>{
	public U first;
	public U second;
	public Tupple(U obj1, U obj2){
		first=obj1;
		second=obj2;
	}
	@Override
	public String toString(){
		String answer=first.toString()+second.toString();
		return answer;
	}
	@Override
	public boolean equals(Object obj){
		Tupple<U> anotherobject=(Tupple<U>)obj;
		if((first.equals(anotherobject.getfirst()))&&(second.equals(anotherobject.getsecond()))){
			return true;
		}
		else{
			return false;
		}
	}
	public U getfirst(){
		return first;
	}
	public U getsecond(){
		return second;
	}
	@Override
	public int compareTo(Tupple<U> comparewiththis){
		String answer1=first.toString()+second.toString();
		int answer=first.compareTo(comparewiththis.getfirst());
		if(answer==0){
			if(second.compareTo(comparewiththis.getsecond())==0){
				return 0;
			}
			else{
				return 5;
			}
		}
		else{
			return answer;
		}
		
	}
}



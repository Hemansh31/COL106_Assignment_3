import java.lang.*;
public class bstnode<K extends Comparable<K>,T>{
	public K key;
	public T object;
	public bstnode<K,T> right;
	public bstnode<K,T> left;
	public bstnode(K insertkey,T insertobject){
		key=insertkey;
		object=insertobject;
		right=null;
		left=null;
	}
	public K getkey(){
		return key;
	}
	public T getvalue(){
		return object;
	}
}
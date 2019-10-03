public class dhnode<K, T>{
	public K key;
	public T tobject;
	public dhnode(K idknow,T waah){
		key=idknow;
		tobject=waah;
	}
	public void updatenode(T replacewiththis){
		tobject=replacewiththis;
	}
	public K getkey(){
		return key;
	}
	public T getvalue(){
		return tobject;
	}
}


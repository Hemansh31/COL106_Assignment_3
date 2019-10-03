public class sctable<K extends Comparable<K>,T> implements MyHashTable_<K,T>{
	bst<K,T>[] hasharray;
	public sctable(int hashtablesize){
		hasharray=new bst[hashtablesize];
		for(int i=0;i<hashtablesize;i++){
			hasharray[i]=null;
		}
	}
	public int insert(K key, T obj){
		String hashkey=key.toString();
		//System.out.println(hashkey);
		int checkthisindex=(int)hashfuncs.djb2(hashkey,hasharray.length);
		//System.out.println(checkthisindex);
		bstnode<K,T> insertthis=new bstnode<K,T>(key,obj);
		int cntnodes=1;
		if(contains(key)){
			return -1;
		}
		if(hasharray[checkthisindex]==null||hasharray[checkthisindex].roottree==null){
			bst<K,T> newtree=new bst<K,T>(insertthis);
			hasharray[checkthisindex]=newtree;
			cntnodes=1;
		}
		else{
			cntnodes=hasharray[checkthisindex].insert(hasharray[checkthisindex].roottree,insertthis);
		}
		return cntnodes;
	}
	public int update(K key, T obj){
		String hashkey=key.toString();
		//System.out.println(hashkey);
		int checkthisindex=(int)hashfuncs.djb2(hashkey,hasharray.length);
		//System.out.println(hasharray[checkthisindex]);
		bstnode<K,T> updatethis=new bstnode<K,T>(key,obj);
		if(hasharray[checkthisindex]==null){
			//System.out.println("Hey1");
			return -1;
		}
		else{
			//System.out.println("Hey");
			int cntnodes=hasharray[checkthisindex].update(hasharray[checkthisindex].roottree,updatethis);
			return cntnodes;
		}		
	}
	public int delete(K key){
		String hashkey=key.toString();
		int checkthisindex=(int)hashfuncs.djb2(hashkey,hasharray.length);
		if(hasharray[checkthisindex]==null||hasharray[checkthisindex].roottree==null){
			return -1;
		}
		else{
			int cntnodes=hasharray[checkthisindex].delete(hasharray[checkthisindex],key);
			return cntnodes;
		}
		
	}
	public boolean contains(K key){
		String hashkey=key.toString();
		int checkthisindex=(int)hashfuncs.djb2(hashkey,hasharray.length);
		if(hasharray[checkthisindex]!=null){
			boolean answer=hasharray[checkthisindex].contain(hasharray[checkthisindex].roottree,key);
		return answer;
		}
		else{
			return false;
		}
	}
	public String address(K key) throws NotFoundException{
		if(!contains(key)){
			NotFoundException raise=new NotFoundException();
			throw raise;
		}
		else{
			String hashkey=key.toString();
			int checkthisindex=(int)hashfuncs.djb2(hashkey,hasharray.length);
			String answer=checkthisindex+"";
			answer=answer+hasharray[checkthisindex].address(hasharray[checkthisindex].roottree,key);
			return answer;
		}		
	}
	public T get(K key) throws NotFoundException{
		if(!contains(key)){
			NotFoundException raise=new NotFoundException();
			throw raise;
		}
		else{
			String hashkey=key.toString();
			int checkthisindex=(int)hashfuncs.djb2(hashkey,hasharray.length);
			T returnthis= hasharray[checkthisindex].get(hasharray[checkthisindex].roottree,key);
			return returnthis;
		}
	}
}
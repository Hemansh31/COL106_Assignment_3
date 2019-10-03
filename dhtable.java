public class dhtable<K,T> implements MyHashTable_<K, T>{
	dhnode<K,T>[] hasharray;
	int[] statearray;
	public dhtable(int hashtablesize){
		hasharray=new dhnode[hashtablesize];
		statearray=new int[hashtablesize];
		for(int i=0;i<hashtablesize;i++){
			hasharray[i]=null;
			statearray[i]=0;
		}
	}
	public int insert(K key,T obj){
		if(contains(key)){
			return -1;
		}
		dhnode<K,T> insertthis=new dhnode<K,T>(key,obj);
		String hashkey=key.toString();
		int cntiteration=1;
		int checkthisindex=(int)hashfuncs.djb2(hashkey,hasharray.length);
		int i=1;
		while(hasharray[checkthisindex]!=null){
			checkthisindex=(int)hashfuncs.djb2(hashkey,hasharray.length)+(((int)hashfuncs.sdbm(hashkey,hasharray.length))*(i));
			checkthisindex=checkthisindex%(hasharray.length);
			cntiteration++;
			i++;
		}
		hasharray[checkthisindex]=insertthis;
		//System.out.println(checkthisindex);
		return cntiteration;
	}
	public int update(K key, T obj){
		String hashkey=key.toString();
		int cntiteration=1;
		int checkthisindex=(int)hashfuncs.djb2(hashkey,hasharray.length);
		int i=1;
		boolean checkpresence=false;
		//System.out.println(checkthisindex);
		while(((hasharray[checkthisindex]!=null)||((hasharray[checkthisindex]==null)&&(statearray[checkthisindex]==1)))&&(cntiteration<=(hasharray.length+2))){
			/*System.out.println((hasharray[checkthisindex]!=null));
			System.out.println(key.toString());
			System.out.println(hasharray[checkthisindex].getkey().toString());
			System.out.println((key.toString().equals(hasharray[checkthisindex].getkey().toString())));*/
			if((hasharray[checkthisindex]!=null)&&(key.equals(hasharray[checkthisindex].getkey()))){
				hasharray[checkthisindex].updatenode(obj);
				checkpresence=true;
				break;
			}
			else{
				//System.out.println("Hey1");
				checkthisindex=(int)hashfuncs.djb2(hashkey,hasharray.length)+(((int)hashfuncs.sdbm(hashkey,hasharray.length))*(i));
				checkthisindex=checkthisindex%(hasharray.length);
				cntiteration++;
				i++;
			}			
		}
		if(!checkpresence){
			return -1;
		}
		else{
			return cntiteration;
		}
	}
	public int delete(K key){
		String hashkey=key.toString();
		int cntiteration=1;
		int checkthisindex=(int)hashfuncs.djb2(hashkey,hasharray.length);
		int i=1;
		boolean checkpresence=false;
		while(((hasharray[checkthisindex]!=null)||((hasharray[checkthisindex]==null)&&(statearray[checkthisindex]==1)))&&(cntiteration<=(hasharray.length+2))){
			if((hasharray[checkthisindex]!=null)&&key.equals(hasharray[checkthisindex].getkey())){
				hasharray[checkthisindex]=null;
				checkpresence=true;
				statearray[checkthisindex]=1;
				break;
			}
			else{
				checkthisindex=(int)hashfuncs.djb2(hashkey,hasharray.length)+(((int)hashfuncs.sdbm(hashkey,hasharray.length))*(i));
				checkthisindex=checkthisindex%(hasharray.length);
				cntiteration++;
				i++;
			}	
		}
		if(!checkpresence){
			return -1;
		}
		else{
			return cntiteration;
		}		
	}
	public boolean contains(K key){
		String hashkey=key.toString();
		int cntiteration=1;
		int checkthisindex=(int)hashfuncs.djb2(hashkey,hasharray.length);
		int i=1;
		boolean answer=false;
		while(((hasharray[checkthisindex]!=null)||((hasharray[checkthisindex]==null)&&(statearray[checkthisindex]==1)))&&(cntiteration<=hasharray.length)){
			if((hasharray[checkthisindex]!=null)&&key.equals(hasharray[checkthisindex].getkey())){
				answer=true;
				break;
			}
			else{
				checkthisindex=(int)hashfuncs.djb2(hashkey,hasharray.length)+(((int)hashfuncs.sdbm(hashkey,hasharray.length))*(i));
				checkthisindex=checkthisindex%(hasharray.length);
				cntiteration++;
				i++;
			}	
		}
		return answer;
	}
	public T get(K key) throws NotFoundException{
		if(!contains(key)){
			NotFoundException raise=new NotFoundException();
			throw raise;
			//return null;
		}
		else{
			String hashkey=key.toString();
			int cntiteration=1;
			int checkthisindex=(int)hashfuncs.djb2(hashkey,hasharray.length);
			int i=1;
			T answer=null;
			while(((hasharray[checkthisindex]!=null)||((hasharray[checkthisindex]==null)&&(statearray[checkthisindex]==1)))&&(cntiteration<=(hasharray.length+2))){
				if((hasharray[checkthisindex]!=null)&&key.equals(hasharray[checkthisindex].getkey())){
					answer=hasharray[checkthisindex].getvalue();
					break;
				}
				else{
					checkthisindex=(int)hashfuncs.djb2(hashkey,hasharray.length)+(((int)hashfuncs.sdbm(hashkey,hasharray.length))*(i));
					checkthisindex=checkthisindex%(hasharray.length);
					cntiteration++;
					i++;
				}	
			}
			return answer;
		}
	}
	public String address(K key) throws NotFoundException{
		if(!contains(key)){
			NotFoundException raise=new NotFoundException();
			throw raise;
			//return null;
		}
		else{
			String hashkey=key.toString();
			int cntiteration=1;
			int checkthisindex=(int)hashfuncs.djb2(hashkey,hasharray.length);
			int i=1;
			int answer=0;
			while(((hasharray[checkthisindex]!=null)||((hasharray[checkthisindex]==null)&&(statearray[checkthisindex]==1)))&&(cntiteration<=(hasharray.length+2))){
				if((hasharray[checkthisindex]!=null)&&key.equals(hasharray[checkthisindex].getkey())){
					answer=checkthisindex;
					break;
				}
				else{
					checkthisindex=(int)hashfuncs.djb2(hashkey,hasharray.length)+(((int)hashfuncs.sdbm(hashkey,hasharray.length))*(i));
					checkthisindex=checkthisindex%(hasharray.length);
					cntiteration++;
					i++;
				}	
			}
			String rthis=answer+"";
			return rthis;
		}
	}
}

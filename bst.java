import java.lang.*;
public class bst<K extends Comparable<K>,T>{
	public bstnode<K,T> roottree;
	public bst(bstnode<K,T> rootnode){
		roottree=rootnode;
	}
	public int insert(bstnode<K,T> root,bstnode<K,T> insertthis){
		int cntnodes=1;
		if(insertthis.getkey().compareTo(root.getkey())>0){
			if(root.right==null){
				root.right=insertthis;
				cntnodes++;
			}
			else{
				cntnodes=1+insert(root.right,insertthis);
			}
		}
		else{
			if(root.left==null){
				root.left=insertthis;
				cntnodes++;
			}
			else{
				cntnodes=1+insert(root.left,insertthis);
			}
		}
		return cntnodes;
	}
	public int update(bstnode<K,T> root,bstnode<K,T> updatethis){
		if(!contain(root,updatethis.getkey())){
			return -1;
		}
		else{
			int cntnodes=0;
			if(updatethis.getkey().compareTo(root.getkey())>0){
				cntnodes=1+update(root.right,updatethis);
			}
			else if(updatethis.getkey().compareTo(root.getkey())<0){
				cntnodes=1+update(root.left,updatethis);
			}
			else{
				cntnodes++;
				root.object=updatethis.object;
			}
			return cntnodes;
		}		
	}
	public boolean contain(bstnode<K,T> root,K key){
		boolean answer=false;
		if(root==null){
			return answer;
		}
		else{
			if(key.compareTo(root.getkey())>0){
			if(root.right!=null){
				answer=contain(root.right,key);
			}
			else{
				return false;
			}
		}
		else if(key.compareTo(root.getkey())<0){
			if(root.left!=null){
				answer=contain(root.left,key);
			}
			else{
				return false;
			}
		}
		else{
			answer=true;
		}
		return answer;
		}
		
	}
	public int delete(bst<K,T> tree,K key){
		int cntnodes=0;
		int answer=0;
		bstnode<K,T> root=tree.roottree;
		if(!contain(root,key)){
			//System.out.println("Fuck");
			return -1;
		}
		else{
			answer=cnttouch(tree,key);
			bstnode<K,T> temp=root;
			bstnode<K,T> ptemp=root;
			String pcdirec="L";
			cntnodes++;
			while(key.compareTo(temp.getkey())!=0){
				if(key.compareTo(temp.getkey())>0){
					cntnodes++;
					ptemp=temp;
					pcdirec="R";
					temp=temp.right;
				}
				else{
					cntnodes++;
					ptemp=temp;
					pcdirec="L";
					temp=temp.left;
				}
			}
			if(ptemp==temp){
				if(temp.right==null&&temp.left==null){
					tree.roottree=null;
				}
				else if(temp.right==null&&temp.left!=null){
					tree.roottree=temp.left;
					cntnodes++;
				}
				else if(temp.left==null&&temp.right!=null){
					tree.roottree=temp.right;
					cntnodes++;
				}
				else{
					bstnode<K,T> success=temp.right;
					bstnode<K,T> psuccess=temp;
					cntnodes++;
					while(success.left!=null){
						psuccess=success;
						success=success.left;
						cntnodes++;
					}
					temp.key=success.key;
					temp.object=success.object;
					if(temp.right.left==null){
						if(success.right==null){
							psuccess.right=null;
						}
						else{
							temp.right=success.right;
							cntnodes++;
						}
					}
					else{
						psuccess.left=success.right;
						if(success.right==null){
							;
						}
						else{
							cntnodes++;
						}
					}
				}
			}
			else{
				if(temp.right==null&&temp.left==null){
					if(pcdirec=="L"){
						ptemp.left=null;
					}
					else{
						ptemp.right=null;
					}
				}
				else if(temp.right==null&&temp.left!=null){
					if(pcdirec=="L"){
						ptemp.left=temp.left;
						cntnodes++;
					}
					else{
						ptemp.right=temp.left;
						cntnodes++;
					}
				}
				else if(temp.left==null&&temp.right!=null){
					if(pcdirec=="L"){
						ptemp.left=temp.right;
						cntnodes++;
					}
					else{
						ptemp.right=temp.right;
						cntnodes++;
					}
				}
				else{
					bstnode<K,T> success=temp.right;
					bstnode<K,T> psuccess=temp;
					cntnodes++;
					while(success.left!=null){
						psuccess=success;
						success=success.left;
						cntnodes++;
					}
					temp.key=success.key;
					temp.object=success.object;
					if(temp.right.left==null){
						if(success.right==null){
							psuccess.right=null;
						}
						else{
							temp.right=success.right;
							cntnodes++;
						}
					}
					else{
						psuccess.left=success.right;
						if(success.right==null){
							;
						}
						else{
							cntnodes++;
						}
					}
				}
			}
			return cntnodes;
			/*bstnode<K,T> temp=root;
			bstnode<K,T> ptemp=root;
			String pcdirec="L";
			if(key.compareTo(ptemp.getkey())>0){
				//System.out.println("Hey1");
				temp=ptemp.right;
				pcdirec="R";
				cntnodes++;
				cntnodes++;
			}
			else if(key.compareTo(ptemp.getkey())<0){
				//System.out.println("Hey2");
				temp=ptemp.left;
				pcdirec="L";
				cntnodes++;
				cntnodes++;
			}
			else{
				//System.out.println("Hey3");
				cntnodes++;
				bstnode<K,T> replacement;
				bstnode<K,T> replacementparent;
				if(root.right==null){
					tree.roottree=root.left;
					if(root.left==null){
						//cntnodes++;
					}
					else{
						cntnodes++;
					}
					
				}
				else{
					bstnode<K,T> rightwing=root.right;
					cntnodes++;
					replacement=rightwing;
					replacementparent=root;
					while(replacement.left!=null){
						replacementparent=replacement;
						replacement=replacement.left;
						cntnodes++;
					}
					cntnodes++;
					if(rightwing.left==null){
						//System.out.println("Hey5");
						rightwing.left=root.left;
						tree.roottree=rightwing;
					}
					else{
						replacementparent.left=replacement.right;
						replacement.left=root.left;
						replacement.right=root.right;
						tree.roottree=replacement;
					}
				}
				return cntnodes;
			}
			//System.out.println(pcdirec);
			while(key.compareTo(temp.getkey())!=0){
				//System.out.println("Hey4");
				if(key.compareTo(temp.getkey())>0){
					ptemp=temp;
					temp=temp.right;
					pcdirec="R";
					cntnodes++;
				}
				else{
					ptemp=temp;
					temp=temp.left;
					pcdirec="L";
					cntnodes++;
				}
			}
			if(temp.right==null){
				if(temp.left==null){
					;
				}
				else{
					//cntnodes++;
				}
				if(pcdirec=="L"){
					ptemp.left=temp.left;
				}
				else{
					ptemp.right=temp.left;
				}
			}
			else{
				//System.out.println("Hey4");
				bstnode<K,T> rightwing=temp.right;
				cntnodes++;
				bstnode<K,T> replacement=rightwing;
				bstnode<K,T> replacementparent=temp;
				while(replacement.left!=null){
					//System.out.println("Hey4");
					replacementparent=replacement;
					replacement=replacement.left;
					cntnodes++;
				}
				if(rightwing.left==null){
					replacement.left=temp.left;
					//cntnodes++;
					if(pcdirec=="L"){
						ptemp.left=replacement;
					}
					else{
						ptemp.right=replacement;
					}
				}
				else{
					//System.out.println(temp.right.getkey().toString());
					//System.out.println(temp.getkey().toString());
					replacementparent.left=replacement.right;
					replacement.left=temp.left;
					replacement.right=temp.right;
					cntnodes++;
					if(pcdirec=="L"){
						ptemp.left=replacement;
					}
					else{
						ptemp.right=replacement;
					}
				}
			}
			return cntnodes;*/
		}
	}
	public String address(bstnode<K,T> root,K key) throws NotFoundException{
		int cntnodes=0;
		if(!contain(root,key)){
			NotFoundException raise=new NotFoundException();
			throw raise;
		}
		else{
			String pcdirec="-";
			bstnode<K,T> temp=root;
			while(key.compareTo(temp.getkey())!=0){
				if(key.compareTo(temp.getkey())>0){
					temp=temp.right;
					pcdirec=pcdirec+"R";
				}
				else{
					temp=temp.left;
					pcdirec=pcdirec+"L";
				}
			}
			return pcdirec;
		}
	}
	public T get(bstnode<K,T> root,K key) throws NotFoundException{
		if(!contain(root,key)){
			NotFoundException raise=new NotFoundException();
			throw raise;
		}
		else{
			bstnode<K,T> temp=root;
			while(key.compareTo(temp.getkey())!=0){
				if(key.compareTo(temp.getkey())>0){
					temp=temp.right;
				}
				else{
					temp=temp.left;
				}
			}
			return temp.getvalue();
		}	
	}
	public int cnttouch(bst<K,T> tree,K key){
		int cntnodes=0;
		bstnode<K,T> temp=tree.roottree;
		cntnodes++;
		while(key.compareTo(temp.getkey())!=0){
			if(key.compareTo(temp.getkey())>0){
				cntnodes++;
				temp=temp.right;
			}
			else{
				cntnodes++;
				temp=temp.left;
			}
		}
		if(temp.right==null){
			if(temp.left==null){
				;
			}
			else{
				cntnodes++;
			}
		}
		else{
			cntnodes++;
			temp=temp.right;
			while(temp.left!=null){
				temp=temp.left;
				cntnodes++;
			}
		}
		if(temp.right==null){
			;
		}
		else{
			cntnodes++;
		}
		return cntnodes;
	}
}
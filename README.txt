-------------------------------README FOR ASSIGNMENT 3-------------------------------------
-----------Algorithmic Approach for Separate Chaining Using Binary Search Tree-------------
bstnode.java-->{
	This is a generic class which has a generic comparable key of class K and object of generic
	class T. Apart from it also posesses a left and right reference to the left and right child
	of the binary search tree.
	It has two functions getkey()--> to return key of node
	getvalue()--> to return value of node
}
bst.java-->{
	This a generic class of comparable generic class K and a generic class T and it has a field
	of roottree which is basically the root of the binary search tree.
	It has the functions:
	insert()--> it inserts the bstnode forming a tree with the following properties:
				1. all nodes to the right of a node have lexographically greater first name than
					than the following node.
				2. if two nodes have same first name and different second name then the node to be
					inserted is always sent to the right of the already present node.
				3. if key to be inserted is already present then "E" is printed on the console.
	update()--> this function finds the node to be updated and if its present it updates the value
				else it prints "E" on the console.
	contains()--> this function recursively finds the node and returns a boolean as an answer.
	delete()--> this function first finds the node to be deleted and if its not present it 
				prints a "E" on the console. If the node is present then four cases arise:
				1. if the node to be deleted is a leaf it simply gets derefernced from the 
					parent.
				2. if the node has only a left or a right child then it simply gets refernced
					from the parent of the node to be deleted.
				3. in any other case the function first finds the inorder successor of the node
					to be deleted by first going right one node and then going to the leftmost 
					node from there. After finding this node the value of the node to be deleted 
					is updated and the successor node is then derefernced from its parent by referencing 
					its right node to its parent.
	get()--> this function returns the object stored in the node and throws a NotFoundException if the key 
				is not present in the tree
	address()--> this function returns the address of the node in form of a string of "L" denoting left and 
				"R" denoting right and throws a NotFoundException if the key is not present in the tree.
	cnttouch()--> this function counts the number of nodes touched while performing delete operation in the
					Binary Search Tree.
}
Tupple.java-->{
	This is a generic class used for making the keys of the object to be inserted in the Binary Search Tree.
	This class implements the comparable interface and overrides the compareTo() function, this class also overrides
	the equals() function defined for the Object class which is the superclass of every class in java. This class also
	overrides the toString() function defined in the Object Superclass and this function returns the concatenation of the toString()
	of the two Objects Stored in the Tupple object. Apart from this I defined the getfirst() and getsecond() functions to return the
	first and second Objects Stored in the Tupple.
}
student.java-->{
	This is class to hold all the student properties and it implements the Student_ interface and it has the following functions:
	fname()--> returns the first name of the student as a string
	lname()--> returns the last name of the student as a string
	hostel()--> returns the hostelname of the student as a string
	department()--> returns the name of the department of the student as a string
	cgpa()--> returns the cgpa of the student as a string
}
sctable.java-->{
	This is a class which implements the MyHashTable_ interface and implements all the functions declared in the interface.
	The following are implemented in the class:
	insert()--> it runs the hashkey through the hash functions and generates a index and calls the insert() function of 
	the bstnode() and inserts the node at the binary tree at that index.
	update()--> it runs the hashkey through the hash functions and generates a index and calls the update() function of 
	the bstnode() and updates the node at the binary tree at that index
	contains()--> it runs the hashkey through the hash functions and generates a index and calls the contains() function of 
	the bstnode() checks the presence of  the node at the binary tree at that index
	delete()--> it runs the hashkey through the hash functions and generates a index and calls the delete() function of 
	the bstnode() and deletes the node at the binary tree at that index
	address()--> it runs the hashkey through the hash functions and generates a index and calls the address() function of 
	the bstnode() and prints the address of the node at the binary tree at that index
	get()--> it runs the hashkey through the hash functions and generates a index and calls the get() function of 
	the bstnode() and gets the node value at the binary tree at that index
}
-----------------------------------Algorithmic Approach for Double Hashing----------------------------------------------
Tupple.java-->{
	This is a generic class used for making the keys of the object to be inserted in the Binary Search Tree.
	This class implements the comparable interface and overrides the compareTo() function, this class also overrides
	the equals() function defined for the Object class which is the superclass of every class in java. This class also
	overrides the toString() function defined in the Object Superclass and this function returns the concatenation of the toString()
	of the two Objects Stored in the Tupple object. Apart from this I defined the getfirst() and getsecond() functions to return the
	first and second Objects Stored in the Tupple.
}
student.java-->{
	This is class to hold all the student properties and it implements the Student_ interface and it has the following functions:
	fname()--> returns the first name of the student as a string
	lname()--> returns the last name of the student as a string
	hostel()--> returns the hostelname of the student as a string
	department()--> returns the name of the department of the student as a string
	cgpa()--> returns the cgpa of the student as a string
}
dhnode.java-->{
	This is a generic class which has a generic key of class K and object of generic
	class T. 
	It has three functions getkey()--> to return key of node
	getvalue()--> to return value of node
	updatenode()--> updates the value of node
}
dhtable.java-->{
	This is a class which implements the MyHashTable_ interface and implements all the functions declared in the interface.
	The following are implemented in the class:
	insert()--> This function probes in the array of dhnodes (using the indices generated by Hash functions index = h1+i*h2)
	  If it finds a null at index it inserts that dhnodes.
	  The function returns the number of steps it had to probe to insert the object.
	update()--> This function probes in the array of pairs (using the indices generated by Hash functions index = h1+i*h2)
	  If it finds a null at index along with flag array zero at that index (means this position is empty from the start)
	  it returns -1 (since if it is empty from start it means elements on this probe ahead of it are also empty).
	  If that object exists in the array, it updates that pair.
	  The function returns the number of steps it had to probe to update the object.
	contains()--> it checks if object is present in the hashtable
	delete()--> it deletes the object if its present in the hashtable returns the number of iterations to find the object.
	address()--> it returns the index of the object if its present in the hashtable
	get()--> it returns object for that key if it's present in the hashtable
}
Hashtable of size n

-------------------------------------------------------Double Hashing-----------------------------------------------------------------
...linear probing...
considering n to be prime
In linear probing the max no. of times seaching for filled,
deleted, empty cell is of the order O(n) (worst case).
All cells are traversed once as n is prime.
Let max no. of elements present at any time be k(<n). Assuming one collision,
it has (k/n) probability, two collisions (k/n)*(k-1/n-1). Similarly for i collisions
(k/n)*(k-1/n-1)*...*(k-i+1/n-i+1). 
Since the no. of item to be inserted is lesser than the
table size (about 1.5 times max), the load factor becomes alpha=(k/n)=0.67
(constant upper limit) the average time complexity for search, insert and delete 
will be O(1).

.....Worst Time Complexity...... 

The worst time complexity is clearly O(N). Because if we choose all the elements such that all have the same hash value for both the functions 
then clearly at every insertion we have to traverse through all the elements inserted earlier. This would be true for all the other functions because'
they first reach that point and perform a constant time complexity opeartion after that. 

insert()=O(N)
update =O(N)
contains=O(N)
get=O(N)
delete=O(N)
address=O(N)

------------------------------------------------------------Separate chaining------------------------------------------------------------------
...using binary search trees...
Time complexity for insertion in a binary tree is O(H) 
where h is the height of the root we can see it as that to insert we have to reach at the 
leaf node. Starting from the root we need count the downward .The maximum number of steps would be equal to height of tree. Hence the time complexity of O(N/H).
	 
For the rest of the operations that is update ,contains, get, delete, address we need to find the element and then do some constant time operation other 
than for delete . So we can similarly say that The time complexity of the other operations would be O(H).
	 
let the size of hash table is p and there are n elements to be inserted in the table 
average time complexity= 
average number of elements in each cell would be n/p now from the above the insertion and other operation take O(H) time. The average height would be  O(log n/p)
beacuse in average case the insertion is assumed to be random.
Hence the average time complexity of the various operations would be  would O(log n).
	
insert()=O(log n)
update =O(log n)
contains=O(log n)
get=O(log n)
delete=O(log n)
address=O(log n)
	
If we maintain some upper bound for N/p then average insertion time would be O(1).
	
Worst Time Complexity
if all the keys are such that the hash function places them in the same index then the number of elements in that index would be N.
Now the maximum Height can be N-1 if all the elements are inserted in increasing or decreasing order.
Hence the worst case time complexity would be O(N).
	
insert()=O(N)
update =O(N)
contains=O(N)
get=O(N)
delete=O(N)
address=O(N)

--------------------------------------------Findings from my personal program---------------------------------------------------------
the following test cases was run for different program configurations:
A) (250 lines)
insert Sarthak Tiwari xyz xyz xyz
insert Mohan Tiwari xyz xyz xyz
insert Abhishek Gupta xyz xyz xyz
insert Rahul Kumar xyz xyz xyz
insert Ram Gupta xyz xyz xyz
insert Aman Singh xyz xyz xyz
insert Mohan Gupta xyz xyz xyz
insert Aman Bansal xyz xyz xyz
insert Aman Sharma xyz xyz xyz
insert Aman Tiwari xyz xyz xyz
insert Sarthak Gupta xyz xyz xyz
insert Abhishek Sharma xyz xyz xyz
insert Mohan Bansal xyz xyz xyz
insert Shyam Bansal xyz xyz xyz
insert Shyam Tiwari xyz xyz xyz
insert Rahul Gupta xyz xyz xyz
insert Aman Gupta xyz xyz xyz
insert Mohan Sharma xyz xyz xyz
insert Abhishek Singh xyz xyz xyz
insert Rahul Singh xyz xyz xyz
insert Abhishek Kumar xyz xyz xyz
insert Ram Sharma xyz xyz xyz
insert Shyam Singh xyz xyz xyz
insert Ram Bansal xyz xyz xyz
insert Ram Singh xyz xyz xyz
insert Rahul Tiwari xyz xyz xyz
insert Ram Tiwari xyz xyz xyz
insert Shyam Agrawal xyz xyz xyz
insert Rahul Bansal xyz xyz xyz
insert Abhishek Bansal xyz xyz xyz
insert Mohan Agrawal xyz xyz xyz
insert Rahul Agrawal xyz xyz xyz
insert Abhishek Agrawal xyz xyz xyz
insert Sarthak Bansal xyz xyz xyz
insert Sarthak Sharma xyz xyz xyz
insert Shyam Gupta xyz xyz xyz
insert Shyam Sharma xyz xyz xyz
insert Mohan Singh xyz xyz xyz
insert Sarthak Kumar xyz xyz xyz
insert Mohan Kumar xyz xyz xyz
insert Shyam Kumar xyz xyz xyz
insert Sarthak Singh xyz xyz xyz
insert Rahul Sharma xyz xyz xyz
insert Aman Kumar xyz xyz xyz
insert Ram Kumar xyz xyz xyz
insert Ram Agrawal xyz xyz xyz
insert Abhishek Tiwari xyz xyz xyz
insert Aman Agrawal xyz xyz xyz
get Mohan Kumar
delete Rahul Singh
delete Rahul Bansal
address Mohan Agrawal
contains Abhishek Bansal
get Abhishek Sharma
delete Rahul Bansal
contains Sarthak Bansal
contains Ram Tiwari
contains Sarthak Singh
delete Sarthak Singh
contains Rahul Bansal
contains Shyam Kumar
get Mohan Sharma
update Sarthak Sharma xyz xyz xyz
update Aman Gupta xyz xyz xyz
address Rahul Kumar
address Ram Agrawal
get Shyam Kumar
get Shyam Kumar
address Ram Kumar
get Shyam Bansal
contains Sarthak Bansal
delete Aman Gupta
delete Shyam Tiwari
update Rahul Agrawal xyz xyz xyz
contains Ram Tiwari
contains Shyam Gupta
contains Aman Gupta
contains Mohan Sharma
get Shyam Sharma
contains Rahul Agrawal
update Aman Tiwari xyz xyz xyz
address Shyam Agrawal
update Abhishek Bansal xyz xyz xyz
address Aman Kumar
get Mohan Gupta
address Sarthak Sharma
update Aman Bansal xyz xyz xyz
contains Aman Gupta
contains Rahul Agrawal
get Ram Agrawal
address Ram Bansal
address Sarthak Bansal
address Aman Sharma
update Sarthak Sharma xyz xyz xyz
delete Rahul Gupta
update Mohan Gupta xyz xyz xyz
address Abhishek Tiwari
contains Rahul Kumar
address Mohan Gupta
contains Abhishek Sharma
delete Sarthak Kumar
address Aman Gupta
get Aman Tiwari
update Sarthak Singh xyz xyz xyz
get Aman Agrawal
address Abhishek Kumar
delete Abhishek Agrawal
address Shyam Agrawal
delete Rahul Kumar
address Sarthak Sharma
address Sarthak Kumar
contains Mohan Bansal
contains Abhishek Singh
delete Aman Sharma
delete Abhishek Singh
update Mohan Kumar xyz xyz xyz
update Aman Agrawal xyz xyz xyz
contains Shyam Singh
get Shyam Agrawal
contains Abhishek Singh
get Mohan Agrawal
delete Rahul Agrawal
delete Sarthak Kumar
delete Abhishek Tiwari
get Aman Gupta
get Ram Agrawal
get Mohan Agrawal
update Mohan Kumar xyz xyz xyz
get Rahul Bansal
update Abhishek Sharma xyz xyz xyz
get Shyam Singh
update Aman Singh xyz xyz xyz
contains Sarthak Kumar
update Mohan Sharma xyz xyz xyz
delete Mohan Sharma
address Ram Kumar
address Mohan Singh
address Abhishek Kumar
contains Abhishek Sharma
contains Mohan Sharma
contains Sarthak Tiwari
contains Ram Singh
delete Aman Bansal
delete Sarthak Tiwari
contains Shyam Tiwari
update Shyam Gupta xyz xyz xyz
update Sarthak Kumar xyz xyz xyz
address Sarthak Sharma
delete Aman Gupta
address Rahul Tiwari
address Ram Agrawal
contains Mohan Tiwari
address Shyam Tiwari
delete Abhishek Singh
contains Rahul Gupta
contains Sarthak Singh
update Abhishek Sharma xyz xyz xyz
contains Mohan Kumar
contains Rahul Gupta
get Mohan Singh
update Aman Kumar xyz xyz xyz
get Abhishek Singh
contains Shyam Singh
get Ram Gupta
contains Abhishek Singh
address Aman Bansal
delete Aman Kumar
update Aman Gupta xyz xyz xyz
address Aman Agrawal
update Shyam Singh xyz xyz xyz
contains Sarthak Kumar
address Ram Tiwari
address Abhishek Agrawal
address Aman Singh
address Aman Gupta
get Abhishek Tiwari
get Mohan Sharma
delete Ram Agrawal
get Shyam Sharma
contains Shyam Sharma
delete Sarthak Gupta
delete Mohan Tiwari
update Rahul Kumar xyz xyz xyz
delete Aman Gupta
update Abhishek Agrawal xyz xyz xyz
address Shyam Agrawal
contains Rahul Tiwari
get Shyam Sharma
get Ram Agrawal
update Sarthak Bansal xyz xyz xyz
delete Rahul Gupta
update Shyam Sharma xyz xyz xyz
delete Sarthak Bansal
address Aman Sharma
get Mohan Sharma
get Shyam Agrawal
address Sarthak Sharma
delete Mohan Agrawal
update Shyam Gupta xyz xyz xyz
delete Sarthak Gupta
contains Rahul Kumar
delete Abhishek Bansal
get Abhishek Sharma
address Aman Agrawal
update Ram Bansal xyz xyz xyz
address Abhishek Kumar
contains Aman Singh
get Mohan Tiwari
contains Sarthak Kumar
address Ram Gupta
address Sarthak Tiwari
address Abhishek Bansal
delete Sarthak Gupta
address Shyam Agrawal
delete Abhishek Agrawal
delete Ram Sharma
address Ram Agrawal
update Shyam Sharma xyz xyz xyz
get Aman Kumar
get Ram Tiwari
update Rahul Tiwari xyz xyz xyz
contains Mohan Bansal
get Abhishek Kumar
delete Sarthak Sharma
update Mohan Kumar xyz xyz xyz
address Abhishek Singh
delete Shyam Gupta
contains Sarthak Gupta
address Ram Singh
contains Abhishek Bansal
contains Sarthak Tiwari
get Ram Tiwari
get Sarthak Sharma
get Shyam Bansal
contains Ram Singh
address Rahul Kumar
update Ram Sharma xyz xyz xyz
update Sarthak Kumar xyz xyz xyz
get Mohan Kumar
address Rahul Sharma
delete Shyam Agrawal
contains Aman Kumar
address Rahul Tiwari
delete Shyam Bansal
address Aman Kumar
contains Abhishek Gupta
contains Rahul Singh
get Rahul Bansal
1) 70 DH :
2) 140 DH :
max insert 50
time of execution of 
1) comes roughly the same as 2)
3) 32 SCBST :
4) 1 SCBST :
For 3) the time taken is lesser than for 4)



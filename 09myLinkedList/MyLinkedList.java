import java.util.*;

public class MyLinkedList implements Iterable<Integer>{

    private class LNode{
	LNode next,prev;
	int value;

	public LNode(int value){
	    this.value=value;
	}

	public String toString(){
	    return value+"";
	}
    }

    LNode head,tail;
    int size;

    public MyLinkedList(){
	head= tail= null;
	size= 0;
    }

    public int size(){
	return size;
    }

    private LNode getNthNode(int n){
	if(n<0 || n>= size)
	    throw new IndexOutOfBoundsException();
	LNode current= head;
	if(size != 0){
	    int a= size/2;
	    if(n<= a){
		for(int i=0; i<n; i++)
		    current=current.next;
	    }else{
		current=tail;
		n=size-1-n;
		for(int i=0; i<n; i++)
		    current=current.prev;
	    }
	}
	return current;
    }

    private void addAfter(LNode location, LNode toBeAdded){
	toBeAdded.prev= location;
	toBeAdded.next= location.next;
	location.next= toBeAdded;
    }

    private void remove(LNode target){
        if(target==head){
	    head= head.next;
	    if(size!=1)
		head.prev= null;
	}else if(target==tail){
	    tail= tail.prev;
	    tail.next= null;
	}else{
	    target.prev.next= target.next;
	    target.next.prev= target.prev;
	}
    }


    public String toString(){
	String ans="[";
	LNode current = head;
	if(current!=null){
	    while(current.next!=null){
		ans+=" "+current.value+",";
		current = current.next;
	    }
	    ans+=" "+current.value+" ]";
	}else{
	    ans+="]";
	}
	return ans;
    }

    public boolean add(int value){ 
	LNode last= new LNode(value);
	if(size!=0){
	    addAfter(tail, last);
	    tail= last;
	}else{
	    head= tail= last;
	}
	size++;
	//System.out.println(this.toString()+"\nSize: "+this.size());
	return true;
    }

    public int get(int index){
	return getNthNode(index).value;
    }

    public int set(int index, int value){
	LNode target= getNthNode(index);
	int ans= target.value;
	target.value= value;
	return ans;
    }

    public int indexOf(int value){
	LNode current=head;
	int index= 0;
	while(current.next!=null){
	    if(current.value==value){
		return index;
	    }
	    current= current.next;
	    index++;
	}
	if(current.value==value){
	    return index;
	}
	return -1;
    }

    public int remove(int index){
	LNode target= getNthNode(index);
	int temp= target.value;
	remove(target);
	size--;
	return temp;
    }

    public void add(int index,int value){
	if(index==0){
	    LNode a= head;
	    addAfter(head, new LNode(value));
	    remove(0);
	    addAfter(head, a);
	    size++;
	}else if(index==size){
	    add(value);
	    size--;
	}else{
	    addAfter(getNthNode(index-1),new LNode(value));
	}
	size++;
    }
 
    private void NodePrinter(LNode a){
        System.out.println(String.format("LNode \n Val: %s\n Prev: %s\n Next: %s", a.value, a.prev, a.next));
    }

    public Iterator<Integer> iterator(){
	return new LLIterator(this);
    }

    public class LLIterator implements Iterator<Integer>{

	private LNode element;
	private MyLinkedList MLL;
    
	public LLIterator(MyLinkedList input) {
	    MLL = input;
	    element =MLL.head;
	}

	public Integer next() {
	    if(!hasNext()){
		throw new NoSuchElementException();
	    }
	    Integer temp= element.value;
	    element= element.next;
	    return temp;
	}
	
	public boolean hasNext() {
	    return element!=null;
	}
	
	public void remove() {
	    throw new UnsupportedOperationException();
	}
	
    }

}

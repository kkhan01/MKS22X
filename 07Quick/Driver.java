
import java.util.*;

public class Driver{
    //creates random array
    public static int[] randomArray(int size, int max){
	int[] data= new int[size];
	Random num = new Random();
	for(int i=0; i<data.length; i++){
	    data[i]=num.nextInt(max);
	}
	return data;
    }
    
    public static void main(String [] args){
	
	//Partition Test Cases (Need to check the array visually)
	/*int []data= randomArray(10, 100);
	  System.out.println(Arrays.toString(data));
	  System.out.println(Quick.part(data, 0, 9));
	  System.out.println(Arrays.toString(data));
	*/
	//K's Test Cases
	/*
	  int[]ary = { 2, 10, 15, 23, 0,  5};
	  System.out.println(Quick.quickSelect( ary , 0 )); //would return 0
	  System.out.println(Quick.quickSelect( ary , 1 )); //would return 2
	  System.out.println(Quick.quickSelect( ary , 2 )); //would return 5
	  System.out.println(Quick.quickSelect( ary , 3 )); //would return 10
	  System.out.println(Quick.quickSelect( ary , 4 )); //would return 15
	  System.out.println(Quick.quickSelect( ary , 5 )); //would return 23
	*/
	//Quick Select Test Cases, can just look to see if a line isn't spaced and is "ERROR"
	//Might modify to give more insight, but what works works.
	/*
	for(int i=0; i<1000000000; i++){
	    //checking for a friend; 10 min and 20 max
	    int size=10+(int)Math.floor(Math.random()*(20-10+1));
	    int []data= randomArray(size, 1000);
	    //data[7]=data[3]; //double check
	    //System.out.println("\n Original:"+Arrays.toString(data));
	    int[]sorted=data.clone();
	    //checking for a friend
	    int randompos=(int)Math.floor(Math.random()*(data.length));
	    Arrays.sort(sorted);
	    //System.out.println(" Sorted:"+Arrays.toString(sorted)+"\n For index: "+randompos+"\n");
	    int q= Quick.quickSelect(data, randompos);
	    if(q==data[randompos]){
		System.out.println(String.format(" Woo! \n sortedSelect: %s : quickSelect: %s",
				   sorted[randompos], q));
	    }else{System.out.println(String.format("ERROR! \n sortedSelect: %s : quickSelect: %s",
						   sorted[randompos], q));
		return;}
	}
	

	*/

	//QuickSort Test Cases
	
	for(int i=0; i<1000; i++){
	    //run out of heap?
	    //int []data= randomArray(249710013, 100);
	    int []data= randomArray(99999, 100);
	    int[]realSort=data.clone();
	    Quick.quickSort(data);
	    Arrays.sort(realSort);
	    //System.out.println(Arrays.equals(data, realSort)+"\n");
	    if(Arrays.equals(data, realSort)){
		System.out.println("GOOD");
	    }else{
		System.out.println("OH NO");
		return;
	    }
	}
	
    }
}

	

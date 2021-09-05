
	//----------------------------------------------------- 
	// Title: implementionOfSorts Class
	// Author: csukesan
	// Description: In this class insertion sort, insertion sort right to left, merge sort are implemented.
	//----------------------------------------------------- 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class implementionOfSorts {

			//--------------------------------------------------------      
			// Summary:Main class to read data from files and create arrays and test the sorting algorithms.
			// 
			//--------------------------------------------------------
		public static void main(String []args) throws FileNotFoundException
		{
			File intfile = new File("C:\\Users\\User\\Desktop\\sort.txt"); // file that holds integer values
			 Scanner scanner = new Scanner(intfile);
			 int d = Integer.parseInt(scanner.nextLine());
			 Integer []intar = new Integer[d];
			 int x = 0;
			 while(scanner.hasNextLine()) // control of end of file
			 {
			    intar[x] = Integer.parseInt(scanner.nextLine());
			    x++;
			 }
			 
			 File doublefile = new File("C:\\Users\\User\\Desktop\\doublesort.txt"); // file that holds double values
			 Scanner scanner2 = new Scanner(doublefile);
			 int s = Integer.parseInt(scanner2.nextLine());
			 Double []doublear = new Double[s];
			 int y = 0;
			 while(scanner2.hasNextLine()) //control of end of file
			 {
			    doublear[y]= Double.parseDouble(scanner2.nextLine());
			 }
			 
			 
			 scanner.close();
			 scanner2.close();
			
			 
			 /*Insertionsort(intar);  //insertion sort call
			 assert isSorted(intar);
			 show(intar);*/
			 
			 /*InsertionSortR(intar); // right to left insertion sort call
			 show(intar);*/
			 
			 /*sort(intar,0, intar.length-1); //merge sort call
			 show(intar);*/
			 
			 MergesortDescending(intar); //descending merge sort call
			 show(intar);
			
		}
		
		private static Comparable []aux; 
		
		//--------------------------------------------------------      
		// Summary: sorts the given array with merge sort(decending order)
		// Precondition: Comparable type array should be given to function
		// Postcondition: Calls the implemented functions sort which is main part of merge sort.
		//--------------------------------------------------------
		public static void MergesortDescending(Comparable []a) 
		{
			aux = new Comparable[a.length]; 
			sort(a,0, a.length-1);
		}
		
		//--------------------------------------------------------      
		// Summary: sorts the given array left to right with insertion sort.
		// Precondition: Comparable type array and 3 integers should be given to function
		// Postcondition: Calls the implemented functions sort (recursively) and merge which were taken from corse book
		//--------------------------------------------------------
		  private static void sort(Comparable []a, int lo, int hi)
		  {
		  	if(hi <= lo)
		  	{
		  		return;
		  	}
		  	else
		  	{
		  		int mid = lo + (hi-lo)/2;
			  	sort(a,lo,mid);
			  	sort(a,mid+1, hi);
			  	merge(a, lo, mid,hi);
		  	}
		  	
		  }
		  
		//--------------------------------------------------------      
		// Summary: Merges the given array to sort with merge sort.
		// Precondition: Comparable type array and 2 integers should be given to function
		// Postcondition: It chances the indexes of array by compare their datas. 
		//--------------------------------------------------------
		  public static void merge(Comparable []a, int lo, int mid,int hi)
		  {
		  	int i = lo;
		  	int j = mid+1;
		  	aux = new Comparable[a.length];

		  	for (int k= 0; k <= hi; k++)
		  	{
		  		aux[k]=a[k];
		  	}
		  	for(int k = lo; k<= hi; k++)
		  	{
		  		if(i>mid)
		  		{
		  			a[k] = aux[j++];
		  		}
		  		else if (j > hi)
		  		{
		  			a[k] = aux[i++];
		  		}
		  		else if (!less(aux[j],aux[i]))
		  		{
		  			a[k]=aux[j++];
		  		}
		  		else
		  		{
		  			a[k]=aux[i++];
		  		}	
		
		  	}
		  }
		  
    //--------------------------------------------------------      
	// Summary: sorts the given array left to right with insertion sort(ascending order)
	// Precondition: Comparable type array should be given to function
	// Postcondition: Calls the implemented functions exch and less which were taken from corse book
	//-------------------------------------------------------- 
	 public static void Insertionsort(Comparable[] a)
		 { 
			  int N = a.length;
			  for (int i = 1; i < N; i++)
			  { 
				  for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
				  {
					  exch(a, j, j-1);
				  }
			  }
			 
		 }
	 
	//--------------------------------------------------------      
	// Summary: Sorts the array by using insertion sort left to right (descending order)
	// Precondition: Comparable type array should be given to function  
	// Postcondition: Calls the implemented functions exch and less which were taken from corse book
	//-------------------------------------------------------- 
	 public static void InsertionSortR (Comparable[]a)
		 {
			 int N = a.length;
				for(int i=N-1;i>0;i--)
				{
					for(int j=i;j<N && !less(a[j], a[j-1]);j++)
					{
						exch(a, j, j-1);
					}
				}
		 }
		 
		 
	 private static boolean less(Comparable v, Comparable w)
		 { 
			 return v.compareTo(w)<0;
			 
		 }
		
	private static void exch(Comparable []a, int i, int j)
		 	
		 { 
			 Comparable t= a[i];
			 a[i] = a[j]; 
			 a[j] = t; 
		 }
		 
	private static void show(Comparable []a) 
		 { 
			 for (int i = 0; i < a.length; i++)
			 {
				
				 System.out.print(a[i]+ " ");
				 System.out.println();
			 }
		
		 }
		 
	public static boolean isSorted(Comparable[]a)
		 { 
			 for (int i = 1; i < a.length; i++)
			 {
				 if (less(a[i], a[i-1])) 
				 {
					 return false;

				 }
			 }
			 return true;
		 }
		 
		

	}


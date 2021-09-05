//-----------------------------------------------------
// Title: Person Class
// Author: csukesan
// Description: In this class there is an implenmention of Quick Sort with Person objects. 
//-----------------------------------------------------
import java.util.ArrayList;
import java.util.Arrays;
public class Person implements Comparable<Person>{

	private String name, surname;
	private long id;
	
	public Person(String name, String surname, long id) {
		this.name = name;
		this.surname = surname;
		this.id = id ;
	}

	public int compareTo(Person obj) {
		if(id > obj.id)
			return +1;
		if(id< obj.id)
			return -1;
		return 0;
		
	}

	public String name() {
		return name;
	}

	
	public String surname() {
		return surname;
	}

	
	public long Id() {
		return id;
	}

		//--------------------------------------------------------      
		// Summary: Sorts the elements decreasingly that are in Comparable type of array according to their long id.    
		// Precondition: Comparable type array must be given to function   
		// Postcondition: Calls DecreaseSort function for sorting.
		//-------------------------------------------------------- 
	public static void DecreaseSort(Comparable [] a)
	{
		StdRandom.shuffle(a);
		DecreaseSort(a, 0, a.length-1);
	}
	
		//--------------------------------------------------------      
		// Summary: Sorts the elements that are in Comparable type of array according to their long id.     
		// Precondition: Comparable type array and 2 integers must be given to function. 
		// Postcondition:Calls DecreaseSort function and partitionDsc function.
		//-------------------------------------------------------- 
	public static void DecreaseSort(Comparable [] a, int lo, int hi)
	{
		if(hi<=lo)
			return;
		int x = partitionDesc(a, lo, hi);
		DecreaseSort(a, lo, x-1);
		DecreaseSort(a, x+1, hi);
		
	}
	
		//--------------------------------------------------------      
		// Summary: Sorts the elements increasingly that are in Comparable type of array according to their long id.     
		// Precondition: Comparable type array must be given to function. 
		// Postcondition:Calls IncreasSort function for sortin with 2 integers.
		//-------------------------------------------------------- 
	public static void IncreaseSort(Comparable [] a)
	{
		StdRandom.shuffle(a);
		IncreaseSort(a, 0, a.length-1);
	}
	
		//--------------------------------------------------------      
		// Summary: Sorts the elements increasingly that are in Comparable type of array according to their long id.     
		// Precondition: Comparable type array and 2 integers must be given to function. 
		// Postcondition:Calls  IncreaseSort function recursively and partitionInc function.
		//-------------------------------------------------------- 
	public static void IncreaseSort(Comparable [] a, int lo, int hi)
	{
		if(hi<=lo)
			return;
		int j = partitionInc(a, lo, hi);
		IncreaseSort(a, lo, j-1);
		IncreaseSort(a, j+1, hi);
		
	}
	
		//--------------------------------------------------------      
		// Summary: It makes necessary exchanges in increase order in Quick sort.  
		// Precondition: Comparable type array and 2 integers must be given to function.
		// Postcondition: change the indexes of values if previous value is bigger than current.
		//-------------------------------------------------------- 
	private static int partitionInc(Comparable[] a, int lo, int hi) 
	{
		
		int i = lo;
		int j = hi+1;
		Comparable v = a[lo];
		
		while(true)
		{
			while(less(a[++i], v))
			{
				if(i==hi)
					break;
			}
			while(less(v, a[--j]))
			{
				if(j == lo)
					break;
			}
			if(i>=j)
				break;
			exch(a, i, j);		
		}
		
		exch(a, lo, j);
		return j;
	}
	
	    //--------------------------------------------------------      
		// Summary: It makes necessary excahnages in decrease order in Quick sort. 
		// Precondition:Comparable type array and 2 integers must be given to function.
		// Postcondition:Changes the indexes of values if previous value is less than current.
		//-------------------------------------------------------- 
	private static int partitionDesc(Comparable [] a,int lo, int hi)
	{
					
			int i = lo;
			int j = hi+1;
			Comparable v = a[lo];
			
			while(true)
			{
				while(!less(a[++i], v))
				{
					if(i==hi)
						break;
				}
				while(!less(v, a[--j]))
				{
					if(j == lo)
						break;
				}
				if(i>=j)
					break;
				exch(a, i, j);		
			}
			
			exch(a, lo, j);
			return j;
		
	}

	private static boolean less(Comparable v,Comparable w)
	{
		return v.compareTo(w)<0;
	}
	
	private static void exch(Comparable [] a,int i,int j)
	{
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	
		//--------------------------------------------------------      
		// Summary:Main class to test Quick Sort Algorithm implemention.
		// 
		//--------------------------------------------------------
	public static void main(String[]args)
	 
	{
		
		Person[] person = new Person[10];
		
		Person person1 = new Person("cagla","kesan", 241L);
		Person person2= new Person ("peter","pan", 345L);
		Person person3 = new Person("john","herr", 349L);
		Person person4 = new Person("ally", "kal", 211L);
		Person person5 = new Person("kelly", "app", 252L);
		Person person6 = new Person("henry","dixon", 313L);
		Person person7 = new Person("alaric", "saltzman", 326L);
		Person person8 = new Person("denise", "gibbs", 112L);
		Person person9 = new Person("julian", "walt", 784L);
		Person person10 = new Person("bertha","car", 102L);
		
		person[0] = person1;
		person[1] = person2;
		person[2] = person3;
		person[3] = person4;
		person[4] = person5;
		person[5] = person6;
		person[6] = person7;
		person[7] = person8;
		person[8] = person9;
		person[9] = person10;
		
		for (int i = 0; i < person.length; i++)
		 {
			
			 System.out.print(person[i].name+ " "+ person[i].surname+ " ");
			 System.out.println();
		 }
	
		System.out.println();
		Person.IncreaseSort(person);
		
		for (int i = 0; i < person.length; i++)
		 {
			
			 System.out.print(person[i].name+ " "+ person[i].surname+ " ");
			 System.out.println();
		 }
		
		Person.DecreaseSort(person);
		
		for (int i = 0; i < person.length; i++)
		 {
			
			 System.out.print(person[i].name+ " "+ person[i].surname+ " ");
			 System.out.println();
		 }
		
	}}



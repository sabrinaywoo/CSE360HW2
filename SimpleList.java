/**
 *Name: Sabrina Woo
 *Class ID: 422
 *Assignment 2
 *Description: Simple List class can add, remove, or search an integer in an array of integers
**/

public class SimpleList {

private int [] list;
private int count;
	
//constructor
public SimpleList()
{
	list = new int [10];
	count = 0;
}

/* 
This method returns the list
@return the array of integers
*/
public int [] getList()
{
	return list;
}

/* 
This method adds a new int to array at index 0 and moves all list elements to the right
@param a new integer to be added
*/
public void add (int newInt)
{	
	//if list is empty then add an integer		
	if (count == 0)
	{
		list[0] = newInt;
		count++;
	}
	//check if list is full
	else if (count == list.length)
	{
		//new array increases size by 50%
		int [] tempArray = new int [(int)(list.length * .5)];
		
		//copy original list elements into new array
		for (int copy = 0; copy < list.length; copy++)
		{
			tempArray[copy] = list[copy];
		}
		list = tempArray;
		add(newInt);
	}
	//add a new int
	else
	{
		//shift integers to the right
		for (int index = list.length - 1; index > 0; index --)
		{
			list[index] = list [index - 1]; 
		}
		//add int at beginning of the list and increment count
		list[0] = newInt;
		count++;
	}

}

/* 
This method removes a specified int and moves the remaining elements down.
If the list has more than 25% empty places it decreases the size of the list.
The list cannot be reduced to less than 1 entry.
@param a specific integer to remove from the list
*/
public void remove (int target)
{
	//list search variables
	int firstIndex, secondIndex;
	//75% size of list
	int reducedSize = (int)(list.length * 0.75);
	
	for (firstIndex = 0; firstIndex < list.length; firstIndex ++)
	{
		if (list[firstIndex] == target)
		{
			if(list[list.length - 1] == target)
			{
				list[list.length - 1] = 0;
				//reduce count since a number was removed
				count --;
			}
			else
			{
				//for loop shifts all numbers down from the removed index
				for (secondIndex = firstIndex; secondIndex < list.length - 1; secondIndex ++)
				{
					list[secondIndex] = list[secondIndex + 1];
				}
				//reduce count since a number was removed
				count --;
				//last index will always be zero if a number was removed
				list[list.length - 1] = 0;	
			}
			
		}
	}
	
	//reduce array size if over 25% of list is empty
	if (count < reducedSize && count > 1)
	{
		//new array with smaller size
		int [] tempArray = new int [reducedSize];
		
		//copy original list elements into new array
		for (int copy = 0; copy < reducedSize; copy++)
		{
			tempArray[copy] = list[copy];
		}
		list = tempArray;
	}
}
	
/* 
This method returns the current count of integers in the list 
*/
public int count ()
{
	return count;
}
	
/* 
This method converts the array to a string and the elements are separated by a space
*/
public String toString()
{
	String finalString = "", tempString = "";
	//for loop copies array and converts to String, excluding the first value
	for(int index = 1; index < list.length; index++)
	{
		tempString += " " + String.valueOf(list[index]);
	}
	//converts the first value to string and append the rest
	finalString = String.valueOf(list[0])+ tempString;
	return finalString;
}
	
/* 
This method return the location of the parameter in the list. If the parameter is not in the list, then it returns -1.
@param the target integer to be found
@return the index of the target integer
*/
public int search(int target)
{
	int found = -1;
	//searches for integer in the array
	for (int index = 0; index < list.length ; index++)
	{
		if (list[index] == target)
			found = index;
	}
	
	return found;
}

}


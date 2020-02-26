/**
 *Name: Sabrina Woo
 *Class ID: 422
 *Assignment 1
 *Description: Simple List class can add remove or 
 *					search an integer
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

//returns list
public int [] getList()
{
	return list;
}

//add a new int to array at index 0
public void add (int newInt)
{
	if (count  == 0)
	{
		list[0] = newInt;
		count++;
	}
	else
	{
		for (int index = list.length - 1; index > 0; index --)
		{
			list[index] = list [index - 1]; 
		}
		list[0] = newInt;
		count++;
	}

}

public void remove (int target)
{
	int secondIndex, firstIndex;
	for (firstIndex = 0; firstIndex < list.length; firstIndex ++)
	{
		if (list[firstIndex] == target)
		{
			if(list[list.length-1] == target)
			{
				list[list.length-1] = 0;
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
}

public int count ()
{
	return count;
}

public String toString()
{
	String finalString = "", tempString = "";

	for(int index = 1; index < list.length; index++)
	{
		tempString += " " + String.valueOf(list[index]);
	}
	
	finalString = String.valueOf(list[0])+ tempString;
	return finalString;
}

public int search(int target)
{
	int found = -1;
	
	for (int index = 0; index < list.length ; index++)
	{
		if (list[index] == target)
			found = index;
	}
	
	return found;
}

}


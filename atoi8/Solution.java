package atoi8;

public class Solution
{
	public int myAtoi(String str) 
	{
		if(str.equals(""))
			return 0;
		
		if(str.matches("[\\s]+[^\\d]")||str.matches("[^0-9]*"))
			return 0;
		
		String[] elements=str.split("[^0-9]+");
		if(str.matches("[\\s]+[0-9]+.*"))
			return Integer.parseInt(elements[1]);
		else
			return Integer.parseInt(elements[0]);
		
    }
	
	public static void main(String[] args)
	{
		Solution solution=new Solution();
		System.out.println(solution.myAtoi("   9"));
	}
}

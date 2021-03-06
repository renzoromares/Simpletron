import java.util.List;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;
import java.lang.*;

public class SimpleTron
{
	public static void main( String args[])
	{
	List <String>myList=FileHelper.readFile(args[0]);
		if(args.length > 1)
		{
			System.out.println("\t------Error kuyaahhhh-----");
		}
		else
		{
			String[] Operand=new String[200];
			String[] mystring=new String[200];
			String[] ToStore=new String[200];
			String[] location=new String[200];
			StringTokenizer token;
			int i=0,j=0,k=0,c=0;
			for (i = 0; i < myList.size(); i++) 
			{
				token=new StringTokenizer(myList.get(i));
				while(token.hasMoreTokens())
				{	
					mystring[j]=token.nextToken();
						if(j%2!=0)
						{
							ToStore[k]=mystring[j];
							Operand[k]=ToStore[k].substring(0,2);
							location[k]=ToStore[k].substring(2);
							k++;
						}		
						j++;
				}
			//System.out.println(myList.get(i));
			}
			SyntaxChecker(location,Operand,ToStore,k);
		}
	}
	public static void MemoryBoard(String ToStore[])
	{
		for(int x=0;x<10;x++)
		{
			System.out.print("	    ");
			System.out.print(x);
		}
		System.out.println();
		for(int row=0;row<=9;row++)
		{
			System.out.print(row +"0" + "\t");
			for(int col=0;col<=9; col++)
			{
			int index=(row*10)+col;
			if(ToStore[index]==null)
			{
				System.out.print("+" +"0000"+"\t");
			}
			else
			{
				System.out.print("+" +ToStore[index] +"\t");
			}
		}
			System.out.println();	
		}	 
	}
	public static void SyntaxChecker(String location[],String operand[],String ToStore[],int k)
	{
		String Operators[] = {"00","10","11","20","21","22","30","31","32","33","34","35","36","37","38","39","40","41","42","43"};
		int i=0,j=0,flag=0;
		for(i=0; i<k;i++)
		{
			for(j=0;j<Operators.length;j++)
			{
				if(operand[i].compareTo(Operators[j])==0){
					flag++;
					break;
					}
				else{
					continue;}
			}
		}	
		if(flag!=k){
			System.out.println("\n\n------->Compile Error\n\n");
		}
		else{
			System.out.println("\n\n------->Operators loaded\n\n");
			MemoryBoard(ToStore);
			Execution(ToStore,location,operand,k);
		}
	}
	public static void Execution(String ToStore[],String location[],String operand[],int k)
	{ 
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("------------------->Welcome to SimpleTron\t");
		System.out.println("------------------->Program loaded loaded successfully\t\t");
		int input=0;
		int accumulator=0;
		int programCounter=0;
		
		for(int i=0;i<k;i++)
		{
			if(operand[i].compareTo("10")==0)
			{
				System.out.println("Executing..."+ToStore[i]);
				Scanner sc=new Scanner(System.in);
				System.out.print("?");
				input=sc.nextInt();
				int index=Integer.parseInt(location[i]);
				if(index>100)
				{
					System.out.println("Error Index outOfRange!!");
				}
				ToStore[index]=String.format("%04d",input);
				programCounter++;
				NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
			}
			else if(operand[i].compareTo("11")==0)
			{
				System.out.println("Executing... "+ToStore[i]);
				int index=Integer.parseInt(location[i]);
				int value=Integer.parseInt(ToStore[index]);
				programCounter++;
				NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
				System.out.println(value);
			}
			else if(operand[i].compareTo("20")==0)
			{
				System.out.println("Executing..."+ToStore[i]);
				int index=Integer.parseInt(location[i]);
				accumulator=Integer.parseInt(ToStore[index]);
				programCounter++;
				NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
			}
			else if(operand[i].compareTo("21")==0)
			{
				System.out.println("Executing..."+ToStore[i]);
				int index=Integer.parseInt(location[i]);
				ToStore[index]=String.format("%04d",accumulator);
				programCounter++;
				NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
			}
			else if(operand[i].compareTo("22")==0)
			{
				System.out.println("Executing... "+ToStore[i]);
				int index=Integer.parseInt(location[i]);
				programCounter++;
				accumulator=index;
			}
			else if(operand[i].compareTo("30")==0)
			{
				System.out.println("Executing..."+ToStore[i]);
				int index=Integer.parseInt(location[i]);
				int value=Integer.parseInt(ToStore[index]);
				accumulator+=value;
				programCounter++;
				NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
			}
			else if(operand[i].compareTo("31")==0)
			{
				System.out.println("Executing..."+ToStore[i]);
				int index=Integer.parseInt(location[i]);
				int value=Integer.parseInt(ToStore[index]);
				accumulator-=value;
				programCounter++;
				NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
			}
			else if(operand[i].compareTo("32")==0)
			{
				System.out.println("Executing..."+ToStore[i]);
				int index=Integer.parseInt(location[i]);
				int value=Integer.parseInt(ToStore[index]);
				accumulator=accumulator/value;
				programCounter++;
				NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
			}
			else if(operand[i].compareTo("33")==0)
			{
				System.out.println("Executing..."+ToStore[i]);
				int index=Integer.parseInt(location[i]);
				int value=Integer.parseInt(ToStore[index]);
				accumulator=accumulator%value;
				programCounter++;
				NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
			}
			else if(operand[i].compareTo("34")==0)
			{
				System.out.println("Executing..."+ToStore[i]);
				int index=Integer.parseInt(location[i]);
				int value=Integer.parseInt(ToStore[index]);
				accumulator*=value;
				programCounter++;
				NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
			}
			else if(operand[i].compareTo("35")==0)
			{
				System.out.println("Executing... "+ToStore[i]);
				int index=Integer.parseInt(location[i]);
				programCounter++;
				accumulator+=index;
				NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
			}
			else if(operand[i].compareTo("36")==0)
			{
				System.out.println("Executing... "+ToStore[i]);
				int index=Integer.parseInt(location[i]);
				programCounter++;
				accumulator-=index;
				NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
			}
			else if(operand[i].compareTo("37")==0)
			{
				System.out.println("Executing... "+ToStore[i]);
				int index=Integer.parseInt(location[i]);
				programCounter++;
				accumulator/=index;
				NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
			}
			else if(operand[i].compareTo("38")==0)
			{
				System.out.println("Executing... "+ToStore[i]);
				int index=Integer.parseInt(location[i]);
				programCounter++;
				accumulator=accumulator%index;
				NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
			}
			else if(operand[i].compareTo("39")==0)
			{
				System.out.println("Executing... "+ToStore[i]);
				int index=Integer.parseInt(location[i]);
				programCounter++;
				accumulator*=index;
				NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
			}
			else if(operand[i].compareTo("40")==0)
			{
				System.out.println("Executing... "+ToStore[i]);
				int index=Integer.parseInt(location[i]);
				programCounter++;
				NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
				i=index;
				break;
			}
			else if(operand[i].compareTo("41")==0)
			{
				if(accumulator<0)
				{
				System.out.println("Executing... "+ToStore[i]);
				int index=Integer.parseInt(location[i]);
				programCounter++;
				NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
				i=index;
				i--;
				}
				else
				{
					System.out.println("Executing... "+ToStore[i]);
					programCounter++;
					NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
				}
			}
			else if(operand[i].compareTo("42")==0)
			{
				if(accumulator==0)
				{
				System.out.println("Executing... "+ToStore[i]);
				int index=Integer.parseInt(location[i]);
				programCounter++;
				i=index;
				i--;
				NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
				}
			}	
			
			else if(operand[i].compareTo("43")==0)
			{
				System.exit(0);
				System.out.println("Executing... "+ToStore[i]);
				//programCounter++;
				//NewMemoryBoard(ToStore,location,operand,k,accumulator,programCounter,i);
			}
		}
	
	}
	public static void NewMemoryBoard(String ToStore[],String location[],String operand[],int k,int accumulator,int programCounter,int i)
	{
		String al=String.format("%04d",accumulator);
		String progCount=String.format("%02d",programCounter);
		System.out.println("-----------------------");
		System.out.println("REGISTER: ");
		System.out.println("accumulator:+"+al);
		System.out.println("programCounter:"+progCount);
		System.out.println("instructionRegister:"+ToStore[i]);
		System.out.println("OperationCode:"+operand[i]);
		System.out.println("Operand:"+location[i]);	
		System.out.println();
		for(int x=0;x<10;x++)
		{
			System.out.print("	    ");
			System.out.print(x);
		}
		System.out.println();
		for(int row=0;row<=9;row++)
		{
		System.out.print(row +"0" + "\t");
		for(int col=0;col<=9; col++)
		{
			int index=(row*10)+col;
			if(ToStore[index]==null)
			{
				System.out.print("+" +"0000"+"\t");
			}
			else
			{
				System.out.print("+" +ToStore[index] +"\t");
			}
		}
			System.out.println();	
		}	 
	}
	

}	
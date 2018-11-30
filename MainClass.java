/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculationofstring;

import java.util.Scanner;

public class MainClass
{	

	private static Scanner scanner = new Scanner(System.in);;
	

	static String variables = "";
	static double[] values = new double[100];
	static String[] equations = new String[100];
	static double[] answer = new double[100];
	
	
	static int Operator_Precedance(char operator)
	{
		int precedance = 0;
		
		if (operator == '+' || operator == '-')
		{
			precedance = 5;
		}
		else if (operator == '*' || operator == '/')
		{
			precedance = 6;
		}
		
		return precedance;
	}
	
	
	static String infixToPostfix(String infix)
	{
		
		String stack = "", postfix = "";
		int i = 0, top = -1;
		
		
		for (i = 0; i < infix.length(); i++)
		{
			//System.out.println(infix.charAt(i));
			
			if(infix.charAt(i) >= 'A' && infix.charAt(i) <= 'Z' || infix.charAt(i) >= 'a' && infix.charAt(i) <= 'z')
			{
				postfix = postfix+infix.charAt(i);
			}
			else if(infix.charAt(i) == ' ')
				continue;
			else
			{
				
				if (top == -1 || Operator_Precedance(infix.charAt(i)) > Operator_Precedance(stack.charAt(top)))
				{
					//push
					top++;
				//	stack.replace(infix.charAt(top), infix.charAt(i));
					
				//	stack = stack+infix.charAt(i);
					
					stack = new StringBuilder(stack).insert(top, infix.charAt(i)).toString(); // This Line is to insert a character in a specific position
				}
				else
				{
					//pop
		 			postfix = postfix+stack.charAt(top);
					top--;
					i--;
				}
			}
			
		}
		
		for (; top > -1; top--)
		{
			postfix = postfix+stack.charAt(top);
		}
		
		return postfix;
		
	}
	
	
	
	
	//----------Calculation Part----------------
	
	public static double Calculate(double num1, char operator, double num2)
	{
		double ans = 0;
		
		switch (operator)
		{
		case '+':
			ans = num1+num2;
			break;
		case '-':
			ans = num1-num2;
			break;
		case '*':
			ans = num1*num2;
			break;
		case '/':
			ans = num1/num2;
			break;
		default:
			break;
		}
		
		return ans;
	}
	
	public static double gettingValue(char variable)
	{
		double value = 0;
		for (int i = 0; i < variables.length(); i++)
		{
			if (variables.charAt(i) == variable)
			{
				return values[i];
			}
		}
		
		return value;

	}
	
	public static double CalculateSorolOnko(String sorolOnko)
	{
		String postfixSorolOnko = infixToPostfix(sorolOnko);
		double ans = 0;
		double[] stack = new double[100];
		int top = -1;
		
		//Main Calculation Code
		
		for (int i = 0; i < postfixSorolOnko.length(); i++)
		{
			if(postfixSorolOnko.charAt(i) >= 'A' && postfixSorolOnko.charAt(i) <= 'Z' || postfixSorolOnko.charAt(i) >= 'a' && postfixSorolOnko.charAt(i) <= 'z')
			{
				stack[++top] = gettingValue(postfixSorolOnko.charAt(i));
			}
			else if(postfixSorolOnko.charAt(i) == ' ')
				continue;
			else
			{
				stack[top-1] = Calculate(stack[top-1], postfixSorolOnko.charAt(i), stack[top]);
				top--;
			}
		}
		
		if (top == 0)
		{
			ans = stack[top];
		}
		
		
		return ans;
	}

	public static void main(String[] args)
	{
		System.out.print("Number Of Variables:  ");
		int NumberOfVariables = scanner.nextInt();
		
		int i;
		
		
		System.out.println("Enter Variable Names(One Letter):");
		for (i = 0; i <= NumberOfVariables; i++)
		{
			variables = variables + scanner.nextLine();
		}
		
		System.out.println("Enter Values:");
		for (i = 0; i < NumberOfVariables; i++)
		{
			System.out.print(variables.charAt(i)+" = ");
			values[i] = scanner.nextDouble();
		}
		
		
		System.out.print("Number Of Equations:  ");
		int NumberOfEquation = scanner.nextInt();
		
		
		System.out.println("Enter Equations:");
		for (i = 0; i <= NumberOfEquation; i++)
		{
			if(i!=0)
				System.out.print((i)+". ");
			equations[i] = scanner.nextLine();
		}
		
		
		
		for (i = 1; i <= NumberOfEquation; i++) {
			answer[i] = CalculateSorolOnko(equations[i]);
		}
		
		System.out.println("\n\n\n");
		for (i = 1; i <= NumberOfEquation; i++) {
			System.out.println("Answer Of Equation "+(i)+" = "+answer[i]);
		}
	}


}
//-----------Sample Input--------------

/*
Number Of Variables:  4
Enter Variable Names(One Letter):
a
d
e
f
Enter Values:
a = 58
d = 98
e = 74
f = 4.0
Number Of Equations:  2
Enter Equations:
1. a+d+e+f
2. a*d/e+f*a



//-----------Sample Output-------------

Answer Of Equation 1 = 234.0
Answer Of Equation 2 = 308.81081081081084

*/

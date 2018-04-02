/*
 * CPSC 2800 -- 46267
 * 10/27/16
 * Project 4-1 
 * by Izabella Arredondo -- CBZ848
 * 
 * This program decomposes a virtual address input 
 * into a page number and offset within page. 
 */

import java.util.Scanner;

public class decompVirtualAddress {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int pgNum;		// page number
		int offset;		// offset
		
		System.out.println("Please enter the system page size: "  );
		double pgSize = in.nextDouble();	// page size input
		double minPS = Math.pow(2, 9);		// minimum page size = 512
		double maxPS = Math.pow(2, 14);		// maximum page size = 16284
		
		
		System.out.println("Please enter the virtual address: ");
		double vrAddress = in.nextDouble();		// virtual address input
		double minVA = 0;						// minimum address = 0
		double maxVA = Math.pow(2, 32) - 1;		// maximum address = 4294967295
		
		// check that both inputs are within bounds
		if(pgSize >= minPS && pgSize <= maxPS && vrAddress >= minVA && vrAddress <= maxVA)
		{
			pgNum = (int) (vrAddress / pgSize);		// page number is whole # quotient of address and size
			offset = (int) (vrAddress % pgSize);	// offset is whole # remainder of quotient	
			
			System.out.println("This address is in virtual page: \n" + pgNum);	// print page number
			System.out.println("At offset: \n" + offset);						// print offset
		}
		if(pgSize < minPS || pgSize > maxPS)		// out of bound page size with error message
		{
			System.out.println("The page size must be between 512 and 16284, inclusive. ");
		}
		if(vrAddress < minVA || vrAddress > maxVA)	// out of bound address with error message
		{
			System.out.println("The virtual address must be between 0 and 4294967295, inclusive.");
		}
		in.close();
	}
}

//Matthew Wright
// Theatre Seats
// This program is designed to allow a customer to purchase a theatre seat
// by choosing either the seat or the price of the ticket. It will update the
// available seats after each purchase and contains input validation.


import java.util.Scanner; // Importing a Scanner class to use a Scanner object.

public class TheatreSeats 
{
	static int count = 0; //Creating a static variable of integer data type called count.
	// Count is static so it can be used in all methods. Count counts the amount of times
	// a ticket has been purchased.
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner (System.in); // Creating a Scanner object named "keyboard".
		// 2D seats array initialization.
	      int[][] seats = { { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
				{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
				{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
				{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
				{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
				{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
				{ 20, 20, 30, 30, 40, 40, 30, 30, 20, 20 },
				{ 20, 30, 30, 40, 50, 50, 40, 30, 30, 20 },
				{ 30, 40, 50, 50, 50, 50, 50, 50, 40, 30 } };
	      
	      boolean repeat = true; // Creating a boolean called repeat that is true.
	      
	      while (repeat) // This code will run as long as repeat is true.
	    	  // Note that repeat will always be true, making this an endless loop.
	    	  // This is okay seeing as this code designed to never stop iterating. 
	      {
	      System.out.println("\t\t\tSEATS"); // Title for the table.
	      
	      System.out.println("        A   B   C   D   E   F   G   H   I   J");
	      // Giving each column a title to organize the seats.
	     
	      for (int i = 0; i < seats.length; i++) // This nested for loop prints the seats array.
	    	  //It shows both the location and the price of each seat.
		{
	    	  System.out.print("Row " + (seats.length - i) + "  "); // Title for the Rows.
			for (int j = 0; j < seats[i].length; j++)
			{
				if (seats[i][j] == 0) 
				// This if statement prints an "XX" if the value of the seats is 0,
				//showing that this seat is taken.
					System.out.print("XX  ");
				else // Prints the value of the seat.
				System.out.print(seats[i][j] + "  ");
			}
			System.out.println(); // Advances the cursor to the next line.
		}
	      if (count == 0) 
	      // This code will only run on the first iteration as count increases each iteration.
	      {
	      System.out.println("\nThe above is a bird's eye view of all the seating available at "
	      		+ "Corpus Christi Theatre for the Arts. Row 1 is \nclosest to the stage while "
	      		+ "row 9 represents the back of the theatre. You can either choose a seat by "
	      		+ "entering \nthe row and seat letter, or you can choose a seat by entering a "
	      		+ "price.");
	      // This next greets the user and explains what the program does and how it should be used.
	      }
	      choice(seats); 
	      // The choice method is called and the seats array is sent to the choice method. 
	      }

	}

	public static void choice(int [][] seats) // Method title
	{
		Scanner keyboard = new Scanner (System.in);
		// Creating a Scanner object named "Keyboard". This must be done in every method 
		// that involves user input.
		
		int choice = 0; 
		// Creating an variable choice of integer data type and assigning it a value of zero.
		
		System.out.println("\nEnter 1 to choose by seat or 2 to choose by price:");
		// Instructs the user to select their method of purchasing a ticket.
		
	    choice = keyboard.nextInt(); // This line collects the user's input.
	    
	      while (choice != 1 && choice != 2) // Input validation loop.
	      {
	    	  System.out.println("That is not a valid number, please enter either 1 or 2:");
	    	  choice = keyboard.nextInt();
	    	  // This code will iterate until a valid number is chosen.
	      }
	      if (choice == 1) // Code that runs if the user chooses to choose their ticket by seat.
	      {
	    	 bySeat(seats); // Calls the bySeat method and sends the array "seats" to this method.  
	      }
	      if (choice == 2) // Code the runs if the user chooses to choose their ticket by price.
	      {
	    	  byPrice(seats);//  Calls the byPrice method and sends the array "seats" to this method.
	      }
		
	}

	public static void bySeat(int [][] seats) // Method Title.
	{
		Scanner keyboard = new Scanner (System.in); 
		// Creating a Scanner object named "keyboard".
		
		boolean input = false;  
		//Creating a variable of boolean data type called input that is initialized as false.
		
		System.out.println("Enter row:"); 
		// Instructs the user to input the row they wish to buy from.
   	 
		int row = keyboard.nextInt(); 
		// Creates a variable row and initializes it with the user's input.
		
   	  	while (row < 1 || row > 9) // Input validation loop.
	      {
	    	  System.out.println("That is not a valid row, please choose a number from 1 to 9");
	    	  row = keyboard.nextInt();
	    	  // This code will run until a valid row is chosen.
	      }
   	  	
   	  	System.out.println("Enter seat:"); 
   	  	//Instructs the user to input the seat they wish to buy.
   	  	
   	  	String seat; // Creates a String object named seat.
   	  	
   	  	seat = keyboard.next(); // seat is initialized with the user's next line of input.
   	  	
   	  	while (!input) // Input validation loop.
   	  	{
   	  		if (seat.equals("A") || seat.equals("B") || seat.equals("C") || seat.equals("D")
   	  		|| seat.equals("E") || seat.equals("F") || seat.equals("G") || seat.equals("H")
   	  		|| seat.equals("I") || seat.equals("J"))
	      {
	    	  input = true; 
	    	  // Changes the boolean input to true and ends the loop as the input is valid.
	      }
   	  		else 
   	  		{
   	  			System.out.println("That is not a valid seat, please choose a seat from A to J:");
   	  			seat = keyboard.next();
   	  			// Does not end the loop. This loop will run until valid input is chosen.
   	  		}
   	  	}
   	  	
   	  	int seatNumber = -1; 
   	  	// Creates an integer named seatNumber and initializes it with a value of -1.
   	  	
   	  	switch (seat) 
   	  	// Switch statement that assigns every possibility of seat a corresponding number value.
   	  	{
   	  		case "A": // Assigns case A a value of 0.
   	  		seatNumber = 0;
   	  		break;
   	  		
   	  		case "B": // Assigns case B a value of 1.
   	  		seatNumber = 1;
   	  		break;
   	  		
   	  		case "C": // Assigns case C a value of 2.
   	  		seatNumber = 2;
   	  		break;
   	  		
   	  		case "D": // Assigns case D a value of 3.
   	  		seatNumber = 3;
   	  		break;
   	  		
   	  		case "E": // Assigns case E a value of 4.
   	  		seatNumber = 4;
   	  		break;
   	  		
   	  		case "F": // Assigns case F a value of 5.
   	  		seatNumber = 5;
   	  		break;
   	  		
   	  		case "G": // Assigns case G a value of 6.
   	  		seatNumber = 6;
   	  		break;
   	  		
   	  		case "H": // Assigns case H a value of 7.
   	  		seatNumber = 7;
   	  		break;
   	  		
   	  		case "I": // Assigns case I a value of 8.
   	  		seatNumber = 8;
   	  		break;
   	  		
   	  		case "J": // Assigns case J a value of 9.
   	  		seatNumber = 9;
   	  		break;
   	  }
   	  	
   	  if (seats[seats.length-row][seatNumber] == 0)
   	  // Code that runs if the seat chosen's value is zero 
   	  //i.e. the seat is "taken"/ already purchased.
   	  {
   		  System.out.println("This seat is taken, please try again");
   		  choice(seats);
   		  // Informs the user that the seat they have chosen is already taken and
   		  // sends the user back to the choices method to choose their method of selection.
   	  }
   	  else
   	  seats[seats.length-row][seatNumber] = 0; 
   	  count++;
   	  // Assigns the seat they have chosen a value of zero and adds one to the variable count.
	}
	
	public static void byPrice(int[][] seats)
	{
		Scanner keyboard = new Scanner (System.in);
		// Creating a Scanner object named "keyboard".
		
		boolean end = false; 
		//Creating a variable of boolean data type called end that is initialized as false.
		
		int price; // Creating a integer variable called price.
		
		System.out.println("Enter a price (10, 20, 30, 40, or 50):");
		// Instructs the user to enter the price they are willing to pay for their ticket.
		
		price = keyboard.nextInt(); // Assigns the user's input the the variable price
		
		while (price != 10 && price != 20 && price != 30 && price != 40 && price != 50)
		{
			System.out.println("That is not a valid price, please enter (10, 20, 30, 40, or 50):");
			price = keyboard.nextInt();
			// This is an input validation loop that ensures the user has chosen a valid price
			// and will iterate until a valid price is chosen.
		}
		
		String seat = "Z"; 
		// Creating a String object called seat and assigning it the letter Z.
		// The letter Z is trivial but the String needs to be filled for the 
		// code to run without an error.

		for (int i = 0; i < seats.length && !end; i++) 
		// This loop runs to ensure each row of seats is being checked to see if it
		// contains a seat that is the price the user requested. If it does not, it will
		// check the next row.
		{
			for (int j = 0; j < seats[i].length; j++)
			// This loop checks each seat in the row to see if they are the price the user
			// requested.
			{
				if (seats[i][j] == price) 
				// This code will run if the seat is priced how the user requested.
				{
					switch (j) 
					// This switch statement will determine the seat letter of the ticket
					// the user has purchased. It will then fill the String seat with the 
					// letter that matches the seat the user has purchased. 
				   	  {
				   	  case 0: // Assigns seat a value of A for case 0.
				   		  seat = "A";
				   		  break;
				   	  case 1: // Assigns seat a value of B for case 1.
				   		  seat = "B";
				   		  break;
				   	  case 2: // Assigns seat a value of C for case 2.
				   		  seat = "C";
				   		  break;
				   	  case 3: // Assigns seat a value of D for case 3.
				   		  seat = "D";
				   		  break;
				   	  case 4: // Assigns seat a value of E for case 4.
				   		  seat = "E";
				   		  break;
				   	  case 5: // Assigns seat a value of F for case 5.
				   		  seat = "F";
				   		  break;
				   	  case 6: // Assigns seat a value of G for case 6.
				   		  seat = "G";
				   		  break;
				   	  case 7: // Assigns seat a value of H for case 7.
				   		  seat = "H";
				   		  break;
				   	  case 8: // Assigns seat a value of I for case 8.
				   		  seat = "I";
				   		  break;
				   	  case 9: // Assigns seat a value of J for case 9.
				   		  seat = "J";
				   		  break;
				   	  }
					System.out.println("Your seat is row " + (seats.length-i) + 
							" seat " + seat);  
					// Informs the buyer what seat they have purchased.
					
					seats[i][j] = 0; 
					// Assigns the seat they have purchased a value of zero. 
					end = true; // Makes the end boolean true to stop the loop.
					count++; // Adds one to the variable count.
					break; // breaks the loop thus ending the method.
				}
			}
		}
	}		
}

	


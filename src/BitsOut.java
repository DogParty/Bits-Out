import java.util.Scanner;

public class BitsOut {

	public static void main(String[] args){
		System.out.println("Welcome to Bits Out!");
		System.out.println("  yes, it's ASCII.. ");
		int board = 386320; //Set up original board.  Bit pattern of 386320 is our board!
		playGame(board);
	}

	private static void playGame(int board) {
		Scanner sc = new Scanner(System.in);
		while (true){
			displayScreen(board); //Render the board
			System.out.println("\nEnter button: [0-24]: ");
			int in = sc.nextInt();
			board = flipBits(board, in);  //Flip the bits and refresh the board
			if (board == 0) //Board would be completed if it were empty, so winner!
				break;
		}
		System.out.println("CONGRATS!");
	}

	private static int flipBits(int board, int in) {
		int masks[] = {35, 71, 142, 284, 536, 1121, 2274, 4548, 9096, 17168, 35872, 72768, 145536, 291072, 549376, 1147904, 2328576, 4657152, 9314304, 17580032, 3178496, 7405568, 14811136, 29622272, 25690112}; //Set an array with the bit patterns that would be flipped for each button press
		return (board ^ masks[in]); //xor to twiddle the bits!
	}

	private static void displayScreen(int board) {
		int mask = 0; //instantiate outside of loop for more optimization
		for (int x = 0; x < 25; ++x){
			mask = (int) java.lang.Math.pow ( 2, x); //mask is 2^x
			if (x % 5 == 0) //returns a new line for the new row on board
				System.out.println();
			System.out.print(" " + (int)(((board & mask) == mask)? 1 : 0) + " "); //Outputs a 1 if the current bit is on, 0 if not.
		}
	}
}
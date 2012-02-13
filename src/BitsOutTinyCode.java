import java.util.Scanner;
public class BitsOut {
	public static int masks[] = {35, 71, 142, 284, 536, 1121, 2274, 4548, 9096, 17168, 35872, 72768, 145536, 291072, 549376, 1147904, 2328576, 4657152, 9314304, 17580032, 3178496, 7405568, 14811136, 29622272, 25690112};
	public static void main(String[] args){
		System.out.println("Welcome to Bits Out!");
		int board = 386320;
		playGame(board);
	}
	private static void playGame(int board) {
		Scanner sc = new Scanner(System.in);
		while (true){
			displayScreen(board);
			System.out.println("\nEnter button: [0-24]: ");
			int in = sc.nextInt();
			board = flipBits(board, in);
			if (board == 0) break;
		}
		System.out.println("CONGRATS!");
	}
	private static int flipBits(int board, int in) {
		return (board ^ masks[in]);
	}
	private static void displayScreen(int board) {
		int mask = 0;
		for (int x = 0; x < 25; ++x){
			mask =  (int) java.lang.Math.pow ( 2, x); //mask is 2^x
			if (x % 5 == 0) System.out.println();
			System.out.print(" " + (((board & mask) == mask)? 1 : 0) + " ");
		}
	}
}
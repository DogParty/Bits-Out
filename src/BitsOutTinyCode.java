import java.util.Scanner;
public class BitsOut {
	public static int a[]={35,71,142,284,536,1121,2274,4548,9096,17168,35872,72768,145536,291072,549376,1147904,2328576,4657152,9314304,17580032,3178496,7405568,14811136,29622272,25690112};
	public static void main(String[] args){
		System.out.println("Welcome!");
		p();
	}
	private static void p() {
		Scanner k=new Scanner(System.in);
		int b=386320;
		while (true){
			d(b);
			System.out.println("\nEnter button [0-24]: ");
			int i=k.nextInt();
			b=f(b,i);
			if (b==0) break;
		}
		System.out.println("!");
	}
	private static int f(int b,int i) {
		return (b^a[i]);
	}
	private static void d(int b) {
		int c=0;
		for (int x=0;x<25;++x){
			c=(int) java.lang.Math.pow (2,x);
			if (x % 5 == 0) System.out.println();
			System.out.print(" "+(((b&c)==c)?1:0)+" ");
		}
	}
}
import java.util.Scanner;
public class BitWiseTTT {

	/*
	 * Hour of Code Every Week #1
	 * 10/3/2016
	 */
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		short a = 0;
		short b = 0;
		
		boolean wincondition = false;
		breakloop:
		while(wincondition == false){
			for(int p = 1; p < 3; p++){
				for(int i = 0; i < 3; i++){
					for(int q = 0; q < 3; q++){
						String temp;
						if((a | (int)Math.pow(2, ((double)i * 3) + q)) == a){
							temp = "X";
						}
						else if((b | (int)Math.pow(2, ((double)i * 3) + q)) == b){
							temp = "O";
						}
						else{
							temp = ".";
						}
						if(q == 2){
							System.out.println(temp);
						}
						else System.out.print(temp);
					}
				}
				
				System.out.println("Player " + p + " place at? (1 is top left, moves right then down)");
				short in;
				while(true){
					in = (short)(sc.nextShort() - 1);
					if((short) (b | (short)Math.pow(2, in)) == b || (short) (a | (short)Math.pow(2, in)) == a || in > 8){
						System.out.println("INVALID MOVE: Input again");
					}
					else break;
				}
				if(p == 1)a = (short) (a | (short)Math.pow(2, in));
				else b = (short) (b | (short)Math.pow(2, in));
				
				//Check for 3 in a rows
				for(int i = 0; i < 3; i++){
					if(((a | (short)Math.pow(2, i)) == a)  &&  ((a | (short)Math.pow(2, i + 3)) == a)  &&  ((a | (short)Math.pow(2, i + 6)) == a)){
						System.out.println("GAME OVER: Player One Wins");
						break breakloop;
					}
					else if(((b | (short)Math.pow(2, i)) == b)  &&  ((b | (short)Math.pow(2, i + 3)) == b)  &&  ((b | (short)Math.pow(2, i + 6)) == b)){
						System.out.println("GAME OVER: Player Two Wins");
						break breakloop;
					}
				}
				for(int i = 0; i < 7; i+=3){
					if(((a | (short)Math.pow(2, i)) == a)  &&  ((a | (short)Math.pow(2, i + 1)) == a)  &&  ((a | (short)Math.pow(2, i + 2)) == a)){
						System.out.println("GAME OVER: Player One Wins");
						break breakloop;
					}
					else if(((b | (short)Math.pow(2, i)) == b)  &&  ((b | (short)Math.pow(2, i + 1)) == b)  &&  ((b | (short)Math.pow(2, i + 2)) == b)){
						System.out.println("GAME OVER: Player Two Wins");
						break breakloop;
					}
				}
				if(((a | (short)Math.pow(2, 0)) == a)  &&  ((a | (short)Math.pow(2, 4)) == a)  &&  ((a | (short)Math.pow(2, 8)) == a)){
					System.out.println("GAME OVER: Player One Wins");
					break breakloop;
				}
				if(((a | (short)Math.pow(2, 2)) == a)  &&  ((a | (short)Math.pow(2, 4)) == a)  &&  ((a | (short)Math.pow(2, 6)) == a)){
					System.out.println("GAME OVER: Player One Wins");
					break breakloop;
				}
				
				if(((b | (short)Math.pow(2, 0)) == b)  &&  ((b | (short)Math.pow(2, 4)) == b)  &&  ((b | (short)Math.pow(2, 8)) == b)){
					System.out.println("GAME OVER: Player Two Wins");
					break breakloop;
				}
				if(((b | (short)Math.pow(2, 2)) == b)  &&  ((b | (short)Math.pow(2, 4)) == b)  &&  ((b | (short)Math.pow(2, 6)) == b)){
					System.out.println("GAME OVER: Player Two Wins");
					break breakloop;
				}
				
				if(a + b == 511){
					System.out.println("GAME OVER: Draw");
					break breakloop;
				}
			}
		}
		
		// Last print
		
		for(int i = 0; i < 3; i++){
			for(int q = 0; q < 3; q++){
				String temp;
				if((a | (int)Math.pow(2, ((double)i * 3) + q)) == a){
					temp = "X";
				}
				else if((b | (int)Math.pow(2, ((double)i * 3) + q)) == b){
					temp = "O";
				}
				else{
					temp = ".";
				}
				if(q == 2){
					System.out.println(temp);
				}
				else System.out.print(temp);
			}
		}
		sc.close();
	}
}

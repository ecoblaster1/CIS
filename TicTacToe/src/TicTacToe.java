import java.util.* ;

public class TicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		//Assign the players
		String player1,player2;
		System.out.print("What is your name Player 1(X)?");
		player1 = scan.nextLine();
		System.out.print("What is your name Player 2(O)?");
		player2 = scan.nextLine();
		
		//Create the board using a double array
		char[][] board = new char[3][3];
		
		//Fill the board with dashes
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}
		
		//Track players turn
		boolean isPlayer1 = true;
		
		//Track game
		boolean gameEnded = false;
		
		
		while(!gameEnded) {
		//Draw the board
		drawBoard(board);		
		
		//Track the symbol used
		char symbol = ' ';
		if (isPlayer1) {
			symbol = 'X' ;}
			else {
				symbol = 'O';
			}
		
		//Print out players turn 
		if(isPlayer1) {
			System.out.print(player1 + "'s turn (X)");
		} else {
			System.out.print(player2 + "'s turn (O)");
		}
		
		
		//Get position from player
		int row = 0;
		int col = 0;
		
		while(true) {
			
			System.out.print("Enter a row #(0, 1, or 2)");
			row = scan.nextInt();
			System.out.print("Enter a column #(0, 1, or 2)");
			col = scan.nextInt();
			
			if (row < 0 || col < 0 || row > 2 || col >2) {
				System.out.print("Those numbers aren't on the board :(");
			} else if (board[row][col] != '-') {
				System.out.print("That space has already been claimed");
			} else {
				break;
			}
			}
		
		board[row][col] = symbol;		
		
		if (hasWon(board) == 'X') {
			System.out.println(player1 + " has won!");
			gameEnded = true;
		}else if (hasWon(board) =='O') {
			System.out.println(player2 + " has won!");
			gameEnded = true;
		}else {
			if(hasTied(board)) {
				System.out.println("Its a tie!");
			}
			else {
				isPlayer1 = !isPlayer1;
			}
		}
		}
	
		drawBoard(board);
	}
	
	
	
	//Print out the board
	public static void drawBoard(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j =0; j < 3; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	//Continously checks win conditions 
	public static char hasWon(char[][] board) {
		
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
				return board[i][0];
			}
		}
		
		for (int j = 0; j < 3; j++) {
			if (board[0][j] == board[0][j] && board[0][j] == board[0][j] && board[0][j] != '-') {
				return board[0][j];
			}
		}
		
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
			return board[2][0];
		}
		
		if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
			return board[2][0];
		}
		return '-';
	}
	public static boolean hasTied(char[][] board) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[i][j] == '-') {
					return false;
				}
			}
		}
		return true;
	}
}

package main;

public class Helper {
	
	
	
	
	public static void generate() {
		
		int emptyCount = 0;
		
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				
				int val = Game.board[row][col];
				
				if (val == 0) {
					
					emptyCount++;
					
				
					int roll = (int) (Math.random() * 100);
					
					if ( roll > 10) {
						Game.board[row][col] = 2;
						return;
					} else {
						emptyCount++;
					}
						
					
				// end of val being zero check 
				}
				
			}
		}
		
		if ( emptyCount == 0) {
			System.out.println("\n!!!  GAME OVER!!!!" );
		}
		
		
	// end of the generate method
	}
	
	
	
	public static void shiftLeft() {
		
		for (int row = 0; row < 4; row++) {
			
			for (int col = 3; col >= 1; col--) {
				
				int first = Game.board[row][col];
				
				int second = 0;
				
				
				try {
					
					second = Game.board[row][col  - 1];
					
					if (first != 0 && first == second) {
						Game.board[row ][col - 1 ] = first << 1;
						Game.board[row][col] = 0;
					}  else if (first != 0 && second == 0) {
						
						Game.board[row ][col - 1 ] = first;
						Game.board[row][col] = 0;
						
					}
					
					
				} catch (Exception e) {
					
					continue;
				}
				
			}
			
			
		// end of the outer for loop
		}
		
		
	// end of shiftLeft 
	}
	
	
	
	public static void shiftUp() {
		
		for ( int row = 3; row >= 1; row --) {
			
			for (int col = 0; col < 4; col++) {
				
				
				int first = Game.board[row][col];
				
				int second = 0;
				
				
				try {
					
					second = Game.board[row - 1][col ];
					
					if (first != 0 && first == second) {
						Game.board[row - 1][col ] = first << 1;
						Game.board[row][col] = 0;
					} else if (first != 0 && second == 0) {
						
						Game.board[row - 1][col ] = first;
						Game.board[row][col] = 0;
						
					}
					
					
				} catch (Exception e) {
					
					continue;
				}
	
	
				
			}
		}
		
		
	// end of the shiftUp method
	}
	
	
	
	public static void shiftDown() {
		
		for (int row = 0; row < 4; row++) {
			
			
			for (int col = 0; col < 4; col++) {
				
			
				int first = Game.board[row][col];
				
				int second = 0;
				
				try {
					
				
					
					second = Game.board[row + 1][col ];
					
					if (first != 0 && first == second) {
						Game.board[row + 1][col ] = first << 1;
						Game.board[row][col] = 0;
					} else if (first != 0 && second == 0){
						
						Game.board[row + 1][col ] = first;
						Game.board[row][col] = 0;
						
					}
					
					
				} catch (Exception e) {
					
					continue;
				}
				
				
			// end of the inner loop
			}
			
		// end of the outer loop	
		}
		
		
	// end of the shiftRight method
	}
	
	
	
	
	public static void shiftRight() {
		
		for (int row = 0; row < 4; row++) {
			
			
			for (int col = 0; col < 4; col++) {
				
			
				int first = Game.board[row][col];
				
				int second = 0;
				
				try {
					
				
					
					second = Game.board[row][col + 1];
					
					if (first != 0 && first == second) {
						Game.board[row][col + 1] = first << 1;
						Game.board[row][col] = 0;
					}  else if (first != 0 && second == 0) {
						
						Game.board[row][col + 1] = first;
						Game.board[row][col] = 0;
						
					}
					
					
				} catch (Exception e) {
					
					continue;
				}
				
				
			// end of the inner loop
			}
			
		// end of the outer loop	
		}
		
		
	// end of the shiftRight method
	}
	
	
	
	
	
	
	
// end of the Helper class 
}

package main;

public class RGBA {
	
	int r, g, b, a;
	
	// this will make it capable of storing row column information...
	int row, col;
	
	public RGBA(int r, int g, int b, int a) {
		
		// alpha of  255 is completely opaque
		// alpha of zero is totally transparent
		
		this.r = r;
		this.g = g; 
		this.b = b;
		this.a = a; 
	}
	
	public void setRowCol(RGBA[][] arr, int row, int col) {
		
		arr[row][col] = this;
		
		this.row = row; 
		this.col = col;
	}
	
// end of the RGBA class 
}

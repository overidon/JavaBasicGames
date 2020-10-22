package main;

import java.awt.Color;

public class Colors {
	
	public static final Color  c_olive  = new Color(0, 100, 20);
	public static final Color  c_juice  = new Color(200, 12, 120);
	public static final Color  c_jazz   = new Color(181, 54, 255);
	public static final Color  c_sauce  = new Color(40, 89, 7);
	public static final Color  c_mint   = new Color(44, 189, 120);
	public static final Color  c_jelly  = new Color(184, 76, 255);
	public static final Color  c_eels   = new Color(4, 16, 3);
	public static final Color  c_snow   = new Color(243, 247, 255);
	
	//                                  0         1       2      3         4        5      6       7        8       9       10
	public static String[] c_names = {"Eels", "White", "Red", "Mint", "Green", "Cyan", "Olive", "Juice", "Jazz", "Sauce", "Snow"};
	//                                   0           1          2
	public static Color[] colors = {c_eels, Color.white, Color.RED, 
			//                             3         4         5     
									    c_mint, Color.GREEN, Color.CYAN,
			//                       6             7         8        9      10
									c_olive,    c_juice,  c_jazz, c_sauce, c_snow};

}

/*
 * This is the code for problem1
 * @Xin He
 * 
 */

public class Swoosh {
	public static void drawSwoosh(int width){

		// if the width is less than 6, there is no meaning to use pixel to form the swoosh
		if(width < 6) return;

		// was thinking do we need a 2D array since we can print without waste the space
		// however this is for potential use of the pictures on the website, so I decide give it an array
		char[][] swoosh = new char[width][width / 2];
		
		for(int j = 0; j < width / 2; j++){
			for(int i = 0; i < width; i++){
				// test if the pixel is in the oval area and left than the parabolas area
				if(isInOval(i, j, width) && isLeftParabola(i, j , width)){
					swoosh[i][j] = '*';
				}

				//when pixels are too few, in case to form a full picture, force to fill one row
				else if(width < 10 && j == (int)(3 / 16.0 * width)) swoosh[i][j] = '*';

				//other pixels
				else swoosh[i][j] = '-';
				System.out.print(swoosh[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	//the function test if the given pixel is in the oval area with the given width
	public static boolean isInOval(int i, int j, int width){
		//since oval is curved, change data type to double to calculate precisely
		//both x and y coordinates shift half unit 
		double x = (double)i + 0.5;
		double y = (double)j + 0.5;
		double a = (double)width / 2;
		double b = (double)width / 4;

		//do the division first for the potential overflow
		if((x - a) / a * (x - a) / a + (y - b) / b * (y - b) / b < 1.1) return true;

		else return false;
	}
	
	//the function test if the given pixel is left to the parabolas area with the given width
	public static boolean isLeftParabola(int i, int j, int width){
		//the top parabola function
		if(j < 3 * width / 8 && 
			i + 0.5 - 3.0 * width / 8 < 
			(160 / 9.0 / width ) * (j + 0.5 - 3.0 * width / 8) * (j + 0.5 - 3.0 * width / 8))

			return true;

		//the bottom parabola function
		else if(i + 0.5 - 3.0 * width / 8 < 
			( 8.0 / width ) * (j + 0.5 - 3 * width / 8) * (j + 0.5 - 3 * width / 8)) 

			return true;

		else return false;
	}
	
}
 
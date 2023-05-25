//Paul Bergeron
//Prog 6
//Due Date and Time:3/1/23 before 10:30
//
//Purpose: creates all required methods for rectangledemo class such as area, drawing rectangles, and perimeter
//Input: rectangle hight, rectangle width, fillstyle
//
//Output: rectangle, outline of rectangle, area,perimeter,height,width,data for rectangles
//Certification of Authenticity: I certify that this lab is entirely my own work
//
//declares the class
public class RectangleBergeron {
	//declares instance variables
	int myWidth;
	int myHeight;
	char myFillStyle;
	
	//gives instance variables their default values
	public RectangleBergeron() {
		myWidth=10;
		myHeight=5;
		myFillStyle='*';
	}//method
	
	//allows the user to assign instance variables their own values
	public RectangleBergeron(int newWidth, int newHight, char newFillStyle) {
		//redefines instance variables as user inputs
		myWidth=newWidth;
		myHeight=newHight;
		myFillStyle=newFillStyle;
	}//methods
	
	//sets height of rectangle
	public void setHeight(int newHight)
	{ myHeight=newHight; }//method
	
	//sets the width of the rectangle
	public void setWidth(int newWidth)
	{ myWidth=newWidth; }//methods
	
	//sets the fill style of the rectangle
	public void setFillStyle(char newFillStyle)
	{ myFillStyle=newFillStyle; }//method
	
	//returns the width of rectangle
	public int getWidth()
	{return myWidth;}//method
	
	//returns the height of the rectangle
	public int getHeight()
	{return myHeight;}//method
	
	//returns the fill style of the rectangle
	public char getFillStyle()
	{return myFillStyle;}//method
	
	//prints out data about the rectangle
	public String toString()
	{
	String ans= "The Width of the object is: "+myWidth;
	ans+="\nThe Height of the object is: "+myHeight;
	ans+="\nThe FillStyle of the object is: "+myFillStyle;
	return ans;
	}//method
	
	//calculates the perimeter of the rectangle
	public int calcPerimeter()
	{
		//calculates perimeter and returns it
		int perim=2*(myWidth+myHeight);
		return perim;
	}//method
	
	//calculates the area of the rectangle
	public int calcArea()
	{
		//calculates and returns area
	int area=myHeight*myWidth;
	return area;
	}//method
	
	//creates the rectangle in the chosen fill shape and prints it to the user
	public void drawRectangle()
	{
		for(int i=0;i<myHeight;i++) 
		{
			System.out.print(myFillStyle);
			for(int z=0;z<myWidth-1;z++)
			{
				System.out.print(myFillStyle);
			}//for
			System.out.println();
		}//for
	}//method
	
	//creates an outline of the rectangle in the chosen fill shape and prints it to the user
	public void drawOutline()
	{
		for(int i=0;i<myHeight;i++) 
		{
			System.out.print(myFillStyle);
			for(int z=0;z<myWidth-1;z++)
			{
				if(z==myWidth-2)
					System.out.print(myFillStyle);
				else if(i==0||i==myHeight-1)
					System.out.print(myFillStyle);
				else 
					System.out.print(" ");
			}//for
			System.out.println();
		}//for
	}//method
}//class
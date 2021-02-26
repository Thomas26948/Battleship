package ensta.ship;

public abstract class AbstractShip{
	public char label;
	public String name;
	public int size;
	public Orientation orientation;

	public AbstractShip(char label, String name, int size, Orientation orientation){
		this.label = label;
		this.name = name;
		this.size = size;
		this.orientation = orientation;
	}


	public char getLabel(){
		return this.label;
	}
	public String getName(){
		return this.name;
	}
	public int getSize(){
		return this.size;
	}
	public Orientation getOrientation(){
		return this.orientation;
	}

	public void setLabel(char label){
		this.label = label;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setSize(int size){
		this.size = size;
	}
	public void setOrientation(Orientation orientation){
		this.orientation = orientation;
	}




}
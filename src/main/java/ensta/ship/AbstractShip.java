package ensta.ship;

public abstract class AbstractShip{
	public Character label;
	public String name;
	public int size;
	public Orientation orientation;
	public int strikeCount;

	public AbstractShip(Character label, String name, int size, Orientation orientation){
		this.label = label;
		this.name = name;
		this.size = size;
		this.orientation = orientation;
		this.strikeCount = 0;
	}


	public Character getLabel(){
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

	public void setLabel(Character label){
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


	public void addStrike(){
		this.strikeCount ++;
	}
	public boolean isSunk(){
		return ( this.strikeCount == this.size );
	}

}
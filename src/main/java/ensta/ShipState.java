package ensta;

import ensta.ship.*;


public class ShipState {
	protected AbstractShip ship;
	protected boolean struck;
	protected boolean isShip;


	public ShipState(AbstractShip ship){
		this.ship = ship;
		this.struck = false;
	}
	public ShipState(){
		this.struck = false;
		this.isShip = false;
	}

	public void setIsShip(boolean val){
		this.isShip = val;
	}
	public boolean getIsShip(){
		return this.isShip;
	}

	public void addStrike(){
		if (!this.struck){
			this.ship.addStrike();
		}else{
			System.out.println("Position déjà endommagé.");
		}
		this.struck = true;
	}

	public boolean isStruck(){
		return this.struck;
	}
	

	public String toString(){
		if (isShip){
			if (this.struck){
				return ColorUtil.colorize(this.ship.getLabel().toString() + " ", ColorUtil.Color.RED);
			}
			return  ColorUtil.colorize(this.ship.getLabel().toString() + " ", ColorUtil.Color.GREEN);
		}else{
			return ColorUtil.colorize(". ", ColorUtil.Color.WHITE);
	}


	}

	public boolean isSunk(){
		return (this.ship.getSize() == this.ship.strikeCount);
	}

	public void setShip(AbstractShip ship){
		setIsShip(true);
		this.ship = ship;
	}

	public AbstractShip getShip(){
		return this.ship;
	}


}
package ensta;

import ensta.ship.*;


public class Board implements IBoard{
	private String name;
	private ShipState[][] navires;
	private Boolean[][] frappes;


	public Board(String name,int N){
		this.name = name;
		this.navires = new ShipState[N][N];
		this.frappes = new Boolean[N][N];
		for ( int i = 0 ; i < N ; i++ ){
			for ( int j = 0 ; j < N ; j++ ){
				this.navires[i][j] = new ShipState();
				this.navires[i][j].setIsShip(false);
				this.frappes[i][j] = null;
			}
		}
	}	

	public Board(String name){
		this.name = name;
		this.navires = new ShipState[10][10];
		this.frappes = new Boolean[10][10];
		int N = 10;
		for ( int i = 0 ; i < N ; i++ ){
			for ( int j = 0 ; j < N ; j++ ){
				this.navires[i][j] = new ShipState();
				this.frappes[i][j] = null;
			}
		}
	}

	public String getName(){
		return this.name;
	}

	public ShipState[][] getNavires(){
		return this.navires;
	}
	public Boolean[][] getFrappes(){
		return this.frappes;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setNavires(ShipState[][] navires){
		this.navires = navires;
	}

	public void setFrappes(Boolean[][] frappes){
		this.frappes = frappes;
	}

	public int getSize(){
		return this.navires.length;
	}


	public boolean canPutShip(AbstractShip ship, int x, int y){
		int[] coef = getCoef(ship);
		int a = coef[0];
		int b = coef[1];
		int n = this.navires.length;
		if( (x + b * (ship.size -1)) > n-1 || (y + a * (ship.size -1)) > n -1|| (x + b * (ship.size -1)) < 0 || (y + a * (ship.size -1)) < 0 ){
			return false;
		}else{

			for (int i = 0; i < ship.size ; i++){
				for (int j = 0 ; j < ship.size ; j++){
					if (this.navires[x + b*i][y + a*j].getIsShip()){
						return false;
					}
				}	
			}
			return true;
		}
	}

	/**
     * Permet d'obtenir des coefficients pour se balader dans le tableau avec la direction du navire
     *
     */
	public int[] getCoef(AbstractShip ship) {
    	int[] coef = new int[2];
		int a = 0;
		int b = 0;
		switch(ship.orientation){
			case WEST:
				a = -1;
				b = 0;
				break;
			case NORTH:
				a = 0;
				b = -1;
				break;
			case SOUTH:
				a = 0;
				b = 1;
				break;
			case EAST:
				a = 1;
				b = 0;
				break;
		}
    	coef[0] = a;
    	coef[1] = b;
    	return coef;
	}

	public void putShip(AbstractShip ship, int x, int y){
		boolean canPut = canPutShip(ship,x,y);
		int[] coef = getCoef(ship);
		int a = coef[0];
		int b = coef[1];
		if (canPut){
			for (int i = 0; i < ship.size ; i++){
			for (int j = 0 ; j < ship.size ; j++){
				this.navires[x + b*i][y + a*j].setShip(ship);
				}
			}	
		}
	}

	public boolean hasShip(int x, int y){
		return this.navires[x][y].getIsShip();


	}

	public void setHit(boolean hit, int x, int y){
		this.frappes[x][y]= hit;
		
	}
	public Boolean getHit(int x, int y){
		return this.frappes[x][y];
	}



	public void print(){
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String newLine = System.getProperty("line.separator");
		int N = navires.length;
		System.out.print("Navires : ");
		for ( int i = 0 ; i < 2*N - 6 ; i++){
			System.out.print(" ");
		}
		System.out.print("Frappes : ");
		System.out.println();

		System.out.print(" ");
		for ( int j = 0 ; j < 2 ; j++){
			for(int i = 0 ; i < N ; i ++){
				System.out.print(" " +alphabet.charAt(i));
			}
			System.out.print("  ");
		}
		
		System.out.println();
		for(int i = 0 ; i < N ; i ++){
			System.out.print(i + " ");
			for ( int k = 0 ; k < 2 ; k++){
				for (int j = 0 ; j < N ; j++){
					if (k == 0 ){
						System.out.print(this.navires[i][j].toString());
						
					}else if ( k == 1){
						if (this.frappes[i][j] == null){
							System.out.print(ColorUtil.colorize(". ", ColorUtil.Color.WHITE));
						}else if (this.frappes[i][j] == false){
							System.out.print(ColorUtil.colorize("X ", ColorUtil.Color.WHITE));
						}else if (this.frappes[i][j] == true){
							System.out.print(ColorUtil.colorize("X ", ColorUtil.Color.RED));
						}
						
					}
				}
				System.out.print("  ");
			}
			
			System.out.println();

		}
	}

	public Hit sendHit(int x, int y){
		if (navires[x][y].getIsShip()){
            this.navires[x][y].addStrike();
            if (navires[x][y].isSunk()){
            	System.out.println("Navire coulé : " + navires[x][y].ship.getName());
                return Hit.fromInt(navires[x][y].getShip().getSize());
            }
            if (navires[x][y].isStruck()){
                return Hit.STRIKE;
            }else{
                return Hit.MISS;
            }
        }else{
            return Hit.MISS;
        }
    }
}


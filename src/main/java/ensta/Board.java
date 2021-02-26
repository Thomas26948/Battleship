package ensta;

import ensta.ship.AbstractShip;
import ensta.ship.Battleship;
import ensta.ship.Carrier;
import ensta.ship.Destroyer;
import ensta.ship.Orientation;
import ensta.ship.Submarine;


public class Board implements IBoard{
	private String name;
	private char[][] navires;
	private boolean[][] frappes;


	public Board(String name,int N){
		this.name = name;
		this.navires = new char[N][N];
		this.frappes = new boolean[N][N];
		for ( int i = 0 ; i < N ; i++ ){
			for ( int j = 0 ; j < N ; j++ ){
				this.navires[i][j] = '.';
				this.frappes[i][j] = false;
			}
		}
	}	

	public Board(String name){
		this.name = name;
		this.navires = new char[10][10];
		this.frappes = new boolean[10][10];
		int N = 10;
		for ( int i = 0 ; i < N ; i++ ){
			for ( int j = 0 ; j < N ; j++ ){
				this.navires[i][j] = '.';
				this.frappes[i][j] = false;
			}
		}
	}

	public String getName(){
		return this.name;
	}

	public char[][] getNavires(){
		return this.navires;
	}
	public boolean[][] getFrappes(){
		return this.frappes;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setNavires(char[][] navires){
		this.navires = navires;
	}

	public void setFrappes(boolean[][] frappes){
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
		if( x + b * (ship.size -1) > n || y + a * (ship.size -1) > n || x + b * (ship.size -1) < 0 || y + a * (ship.size -1) < 0 ){
			return false;
		}
		for (int i = 0; i < ship.size ; i++){
			for (int j = 0 ; j < ship.size ; j++){
				if (this.navires[x + b*i][y + a*j] != '.'){
					System.out.println("Impossible de placer le bateau.");
					return false;
				}
			}
			
		}
		return true;
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
				this.navires[x + b*i][y + a*j] = ship.label;
				}
			}
			
		}

	}

	public boolean hasShip(int x, int y){
		return this.navires[x][y] != '.';

	}

	public void setHit(boolean hit, int x, int y){
		if (hit){
			this.frappes[x][y]= true;
		}
	}
	public Boolean getHit(int x, int y){
		return this.navires[x][y] != '.';
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
						System.out.print(this.navires[i][j] + " ");
					}else if ( k == 1){
						if (this.frappes[i][j] == false){
							System.out.print(". ");
						}else{
							System.out.print("X ");
						}
						
					}
				}
				System.out.print("  ");
			}
			
			System.out.println();

		}
	}

}


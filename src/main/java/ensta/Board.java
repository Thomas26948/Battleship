package ensta;

public class Board{
	private String name;
	private char[][] navires;
	private boolean[][] frappes;


	public Board(String name,int N){
		this.name = name;
		this.navires = new char[N][N];
		this.frappes = new boolean[N][N];
	}	

	public Board(String name){
		this.name = name;
		this.navires = new char[10][10];
		this.frappes = new boolean[10][10];
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


	// public void print(){
	// 	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	// 	String newLine = System.getProperty("line.separator");
	// 	int N = navires.length;
	// 	System.out.print("Navires : ");
	// 	for ( int i = 0 ; i < 2*N - 6 ; i++){
	// 		System.out.print(" ");
	// 	}
	// 	System.out.print("Frappes : ");
	// 	System.out.println();

	// 	System.out.print(" ");
	// 	for ( int j = 0 ; j < 2 ; j++){
	// 		for(int i = 0 ; i < N ; i ++){
	// 			System.out.print(" " +alphabet.charAt(i));
	// 		}
	// 		System.out.print("  ");
	// 	}
		
	// 	System.out.println();
	// 	for(int i = 0 ; i < N ; i ++){
	// 		System.out.print(i + " ");
	// 		for ( int k = 0 ; k < 2 ; k++){
	// 			for (int j = 0 ; j < N ; j++){
	// 				System.out.print(". ");
	// 			}
	// 			System.out.print("  ");
	// 		}
			
	// 		System.out.println();

	// 	}


	// }
	public void print() {
		int N = this.navires.length;
        System.out.println("Navires: ");
        String firstLine="   ";
        for (int i=0;i<N;i++) {
            char ascii = (char)(i+65);
            firstLine += Character.toString(ascii) + "  ";
        }
        System.out.println(firstLine);
        for (int i=0;i<N;i++) {
            String str="";
            str += String.valueOf(i+1) + " ";
            for (int j=0; j<N;j++) {
              str+= " . ";
               
            }
            System.out.println(str);
        }

        System.out.println("\nFrappes: ");
        firstLine="   ";
        for (int i=0;i<N;i++) {
            char ascii = (char)(i+65);
            firstLine += Character.toString(ascii) + "  ";
        }
        System.out.println(firstLine);
        for (int i=0;i<N;i++) {
            String str="";
            str += String.valueOf(i+1) + " ";
            for (int j=0; j<N;j++) {
                str+= " . ";
                
            }
            System.out.println(str);
        }
    }

}

package ensta;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Board tab = new Board("Jeu",14);
        System.out.println(tab.getName());
        tab.print();
    }
}

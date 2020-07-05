import javax.swing.*;
import java.awt.*;
public class Driver
{
    public static void main( String[] args )
    {
        //create a JFrame (window) that will be visible on screen
        JFrame frame = new JFrame( "2DStealth" );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //make the red close button work
        frame.setLocation( 0, 0 ); //place the frame in the upper left corner
        Game game = new Game( 800, 500 );
        frame.getContentPane().add(game); //add game to the frame so it will be on the screen
        frame.pack();
        frame.setVisible(true);
        game.playGame();//call the playGame() method to initiate the game
    }
}

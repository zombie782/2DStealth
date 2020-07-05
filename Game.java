import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Game extends JPanel implements KeyListener
{
    private Player player;
    private Square square1,square2,square3;
    private boolean over;
	private JLabel label;
    
    //constructor - sets the initial conditions for this Game object
    public Game(int width, int height)
    {
        //make a panel with dimensions width by height with a black background
        this.setLayout( null );//Don't change
        this.setBackground( Color.WHITE );
        this.setPreferredSize( new Dimension( width, height ) );//Don't change
        
        //initialize the instance variables
        over = false;
        player = new Player(50,150);
        square1 = new Square(550,225);
		square2 = new Square(550,400);
		square3 = new Square(50,50);
		label=new JLabel("Get past the yellow square without touching any lasers!");
		this.add(label);
		label.setBounds(75,0,650,45);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial",Font.BOLD,24));
		
        this.addKeyListener(this);//allows the program to respond to key presses - Don't change

        this.setFocusable(true);//I'll tell you later - Don't change
    }

    //This is the method that runs the game
    public void playGame(){
        while( !over ){
			player.move(Map.map1);
			square1.ai1(Map.map1);
			square2.ai2(Map.map1);
			square3.ai3(Map.map1);
            if(player.v_collision(square1) || player.v_collision(square2) || player.v_collision(square3)){
                over=true;
				label=new JLabel("You Lost!");
				this.add(label);
				label.setBounds(250,450,300,45);
				label.setForeground(Color.WHITE);
				label.setFont(new Font("Arial",Font.BOLD,56));
            }
			if(player.getX()+player.size>=800){
				over=true;
				label=new JLabel("You Won!");
				this.add(label);
				label.setBounds(250,450,300,45);
				label.setForeground(Color.WHITE);
				label.setFont(new Font("Arial",Font.BOLD,56));
			}
            try{
                Thread.sleep( 10 );
            }catch( InterruptedException ex ){}
            this.repaint();//redraw the screen with the updated locations; calls paintComponent below
        }
    }

    //Precondition: executed when repaint() or paintImmediately is called
    //Postcondition: the screen has been updated with current player location
    public void paintComponent( Graphics page )
    {
        super.paintComponent( page );//I'll tell you later.
		Map.draw_map1(page);
        player.draw( page,Color.BLUE );//calls the draw method in the Player class
        square1.draw( page,Color.RED );//calls the draw method in the Square class
        square1.getVision().draw(page,Color.GREEN);
		square2.draw( page,Color.RED );
        square2.getVision().draw(page,Color.GREEN);
		square3.draw( page,Color.RED );
        square3.getVision().draw(page,Color.GREEN);
    }

    //tells the program what to do when keys are pressed
    public void keyReleased( KeyEvent event )
    {
        if( event.getKeyCode() == KeyEvent.VK_RIGHT )
        {
            player.setRight(false);
        }
        else if( event.getKeyCode() == KeyEvent.VK_LEFT )
        {
            player.setLeft(false);
        }
        else if( event.getKeyCode() == KeyEvent.VK_UP )
        {
            player.setUp(false);
        }
        else if( event.getKeyCode() == KeyEvent.VK_DOWN )
        {
            player.setDown(false);
        }
    }
    
    //not used but must be present
    public void keyPressed( KeyEvent event )
    {
        if( event.getKeyCode() == KeyEvent.VK_RIGHT )
        {
            player.setRight(true);
        }
        else if( event.getKeyCode() == KeyEvent.VK_LEFT )
        {
            player.setLeft(true);
        }
        else if( event.getKeyCode() == KeyEvent.VK_UP )
        {
            player.setUp(true);
        }
        else if( event.getKeyCode() == KeyEvent.VK_DOWN )
        {
            player.setDown(true);
        }
    }
    
    //not used but must be present
    public void keyTyped( KeyEvent event ){}
}

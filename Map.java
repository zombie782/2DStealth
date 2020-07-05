//class for map information
import java.util.*;
import java.awt.*;
public class Map{
	public static final Rectangle map1[]={new Rectangle(0,0,800,50),new Rectangle(0,450,800,50),
	new Rectangle(0,50,50,400),new Rectangle(750,50,50,175),new Rectangle(750,275,50,175),
	new Rectangle(50,100,400,50),new Rectangle(500,100,100,50),
	new Rectangle(100,350,150,50),new Rectangle(500,350,200,50),new Rectangle(500,400,50,50),
	new Rectangle(650,100,50,125),new Rectangle(650,275,50,75),new Rectangle(500,150,50,150),
	new Rectangle(100,200,50,100),new Rectangle(200,200,250,50),new Rectangle(300,300,150,100),
	new Rectangle(200,300,50,50)};
	public static void draw_map1(Graphics page){
		for(int i=0;i!=map1.length;++i){
			map1[i].draw(page,Color.BLACK);
		}
		page.setColor(Color.YELLOW);
		page.fillRect(750,225,50,50);
	}
}
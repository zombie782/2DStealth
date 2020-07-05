import java.awt.*;//must be imported to use Graphics
import java.util.*;
public class Player
{
    private int x;
    private int y;
    public final int size=30;
    private boolean right,left,up,down;
	private ArrayList<Integer> collided=new ArrayList<Integer>(0);
    
    public Player( int xLoc, int yLoc )
    {
        x = xLoc;
        y = yLoc;
    }
    public void setRight(boolean b){
        right=b;
    }
    public void setLeft(boolean b){
        left=b;
    }
    public void setUp(boolean b){
        up=b;
    }
    public void setDown(boolean b){
        down=b;
    }
    public void move(Rectangle map[]){
        if(right==true && w_collision(map)[0]==false){
            x+=3;
        }if(left==true && w_collision(map)[1]==false){
            x-=3;
        }if(up==true && w_collision(map)[2]==false){
            y-=3;
        }if(down==true && w_collision(map)[3]==false){
            y+=3;
        }
    }
    public void draw( Graphics page,Color c )
    {
        page.setColor( c );
        page.fillRect( x, y, size, size );
    }
    public boolean v_collision(Square s){
        if((x+size>s.getVision().getX() &&
		x<s.getVision().getX()+s.getVision().getWidth() &&
		y<s.getVision().getY()+s.getVision().getHeight() &&
		y+size>s.getVision().getY()) || 
		(x+size>=s.getX() && 
		x<=s.getX()+size &&
		y<=s.getY()+size &&
		y+size>=s.getY())){
            return true;
        }
        return false;
    }
	public boolean has_collision(Rectangle map[]){
		for(int i=0;i!=map.length;++i){
			if(x+size>=map[i].getX() && 
			x<=map[i].getX()+map[i].getWidth() &&
			y<=map[i].getY()+map[i].getHeight() &&
			y+size>=map[i].getY()){
				collided.add(i);
				return true;
			}
		}
		return false;
	}
	public boolean[] w_collision(Rectangle map[]){
		boolean directions[]={false,false,false,false};
		if(has_collision(map)==true){
			for(int i:collided){
				if(x<=map[i].getX()){directions[0]=true;}
				if(x+size>=map[i].getX()+map[i].getWidth()){directions[1]=true;}
				if(y+size>=map[i].getY()+map[i].getHeight()){directions[2]=true;}
				if(y<=map[i].getY()){directions[3]=true;}
			}
			collided.clear();
		}
		return directions;
	}
	public int getX(){return x;}
	public int getY(){return y;}
}
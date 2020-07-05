import java.awt.*;//must be imported to use Graphics
import java.lang.Math;
import java.util.*;
public class Square
{
    private int x;
    private int y;
    private Direction direction;
    private Rectangle vision=new Rectangle(0,0,0,0);
    public Square( int xLoc, int yLoc)
    {
        x = xLoc;
        y = yLoc;
    }
	public void move(Direction d,int speed,Rectangle map[]){
        direction=d;
		switch(d){
			case LEFT:x-=speed;
			vision.setValues(0,y+20,x,10);
			break;
			case RIGHT:x+=speed;
			vision.setValues(x+50,y+20,750-x,10);
			break;
			case UP:y-=speed;
			vision.setValues(x+20,0,10,y);
			break;
			case DOWN:y+=speed;
			vision.setValues(x+20,y+50,10,450-y);
			break;
		}
		if(vw_collision(map).size()>0){
			Rectangle wall=map[vw_collision(map).get(0)];
			switch(d){
				case LEFT:
				for(int i:vw_collision(map)){
					if(x-(map[i].getX()+map[i].getWidth())<x-(wall.getX()+wall.getWidth())){
						wall=map[i];
					}
				}
				vision.setValues(wall.getX()+wall.getWidth(),y+20,x-(wall.getX()+wall.getWidth()),10);
				break;
				case RIGHT:
				for(int i:vw_collision(map)){
					if((map[i].getX()+map[i].getWidth())-x<(wall.getX()+wall.getWidth())-x){
						wall=map[i];
					}
				}
				vision.setValues(x+50,y+20,wall.getX()-(x+50),10);
				break;
				case UP:
				for(int i:vw_collision(map)){
					if(y-(map[i].getY()+map[i].getHeight())<y-(wall.getY()+wall.getHeight())){
						wall=map[i];
					}
				}
				vision.setValues(x+20,wall.getY()+wall.getHeight(),10,y-(wall.getY()+wall.getHeight()));
				break;
				case DOWN:
				for(int i:vw_collision(map)){
					if(map[i].getY()-(y+50)<(wall.getY()-(y+50))){
						wall=map[i];
					}
				}
				vision.setValues(x+20,y+50,10,(wall.getY()-(y+50)));
				break;
			}
		}
    }
	public void ai1(Rectangle map[]){
		if(x<=550){
			direction=Direction.RIGHT;
		}else if(x>=600){
			direction=Direction.LEFT;
		}
		move(direction,1,map);
	}
	public void ai2(Rectangle map[]){
		if(x==550 && y==400){
			direction=Direction.RIGHT;
		}else if(x==700 && y==400 && direction==Direction.RIGHT){
			direction=Direction.UP;
		}else if(x==700 && y==225 && direction==Direction.UP){
			direction=Direction.LEFT;
		}else if(x==600 && y==225 && direction==Direction.LEFT){
			direction=Direction.DOWN;
		}else if(x==600 && y==300 && direction==Direction.DOWN){
			direction=Direction.LEFT;
		}else if(x==450 && y==300 && direction==Direction.LEFT){
			direction=Direction.DOWN;
		}else if(x==450 && y==400 && direction==Direction.DOWN){
			direction=Direction.LEFT;
		}else if(x==250 && y==400 && direction==Direction.LEFT){
			direction=Direction.UP;
		}else if(x==250 && y==250 && direction==Direction.UP){
			direction=Direction.RIGHT;
		}else if(x==450 && y==250 && direction==Direction.RIGHT){
			direction=Direction.DOWN;
		}else if(x==450 && y==300 && direction==Direction.DOWN){
			direction=Direction.RIGHT;
		}else if(x==600 && y==300 && direction==Direction.RIGHT){
			direction=Direction.UP;
		}else if(x==600 && y==225 && direction==Direction.UP){
			direction=Direction.RIGHT;
		}else if(x==700 && y==225 && direction==Direction.RIGHT){
			direction=Direction.DOWN;
		}else if(x==700 && y==400 && direction==Direction.DOWN){
			direction=Direction.LEFT;
		}
		move(direction,1,map);
	}
	public void ai3(Rectangle map[]){
		if(x==50 && y==50){
			direction=Direction.RIGHT;
		}else if(x==450 && y==50 && direction==Direction.RIGHT){
			direction=Direction.DOWN;
		}else if(x==450 && y==150 && direction==Direction.DOWN){
			direction=Direction.LEFT;
		}else if(x==150 && y==150 && direction==Direction.LEFT){
			direction=Direction.DOWN;
		}else if(x==150 && y==250 && direction==Direction.DOWN){
			direction=Direction.RIGHT;
		}else if(x==450 && y==250 && direction==Direction.RIGHT){
			direction=Direction.UP;
		}else if(x==450 && y==50 && direction==Direction.UP){
			direction=Direction.LEFT;
		}
		move(direction,1,map);
	}
    public void draw( Graphics page,Color c)
    {
        page.setColor(c);
        page.fillRect(x,y,50,50);
    }
	public ArrayList<Integer> vw_collision(Rectangle map[]){
		ArrayList<Integer> collided=new ArrayList<Integer>(0);
		for(int i=0;i!=map.length;++i){
			if(vision.getX()+vision.getWidth()>=map[i].getX() && 
			vision.getX()<=map[i].getX()+map[i].getWidth() &&
			vision.getY()<=map[i].getY()+map[i].getHeight() &&
			vision.getY()+vision.getHeight()>=map[i].getY()){
				collided.add(i);
			}
		}
		return collided;
	}
	public int getX(){return x;}
	public int getY(){return y;}
    public Rectangle getVision(){return vision;}
}

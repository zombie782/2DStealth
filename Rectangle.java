import java.awt.*;
public class Rectangle{
    private int xLoc,yLoc,width,height;
    public Rectangle(int x,int y,int w,int h){
        xLoc=x;yLoc=y;width=w;height=h;
    }
    public void setValues(int x,int y,int w,int h){
        xLoc=x;yLoc=y;width=w;height=h;
    }
    public void draw(Graphics page,Color c){
        page.setColor( c );
        page.fillRect( xLoc, yLoc, width, height );
    }
    public int getX(){return xLoc;}
    public int getY(){return yLoc;}
    public int getWidth(){return width;}
    public int getHeight(){return height;}
}

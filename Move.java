import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Move{
  
  Target t=new Target(1,1);
  
  public Point toMove(Point mypoint){
    double angle=getAngle(mypoint.getX(),mypoint.getY());
                                                                                                    //  System.out.println("angle"+angle);
    Point result=new Point((int)(Math.cos(angle)*t.bulletspeed),(int)(Math.sin(angle)*t.bulletspeed)); // After Math. 's result * anything. All need to be add '(' ')'.
    return result;
  }

  public double getAngle(double myx,double myy){
    double mouseX=getMousePoint().getX();
    double mouseY=getMousePoint().getY();
    double angle = Math.toDegrees(Math.atan2(mouseY-myy,mouseX-myx));
    return angle;
  }

  public Point getMousePoint(){
    PointerInfo pi=MouseInfo.getPointerInfo();
    return pi.getLocation();
  }
} 

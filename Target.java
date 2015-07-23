import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

class Target{
  
  private Point location;
  public final static int bulletspeed=1;
  
  public Target(int x,int y){
    setLocation(x,y);
  }

  public void setLocation(int x,int y){ location=new Point(x,y); }

  public Point getLocation(){ return location; }
} 

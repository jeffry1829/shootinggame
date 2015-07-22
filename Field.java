import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

class Field{
  JFrame field;
  Painter painter;
  ArrayList<Target> targetlist=new ArrayList<Target>();
  Target target;
  //Image targetImage=new ImageIcon("./img/target.png").getImage();
  //Image myImage=new ImageIcon("./img/my.png").getImage();
  final static Point myLocation=new Point(300,560);
  boolean toRemove=false;
  int crashIndex;
  
  public void construc(){
    field=new JFrame("這是個非常好玩的射擊遊戲");
    painter=new Painter();
    painter.addMouseListener(new MListener());
    field.setContentPane(painter);
    field.setBounds(0,0,600,610); // left-i,right-i,width,height
    field.setVisible(true);  
  }  

  public void placetarget(int targetlen){
    for(int i=0;i<targetlen;i++){
      int randomX = (int)(Math.random()*600);
      int randomY = (int)(Math.random()*500);
      Point point=new Point(randomX,randomY);
      target=new Target((int)point.getX(),(int)point.getY());
      targetlist.add(target);
      field.getContentPane().repaint();
    }
  } 

  public double distance(Point p1,Point p2){
    return Math.sqrt( Math.abs( (p1.getX()-p2.getX())) * Math.abs( (p1.getX()-p2.getX()) )+Math.abs( (p1.getY()-p2.getY()) )*Math.abs( (p1.getY()-p2.getY()) ) );
  } 
  
    class Painter extends JPanel{
      public void paintComponent(Graphics g){
        if(!toRemove){
          
          Graphics2D g2=(Graphics2D)g;
          //g.drawImage(targetImage,(int)target.getLocation().getX(),(int)target.getLocation().getY(),50,50,Color.white,this);
            g.setColor(Color.RED);
            g.fillOval((int)target.getLocation().getX(),(int)target.getLocation().getY(),50,50);
          //g.drawImage(myImage,300,560,50,50,Color.white,this);
            g.setColor(Color.BLACK);
            g.fillOval(300,560,50,50);
        }
        else{
          g.setColor(Color.white);
          
          g.fillOval((int)targetlist.get(crashIndex).getLocation().getX(),(int)targetlist.get(crashIndex).getLocation().getY(),50,50);
        }
        
      }
    } //end of inner-class 

    class MListener extends MouseAdapter{
      public void mouseClicked(MouseEvent e){ // declare attack message
        
        Point Ibullet=myLocation;

                                                                               System.out.println("Mouse Clicked");
        
        for(int i=1;i<=50;i++){
          Move move=new Move();
          Point tomove=move.toMove(myLocation);
          Ibullet.move((int)tomove.getX(),(int)tomove.getY());
          for(Target t : targetlist){
            if( distance(t.getLocation(),Ibullet) < 50){
              targetlist.remove( targetlist.indexOf(t) );
              toRemove=true;
              crashIndex=targetlist.indexOf(t);
              field.getContentPane().repaint();
              toRemove=false;
              crashIndex=0;
            }
          }
        }
      }
    }
} 

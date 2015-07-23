import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Shootinggame{
  public static void main(String[] args) {   	
    Field field=new Field();
    field.construc();
    field.placetarget(20);
    new Move();
  }
} 

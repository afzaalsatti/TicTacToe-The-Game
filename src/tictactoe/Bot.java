/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Bot
{
    
    public static void main(String [] args)
    {
        Scanner scan=new Scanner(System.in);
        List danger=new ArrayList();
        List poss=new ArrayList();
        
        String[][]arr=new String[3][3];
       
        for(int i=0;i<3;i++)
        {
             for(int j=0;j<3;j++)
             {
                 System.out.print("Input Number : ");
                 String num=scan.nextLine();
                 
                
                 arr[i][j]=num;
             }
            
        }
        double points=0;
        String emp="";
        String dan="";
       
        for(int i=0;i<3;i++)
        {
            points=0;
             for(int j=0;j<3;j++)
             {
                 switch (arr[i][j]) {
                     case "X":
                         points+=1;
                         break;
                     case "nil":
                         points+=0.5;
                         emp=arr[i][j];
                         
                         break;
                     default:
                         points-=1;
                          dan=arr[i][j];
                         break;
                 }
                }
             if(points<0)
             {
                 danger.add("Row "+dan);
             }else
                 if(points>0)
                 {
                     poss.add("Row "+emp);
                 }
             
            
        }
          points=0;
        
        for(int i=0;i<3;i++)
        {
            points=0;
             for(int j=0;j<3;j++)
             {
                 switch (arr[j][i]) {
                     case "X":
                         points+=1;
                         break;
                     case "nil":
                         points+=0.5;
                         emp=arr[j][i];
                         
                         break;
                     default:
                         points-=1;
                          dan=arr[j][i];
                         break;
                 }
                }
             if(points<0)
             {
                 danger.add("Col "+dan);
             }else
                 if(points>0)
                 {
                     poss.add("Col "+emp);
                 }
             
            
        }
         points=0;
        
        for (int k=0;k<arr.length;k++)
         {
             switch (arr[k][k]) {
                     case "X":
                         points+=1;
                         break;
                     case "nil":
                         points+=0.5;
                         emp=arr[k][k];
                         
                         break;
                     default:
                         points-=1;
                          dan=arr[k][k];
                         break;
             
         }
        
         }
        if(points<0)
             {
                 danger.add("Dig-R "+arr[0][0]);
             }else
                 if(points>0)
                 {
                     poss.add("Dig-R "+arr[0][0]);
                 }
        
        
        points=0;
         int last_pos=arr.length-1;
        for (int k=0;k<arr.length;k++)
         {
             switch (arr[k][last_pos]) {
                     case "X":
                         points+=1;
                         break;
                     case "nil":
                         points+=0.5;
                         emp=arr[k][k];
                         
                         break;
                     default:
                         points-=1;
                          dan=arr[k][k];
                         break;
                          }
            last_pos--;
         }
        if(points<0)
             {
                 danger.add("Dig-L "+arr[0][arr.length-1]);
             }else
                 if(points>0)
                 {
                     poss.add("Dig-L "+arr[0][arr.length-1]);
                 }
        
        
        
       
        System.out.println("Dangerous lines "+danger);
        System.out.println("Possible lines "+poss);
        
    }
    
    
}
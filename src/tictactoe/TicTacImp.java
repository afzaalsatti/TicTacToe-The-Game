/* **************************************************
        Name:Afzaal Shoukat
        Class:BSSE F16-B
        REG: 3328
       Instructor: Sir Majid Bashir
       Task: TicTacToe-The Game


     Sir I have Added some icons to App..
thats why iam sending these png along with code via Gmail
.. add them to src and then run these .java file .. Thanks
        ***************************************************** */

package tictactoe;

import java.util.Optional;
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


public class TicTacImp {
    
    Scene scene;
      Rectangle rect;
     // Image image=new Image("waterfall.gif");
      ImageView background;
    Group root=new Group();
     Button [][] tabs;
     Text p1,p2;
     GridPane gridpane=new GridPane();
     Text history,total_games,p1_wins,p2_wins;
     int turn=0;
     int t_games,p1_score,p2_score;
     Button start=new Button("Start");
     Stage popup=new Stage();
     boolean selected=false;
  Scene subscene;
  RadioButton option1, option2, option3;
 Stage stage;
  Group subroot=new Group();
    public  TicTacImp(Stage stage)
    {
        this.stage=stage;
    }
     public Scene getWindow()
     {

       
         getPlayerInfo();
       // background=new ImageView(image);
        
  scene=new Scene(root,700,700,Color.CHOCOLATE);
         setDimentions();
        
           root.getChildren().addAll(start,rect,p1,p2,history,total_games,p1_wins,p2_wins);
            
           
         actionListeners();
        return scene;
         
         
         
     }
private void getPlayerInfo()
{
    TextInputDialog dialog = new TextInputDialog("");
   
dialog.setTitle("TicTacToe-The Game");

dialog.setHeaderText("AOA, Input Name of First Player ");
// Traditional way to get the response value.
       Optional<String> result = dialog.showAndWait();
       p1=new Text(result.get().toUpperCase());
       dialog = new TextInputDialog("");
       dialog.setTitle("TicTacToe-The Game");
       dialog.setHeaderText("AOA, Input Name of Second Player ");
       dialog.setResult("");
       Optional<String> result1 = dialog.showAndWait();
       p2=new Text(result1.get().toUpperCase());
}
     private void initialization()
     {
         try
         {
             int num=1;
         for(int i=0;i<tabs.length;i++)
         {
             for(int j=0;j<tabs.length;j++)
             {
                 tabs[i][j]=new Button(" "+num+" ");
                  root.getChildren().addAll(tabs[i][j]);
                  if(num<10)
                  {
                       tabs[i][j].setScaleX(2);
                 tabs[i][j].setScaleY(2);
                  }
                  else
                  {
                      tabs[i][j].setScaleX(1.6);
                      tabs[i][j].setScaleY(2);
                  }
                 num++;
             }
            
             
         }
         allignTabs();
         }catch(Exception e)
         {
             System.out.println(e);
         }
         
     }
     private void allignTabs()
     {
         int x=10;
   int xinc=0;
   int y=200;
   //Game Tabs
   for(int i=0;i<tabs.length;i++)
         {
             x=250;
             y=y+55;
             xinc=0;
             for(int j=0;j<tabs.length;j++)
             {
                 
                 tabs[i][j].setLayoutX(x+xinc);tabs[i][j].setLayoutY(y);
                
                 xinc=xinc+64;
                 
                 
             }
             
             
         }
   startGame();
    if(start.getText().equals("Start"))
        {
            start.setText("Start New Game");
        }
        else
         if(start.getText().equals("Start New Game"))
        {
            start.setText("Start New Game");
        }
   
    start.setVisible(true);
     }
public void actionListeners()
{
   
//Adding event Filter 

          
    
    
    
    start.setOnMouseClicked(event->
    {
        start.setVisible(false);
        popup.show();
        t_games++;
        total_games.setText("total_games  :"+t_games);

       
            
        
    });
    scene.setOnMouseClicked(event->
         {
             popup.hide();
            
         }
         );
    option1.setOnMouseClicked(event->
         {
              turn=0;
             option1.setSelected(false);
            
             option2.setSelected(false);
            option3.setSelected(false);
             popup.hide();
             if(selected)
             {
                 
             for(int i=0;i<tabs.length;i++)
         {
             for(int j=0;j<tabs.length;j++)
             {
                 
                  root.getChildren().remove(tabs[i][j]);
                  
             }
            
             
         }}
             
             tabs=new Button[3][3];
             initialization();
             selected=true;
             
            
            
         }
         );
    option2.setOnMouseClicked(event->
         {
             turn=0;
             option1.setSelected(false);
             option2.setSelected(false);
            
            option3.setSelected(false);
             popup.hide();
             if(selected)
             {
             for(int i=0;i<tabs.length;i++)
         {
             for(int j=0;j<tabs.length;j++)
             {
                 
                  root.getChildren().remove(tabs[i][j]);
                  
             }
            
             
         }}
             tabs=new Button[4][4];
              initialization();
              selected=true;
             
            
         }
         );
    popup.setOnCloseRequest(event->
    {
        System.out.println("Closing");
        popup.close();
        start.setVisible(true);
    });
    option3.setOnMouseClicked(event->
         {
              turn=0;
             option1.setSelected(false);
            option2.setSelected(false);
            option3.setSelected(false);
            popup.hide();
            if(selected)
             {
             for(int i=0;i<tabs.length;i++)
         {
             for(int j=0;j<tabs.length;j++)
             {
                 
                  root.getChildren().remove(tabs[i][j]);
                  
             }
            
             
         }}
            
             tabs=new Button[5][5];
             
              initialization();
            selected=true;
         }
         );

    
}
    public void setDimentions()
    {
        
        t_games=0;
        p1_score=0;
        p2_score=0;
        //background
       // background.setLayoutX(0);
        
        
        //RadioButtons
        option1=new RadioButton("  3 x 3  ");
         option2=new RadioButton("  4 x 4  ");
         option3=new RadioButton("  5 x 5  ");
        
         
  
  
  subroot.getChildren().addAll(option1,option2,option3);
  
   subscene=new Scene(subroot,400,200,Color.CADETBLUE);
   option1.setLayoutX(subscene.getHeight()/2);option1.setLayoutY(50);
  option2.setLayoutX(subscene.getHeight()/2);option2.setLayoutY(100);
  option3.setLayoutX(subscene.getHeight()/2);option3.setLayoutY(150);
  popup.getIcons().add(new Image("icon2.png"));
  popup.setScene(subscene);
   popup.setTitle("Choose Nature of Game");
   
   
   
   //start Button
   start.setLayoutX(scene.getWidth()/2-70);
   start.setLayoutY(scene.getHeight()/2+190);
   start.setScaleY(1.5);
   start.setScaleX(1.5);
   
   //Heading
   p1.setFill(Color.YELLOW);
p1.setFont(Font.font(null, FontWeight.BOLD, 50));
 
 

p1.setLayoutX(scene.getWidth()/2-140);p1.setLayoutY(50);




p2.setFill(Color.RED);
p2.setFont(Font.font(null, FontWeight.BOLD, 50));
 
 

p2.setLayoutX(scene.getWidth()/2+90);p2.setLayoutY(50);


//Side-View /History
history=new Text("History");
total_games=new Text("total_games  :"+t_games);
p1_wins=new Text(p1.getText()+" : "+p1_score);
p2_wins=new Text(p2.getText()+" : "+p2_score);

history.setLayoutX(10);history.setLayoutY(130);
total_games.setLayoutX(10);total_games.setLayoutY(160);
p1_wins.setLayoutX(10);p1_wins.setLayoutY(200);
p2_wins.setLayoutX(10);p2_wins.setLayoutY(240);



history.setFont(Font.font(null, FontWeight.BOLD, 25));
total_games.setFont(Font.font(null, FontWeight.BOLD, 15));
p1_wins.setFont(Font.font(null, FontWeight.BOLD, 15));
p2_wins.setFont(Font.font(null, FontWeight.BOLD, 15));
   //header bar
   rect=new Rectangle(scene.getWidth(),100);
        rect.setFill(Color.rgb(46,35,50));
        
    }
    
    
    //to check matches
    private boolean check()
    {
        boolean match=false;
        String text=null;
            //Checking Row by row
         for(int i=0;i<tabs.length;i++)
         {
             if(match)
                 {
                     return match;
                     
                 }
             String res=tabs[i][0].getText();
             for(int j=0;j<tabs.length;j++)
             {
                 
                 
                if(tabs[i][j].getText().equals(res)  ) 
                {
                    match=true;
                    System.out.println(match);
                    
                }
                else
                {
                    match=false;
                    break;
                }
                  
             }
            
             
         }
         
         //if no row matches Now Checking Column by column
         for(int i=0;i<tabs.length;i++)
         {
             if(match)
                 {
                     return true;
                 }
             String res=tabs[0][i].getText();
             for(int j=0;j<tabs.length;j++)
             {
                 
                 
                if(tabs[j][i].getText().equals(res)   ) 
                {
                    match=true;
                    System.out.println(match);
                    
                }
                else
                {
                    match=false;
                    break;
                }
                  
             }
            
             
         }
         
         //Lastly Checking Dia Righ to left
         if(!match)
         {
        
         for (int k=0;k<tabs.length;k++)
         {
              String res=tabs[0][0].getText();
            
             if(tabs[k][k].getText().equals(res)   ) 
                {
                    match=true;
                    System.out.println(res);
                    
                }
                else
                {
                    match=false;
                    break;
                }
             
         }}
         //Lastly Checking Dia  left to Righ
         if(!match)
         {
         int last_pos=tabs.length-1;
         
         for (int l=0;l<tabs.length;l++)
         {
              String res=tabs[0][tabs.length-1].getText();
            
             if(tabs[l][last_pos].getText().equals(res)   ) 
                {
                    match=true;
                    System.out.println(res);
                    
                }
                else
                {
                    match=false;
                    break;
                }
             if(last_pos>0)
             last_pos--;
             
         }
         
         }
         //Presenting Alert messsage of turn according to result if no matches found
         System.out.println("Returning value :"+ match);
         if(!match)
         {
//            if(turn%2==0)
//            {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Hint");
//            alert.setHeaderText(p2.getText()+"`s Turn");
//            alert.setContentText("");
//            alert.showAndWait();
//            }else
//            {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Hint");
//            alert.setHeaderText(p1.getText()+"`s Turn");
//            alert.setContentText("");
//            alert.showAndWait();
//            }
         }
         //returning ture or false if match found true else false
        return match;
        
    }
    private void  startGame()
    {
        
        tabs[0][0].setOnMouseClicked(event->
        
        {
            tabsListener(event);
        });
        tabs[0][1].setOnMouseClicked(event->
        
        {
             tabsListener(event);
          
        });
        tabs[0][2].setOnMouseClicked(event->
                
        
        {
            tabsListener(event);
           
        });
        
        
        
        
        tabs[1][0].setOnMouseClicked(event->
        
        {
             tabsListener(event);
           
        });
        tabs[1][2].setOnMouseClicked(event->
                
        
        {
            tabsListener(event);
           
        });
        tabs[1][1].setOnMouseClicked(event->
                
        
        {
            tabsListener(event);
           
        });
        
        
        
        
        
        tabs[2][0].setOnMouseClicked(event->
        
        {
             tabsListener(event);
        
        });
        tabs[2][1].setOnMouseClicked(event->
        
        {
            tabsListener(event);
          
        });
        tabs[2][2].setOnMouseClicked(event->
                
        
        {
            tabsListener(event);
           
        });
        
        
        //for 4 X 4
        
        if(tabs.length>3)
        {
         tabs[0][3].setOnMouseClicked(event->
        
        {
            tabsListener(event);
        });
        tabs[1][3].setOnMouseClicked(event->
        
        {
             tabsListener(event);
          
        });
        tabs[2][3].setOnMouseClicked(event->
                
        
        {
            tabsListener(event);
           
        });
        
        
        
        
        tabs[3][0].setOnMouseClicked(event->
        
        {
             tabsListener(event);
           
        });
        tabs[3][1].setOnMouseClicked(event->
                
        
        {
            tabsListener(event);
           
        });
        tabs[3][2].setOnMouseClicked(event->
                
        
        {
            tabsListener(event);
           
        });
        
        
        
        
        
        tabs[3][3].setOnMouseClicked(event->
        
        {
             tabsListener(event);
        
        });
        
        }
        
      //  for 5 X 5
      if(tabs.length>4)
        {
         tabs[0][4].setOnMouseClicked(event->
        
        {
            tabsListener(event);
        });
        tabs[1][4].setOnMouseClicked(event->
        
        {
             tabsListener(event);
          
        });
        tabs[2][4].setOnMouseClicked(event->
                
        
        {
            tabsListener(event);
           
        });
        
        
        
        
        tabs[3][4].setOnMouseClicked(event->
        
        {
             tabsListener(event);
           
        });
        tabs[4][4].setOnMouseClicked(event->
                
        
        {
            tabsListener(event);
           
        });
        tabs[4][3].setOnMouseClicked(event->
                
        
        {
            tabsListener(event);
           
        });
        
        
        
        
        
        tabs[4][2].setOnMouseClicked(event->
        
        {
             tabsListener(event);
        
        });
        
        
        tabs[4][1].setOnMouseClicked(event->
        
        {
             tabsListener(event);
        
        });
        
        tabs[4][0].setOnMouseClicked(event->
        
        {
             tabsListener(event);
        
        });
        
        
        }
  
 
    }
    
    
    private void tabsListener(Event event)
    {
        Button eventButton=(Button)event.getSource();
        if(turn%2==0)
            {
                 eventButton.setText("X");
              eventButton.setStyle("-fx-background-color:Yellow");
            }
            else
            {
                 eventButton.setText("O");
              eventButton.setStyle("-fx-background-color:Red");
                
            }
        try
        {
            
           Thread.sleep(100);
        }
        catch(Exception exp)
        {
            System.out.println("Error at line 729 Tic ToeImp.java :"+exp);
        }
        eventButton.setDisable(true);
             if(check())
        {
            if(turn%2==0)
            {
                p1_score++;
p1_wins.setText(p1.getText()+" : "+p1_score);


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Victory");
            alert.setHeaderText(p1.getText()+" Wins");
            alert.setContentText("");
           
            alert.showAndWait();
           
          
            }
            else
            {
                p2_score++;
                 p2_wins.setText(p2.getText()+" : "+p2_score);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Victory");
            alert.setHeaderText(p2.getText()+" Wins");
            alert.setContentText("");
            alert.showAndWait();
            }
            for (Button[] tab : tabs) {
                for (int j = 0; j<tabs.length; j++) {
                    root.getChildren().remove(tab[j]);
                }
            }
        }
            turn++;
    }
    
}

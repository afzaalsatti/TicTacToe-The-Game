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

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author ROOTED
 */
public class TicTacToe extends Application {
    
    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            
        primaryStage.setScene(new TicTacImp(primaryStage).getWindow());
        primaryStage.setResizable(false);
        primaryStage.setTitle("TicTacToe-The Game");
        primaryStage.getIcons().add(new Image("icon.jpg"));
        primaryStage.show();
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
       
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

package krobis.game;

import javax.swing.SwingUtilities;

public class Father { 
  
  private GameController gameController;
  
  public static void main(String[] args) {
    new Father(args);
  } 
  
  public Father(String[] args) {
    this.gameController = GameController.getInstance();  
    this.gameController.begin();
  } 

}

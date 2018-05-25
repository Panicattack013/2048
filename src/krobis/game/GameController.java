package krobis.game;

public class GameController {

  private static GameController controller;
  
  public static GameController getInstance() {
    if (GameController.controller == null) {
      GameController.controller = new GameController();
    }
    return GameController.controller;
  }
  
  private GameController(){}
  
}

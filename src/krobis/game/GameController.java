package krobis.game;

import krobis.gui.GUIHandler;

public class GameController {

  private static GameController controller;
  
  private GUIHandler guiHandler;
  
  public static GameController getInstance() {
    if (GameController.controller == null) {
      GameController.controller = new GameController();
    }
    return GameController.controller;
  }
  
  private GameController(){}
  
  public void begin() {
    this.guiHandler = GUIHandler.getInstance(this);
    this.guiHandler.init();
  }
  
  
}

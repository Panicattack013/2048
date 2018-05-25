package krobis.model;

import krobis.game.GameController;
import krobis.model.board.Grid;

public class ModelManager {
	private GameController gameController;
	private Grid grid;

	public ModelManager(GameController gameController) {
		this.gameController = gameController;
		grid = new Grid(this);
	}

}

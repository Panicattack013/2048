package krobis.modelTest;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import krobis.game.GameController;
import krobis.model.ModelManager;
import krobis.model.board.Grid;
import krobis.model.board.Tile;

class GridTest {


	@Test
	public void testConstructorValid() {
		Grid grid = new Grid(new ModelManager(GameController.getInstance()));
		LinkedList<Tile> tilesOnBoard = grid.getTilesOnBoard();
		assertTrue(tilesOnBoard.size() == 2);
		Tile[][] board = grid.getBoard();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j] != null) {
					System.out.println(i + ", " + j + ": " + board[i][j].getValue());
				}
			}
		}
	}
	

}

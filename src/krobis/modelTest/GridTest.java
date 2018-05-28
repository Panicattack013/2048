package krobis.modelTest;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import krobis.game.GameController;
import krobis.model.Direction;
import krobis.model.ModelManager;
import krobis.model.board.Grid;
import krobis.model.board.Tile;

class GridTest {

	@Test
	public void testConstructorValid() {
		Grid grid = new Grid(new ModelManager(GameController.getInstance()));
		List<Tile> tilesOnBoard = grid.getTilesOnBoard();
		assertTrue(tilesOnBoard.size() == 2);
		Tile[][] board = grid.getBoard();
		System.out.println("BEFORE MOVE");
		System.out.println(grid);
		System.out.println("AFTER MOVE");
		grid.move(Direction.UP);
		System.out.println(grid);
	}
	

}

package krobis.model.board;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import krobis.model.Direction;
import krobis.model.ModelManager;

public class Grid {

	private Tile[][] board;
	private ModelManager modelManager;
	private List<Tile> tilesOnBoard;

	public Grid(ModelManager modelManager) {
		this.modelManager = modelManager;
		board = new Tile[4][4];
		tilesOnBoard = new ArrayList<Tile>();
		tilesOnBoard.add(this.addRandom());
		tilesOnBoard.add(this.addRandom());
		System.out.println("nothing");
	}
	public Tile[][] getBoard() {
		return this.board;
	}
	public ArrayList<Tile> getTilesOnBoard() {
		return (ArrayList<Tile>) tilesOnBoard;
	}

	public Tile addRandom() {
		int row = (int)(Math.random() * 4);
		int column = (int)(Math.random() * 4);
		while (!isEmpty(board[row][column])) {
			row = (int)(Math.random() * 4);
			column = (int)(Math.random() * 4);
		}
		board[row][column] = generateRandomTile();
		return board[row][column];
	}
	public Tile generateRandomTile() {
		if (Math.random() < .5) {
			return new Tile(2);
		}
		return new Tile(4);
	}

	public boolean isEmpty(Tile tile) {
		return tile == null;
	}

	public void move(Direction dir) {
		switch(dir) {
		case DOWN:
			moveDown();
			break;
		case LEFT:
			moveLeft();
			break;
		case RIGHT:
			moveRight();
			break;
		case UP:
			moveUp();
			break;
		default:
			System.out.println("fucked up, impossible direction");
			break;
		}
	}
	public void moveUp() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				Tile currentTile = board[i][j];
				int yIndex = i;
				while (yIndex != 0) { //not on border
					if (!isEmpty(currentTile)) { // found tile
						
					} else {
						Tile adjacentTile = board[i - 1][j];
						if (sameValue(currentTile, adjacentTile)) {
							combine(currentTile, adjacentTile);
						}
					}
				}
			}
		}
	}
	public void moveDown() {

	}
	public void moveRight() {

	}
	public void moveLeft() {

	}

	public boolean sameValue(Tile one, Tile two) {
		return one.getValue() == two.getValue();
	}
	public void combine(Tile current, Tile adjacent) {
		
	}

	/*
	 * MOVE LOGIC
	 * Outer loop, through 2d array
- rows
- columns
    - nested loop (if tile exists)
        - border
        - loop until can’t move
            - isEmpty
                - true -> move, loop
                - false ->
                    - same values -> combine
                    - different values -> break
- add random tile in empty spot
- call redraw (through game controller)
	 */

}

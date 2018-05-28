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
			System.out.println("Evaluating row " + i);
			for (int j = 0; j < 4; j++) {
				System.out.println("Evaluating column " + j);
				Tile currentTile = board[i][j];
				if (currentTile != null) {
					System.out.println("Tile found: " + currentTile.getValue());
					int yIndex = j - 1;
					while (yIndex > 0) { //not on border
						System.out.println("y index: " + yIndex);
						Tile adjacentTile = board[i][j-yIndex];
						if (isEmpty(adjacentTile)) {
							Tile replace = new Tile(currentTile.getValue());
							board[i][j - yIndex - 1] = replace;
							currentTile = replace;
							board[i][j] = null;
							yIndex--;
						} else {
							adjacentTile = new Tile(currentTile.getValue());
							adjacentTile.doubleValue();
							currentTile = null;
							yIndex--;
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
		if (one == null || two == null) return false;
		return one.getValue() == two.getValue();
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

	@Override
	public String toString() {
		String out = "";
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[j][i] != null) {
					out += board[j][i].getValue();
				} else {
					out += "x";
				}
			}
			out += "\n";
		}
		return out;
	}

}

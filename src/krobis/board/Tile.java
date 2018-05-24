package krobis.board;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Tile {

  private int val;
  
  public static final int SIZE = 48;
  
  private static final Color COLOR_TILE = new Color(0x6185b5);
  private static final Color COLOR_BORDER = new Color(0xeedede);
  
  private static final Font FONT_NUMBER = new Font("Garamond", Font.PLAIN, 32);
  
  public void draw(Graphics2D g) {
    throw new UnsupportedOperationException("Tile drawing not implemented");
  }
  
  public void doubleValue() {
    this.val *= this.val;
  }
  
  public int getValue() {
    return this.val;
  }
  
}

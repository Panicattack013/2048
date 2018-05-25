package krobis.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import krobis.game.GameController;

public class GUIHandler {
  
  private static final int HEIGHT = 600;
  private static final int WIDTH = 400;
  private static final int HEIGHT_OPTIONS = 200;
  private static final int HEIGHT_GAME = HEIGHT - HEIGHT_OPTIONS;
  public static final Dimension DIM_CONTAINER = new Dimension(GUIHandler.WIDTH, GUIHandler.HEIGHT);
  public static final Dimension DIM_OPTIONS = new Dimension(GUIHandler.WIDTH, GUIHandler.HEIGHT_OPTIONS);
  public static final Dimension DIM_GAME = new Dimension(GUIHandler.WIDTH, GUIHandler.HEIGHT_GAME);
  
  private static final int WIDTH_BEST = 50;
  private static final int HEIGHT_BEST = 30;
  private static final Dimension DIM_BEST = new Dimension(GUIHandler.WIDTH_BEST, GUIHandler.HEIGHT_BEST);
  
  private static final int WIDTH_SCORE = 100;
  private static final int HEIGHT_SCORE = 50;
  private static final Dimension DIM_SCORE = new Dimension(GUIHandler.WIDTH_SCORE, GUIHandler.HEIGHT_SCORE);
  
  private static final int WIDTH_TITLE = 150;
  private static final int HEIGHT_TITLE = 50;
  private static final Dimension DIM_TITLE = new Dimension(GUIHandler.WIDTH_TITLE, GUIHandler.HEIGHT_TITLE);
  
  private static final int WIDTH_SCORE_BEST = GUIHandler.WIDTH;
  private static final int HEIGHT_SCORE_BEST = 100;
  private static final Dimension DIM_SCORE_BEST = new Dimension(GUIHandler.WIDTH_SCORE_BEST, GUIHandler.HEIGHT_SCORE_BEST);
  
  private static final int WIDTH_INSTRUCTIONS = GUIHandler.WIDTH;
  private static final int HEIGHT_INSTRUCTIONS = 50;
  private static final Dimension DIM_INSTRUCTIONS = new Dimension(GUIHandler.WIDTH_INSTRUCTIONS, GUIHandler.HEIGHT_INSTRUCTIONS);
  
  private final JFrame mainframe = new JFrame("2048 in 20:48"); 
  
  private final JPanel container = new JPanel() { 
    private static final long serialVersionUID = 1L;

    @Override
    public void paintComponent(Graphics g) {
      g.setColor(Color.BLUE);
      g.fillRect(0, 0, GUIHandler.WIDTH, GUIHandler.HEIGHT);
    }
  };
  private final JPanel optionsPanel = new JPanel() { 
    private static final long serialVersionUID = 1L;

    @Override
    public void paintComponent(Graphics g) {
      g.setColor(Color.RED);
      g.fillRect(0, 0, GUIHandler.WIDTH, GUIHandler.HEIGHT_OPTIONS);
    }
    
  };
  private final JPanel gamePanel = new JPanel() { 
    private static final long serialVersionUID = 1L;

    @Override
    public void paintComponent(Graphics g) {
      g.setColor(Color.YELLOW);
      g.fillRect(0, 0, GUIHandler.WIDTH, GUIHandler.HEIGHT_GAME);
    }
    
  };
  
  private final JButton newGame = new JButton();
  
  private final JLabel score = new JLabel();
  private final JLabel best = new JLabel();
  private final JLabel title = new JLabel();
  private final JLabel instructions = new JLabel();
  
  private GameController gc;

  private static GUIHandler handler;
  
  public static GUIHandler getInstance(GameController gc) {
    if (GUIHandler.handler == null) {
      GUIHandler.handler = new GUIHandler(gc);
    }
    return GUIHandler.handler;
  }
  
  public GUIHandler(GameController gc) {
    this.gc = gc; 
  }
  
  public void init() { 
    this.initPanels();
    this.fin();
  } 
  
  private void initPanels() { 
    this.initPanelComponents();
    
    this.gamePanel.setPreferredSize(GUIHandler.DIM_GAME);
    
    
    this.optionsPanel.setPreferredSize(GUIHandler.DIM_OPTIONS);
    this.optionsPanel.setLayout(new BoxLayout(this.optionsPanel, BoxLayout.PAGE_AXIS)); 

    JPanel scoreBestContainer = new JPanel();
    scoreBestContainer.setPreferredSize(GUIHandler.DIM_SCORE_BEST); 
    scoreBestContainer.add(Box.createHorizontalStrut(100));
    scoreBestContainer.add(this.score); 
    scoreBestContainer.add(Box.createHorizontalStrut(50));
    scoreBestContainer.add(this.best); 
    
    this.optionsPanel.add(this.title);
    this.optionsPanel.add(scoreBestContainer);
    this.optionsPanel.add(this.instructions);
    
    this.container.setPreferredSize(GUIHandler.DIM_CONTAINER);
    this.container.setLayout(new BoxLayout(this.container, BoxLayout.PAGE_AXIS));
    
    this.container.add(this.optionsPanel);
    this.container.add(this.gamePanel);

    this.mainframe.setPreferredSize(GUIHandler.DIM_CONTAINER);
    this.mainframe.add(this.container);
  }
  
  private void initPanelComponents() {
    this.best.setText("Best: 0");
    this.best.setPreferredSize(GUIHandler.DIM_BEST);
    this.best.setOpaque(true);
    this.best.setBackground(Color.GRAY);
    
    this.score.setText("SCORE: 0");
    this.score.setPreferredSize(GUIHandler.DIM_SCORE);
    this.score.setOpaque(true);
    this.score.setBackground(Color.GRAY);
    
    this.title.setText("title");
    this.title.setPreferredSize(GUIHandler.DIM_TITLE); 
    
    this.instructions.setText("instructions");
    this.instructions.setPreferredSize(GUIHandler.DIM_INSTRUCTIONS);
  }
  
  private void fin() {
    this.mainframe.pack();
    this.mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.mainframe.setResizable(false);
    this.mainframe.setVisible(true);
  }

}



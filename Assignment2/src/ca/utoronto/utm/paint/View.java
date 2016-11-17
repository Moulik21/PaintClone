package ca.utoronto.utm.paint;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;
/**
 * This is the top level View+Controller, it contains other aspects of the View+Controller.
 * @author arnold
 **
 */
public class View extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private PaintModel model;
	
	// The components that make this up
	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	private ColourChooserPanel colourChooserPanel;
	private StyleChooserPanel styleSelector;
	private StrokeChooserPanel strokeChooserPanel;
	private ClearCanvasPanel clearCanvasPanel;
	private CurrentColourPanel currentColourPanel;
	private ColorPalette palette;

	
	public View(PaintModel model) {
		super("Paint"); // set the title and do other JFrame init
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(createMenuBar());
				
		Container c=this.getContentPane();
		
		//Model and PaintPanel
		this.model=model;
		
		this.paintPanel = new PaintPanel(model, this);
		c.add(this.paintPanel, BorderLayout.CENTER);
		
		this.shapeChooserPanel = new ShapeChooserPanel(this);
		this.colourChooserPanel = new ColourChooserPanel(this);
		this.styleSelector = new StyleChooserPanel(this);
		this.strokeChooserPanel = new StrokeChooserPanel(this);
		this.currentColourPanel = new CurrentColourPanel(this.paintPanel);
		this.palette = new ColorPalette(this.paintPanel, this);
		this.clearCanvasPanel = new ClearCanvasPanel(this);
		
		this.palette.addActionListener();
				
		this.shapeChooserPanel.add(this.styleSelector.getButton());
		this.shapeChooserPanel.add(this.strokeChooserPanel.getStrokeJComboBox());
		
		this.shapeChooserPanel.add(palette.getPanel1());
		this.shapeChooserPanel.add(palette.getPanel2());
		this.shapeChooserPanel.add(this.colourChooserPanel.getColourButton());
		this.shapeChooserPanel.add(currentColourPanel);
		this.shapeChooserPanel.add(this.clearCanvasPanel.getClearCanvasButton());		
		c.add(this.shapeChooserPanel,BorderLayout.WEST);
		this.pack();
		this.setSize(1000, 825);
		this.setVisible(true);

	}
	
	public StyleChooserPanel getStyleSelector(){
		return this.styleSelector;
	}

	public PaintPanel getPaintPanel(){
		return paintPanel;
	}
	
	public StrokeChooserPanel getStrokeChooserPanel(){
		return this.strokeChooserPanel;
	}
	
	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}
	
	public CurrentColourPanel getCurrentColourPanel() {
		return currentColourPanel;
	}
	/**
	 * create the top menu bar of the window
	 * @return
	 */
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem menuItem;

		menu = new JMenu("File");

		// a group of JMenuItems
		menuItem = new JMenuItem("New");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		menu = new JMenu("Edit");

		// a group of JMenuItems
		menuItem = new JMenuItem("Cut");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Copy");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Paste");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Undo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Redo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		return menuBar;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}
}

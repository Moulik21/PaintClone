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
	private colorPalette palette;
	
	public View(PaintModel model) {
		super("Paint"); // set the title and do other JFrame init
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(createMenuBar());
				
		Container c=this.getContentPane();
		
		this.shapeChooserPanel = new ShapeChooserPanel(this);
		
		this.colourChooserPanel = new ColourChooserPanel(this);
		this.styleSelector = new StyleChooserPanel(this);
		this.strokeChooserPanel = new StrokeChooserPanel(this);
		
		this.shapeChooserPanel.add(this.colourChooserPanel.getColourButton());
		this.shapeChooserPanel.add(this.styleSelector.getButton());
		this.shapeChooserPanel.add(this.strokeChooserPanel.getStrokeJComboBox());
		c.add(this.shapeChooserPanel,BorderLayout.WEST);
		
		
		//Model and PaintPanel
		this.model=model;
		
		this.paintPanel = new PaintPanel(model, this);
		c.add(this.paintPanel, BorderLayout.CENTER);
		
		//Colour Palette
		this.palette = new colorPalette(this.paintPanel);
		this.palette.addActionListener();
		c.add(this.palette, BorderLayout.EAST);
				
		this.pack();
		this.setSize(600,500);
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

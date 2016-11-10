package ca.utoronto.utm.paint;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A StrokeChoosePanel is a JPanel that contains a JComboBox of ImageIcons that are used 
 * to to select the different type of stroke that user can use. The available types of strokes
 * as a dashed stroke and 3 solid strokes of width 1px, 3px and 8px.
 * 
 *
 */
public class StrokeChooserPanel extends JPanel implements ActionListener {
	
	//Instance Variables
	private View view;	
	private JComboBox strokes;
	private ArrayList<BasicStroke> strokeList = new ArrayList<BasicStroke>();
	private BasicStroke stroke;
	private JComboBox myComboBox;
	
	/**
	 * Creates a new StrokeChoosePanel
	 * @param viewIn the view that contains the panel where the user will draw
	 */
	public StrokeChooserPanel(View viewIn){
		view = viewIn;
		ImageIcon[] imgList = new ImageIcon[4]; 
		
		//Create Image Icons from .png files
		try{
			BufferedImage img = ImageIO.read(getClass().getResource("dashed.png"));			
			imgList[0] = new ImageIcon(img);
			imgList[0].setDescription("Dashed");
			img = ImageIO.read(getClass().getResource("size1.png"));
			imgList[1] = new ImageIcon(img);
			imgList[1].setDescription("1px");
			img = ImageIO.read(getClass().getResource("size3.png"));
			imgList[2] = new ImageIcon(img);
			imgList[2].setDescription("3px");
			img = ImageIO.read(getClass().getResource("size8.png"));
			imgList[3] = new ImageIcon(img);
			imgList[3].setDescription("8px");
			
		}catch(IOException ex){}
		
		myComboBox = new JComboBox(imgList);
		myComboBox.setPreferredSize(new Dimension(5,5));
		myComboBox.setSelectedIndex(1);// solid stroke of width 1px will be selected by default
		myComboBox.addActionListener(this); //adding actionListener to the JComboBox
		
		//Create an ArrayList of Strokes
		float dash[] = { 10.0f };
		BasicStroke dashed = new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);		
		strokeList.add(dashed);
		BasicStroke size1 = new BasicStroke(1);
		strokeList.add(size1);		
		BasicStroke size3 = new BasicStroke(3);
		strokeList.add(size3);
		BasicStroke size5 = new BasicStroke(8);
		strokeList.add(size5);
		stroke = strokeList.get(1);
		
	}
	
	/**
	 * Changes the stroke of the PaintPanel when user selects a different type of stroke.
	 */	
	public void actionPerformed(ActionEvent e) {
		myComboBox = (JComboBox)e.getSource();
		int index = myComboBox.getSelectedIndex();
		stroke = strokeList.get(index);
		view.getPaintPanel().setStroke(stroke);
		
	}
	
	/**
	 * 
	 * @return the JComboBox that contains the ImageIcons
	 */
	public JComboBox getStrokeJComboBox(){
		return this.myComboBox;
	}

}

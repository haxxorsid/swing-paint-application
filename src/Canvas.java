import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Draw {

	public static void main(String[] args) {
		new Draw();
	}

	Canvas canvas;
	Color color = Color.WHITE;
	JButton clearButton, blackButton, blueButton, greenButton, redButton,
			colorPicker, magentaButton, grayButton, orangeButton, yellowButton,
			pinkButton, cyanButton, lightGrayButton, saveButton, loadButton,
			saveAsButton,rectangle,pencil;
	private JFileChooser fileChooser;
	private File file;
	private Icon save = new ImageIcon(getClass().getResource("save.png"));
	private Icon drawRect = new ImageIcon(getClass().getResource("rect.png"));
	private Icon drawPencil = new ImageIcon(getClass().getResource("pencil.png"));
	private int saveCounter = 0;
	private JLabel filenameBar,thicknessStat;
	private JSlider thicknessSlider;
	ChangeListener thick = new ChangeListener(){
		public void stateChanged(ChangeEvent e){
			thicknessStat.setText(String.format("%s",thicknessSlider.getValue()));
			canvas.setThickness(thicknessSlider.getValue());
		}
	};
	ActionListener listener = new ActionListener() {

		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == clearButton) {
				canvas.clear();
			} else if (event.getSource() == blackButton) {
				canvas.black();
			} else if (event.getSource() == blueButton) {
				canvas.blue();
			} else if (event.getSource() == greenButton) {
				canvas.green();
			} else if (event.getSource() == redButton) {
				canvas.red();
			} else if (event.getSource() == magentaButton) {
				canvas.magenta();
			} else if (event.getSource() == grayButton) {
				canvas.gray();
			} else if (event.getSource() == orangeButton) {
				canvas.orange();
			} else if (event.getSource() == yellowButton) {
				canvas.yellow();
			} else if (event.getSource() == pinkButton) {
				canvas.pink();
			} else if (event.getSource() == cyanButton) {
				canvas.cyan();
			} else if (event.getSource() == lightGrayButton) {
				canvas.lightGray();
			}else if (event.getSource() == saveButton) {
				if (saveCounter == 0) {
					fileChooser = new JFileChooser();
					if (fileChooser.showSaveDialog(saveButton) == JFileChooser.APPROVE_OPTION) {
						file = fileChooser.getSelectedFile();
						saveCounter = 1;
						filenameBar.setText(file.toString());
						canvas.save(file);
					}
				} else {
					filenameBar.setText(file.toString());
					canvas.save(file);
				}
			} else if (event.getSource() == saveAsButton) {
				saveCounter = 1;
				fileChooser = new JFileChooser();
				if (fileChooser.showSaveDialog(saveAsButton) == JFileChooser.APPROVE_OPTION) {
					file = fileChooser.getSelectedFile();
					filenameBar.setText(file.toString());
					canvas.save(file);
				}
			} else if (event.getSource() == loadButton) {
				fileChooser = new JFileChooser();
				if (fileChooser.showOpenDialog(loadButton) == JFileChooser.APPROVE_OPTION) {
					file = fileChooser.getSelectedFile();
					filenameBar.setText(file.toString());
					canvas.load(file);
				}
			} else if (event.getSource() == colorPicker) {
				color = JColorChooser.showDialog(null, "Pick your color!",
						color);
				if (color == null)
					color = (Color.WHITE);
				canvas.picker(color);
			}
		}
	};

	public Draw() {
		JFrame frame = new JFrame("Paint");
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		canvas = new Canvas();
		
		container.add(canvas, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		Box box = Box.createVerticalBox();
		Box box1 = Box.createHorizontalBox();
		
		panel1.setLayout(new FlowLayout());

		thicknessSlider = new JSlider(JSlider.HORIZONTAL,0,50,1);
		thicknessSlider.setMajorTickSpacing(25);
		thicknessSlider.setPaintTicks(true);
		thicknessSlider.setPreferredSize(new Dimension( 40, 40));
		thicknessSlider.addChangeListener(thick);
		blackButton = new JButton();
		blackButton.setBackground(Color.BLACK);
		blackButton.setPreferredSize(new Dimension(40, 40));
		blackButton.addActionListener(listener);
		blueButton = new JButton();
		blueButton.setBackground(Color.BLUE);
		blueButton.setPreferredSize(new Dimension(40, 40));
		blueButton.addActionListener(listener);
		greenButton = new JButton();
		greenButton.setBackground(Color.GREEN);
		greenButton.setPreferredSize(new Dimension(40, 40));
		greenButton.addActionListener(listener);
		redButton = new JButton();
		redButton.setBackground(Color.RED);
		redButton.setPreferredSize(new Dimension(40, 40));
		redButton.addActionListener(listener);
		magentaButton = new JButton();
		magentaButton.setBackground(Color.MAGENTA);
		magentaButton.setPreferredSize(new Dimension(40, 40));
		magentaButton.addActionListener(listener);
		grayButton = new JButton();
		grayButton.setBackground(Color.GRAY);
		grayButton.setPreferredSize(new Dimension(40, 40));
		grayButton.addActionListener(listener);
		orangeButton = new JButton();
		orangeButton.setBackground(Color.ORANGE);
		orangeButton.setPreferredSize(new Dimension(40, 40));
		orangeButton.addActionListener(listener);
		yellowButton = new JButton();
		yellowButton.setBackground(Color.YELLOW);
		yellowButton.setPreferredSize(new Dimension(40, 40));
		yellowButton.addActionListener(listener);
		pinkButton = new JButton();
		pinkButton.setBackground(Color.PINK);
		pinkButton.setPreferredSize(new Dimension(40, 40));
		pinkButton.addActionListener(listener);
		cyanButton = new JButton();
		cyanButton.setBackground(Color.CYAN);
		cyanButton.setPreferredSize(new Dimension(40, 40));
		cyanButton.addActionListener(listener);
		lightGrayButton = new JButton();
		lightGrayButton.setBackground(Color.LIGHT_GRAY);
		lightGrayButton.setPreferredSize(new Dimension(40, 40));
		lightGrayButton.addActionListener(listener);
		saveButton = new JButton(save);
		saveButton.addActionListener(listener);
		saveAsButton = new JButton("Save As");
		saveAsButton.addActionListener(listener);
		loadButton = new JButton("Load");
		loadButton.addActionListener(listener);
		colorPicker = new JButton("Color Picker");
		colorPicker.addActionListener(listener);
		clearButton = new JButton("Clear");
		clearButton.addActionListener(listener);
		
		filenameBar = new JLabel("No file");
		thicknessStat = new JLabel("1");
		
		box1.add(thicknessSlider,BorderLayout.NORTH);
		box1.add(thicknessStat,BorderLayout.NORTH);
		box.add(box1,BorderLayout.NORTH);
		panel1.add(filenameBar, BorderLayout.SOUTH);
		
		panel.add(greenButton);
		panel.add(blueButton);
		panel.add(blackButton);
		panel.add(redButton);
		panel.add(magentaButton);
		panel.add(grayButton);
		panel.add(orangeButton);
		panel.add(yellowButton);
		panel.add(pinkButton);
		panel.add(cyanButton);
		panel.add(lightGrayButton);
		panel.add(saveButton);
		panel.add(saveAsButton);
		panel.add(loadButton);
		panel.add(colorPicker);
		panel.add(clearButton);

		container.add(panel, BorderLayout.NORTH);
		container.add(panel1,BorderLayout.SOUTH);
		container.add(box,BorderLayout.WEST);
		
		frame.setVisible(true);
		
		frame.setSize(905, 905);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

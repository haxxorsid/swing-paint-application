import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Canvas extends JComponent {

	private int X1, Y1, X2, Y2;
	private Graphics2D g;
	
	private BufferedImage img;

	public void save(File file){
		 try {  
	       ImageIO.write(img, "PNG", new File("filename.png"));
	       
	    } catch (IOException ex) {}
	 }
	 
	public void load(File file) {
		try {
			img = ImageIO.read(new File("filename.png"));
			g = img.createGraphics();
		} catch (IOException ex) {
		}
	}

	protected void paintComponent(Graphics g1) {
		if (img == null) {
			img = (BufferedImage) createImage(getSize().width, getSize().height);
			g = (Graphics2D) img.getGraphics();
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			clear();
		}

		g1.drawImage(img, 0, 0, null);
	}

	public Canvas() {
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				X2 = e.getX();
				Y2 = e.getY();
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				X1 = e.getX();
				Y1 = e.getY();

				if (g != null) {
					g.drawLine(X2, Y2, X1, Y1);
					repaint();
					X2 = X1;
					Y2 = Y1;
				}
			}
		});
	}

	public void red() {
		g.setPaint(Color.red);
	}

	public void black() {
		g.setPaint(Color.black);
	}

	public void magenta() {
		g.setPaint(Color.magenta);
	}

	public void green() {
		g.setPaint(Color.green);
	}

	public void blue() {
		g.setPaint(Color.blue);
	}

	public void gray() {
		g.setPaint(Color.GRAY);
	}

	public void orange() {
		g.setPaint(Color.ORANGE);
	}

	public void yellow() {
		g.setPaint(Color.YELLOW);
	}

	public void pink() {
		g.setPaint(Color.PINK);
	}

	public void cyan() {
		g.setPaint(Color.CYAN);
	}

	public void lightGray() {
		g.setPaint(Color.lightGray);
	}

	public void picker(Color color) {
		g.setPaint(color);
	}

	public void clear() {
		g.setPaint(Color.white);
		g.fillRect(0, 0, getSize().width, getSize().height);
		g.setPaint(Color.black);
		repaint();
	}

}

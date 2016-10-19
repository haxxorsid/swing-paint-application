import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Canvas extends JComponent {

	private int X1, Y1, X2, Y2, checkTool = 0;
	private Graphics2D g;
	private Image img, background, undoTemp, redoTemp;
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	Point startDrag, endDrag;
	private final SizedStack<Image> undoStack = new SizedStack<>(12);
	private final SizedStack<Image> redoStack = new SizedStack<>(12);

	public void save(File file) {
		try {
			ImageIO.write((RenderedImage) img, "PNG", file);
		} catch (IOException ex) {
		}
	}

	public void load(File file) {
		try {
			img = ImageIO.read(file);
			g = (Graphics2D) img.getGraphics();
		}

		catch (IOException ex) {
		}
	}

	protected void paintComponent(Graphics g1) {
		if (img == null) {
			img = createImage(getSize().width, getSize().height);
			g = (Graphics2D) img.getGraphics();
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);

			clear();
			for (Shape s : shapes) {
				g.draw(s);
				g.fill(s);
			}

			if (startDrag != null && endDrag != null) {
				g.setPaint(Color.LIGHT_GRAY);
			}
		}

		g1.drawImage(img, 0, 0, null);
	}

	public Canvas() {
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				saveToStack(img);
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
		if (background != null) {
			setImage(copyImage(background));
		} else {
			g.setPaint(Color.white);
			g.fillRect(0, 0, getSize().width, getSize().height);
			g.setPaint(Color.black);
		}
		repaint();
	}

	public void undo() {
		if (undoStack.size() > 0) {
			undoTemp = undoStack.pop();
			redoStack.push(img);
			setImage(undoTemp);
		}
	}

	public void redo() {
		if (redoStack.size() > 0) {
			redoTemp = redoStack.pop();
			undoStack.push(img);
			setImage(redoTemp);
		}
	}

	private void setImage(Image img) {
		g = (Graphics2D) img.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setPaint(Color.black);
		this.img = img;
		repaint();
	}

	public void setBackground(Image img) {
		background = copyImage(img);
		setImage(copyImage(img));
	}

	private BufferedImage copyImage(Image img) {
		BufferedImage copyOfImage = new BufferedImage(getSize().width,
				getSize().height, BufferedImage.TYPE_INT_RGB);
		Graphics g = copyOfImage.createGraphics();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		return copyOfImage;
	}

	private void saveToStack(Image img) {
		undoStack.push(copyImage(img));
	}

	public void setThickness(int thick) {
		g.setStroke(new BasicStroke(thick));
	}

}

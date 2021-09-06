package swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MsPaint extends JFrame implements ActionListener {
	private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
	private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
	private JCheckBox fill;
	private JRadioButton line, circle, rect, roundRect, pen;
	private JComboBox<String> combo;
	private JButton draw;
	private DrCanvas can;
	private List<ShapeDTO> list;

	public MsPaint() {

		setTitle("�׸���");

		// �� ����
		x1L = new JLabel("x1", SwingConstants.RIGHT);
		x1L.setSize(70, 70);
		y1L = new JLabel("y1", SwingConstants.RIGHT);
		y1L.setSize(70, 70);
		x2L = new JLabel("x2", SwingConstants.RIGHT);
		x2L.setSize(70, 70);
		y2L = new JLabel("y2", SwingConstants.RIGHT);
		y2L.setSize(70, 70);
		z1L = new JLabel("z1", SwingConstants.RIGHT);
		z1L.setSize(70, 70);
		z2L = new JLabel("z2", SwingConstants.RIGHT);
		z2L.setSize(70, 70);

		// �ؽ�Ʈ �ʵ� ����
		x1T = new JTextField("0");
		x1T.setSize(70, 70);
		y1T = new JTextField("0");
		y1T.setSize(70, 70);
		x2T = new JTextField("0");
		x2T.setSize(70, 70);
		y2T = new JTextField("0");
		y2T.setSize(70, 70);
		z1T = new JTextField("50");
		z1T.setSize(70, 70);
		z2T = new JTextField("50");
		z2T.setSize(70, 70);

		// üũ�ڽ� ����
		fill = new JCheckBox("ä���");

		// ��ܺ�
		JPanel p = new JPanel(new GridLayout(1, 13, 0, 0));
		p.add(x1L);
		p.add(x1T);
		p.add(y1L);
		p.add(y1T);
		p.add(x2L);
		p.add(x2T);
		p.add(y2L);
		p.add(y2T);
		p.add(z1L);
		p.add(z1T);
		p.add(z2L);
		p.add(z2T);
		p.add(fill);

		// ĵ���� ȣ��
		can = new DrCanvas(this);

		list = new ArrayList<ShapeDTO>();

		// ���� ��ư ����
		line = new JRadioButton("��");
		circle = new JRadioButton("��");
		rect = new JRadioButton("�簢��", true);
		roundRect = new JRadioButton("�ձٻ簢��");
		pen = new JRadioButton("��");

		// �޺��ڽ� ����
		String[] color = { "����", "�ʷ�", "�Ķ�", "�ϴ�", "����" };
		combo = new JComboBox<String>(color);

		// �׸��� ��ư
		draw = new JButton("�׸���");

		// Radio��ư�� �׻� �׷�ó��

		ButtonGroup group = new ButtonGroup();

		group.add(line);
		group.add(circle);
		group.add(rect);
		group.add(roundRect);
		group.add(pen);

		// �ϴܺ� �гο� �߰�
		JPanel p2 = new JPanel();
		p2.add(line);
		p2.add(circle);
		p2.add(rect);
		p2.add(roundRect);
		p2.add(pen);
		p2.add(combo);
		p2.add(draw);

		// �����̳�
		Container c = this.getContentPane();

		// �����̳� �߰�
		c.add("North", p);
		c.add("Center", can);
		c.add("South", p2);

		setBounds(300, 150, 860, 500);
		setVisible(true);
		// setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// event
		draw.addActionListener(this);
		can.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x1T.setText(e.getX() + "");
				y1T.setText(e.getY() + "");
			}//mousepressed
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				if(Integer.parseInt(x1T.getText()) == e.getX() && Integer.parseInt(y1T.getText())== e.getY()) {
					return;
				}
				
				ShapeDTO dto = new ShapeDTO();
				
				//��ǥ
				dto.setX1(Integer.parseInt(x1T.getText()));
				dto.setY1(Integer.parseInt(y1T.getText()));
				dto.setX2(Integer.parseInt(x2T.getText()));
				dto.setY2(Integer.parseInt(y2T.getText()));
				dto.setZ1(Integer.parseInt(z1T.getText()));
				dto.setZ2(Integer.parseInt(z2T.getText()));

				//ä���
				dto.setFill(fill.isSelected());
			
				//����
				if(line.isSelected())dto.setShape(Shape.LINE);
				else if(circle.isSelected())dto.setShape(Shape.CIRCLE);
				else if(rect.isSelected())dto.setShape(Shape.RECT);
				else if(roundRect.isSelected())dto.setShape(Shape.ROUNDRECT);
				else if(pen.isSelected())dto.setShape(Shape.PEN);
				
				//��
				dto.setColor(combo.getSelectedIndex());
				

				list.add(dto);
				
				System.out.println(list);

			}//mousereleased
		});
		can.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				x2T.setText(e.getX() + "");
				y2T.setText(e.getY() + "");
				can.repaint();
				
				if(pen.isSelected()) {//��
					ShapeDTO dto = new ShapeDTO();
					
					//��ǥ
					dto.setX1(Integer.parseInt(x1T.getText()));
					dto.setY1(Integer.parseInt(y1T.getText()));
					dto.setX2(Integer.parseInt(x2T.getText()));
					dto.setY2(Integer.parseInt(y2T.getText()));
					
					//��
					dto.setColor(combo.getSelectedIndex());
					
					//����
					dto.setShape(Shape.PEN);
					
					list.add(dto);
					
					x1T.setText(x2T.getText());
					y1T.setText(y2T.getText());
					
				}//if
			}
		});


	}// MsPaint()

	@Override
	public void actionPerformed(ActionEvent e) {
		can.repaint();

	}// actionPerformed(ActionEvent e)

	public JTextField getX1T() {
		return x1T;
	}

	public JTextField getY1T() {
		return y1T;
	}

	public JTextField getX2T() {
		return x2T;
	}

	public JTextField getY2T() {
		return y2T;
	}

	public JTextField getZ1T() {
		return z1T;
	}

	public JTextField getZ2T() {
		return z2T;
	}

	public JComboBox<String> getCombo() {
		return combo;
	}

	public JCheckBox getFill() {
		return fill;
	}

	public JRadioButton getLine() {
		return line;
	}

	public JRadioButton getCircle() {
		return circle;
	}

	public JRadioButton getRect() {
		return rect;
	}

	public JRadioButton getRoundRect() {
		return roundRect;
	}
	public JRadioButton getPen() {
		return pen;
	}
	
	public List<ShapeDTO> getList() {
		return list;
	}

	// =---------------------------------------------------------------------------------
	public static void main(String[] args) {

		new MsPaint();
	}// main

}

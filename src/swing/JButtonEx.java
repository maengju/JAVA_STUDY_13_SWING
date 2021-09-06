package swing;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class JButtonEx extends JFrame {
	private Icon icon1 = new ImageIcon("image/모코코흑백.jpg");
	private Icon icon2 = new ImageIcon("image/[놀자에요].jpg");
	private Icon icon3 = new ImageIcon("image/[머쓱해요].png");
	private Icon icon4 = new ImageIcon("image/[놀자에몽].png");
	private JRadioButton[] jb = new JRadioButton[4];
	private ButtonGroup bg = new ButtonGroup();

	public JButtonEx() {
		super("Test");
		Container con = this.getContentPane(); //JFrame은 내부적으로 들어오는 구역을 미리 지정해 놓앗기때문에 소환
		con.setLayout(new GridLayout(2, 2));

		for (int i = 0; i < 4; i++) {
			jb[i] = new JRadioButton(i + 1 + "번 버튼", icon1);
			con.add(jb[i]);
			jb[i].setToolTipText(i + 1 + "번째 버튼입니다 눌러주세요");
			jb[i].setMnemonic(i + 49);
			jb[i].setRolloverIcon(icon2);
			jb[i].setPressedIcon(icon3);
			jb[i].setSelectedIcon(icon4);
			bg.add(jb[i]);

		}
		pack();
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new JButtonEx();
	}

}

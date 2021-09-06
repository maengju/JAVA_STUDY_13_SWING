package swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableEx2 extends JFrame implements ActionListener{
	
	private List<PersonDTO>list;
	private DefaultTableModel model;
	private JTable table;
	private JButton addBtn,delBtn;
	
	public JTableEx2() {
		list = new ArrayList<PersonDTO>();
		list.add(new PersonDTO("hong","ȫ�浿","111","010-123-1234"));
		list.add(new PersonDTO("connan","�ڳ�","333","010-777-7777")); // 
		
		Vector vector = new Vector<String>();
		vector.addElement("���̵�");
		vector.addElement("�̸�");
		vector.add("��й�ȣ");
		vector.add("�ڵ���");
		
		model = new DefaultTableModel(vector,0) {
			@Override
			public boolean isCellEditable(int row, int column) {		
				return column==0?false:true;
			}
		}; // �͸�Ŭ������ ������ �߻󿡼��� �����ִ°��� �ƴϴ�.
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		//������
		for(PersonDTO dto : list) {
			Vector<String> v = new Vector<String>();
			v.add(dto.getId());
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getPhone());
			
			model.addRow(v);
			
		}
		
		//��ư ���� 
		addBtn = new JButton("�߰�");
		delBtn = new JButton("����");
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(addBtn);
		p.add(delBtn);
		
		Container c = this.getContentPane(); // ������ ���� ��
		c.add("South",p);
		c.add(scroll);
		
		
		
		setBounds(400,150,500,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//�̺�Ʈ
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
		
		
	}
	
	public void insert() {
		String id = JOptionPane.showInputDialog(this,"���̵� �Է��ϼ���"); //�޴� ���̾�α�
		if(id==null) {
			JOptionPane.showMessageDialog(this,"���̵�� �ʼ��׸��Դϴ�");
			return;
		}
		
		// �ߺ� üũ
		for(int i = 0 ; i<model.getRowCount();i++) {
			if(id.equals(model.getValueAt(i, 0))) {//�ߺ�üũ�� ��ġ ���ϱ�
				JOptionPane.showMessageDialog(this,"��� ���� ���̵��Դϴ�");
				return;
			}
		}
		
		String name = JOptionPane.showInputDialog(this,"�̸��� �Է��ϼ���");
		
		String pwd = JOptionPane.showInputDialog(this,"��й�ȣ�� �Է��ϼ���");
		
		String phone = JOptionPane.showInputDialog(this,"�ڵ��� ��ȣ�� �Է��ϼ���");
		
		JOptionPane.showMessageDialog(this,"��ϿϷ�");
		
		
		Vector<String> v = new Vector<String>();
		v.add(id);
		v.add(name);
		v.add(pwd);
		v.add(phone);
		model.addRow(v);
	}
	//insert()
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addBtn) {//�߰�
			insert();
		}else if(e.getSource() == delBtn) {//����
			delete();
			
		}
		
		
	}
	
	public void delete() {
		// TODO Auto-generated method stub
		String name = JOptionPane.showInputDialog(this,"�̸��� �Է��ϼ���");
		int sw = 0;
		if(name ==null)return;
		
		for(int i=0; i < model.getRowCount(); i++) {
			if(name.equals(model.getValueAt(i, 1))) {
				model.removeRow(i);
				i--;
				sw=1;
			}
		}//for
		
		if(sw==0) JOptionPane.showMessageDialog(this, "ã�� �̸��� �����ϴ�.");
		else
			JOptionPane.showMessageDialog(this, "�����Ϸ�");
	}

	//=================================================================================
	
	
	
	public static void main(String[] args) {
		new JTableEx2();
	}

}

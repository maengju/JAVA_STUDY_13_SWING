package swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

class JTableModel extends AbstractTableModel {
	
	//JDK 9���ʹ� Wrapper Class�� �����ڰ� ������� AutoBoxing�ȴ�.
	Object[][] data = {{"Nari","����ġ",1234,"����ģ��"},
			{"one","������",1111,"������"},
			{"tow","������",2222,"�Ϳ�����"},
			{"three","�ƶ�ġ",3333,"���Ƹ�ģ��"}	};
	
	String[] name = {"���̵�","�̸�","��й�ȣ","����"};//�ʵ��
	

	@Override
	public int getRowCount() { // ���ǰ���
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public int getColumnCount() {//�÷��� ����
		// TODO Auto-generated method stub
		return name.length;
	}

	@Override
	public Object getValueAt(int r, int c) { //���� ��������°�
		// TODO Auto-generated method stub
		return data[r][c];
	}
	
	@Override
	public void setValueAt(Object ob, int r, int c) {
		data[r][c] = ob;
		
	}
	
	public String getColumnName(int c)	{//�ʵ�� Ÿ��Ʋ
		return name[c];
	}
	@Override
	public boolean isCellEditable(int r, int c) {
		//���� ? �� : ����
		return c==0 ? false : true;
	}
}













//==================================================================================
public class JTableEx extends JFrame{
	JTable table;
	JTableModel model;
	
	
	public JTableEx() {
		
		model = new JTableModel();
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		
		
		add(scroll);
		this.setBounds(400,100,300,300);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		new JTableEx();
		
	}

}

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
		list.add(new PersonDTO("hong","홍길동","111","010-123-1234"));
		list.add(new PersonDTO("connan","코난","333","010-777-7777")); // 
		
		Vector vector = new Vector<String>();
		vector.addElement("아이디");
		vector.addElement("이름");
		vector.add("비밀번호");
		vector.add("핸드폰");
		
		model = new DefaultTableModel(vector,0) {
			@Override
			public boolean isCellEditable(int row, int column) {		
				return column==0?false:true;
			}
		}; // 익명클래스는 무조건 추상에서만 쓸수있는것이 아니다.
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		//데이터
		for(PersonDTO dto : list) {
			Vector<String> v = new Vector<String>();
			v.add(dto.getId());
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getPhone());
			
			model.addRow(v);
			
		}
		
		//버튼 생성 
		addBtn = new JButton("추가");
		delBtn = new JButton("삭제");
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(addBtn);
		p.add(delBtn);
		
		Container c = this.getContentPane(); // 구역을 얻어내는 것
		c.add("South",p);
		c.add(scroll);
		
		
		
		setBounds(400,150,500,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//이벤트
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
		
		
	}
	
	public void insert() {
		String id = JOptionPane.showInputDialog(this,"아이디를 입력하세요"); //받는 다이얼로그
		if(id==null) {
			JOptionPane.showMessageDialog(this,"아이디는 필수항목입니다");
			return;
		}
		
		// 중복 체크
		for(int i = 0 ; i<model.getRowCount();i++) {
			if(id.equals(model.getValueAt(i, 0))) {//중복체크할 위치 정하기
				JOptionPane.showMessageDialog(this,"사용 중인 아이디입니다");
				return;
			}
		}
		
		String name = JOptionPane.showInputDialog(this,"이름를 입력하세요");
		
		String pwd = JOptionPane.showInputDialog(this,"비밀번호를 입력하세요");
		
		String phone = JOptionPane.showInputDialog(this,"핸드폰 번호를 입력하세요");
		
		JOptionPane.showMessageDialog(this,"등록완료");
		
		
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
		if(e.getSource()==addBtn) {//추가
			insert();
		}else if(e.getSource() == delBtn) {//삭제
			delete();
			
		}
		
		
	}
	
	public void delete() {
		// TODO Auto-generated method stub
		String name = JOptionPane.showInputDialog(this,"이름를 입력하세요");
		int sw = 0;
		if(name ==null)return;
		
		for(int i=0; i < model.getRowCount(); i++) {
			if(name.equals(model.getValueAt(i, 1))) {
				model.removeRow(i);
				i--;
				sw=1;
			}
		}//for
		
		if(sw==0) JOptionPane.showMessageDialog(this, "찾는 이름이 없습니다.");
		else
			JOptionPane.showMessageDialog(this, "삭제완료");
	}

	//=================================================================================
	
	
	
	public static void main(String[] args) {
		new JTableEx2();
	}

}

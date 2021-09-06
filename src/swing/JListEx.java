package swing;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class JListEx extends JFrame {

	public JListEx() {
		super("JList Test");// 부모생성사 호출

		setLayout(new FlowLayout()); // flowlayout 중앙을 기점으로 순서대로 붙음

		String[] listData = { "Hong", "Gil", "Dong", "JAVA", "JSP" };
		JList<String> list1 = new JList<String>(listData);
		list1.setSelectedIndex(0); // ?번항목에 초첨 맞추기

//		DefaultListModel<String> model = new DefaultListModel<String>();
//		JList<String> list2 = new JList<String>(model);

		JList<String> list2 = new JList<String>(new DefaultListModel<String>());
		DefaultListModel<String> model = (DefaultListModel<String>) list2.getModel();
		model.addElement("사과");
		model.addElement("배");
		model.addElement("딸기");
		model.addElement("바나나");
		list1.setSelectedIndex(1); // ?번항목에 초첨 맞추기

		Vector<String> vListData = new Vector<String>();
		JList<String> list3 = new JList<String>(vListData);
		JScrollPane scroll = new JScrollPane(list3);
		vListData.add("축구");
		vListData.add("야구");
		vListData.add("농구");
		vListData.add("배구");
		vListData.add("테니스");
		vListData.add("수영");
		vListData.add("육상");
		vListData.add("태권도");
		vListData.add("유도");

		class Student {
			String id;
			String name;
			String departMent;

			public Student(String id, String name, String departMent) {
				super();
				this.id = id;
				this.name = name;
				this.departMent = departMent;
			}
			@Override
			public String toString() {
				return name;
			}

		}

		JList<Student> list4 = new JList<Student>(new DefaultListModel<Student>());
		DefaultListModel<Student> model2 = (DefaultListModel<Student>) list4.getModel();
		list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model2.addElement(new Student("100", "홍길동", "전산과"));
		model2.addElement(new Student("200", "손오공", "건축과"));
		model2.addElement(new Student("300", "사오정", "토목과"));
		model2.addElement(new Student("400", "저팔계", "경영학"));
		list4.setSelectedIndex(1);

		add(list1);
		add(list2);
		add(scroll);
		add(list4);

		setBounds(300, 200, 300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JListEx();

	}

}

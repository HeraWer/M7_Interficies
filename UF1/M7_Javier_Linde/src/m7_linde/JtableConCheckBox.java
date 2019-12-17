package m7_linde;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class JtableConCheckBox extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JtableConCheckBox frame = new JtableConCheckBox();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public JtableConCheckBox() {
		JScrollPane scrollPane_1;
		DefaultTableModel model = new DefaultTableModel() {
			
			private static final long serialVersionUID = 1L;

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return Float.class;
				default:
					return Boolean.class;
				}
			}
		};
		model.addColumn("column1");
		model.addColumn("column2");
		model.addColumn("colFloat");
		model.addColumn("colBool");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(38, 32, 314, 218);
		contentPane.add(panel);
		
		table = new JTable(model);
		scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(10, 11, 342, 415);
		contentPane.add(scrollPane_1);
		model.addRow(new Object[] { "fsdfas", "fdsf",65f, false });
	}
}

package test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class JTableCheckBox extends JFrame {

	/*
	 * Componentes que usaremos
	 */
	JTable table;
	DefaultTableModel model;
	DefaultListSelectionModel selectionModel;
// Muy importante para que se vea la tabla el JScrollPane!!!!!
	JScrollPane scroll;
	JInternalFrame panel;
	JButton button;

	public JTableCheckBox() {
		super("");

		/*
		 * PARA AÑADIR UN MENU EN LA APP:
		 */
		JMenuBar menu = new JMenuBar();
		JMenu menuMenu = new JMenu("Menu1");
		JMenuItem menuItem = new JMenuItem("Menu Item 1");
		menu.add(menuMenu);
		menuMenu.add(menuItem);
		this.setJMenuBar(menu);
		JMenu menuMenu2 = new JMenu("Menu2");
		menu.add(menuMenu2);

		this.getContentPane().setLayout(new GridLayout(2, 1));
		panel = new JInternalFrame();
		panel.setVisible(true);
		panel.setLayout(new GridLayout(1, 1));
// Seteamos un GridLayout()

// Le damos tamaño al Jframe
		this.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.8),
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.8));

// hacemos visible el jframe
		this.setVisible(true);
// Inicializamos, preferiblemente en este orden!
		button = new JButton("Borrar");
		model = new DefaultTableModel();
		table = new JTable(model);
		selectionModel = new DefaultListSelectionModel();
		table.setSelectionModel(selectionModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scroll = new JScrollPane(table);

		this.getContentPane().add(panel);
		panel.add(scroll);

		model.setColumnIdentifiers(new String[] { "Hola", "Que", "tal" });

		/*
		 * METER CHECKBOX EN LA TABLA!!!!
		 */
		table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(new JCheckBox()));
		table.getColumnModel().getColumn(2).setCellRenderer(new TableCellRenderer() {

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				JCheckBox cb = new JCheckBox();
				cb.setBackground(Color.GREEN);
				cb.setSelected((Boolean) value);
				return cb;
			}
		});

		/*
		 * AÑADIMOS DATOS A LA TABLA
		 */
		Vector<Object> v;
		v = new Vector<Object>();
		v.add("Adios");
		v.add("Muy Bien");
		v.add(true);
		model.addRow(v);

		v = new Vector<Object>();
		v.add("Adios");
		v.add("Muy Bien");
		v.add(true);
		model.addRow(v);

		v = new Vector<Object>();
		v.add("Adios");
		v.add("Muy Bien");
		v.add(false);
		model.addRow(v);

		v = new Vector<Object>();
		v.add("Adios");
		v.add("Muy Bien");
		v.add(true);
		model.addRow(v);

// Button Listener
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				/*
				 * MUY IMPORTANTE BORRAR DEL FINAL AL PRINCIPIO!!!
				 */
				for (int i = table.getRowCount() - 1; i >= 0; i--) {
// Comprobamos el valor de la celda
					if ((boolean) table.getValueAt(i, 2)) {
// Removemos la row
						model.removeRow(i);

// En caso de querer pasar de table a otra:
						/*
						 * Vector<Object> v = new Vector<Object>(); v.add(tabla1.getValueAt(i, 0);
						 * v.add(tabla1.getValueAt(i, 1); v.add(tabla1.getValueAt(i, 2);
						 * modeloTabla2.addRow(v); modeloTabla1.removeRow(i);
						 */
					}
				}
			}
		});

		this.getContentPane().add(button);

	}

	public static void main(String[] args) {

		/*
		 * PARA CORRER LA UI EN UN THREAD APARTE
		 */
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new JTableCheckBox();
			}
		});

	}

}
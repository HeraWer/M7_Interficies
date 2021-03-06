package ciudades;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public DatosCiudades intercambioDatos;
	private DefaultTableModel dtm;
	private VentanaPreguntas vp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {

		intercambioDatos = new DatosCiudades();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setBorder(new CompoundBorder());
		
		// Lo uso para poder seleccionar las columnas
		table.setCellSelectionEnabled(true);
		
		// Nombres de las columnas
		String[] nombreColumnas = { "Comunidad Aut", "Provincia", "N� Habitantes", "Metros cuadrados" };
		dtm = new DefaultTableModel(nombreColumnas, 0);

		// ListSelectionModel contendr� las filas seleccionadas
		ListSelectionModel select = table.getSelectionModel();
		// solo podremos seleccionar una fila
		select.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		// A�adimos un listener para actuar cuando se selecciona
		select.addListSelectionListener(new ListSelectionListener() {

			// Este metodo es para que cuando seleccionemos una fila y columna ir marcandola en la consola.
			public void valueChanged(ListSelectionEvent e) {
				String Data = null;
				int[] row = table.getSelectedRows();
				int[] columns = table.getSelectedColumns();
				for (int i = 0; i < row.length; i++) {
					System.out.println("La fila es " + i + " y tiene " + columns.length);
					for (int j = 0; j < columns.length; j++) {
						Data = (String) table.getValueAt(row[i], columns[j]);
						System.out.println("Table element selected is: " + Data);
					}
				}

			}
		});

		// Aqui creo varias comunidades autonomas con su provincia como ejemplo.
		Vector<String> v = new Vector<String>();
		v.add("Catalunya");
		v.add("Lleida");
		v.add("438.000");
		v.add("211.7 km�");
		dtm.addRow(v);
		table.setModel(dtm);

		v = new Vector<String>();
		v.add("Castilla la Mancha");
		v.add("Ciudad Real");
		v.add("74.643");
		v.add("19.813 km�");
		dtm.addRow(v);
		table.setModel(dtm);

		v = new Vector<String>();
		v.add("Extremadua");
		v.add("Caceres");
		v.add("95.917");
		v.add("129 km�");
		dtm.addRow(v);
		table.setModel(dtm);

		JScrollPane sp = new JScrollPane(table);

		// Boton para a�adir una nueva provincia con su comunidad autonoma, metros,
		// habitantes.
		JButton btnNueva = new JButton("Nueva");
		btnNueva.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vp.setVisible(true);
			}

		});

		// Boton para eliminar un linea de la tabla.
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] row = table.getSelectedRows();
				System.out.println("Numero de filas seleccionadas: " + row.length);
				for (int i = row.length - 1; i >= 0; i--) {
					dtm.removeRow(row[i]);
				}
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(sp, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnNueva)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnEliminar).addGap(260)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(sp, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNueva).addComponent(btnEliminar))
								.addContainerGap(55, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

		// A�ado un listener a VentanaPreguntas para hacer algo cuando se cierre esta
		// ventana
		vp = new VentanaPreguntas(this, "Introduzca datos de la ciudad...");
		vp.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("Cierre de ventana");
				// Devolvuevo los datos para a�adirlos a la tabla.
				intercambioDatos = vp.devolverDatos();
				System.out.println("Nombre=" + intercambioDatos.nombre);
				// El metodo siguiente lo que hace es a�adir los datos a la tabla.
				anadirCiudad();
			}
		});

	}

	// En este metodo a�ado todos los datos que recojo en el dialogo y los a�ado a
	// la tabla.
	private void anadirCiudad() {
		Vector<String> v = new Vector<String>();

		v.add(intercambioDatos.nombre);
		v.add(intercambioDatos.provincia);
		v.add(String.valueOf(intercambioDatos.habitantes));
		v.add(String.valueOf(intercambioDatos.metro2));
		dtm.addRow(v);
	}
}

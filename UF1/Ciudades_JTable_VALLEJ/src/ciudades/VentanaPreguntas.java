package ciudades;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Aqui creamos la ventana emergente cuando le damos al boton NUEVA.
public class VentanaPreguntas extends JDialog implements ActionListener {
	private JTextField txtNombre;
	private JTextField txtMetros2;
	private JTextField txtHabitantes;
	private DatosCiudades datosIntercambio;
	private JTextField txtComarca;

	public VentanaPreguntas(JFrame padre, String titulo) {

		super(padre, titulo);
		// this.datosIntercambio=datosIntercambio;
		setTitle("Datos Provincia");
		setBounds(0, 0, 350, 300);
		datosIntercambio = new DatosCiudades();

		// Componentes del dialogo donde insertare los datos de la nueva ciudad con su
		// comunidad autonoma, metros y habitantes.
		JLabel lblNombreDeLa = new JLabel("Comunidad Autonoma:");

		txtNombre = new JTextField();
		txtNombre.setColumns(10);

		JLabel lblMetrosCuadrados = new JLabel("Metros Cuadrados");

		txtMetros2 = new JTextField();
		txtMetros2.setColumns(10);

		JLabel lblNumeroHabitantes = new JLabel("N� habitantes");

		txtHabitantes = new JTextField();
		txtHabitantes.setColumns(10);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(this);

		JLabel lblComarca = new JLabel("Provincia");

		txtComarca = new JTextField();
		txtComarca.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout
								.createSequentialGroup().addGap(
										23)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 275,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblComarca, GroupLayout.PREFERRED_SIZE, 101,
														GroupLayout.PREFERRED_SIZE)
												.addGap(10).addComponent(txtComarca, GroupLayout.PREFERRED_SIZE, 145,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblNombreDeLa)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 145,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblMetrosCuadrados, GroupLayout.PREFERRED_SIZE,
																101, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(txtMetros2, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblNumeroHabitantes, GroupLayout.PREFERRED_SIZE,
																101, GroupLayout.PREFERRED_SIZE)
														.addGap(10).addComponent(txtHabitantes,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))))
								.addGap(36)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(27)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNombreDeLa).addComponent(
						txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(28)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblComarca))
						.addComponent(txtComarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(35)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblNumeroHabitantes))
						.addComponent(txtHabitantes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(31)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMetros2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMetrosCuadrados))
				.addGap(18).addComponent(btnOk).addContainerGap(31, Short.MAX_VALUE)));
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] { txtNombre, txtMetros2, txtHabitantes });
		groupLayout.linkSize(SwingConstants.HORIZONTAL,
				new Component[] { lblNombreDeLa, lblMetrosCuadrados, lblNumeroHabitantes });
		getContentPane().setLayout(groupLayout);
	}

	// Eesto es para psar todos los datos recogidos en el dialogo y comprobados si son enteros los de metros y habitantes
	// Los almaceno en la clase DatosCiudades para luego llamar al metedo DevolverDatos y a si almaceno los datos en la tabla.
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		datosIntercambio.nombre = txtNombre.getText();
		datosIntercambio.provincia = txtComarca.getText();
		try {
			datosIntercambio.habitantes = Float.parseFloat(txtHabitantes.getText());
		} catch (NumberFormatException nfe) {
			datosIntercambio.habitantes = 0.0f;
		}
		try {
			datosIntercambio.metro2 = Float.parseFloat(txtMetros2.getText());
		} catch (NumberFormatException nfe) {
			datosIntercambio.metro2 = 0.0f;
		}
		this.dispose();
	}

	public DatosCiudades devolverDatos() {
		return datosIntercambio;
	}
}

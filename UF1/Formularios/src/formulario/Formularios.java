package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Formularios extends JFrame {
	public static JTextArea textArea;
	public static JLabel lblNombre, lblCiudad, lblAficiones, lblGnero;
	public static JComboBox comboBox;
	public static JCheckBox chckbxGolf, chckbxTenis, chckbxPadel, chckbxPetanca;
	public static JRadioButton rdbtnHombre, rdbtnMujer;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formularios frame = new Formularios();
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
	public Formularios() {
		setMinimumSize(new Dimension(450, 300));
		getContentPane().setMinimumSize(new Dimension(500, 300));
		getContentPane().setName("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Peque\u00F1o formulario");
		getContentPane().setLayout(null);

		// CREO TODOS LOS COMPONENTES NECESARIOS
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(28, 39, 53, 14);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblNombre);

		textArea = new JTextArea();
		textArea.setBounds(103, 34, 134, 22);
		getContentPane().add(textArea);

		lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(28, 78, 46, 14);
		lblCiudad.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblCiudad);

		comboBox = new JComboBox();
		comboBox.setBounds(103, 75, 134, 22);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Escoja una ciudad", "Barcelona", "Madrid", "Valencia" }));
		comboBox.setToolTipText("");
		getContentPane().add(comboBox);

		lblAficiones = new JLabel("Aficiones:");
		lblAficiones.setBounds(28, 124, 63, 14);
		lblAficiones.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblAficiones);

		lblGnero = new JLabel("G\u00E9nero:");
		lblGnero.setBounds(246, 125, 53, 14);
		lblGnero.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblGnero);

		chckbxGolf = new JCheckBox("Golf");
		chckbxGolf.setBounds(38, 145, 97, 23);
		chckbxGolf.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(chckbxGolf);

		chckbxTenis = new JCheckBox("Tenis");
		chckbxTenis.setBounds(38, 189, 97, 23);
		chckbxTenis.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(chckbxTenis);

		chckbxPadel = new JCheckBox("Padel");
		chckbxPadel.setBounds(140, 145, 97, 23);
		chckbxPadel.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(chckbxPadel);

		chckbxPetanca = new JCheckBox("Petanca");
		chckbxPetanca.setBounds(137, 189, 97, 23);
		chckbxPetanca.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(chckbxPetanca);

		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(276, 145, 109, 23);
		buttonGroup.add(rdbtnHombre);
		rdbtnHombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(rdbtnHombre);

		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBounds(276, 189, 109, 23);
		buttonGroup.add(rdbtnMujer);
		rdbtnMujer.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(rdbtnMujer);

		// AQUI LA LLAMADA AL BOTON CUANDO ES CLICADO
		JButton btnNewButton = new JButton("ENVIAR");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					// CREO UNA CONDICION QUE SI NO SE CUMPLE SALTA UN ERROR
					if(textArea.getText().equals("") || comboBox.getSelectedIndex() == 0 || (!rdbtnHombre.isSelected() && !rdbtnMujer.isSelected())) {
						JOptionPane.showMessageDialog(null, "Hay que rellenar todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
					}else { // SI NO SE CUMPLE SALE LA VENTANA NORMAL CON LOS DATOS 
						Secundario sec = new Secundario();
						sec.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 227, 414, 23);
		btnNewButton.setToolTipText("");
		getContentPane().add(btnNewButton);
	}
}

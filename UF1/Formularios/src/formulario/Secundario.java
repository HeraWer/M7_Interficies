package formulario;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class Secundario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Secundario frame = new Secundario();
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
	public Secundario() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		// CREO EL TEXTAREA
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false); // LE DIGO QUE NO SEA EDITABLE
		String aux; // CREO UN STRING QUE ALMACENARA TODAS LAS OPCIONES DE LA VENTANA PRINCIPAL
		aux = "Nombre: " + Formularios.textArea.getText() + "\n" +
		"Ciudad: " + Formularios.comboBox.getSelectedItem() + "\n" +
		"Aficiones: ";
		if(Formularios.chckbxGolf.isSelected()) {
			aux = aux + "Golf ";
		}
		if(Formularios.chckbxTenis.isSelected()) {
			aux = aux + "Tenis ";
		}
		if(Formularios.chckbxPadel.isSelected()) {
			aux = aux + "Padel ";
		}
		if(Formularios.chckbxPetanca.isSelected()) {
			aux = aux + "Petanca ";
		}
		if(!Formularios.chckbxGolf.isSelected() || !Formularios.chckbxTenis.isSelected() || !Formularios.chckbxTenis.isSelected() || !Formularios.chckbxPetanca.isSelected()) {
			aux = aux + "No tiene aficiones\n" ;
		}else {
		
		aux = aux + "\n"; 
		}
		aux = aux + "Genero: ";
		
		if(Formularios.rdbtnMujer.isSelected()) {
			aux = aux + "Mujer";
		}else if(Formularios.rdbtnHombre.isSelected()) {
			aux = aux + "Hombre";
		}
		textArea.setText(aux);
		contentPane.add(textArea);
	}
}

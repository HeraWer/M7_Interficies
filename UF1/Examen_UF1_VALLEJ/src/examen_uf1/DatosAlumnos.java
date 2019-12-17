package examen_uf1;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JLabel;
import javax.swing.JList;


public class DatosAlumnos extends JFrame {
	
	private JTextField nombre;
	private JTextField primerApellido;
	private JTextField segundoApellido;
	private JTextField telefono;
	private JScrollPane scroll;
	private static ArrayList<Alumno> alumnosASIX = new ArrayList<Alumno>();;
	private static ArrayList alumnosDAM;
	private static ArrayList alumnosDAW;
	
	DefaultListModel<Alumno> mAlumnos = new DefaultListModel<Alumno>();
	
	public static void main(String[] args) {
		
		Alumno alu3 =   new Alumno("ap1_1", "ap2_1",  "Nombre1", "456325234", "ASIX");
		Alumno alu4 =   new Alumno("ap1_2", "ap2_2",  "Nombre2", "356746534", "ASIX");
		Alumno alu1 =   new Alumno("ap1_3", "ap2_3",  "Nombre3", "789653342", "ASIX");
		Alumno alu2 =   new Alumno("ap1_4", "ap2_4",  "Nombre4", "337638377", "ASIX");
		Alumno alu2a =  new Alumno("ap1_4a", "ap2_4a",  "Nombre4a", "337638377a", "ASIX");
		Alumno alu2b =  new Alumno("ap1_4b", "ap2_4b",  "Nombre4b", "337638377b", "ASIX");
		Alumno alu2c =  new Alumno("ap1_4c", "ap2_4c",  "Nombre4c", "337638377c", "ASIX");
		Alumno alu2d =  new Alumno("ap1_4d", "ap2_4d",  "Nombre4d", "337638377d", "ASIX");
		
		Alumno alu5 =  new Alumno("ap1_5", "ap2_5",   "Nombre5", "345627277", "DAM");
		Alumno alu6 =  new Alumno("ap1_6", "ap2_6",   "Nombre6", "245723672", "DAM");
		Alumno alu7 =  new Alumno("ap1_7", "ap2_7",   "Nombre7", "845632235", "DAM");
		Alumno alu8 =  new Alumno("ap1_8", "ap2_8",   "Nombre8", "345648335", "DAM");
		
		Alumno alu9 =  new Alumno("ap1_9", "ap2_9",   "Nombre9", "345277376", "DAW");
		Alumno alu10 = new Alumno("ap1_10", "ap2_10", "Nombre10", "2452626226", "DAW");
		Alumno alu11 = new Alumno("ap1_11", "ap2_11", "Nombre11", "262623446", "DAW");
		Alumno alu12 = new Alumno("ap1_12", "ap2_12", "Nombre12", "456346346", "DAW");
		
		alumnosASIX.add(alu3);
		alumnosASIX.add(alu4);
		alumnosASIX.add(alu1);
		alumnosASIX.add(alu2);
		alumnosASIX.add(alu2a);
		alumnosASIX.add(alu2b);
		alumnosASIX.add(alu2c);
		alumnosASIX.add(alu2d);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosAlumnos frame = new DatosAlumnos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		
	}
	
	public DatosAlumnos() {
		setMinimumSize(new Dimension(800, 800));
		getContentPane().setMinimumSize(new Dimension(500, 300));
		getContentPane().setName("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Datos Alumnos");
		getContentPane().setLayout(null);
		
		nombre = new JTextField();
		nombre.setBounds(610, 77, 86, 20);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		primerApellido = new JTextField();
		primerApellido.setBounds(610, 140, 86, 20);
		getContentPane().add(primerApellido);
		primerApellido.setColumns(10);
		
		segundoApellido = new JTextField();
		segundoApellido.setBounds(610, 203, 86, 20);
		getContentPane().add(segundoApellido);
		segundoApellido.setColumns(10);
		
		telefono = new JTextField();
		telefono.setBounds(610, 271, 86, 20);
		getContentPane().add(telefono);
		telefono.setColumns(10);
		
		JLabel nombreLabel = new JLabel("Nombre:");
		nombreLabel.setBounds(450, 80, 100, 14);
		getContentPane().add(nombreLabel);
		
		JLabel primerApellidoLabel = new JLabel("Primer Apellido");
		primerApellidoLabel.setBounds(450, 143, 100, 14);
		getContentPane().add(primerApellidoLabel);
		
		JLabel segundoApellidoLabel = new JLabel("Segundo Apellido");
		segundoApellidoLabel.setBounds(450, 206, 100, 14);
		getContentPane().add(segundoApellidoLabel);
		
		JLabel telefonoLabel = new JLabel("Telefono");
		telefonoLabel.setBounds(450, 274, 100, 14);
		getContentPane().add(telefonoLabel);
		
		
		
		JList<Alumno> list = new JList<Alumno>();
		list.setModel(mAlumnos);
		scroll = new JScrollPane(list);
		scroll.setBounds(173, 484, 161, 192);
		scroll.setVisible(true);
		getContentPane().add(scroll);

		
		
		
		JButton ciclo = new JButton("AWS");
		ciclo.setBounds(172, 200, 100, 100);
		getContentPane().add(ciclo);
		ciclo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for(int i=0; i<alumnosASIX.size(); i++) {
				    mAlumnos.add(i, alumnosASIX.get(i));
				}
				list.setModel(mAlumnos);
			}
		});
	}
}

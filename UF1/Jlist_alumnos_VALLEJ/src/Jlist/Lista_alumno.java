package Jlist;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;

public class Lista_alumno extends JFrame {
	
	DefaultListModel<String> mAlumnos = new DefaultListModel<String>();
	DefaultListModel<String> mMatriculados = new DefaultListModel<String>();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lista_alumno frame = new Lista_alumno();
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
	public Lista_alumno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblListaAlumnos = new JLabel("Lista Alumnos");
		
		JLabel lblListaMatriculados = new JLabel("Lista Matriculados");
		
		JLabel lblNuevoAlumno = new JLabel("Nuevo alumno:");
		
		JTextArea inscribirTextArea = new JTextArea();
		
		
		JList<String> listAlumnos = new JList<String>();
		listAlumnos.setModel(mAlumnos);
		listAlumnos.setVisible(true);
		
		JList<String> listMatriculados = new JList<String>();
		listMatriculados.setModel(mMatriculados);
		listMatriculados.setVisible(true);
		
		JButton btnInscribir = new JButton("Inscribir");
		btnInscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mAlumnos.addElement(inscribirTextArea.getText());
				inscribirTextArea.setText("");;
			}
		});
		
		JButton btnEliminarAlumnoSeleccionado = new JButton("Eliminar alumno seleccionado");
		btnEliminarAlumnoSeleccionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
				mAlumnos.remove(listAlumnos.getSelectedIndex());
				}catch(Exception eRemove) {
					mMatriculados.remove(listMatriculados.getSelectedIndex());
				}
			}
		});
		
		JButton btnMatricular = new JButton("Matricular");
		btnMatricular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] sele = listAlumnos.getSelectedIndices();
				mAlumnos = (DefaultListModel<String>) listAlumnos.getModel();
				mMatriculados = (DefaultListModel<String>) listMatriculados.getModel();
				for(int i = sele.length - 1; i >= 0; i--) {
					mMatriculados.addElement(mAlumnos.get(sele[i]));
					mAlumnos.remove(sele[i]);
				}
			}
		});
		
		
		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] sele = listMatriculados.getSelectedIndices();
				mAlumnos = (DefaultListModel<String>) listAlumnos.getModel();
				mMatriculados = (DefaultListModel<String>) listMatriculados.getModel();
				for(int i = sele.length - 1; i >= 0; i--) {
					mAlumnos.addElement(mMatriculados.get(sele[i]));
					mMatriculados.remove(sele[i]);
				}
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(76)
					.addComponent(lblListaAlumnos)
					.addPreferredGap(ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
					.addComponent(lblListaMatriculados)
					.addGap(85))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNuevoAlumno)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnInscribir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(inscribirTextArea, Alignment.LEADING)
						.addComponent(btnEliminarAlumnoSeleccionado, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
					.addContainerGap(348, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(listAlumnos, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnQuitar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnMatricular, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(listMatriculados, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblListaAlumnos)
						.addComponent(lblListaMatriculados))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(65)
							.addComponent(btnMatricular)
							.addGap(18)
							.addComponent(btnQuitar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(listAlumnos, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
								.addComponent(listMatriculados, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNuevoAlumno)
						.addComponent(btnInscribir))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(inscribirTextArea, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEliminarAlumnoSeleccionado)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

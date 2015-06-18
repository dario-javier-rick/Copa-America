package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Logica.Arquero;
import Logica.Defensor;
import Logica.Delantero;
import Logica.Jugador;
import Logica.Mediocampista;
import Recursos.Fondo;

import java.awt.Toolkit;

public class GenerarEquipo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static GenerarEquipo frame = new GenerarEquipo();
	DefaultListModel<Jugador> listModel = new DefaultListModel<Jugador>();
	JList<Jugador> listJugadores = new JList<Jugador>(listModel);
	JScrollPane pane = new JScrollPane(listJugadores);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GenerarEquipo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				GenerarEquipo.class.getResource("/Recursos/copa-icon.png")));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 414);
		Fondo p = new Fondo();
		p.setBackground(Color.BLACK);
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);
		
		add(pane, BorderLayout.NORTH);

		bindJugadores();
		
		listJugadores.setBounds(0, 0, 100, 100);
		p.add(listJugadores);
		
		
		
	}

	private void bindJugadores() {
		try {
			ArrayList<Delantero> delanteros = Delantero.getJugadores();
			for (Delantero delantero : delanteros) {
				listModel.addElement(delantero);
			}
//			ArrayList<Mediocampista> mediocampistas = Mediocampista.getJugadores();
//			for (Mediocampista mediocampista : mediocampistas) {
//				listModel.addElement(mediocampista);
//			}
//			ArrayList<Defensor> defensores = Defensor.getJugadores();
//			for (Defensor defensor : defensores) {
//				listModel.addElement(defensor);
//			}
//			ArrayList<Arquero> arqueros = Arquero.getJugadores();
//			for (Arquero arquero: arqueros) {
//				listModel.addElement(arquero);
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

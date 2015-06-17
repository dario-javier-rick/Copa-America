package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;

import Logica.Delantero;
import Logica.Jugador;
import Recursos.Fondo;
import java.awt.Toolkit;

public class GenerarEquipo extends JFrame {

	public static GenerarEquipo frame1 = new GenerarEquipo();
	private JFrame frame;
	DefaultListModel<Jugador> listModel = new DefaultListModel<Jugador>();
	JList<Jugador> listJugadores = new JList<Jugador>(listModel);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1.setVisible(true);
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(GenerarEquipo.class.getResource("/Recursos/copa-icon.png")));
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
		
		listJugadores.setBounds(33, 181, 106, -151);
		p.add(listJugadores);

		bindJugadores();
	}

	private void bindJugadores() {
		try {
			ArrayList<Delantero> delanteros = Delantero.getJugadores();
			for (Delantero delantero : delanteros) {
				listModel.addElement(delantero);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

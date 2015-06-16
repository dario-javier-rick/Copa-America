package Interfaz;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import Logica.Delantero;
import Logica.Jugador;

public class GenerarEquipo {

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
					GenerarEquipo window = new GenerarEquipo();
					window.frame.setVisible(true);
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		listJugadores.setBounds(33, 161, 107, -131);
		frame.getContentPane().add(listJugadores);

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

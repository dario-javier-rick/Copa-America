package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;

import Logica.Jugador;

import java.awt.Font;
import java.util.ArrayList;

public class Principal {

	private JFrame frame;
	private ArrayList<Jugador> listaJugadores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
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
		
		JButton btnCargarJugador = new JButton("Cargar Jugador");
		btnCargarJugador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCargarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CargarJugador.main(null);
			}
		});
		btnCargarJugador.setBounds(32, 228, 131, 23);
		frame.getContentPane().add(btnCargarJugador);
		
		JButton btnGenerarEquipoIdeal = new JButton("Generar equipo ideal");
		btnGenerarEquipoIdeal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGenerarEquipoIdeal.setBounds(293, 228, 131, 23);
		frame.getContentPane().add(btnGenerarEquipoIdeal);
		
		JList listJugadores = new JList();
		listJugadores.setBounds(32, 197, 131, -181);
		frame.getContentPane().add(listJugadores);
		
		JList listEquipoIdeal = new JList();
		listEquipoIdeal.setBounds(270, 197, 131, -181);
		frame.getContentPane().add(listEquipoIdeal);
	}
}

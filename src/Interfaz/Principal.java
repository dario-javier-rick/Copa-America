package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.border.EmptyBorder;

import Logica.Jugador;
import Recursos.Fondo;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.Toolkit;

public class Principal extends JFrame{

	private JFrame frame;
	private ArrayList<Jugador> listaJugadores;

	public static Principal frame1 = new Principal();
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
	public Principal() {
		setTitle("Copa Am\u00E9rica 2015");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Karen\\Desktop\\copa-icon.png"));
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
		
		
		JButton btnCargarJugador = new JButton("Cargar Jugador");
		btnCargarJugador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCargarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CargarJugador.main(null);
			}
		});
		btnCargarJugador.setBounds(98, 232, 138, 41);
		p.add(btnCargarJugador);
		
		JButton btnGenerarEquipoIdeal = new JButton("Generar equipo ideal");
		btnGenerarEquipoIdeal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGenerarEquipoIdeal.setBounds(295, 232, 138, 41);
		p.add(btnGenerarEquipoIdeal);
		
		JList listJugadores = new JList();
		listJugadores.setBounds(32, 197, 131, -181);
		p.add(listJugadores);
		
		JList listEquipoIdeal = new JList();
		listEquipoIdeal.setBounds(270, 197, 131, -181);
		p.add(listEquipoIdeal);
	}
}

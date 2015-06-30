package Interfaz;

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
import Logica.Equipo;
import Logica.Jugador;
import Logica.Logica;
import Logica.Mediocampista;
import Recursos.Fondo;

import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GenerarEquipo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static GenerarEquipo frame = new GenerarEquipo();
	
	JScrollPane SPJugadores = new JScrollPane();
	DefaultListModel<Jugador> listModel = new DefaultListModel<Jugador>();
	JList<Jugador> listJugadores = new JList<Jugador>(listModel);
	
	ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	
	JScrollPane SPEquipoIdeal = new JScrollPane();
	DefaultListModel<Jugador> listModelEquipoIdeal = new DefaultListModel<Jugador>();
	JList<Jugador> listEquipoIdeal = new JList<Jugador>(listModelEquipoIdeal);
	

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
		
		SPJugadores.setViewportView(listJugadores);
		SPEquipoIdeal.setViewportView(listEquipoIdeal);
		
		listJugadores.setBounds(10, 11, 516, 100);
		p.add(listJugadores);
		
		JButton btnGenerarDreamTeam = new JButton("Generar Dream Team!");
		btnGenerarDreamTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Equipo dreamTeam = new Equipo();
				for(Jugador jugador:jugadores)
				{
					dreamTeam.agregarJugador(jugador);
				}
				Logica.buscarSolucion(dreamTeam, 0, jugadores); // Pasarle ArrayList de jugadores
				bindEquipoIdeal(dreamTeam);
				listEquipoIdeal.setVisible(true);
			}


		});
		btnGenerarDreamTeam.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGenerarDreamTeam.setBounds(191, 157, 147, 43);
		p.add(btnGenerarDreamTeam);

		listEquipoIdeal.setBounds(10, 265, 516, 100);
		listEquipoIdeal.setVisible(false);
		p.add(listEquipoIdeal);
		
		//add(pane, BorderLayout.NORTH);

		bindJugadores();

		
		
		
	}

	private void bindJugadores() {
		try {
			ArrayList<Delantero> delanteros = Delantero.getJugadores();
			for (Delantero delantero : delanteros) {
				listModel.addElement(delantero);
				jugadores.add(delantero);
			}
			ArrayList<Mediocampista> mediocampistas = Mediocampista.getJugadores();
			for (Mediocampista mediocampista : mediocampistas) {
				listModel.addElement(mediocampista);
				jugadores.add(mediocampista);
			}
			ArrayList<Defensor> defensores = Defensor.getJugadores();
			for (Defensor defensor : defensores) {
				listModel.addElement(defensor);
				jugadores.add(defensor);
			}
			ArrayList<Arquero> arqueros = Arquero.getJugadores();
			for (Arquero arquero: arqueros) {
				listModel.addElement(arquero);
				jugadores.add(arquero);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void bindEquipoIdeal(Equipo dreamTeam) {
		for(int i =0 ; i< dreamTeam.getCantidadJugadores() ; i++)
		{
			listModelEquipoIdeal.addElement(dreamTeam.getJugadores().get(i));
		}
	}
}

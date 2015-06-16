package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import Logica.Arquero;
import Logica.Defensor;
import Logica.Delantero;
import Logica.Mediocampista;
import Logica.TipoJugador;
import Recursos.Fondo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.awt.Font;
import java.awt.Toolkit;

public class CargarJugador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6472114933233375254L;
	public static CargarJugador frame1 = new CargarJugador();
	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtSeleccion;
	private JTextField txtPuntaje;
	@SuppressWarnings("rawtypes")
	JComboBox cboPosicion = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox cboTarjetasAmarillas = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox cboTarjetasRojas = new JComboBox();
	JLabel lblMensaje = new JLabel("");
	@SuppressWarnings("unused")
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Jugador frame1 = new Jugador();
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
	public CargarJugador() {
		setTitle("Cargar nuevo jugador");
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
		
		JLabel lblNombre = new JLabel("Nombre del jugador:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(56, 74, 200, 22);
		p.add(lblNombre);
		
		JLabel lblSeleccion = new JLabel("Selecci\u00F3n:");
		lblSeleccion.setForeground(Color.WHITE);
		lblSeleccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSeleccion.setBounds(56, 107, 108, 22);
		p.add(lblSeleccion);
		
		JLabel lblPosicion = new JLabel("Posici\u00F3n:");
		lblPosicion.setForeground(Color.WHITE);
		lblPosicion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPosicion.setBounds(56, 139, 108, 22);
		p.add(lblPosicion);
		
		JLabel lblPuntaje = new JLabel("Puntaje:");
		lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPuntaje.setBounds(56, 172, 108, 22);
		p.add(lblPuntaje);
		
		JLabel lblTarjetasAmarillas = new JLabel("Tarjetas Amarillas:");
		lblTarjetasAmarillas.setForeground(Color.WHITE);
		lblTarjetasAmarillas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTarjetasAmarillas.setBounds(56, 205, 142, 22);
		p.add(lblTarjetasAmarillas);

		JLabel lblTarjetasRojas = new JLabel("Tarjetas rojas:");
		lblTarjetasRojas.setForeground(Color.WHITE);
		lblTarjetasRojas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTarjetasRojas.setBounds(56, 238, 108, 22);
		p.add(lblTarjetasRojas);
		
		
		txtNombre = new JTextField();
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setBounds(266, 75, 135, 22);
		p.add(txtNombre);
		txtNombre.setColumns(10);

		txtSeleccion = new JTextField();
		txtSeleccion.setBackground(Color.WHITE);
		txtSeleccion.setBounds(266, 108, 135, 21);
		p.add(txtSeleccion);
		txtSeleccion.setColumns(10);
		cboPosicion.setBackground(Color.WHITE);

		cboPosicion.setBounds(266, 140, 135, 21);
		p.add(cboPosicion);
		
		txtPuntaje = new JTextField();
		txtPuntaje.setBackground(Color.WHITE);
		txtPuntaje.setBounds(266, 173, 135, 21);
		p.add(txtPuntaje);
		txtPuntaje.setColumns(10);
		cboTarjetasAmarillas.setBackground(Color.WHITE);

		cboTarjetasAmarillas.setBounds(266, 206, 135, 22);
		p.add(cboTarjetasAmarillas);
		cboTarjetasRojas.setBackground(Color.WHITE);

		cboTarjetasRojas.setBounds(266, 239, 135, 21);
		p.add(cboTarjetasRojas);
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMensaje.setForeground(Color.WHITE);

		lblMensaje.setBounds(39, 304, 319, 19);
		p.add(lblMensaje);

		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (validarDatos()) {
					try {
						switch ((TipoJugador) cboPosicion.getSelectedItem()) {
						case Arquero:
							Arquero arquero = new Arquero(txtNombre.getText(),
									txtSeleccion.getText(), Double
											.parseDouble(txtPuntaje.getText()),
									Integer.parseInt(cboTarjetasAmarillas
											.getSelectedItem().toString()),
									Integer.parseInt(cboTarjetasRojas
											.getSelectedItem().toString()));
							arquero.persistir();
							break;
							
						case Defensor:
							Defensor defensor = new Defensor(txtNombre.getText(),
									txtSeleccion.getText(), Double
											.parseDouble(txtPuntaje.getText()),
									Integer.parseInt(cboTarjetasAmarillas
											.getSelectedItem().toString()),
									Integer.parseInt(cboTarjetasRojas
											.getSelectedItem().toString()));
							defensor.persistir();
							break;
							
						case Mediocampista:
							Mediocampista mediocampista = new Mediocampista(txtNombre.getText(),
									txtSeleccion.getText(), Double
											.parseDouble(txtPuntaje.getText()),
									Integer.parseInt(cboTarjetasAmarillas
											.getSelectedItem().toString()),
									Integer.parseInt(cboTarjetasRojas
											.getSelectedItem().toString()));
							mediocampista.persistir();
							break;
							
						case Delantero:
							Delantero delantero = new Delantero(txtNombre.getText(),
									txtSeleccion.getText(), Double
											.parseDouble(txtPuntaje.getText()),
									Integer.parseInt(cboTarjetasAmarillas
											.getSelectedItem().toString()),
									Integer.parseInt(cboTarjetasRojas
											.getSelectedItem().toString()));
							delantero.persistir();
							break;

						default:
							break;
						}

						FileOutputStream fos = new FileOutputStream(
								"C:/jugadores.txt");
						ObjectOutputStream out = new ObjectOutputStream(fos);

//						out.writeObject(jugador);
						out.close();

						lblMensaje.setText("");
						JOptionPane.showMessageDialog(null, "Jugador cargado!");
						frame.dispose();
					} catch (Exception ex) {
						ex.printStackTrace();
						lblMensaje.setText(ex.getMessage());
					}

				}
			}

		});
		
		btnCargar.setBounds(437, 300, 89, 23);
		p.add(btnCargar);
		

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});

		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCerrar.setBounds(437, 342, 89, 23);
		p.add(btnCerrar);

		bindPosicion();
		bindTarjetasAmarillas();
		bindTarjetasRojas();
	}

	@SuppressWarnings("unchecked")
	private void bindTarjetasRojas() {
		for (int i = 0; i < 11; i++) {
			this.cboTarjetasRojas.addItem(i);
		}
	}

	@SuppressWarnings("unchecked")
	private void bindTarjetasAmarillas() {
		for (int i = 0; i < 6; i++) {
			this.cboTarjetasAmarillas.addItem(i);
		}
	}

	@SuppressWarnings("unchecked")
	private void bindPosicion() {
		this.cboPosicion.addItem("...");
		this.cboPosicion.addItem(TipoJugador.Arquero);
		this.cboPosicion.addItem(TipoJugador.Defensor);
		this.cboPosicion.addItem(TipoJugador.Delantero);
		this.cboPosicion.addItem(TipoJugador.Mediocampista);
	}


	private boolean validarDatos() {
		if (this.txtNombre.getText().equals("")) {
			this.lblMensaje.setText("El nombre del jugador se encuentra vacío");
			return false;
		}
		if (this.txtSeleccion.getText().equals("")) {
			this.lblMensaje.setText("El campo selección se encuentra vacío");
			return false;
		}
		if (this.txtPuntaje.getText().equals("")) {
			this.lblMensaje.setText("El puntaje se encuentra vacío");
			return false;
		}
		try {
			Double.parseDouble(this.txtPuntaje.getText());
		} catch (Exception e) {
			this.lblMensaje.setText("El puntaje no es un valor numérico");
			return false;
		}
		return true;
	}


		
		
		
		
		

}


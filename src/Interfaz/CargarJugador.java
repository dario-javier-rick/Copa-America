package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import Logica.Arquero;
import Logica.Defensor;
import Logica.Delantero;
import Logica.Mediocampista;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CargarJugador {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtSeleccion;
	private JTextField txtPuntaje;
	JComboBox<TipoJugador> cboPosicion = new JComboBox<TipoJugador>();
	JComboBox<Integer> cboTarjetasAmarillas = new JComboBox<Integer>();
	JComboBox<Integer> cboTarjetasRojas = new JComboBox<Integer>();
	JLabel lblMensaje = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CargarJugador window = new CargarJugador();
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
	public CargarJugador() {
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

		JLabel lblNombre = new JLabel("Nombre del jugador:");
		lblNombre.setBounds(10, 35, 108, 22);
		frame.getContentPane().add(lblNombre);

		JLabel lblSeleccion = new JLabel("Selecci\u00F3n:");
		lblSeleccion.setBounds(10, 68, 108, 22);
		frame.getContentPane().add(lblSeleccion);

		JLabel lblPosicion = new JLabel("Posici\u00F3n:");
		lblPosicion.setBounds(10, 100, 108, 22);
		frame.getContentPane().add(lblPosicion);

		JLabel lblPuntaje = new JLabel("Puntaje:");
		lblPuntaje.setBounds(10, 133, 108, 22);
		frame.getContentPane().add(lblPuntaje);

		JLabel lblTarjetasAmarillas = new JLabel("Tarjetas Amarillas:");
		lblTarjetasAmarillas.setBounds(10, 166, 108, 22);
		frame.getContentPane().add(lblTarjetasAmarillas);

		JLabel lblTarjetasRojas = new JLabel("Tarjetas rojas:");
		lblTarjetasRojas.setBounds(10, 199, 108, 22);
		frame.getContentPane().add(lblTarjetasRojas);

		txtNombre = new JTextField();
		txtNombre.setBounds(145, 36, 135, 22);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtSeleccion = new JTextField();
		txtSeleccion.setBounds(145, 69, 135, 21);
		frame.getContentPane().add(txtSeleccion);
		txtSeleccion.setColumns(10);

		cboPosicion.setBounds(145, 101, 135, 21);
		frame.getContentPane().add(cboPosicion);

		txtPuntaje = new JTextField();
		txtPuntaje.setBounds(145, 134, 135, 21);
		frame.getContentPane().add(txtPuntaje);
		txtPuntaje.setColumns(10);

		cboTarjetasAmarillas.setBounds(145, 167, 135, 22);
		frame.getContentPane().add(cboTarjetasAmarillas);

		cboTarjetasRojas.setBounds(145, 200, 135, 21);
		frame.getContentPane().add(cboTarjetasRojas);

		lblMensaje.setBounds(10, 232, 270, 19);
		frame.getContentPane().add(lblMensaje);

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
//							defensor.persistir();
							break;
							
						case Mediocampista:
							Mediocampista mediocampista = new Mediocampista(txtNombre.getText(),
									txtSeleccion.getText(), Double
											.parseDouble(txtPuntaje.getText()),
									Integer.parseInt(cboTarjetasAmarillas
											.getSelectedItem().toString()),
									Integer.parseInt(cboTarjetasRojas
											.getSelectedItem().toString()));
//							mediocampista.persistir();
							break;
							
						case Delantero:
							Delantero delantero = new Delantero(txtNombre.getText(),
									txtSeleccion.getText(), Double
											.parseDouble(txtPuntaje.getText()),
									Integer.parseInt(cboTarjetasAmarillas
											.getSelectedItem().toString()),
									Integer.parseInt(cboTarjetasRojas
											.getSelectedItem().toString()));
//							delantero.persistir();
							break;

						default:
							break;
						}


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
		btnCargar.setBounds(335, 232, 89, 23);
		frame.getContentPane().add(btnCargar);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCerrar.setBounds(335, 199, 89, 23);
		frame.getContentPane().add(btnCerrar);

		bindPosicion();
		bindTarjetasAmarillas();
		bindTarjetasRojas();
	}

	private void bindTarjetasRojas() {
		for (int i = 0; i < 5; i++) {
			this.cboTarjetasRojas.addItem(i);
		}
	}

	private void bindTarjetasAmarillas() {
		for (int i = 0; i < 10; i++) {
			this.cboTarjetasAmarillas.addItem(i);
		}
	}

	private void bindPosicion() {
		this.cboPosicion.addItem(TipoJugador.Arquero);
		this.cboPosicion.addItem(TipoJugador.Defensor);
		this.cboPosicion.addItem(TipoJugador.Mediocampista);
		this.cboPosicion.addItem(TipoJugador.Delantero);
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

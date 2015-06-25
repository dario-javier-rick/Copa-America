package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import Recursos.Fondo;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.Toolkit;

public class EquipoIdeal extends JFrame {

	private JFrame frame;

	public static EquipoIdeal frame1 = new EquipoIdeal();
	private JTable table;
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
	public EquipoIdeal() {
		setTitle("Equipo ideal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EquipoIdeal.class.getResource("/Recursos/copa-icon.png")));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 455);
		Fondo p = new Fondo();
		p.setBackground(Color.BLACK);
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 114, 540, 203);
		p.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, "Arquero"},
				{null, null, null, null, null, "Defensor"},
				{null, null, null, null, null, "Defensor"},
				{null, null, null, null, null, "Defensor"},
				{null, null, null, null, null, "Defensor"},
				{null, null, null, null, null, "Mediocampista"},
				{null, null, null, null, null, "Mediocampista"},
				{null, null, null, null, null, "Mediocampista"},
				{null, null, null, null, null, "Delantero"},
				{null, null, null, null, null, "Delantero"},
				{null, null, null, null, null, "Delantero"},
			},
			new String[] {
				"Nombre", "Selección", "Puntaje", "T.Amarillas", "T.Rojas", "Posición"
			}
		));
		
		JLabel lblEquipoIdeal = new JLabel("Equipo ideal");
		lblEquipoIdeal.setForeground(Color.WHITE);
		lblEquipoIdeal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEquipoIdeal.setBounds(31, 58, 156, 44);
		p.add(lblEquipoIdeal);
		
		JLabel lblPuntajeTotal = new JLabel("Puntaje total :");
		lblPuntajeTotal.setForeground(Color.WHITE);
		lblPuntajeTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPuntajeTotal.setBounds(325, 329, 125, 21);
		p.add(lblPuntajeTotal);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setForeground(Color.WHITE);
		label.setBounds(460, 336, 108, 14);
		p.add(label);
		
	}
}

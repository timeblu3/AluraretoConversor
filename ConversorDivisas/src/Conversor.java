import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Conversor extends JFrame {

	private JPanel contentPane;
	private JTextField valor;
	private JComboBox opciones;
	private JLabel resultado;
	private JButton botonsalir;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
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
	public Conversor() {
		setTitle("Conversor ONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 546);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Colores");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Gris");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.GRAY);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conversor Moneda");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(28, 50, 287, 73);
		contentPane.add(lblNewLabel);
		
		opciones = new JComboBox();
		opciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		opciones.setModel(new DefaultComboBoxModel(new String[] {"COP to USD", "USD to COP"}));
		opciones.setBounds(95, 146, 155, 35);
		contentPane.add(opciones);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese un monto:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 193, 178, 35);
		contentPane.add(lblNewLabel_1);
		
		valor = new JTextField();
		valor.setBounds(198, 192, 155, 35);
		contentPane.add(valor);
		valor.setColumns(10);
		
		JButton botonconvertir = new JButton("CONVERTIR");
		botonconvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor2 = valor.getText();
				double valornum = Double.parseDouble(valor2);
				
				double tipodecambio = 0.0002432;
				double resultadofinal = 0;
				
				DecimalFormat formatear = new DecimalFormat("0.00");
				
				if (opciones.getSelectedIndex()==0) {
					resultadofinal = (valornum*tipodecambio);
					resultado.setText("resultado" + formatear.format(resultadofinal));
				} else if(opciones.getSelectedIndex()==1) {
					resultadofinal = (valornum/tipodecambio);
					resultado.setText("resultado" + formatear.format(resultadofinal));
				}
			}
		});
		botonconvertir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonconvertir.setBounds(95, 264, 155, 35);
		contentPane.add(botonconvertir);
		
		botonsalir = new JButton("SALIR");
		botonsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		botonsalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonsalir.setBounds(95, 436, 155, 47);
		contentPane.add(botonsalir);
		
		resultado = new JLabel("0");
		resultado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resultado.setBounds(60, 376, 287, 35);
		contentPane.add(resultado);
		
		JLabel imagennextone = new JLabel("New label");
		imagennextone.setIcon(new ImageIcon("C:\\Users\\JoseElCrack\\Downloads\\one-acate-800x533.jpg"));
		imagennextone.setBounds(0, 0, 752, 483);
		contentPane.add(imagennextone);
	}
}

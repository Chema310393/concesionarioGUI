package concesionarioGUI.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import concesionarioGUI.concesionario.*;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.*;

/**
 * Clase padre de la gestión de coches
 * 
 * @author Chema
 * @version 1.0
 */
public class CocheGUI extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Coche coche;
	protected final JPanel contentPanel = new JPanel();
	protected JTextField textFieldMatricula;
	protected final ButtonGroup btngroupColor = new ButtonGroup();
	int indice = 0;
	JRadioButton btnRojo = new JRadioButton("Rojo");
	JRadioButton btnAzul = new JRadioButton("Azul");
	JRadioButton btnPlata = new JRadioButton("Plata");
	JButton btnAtras = new JButton("<");
	JButton btnSiguiente = new JButton(">");
	JButton aceptarButton = new JButton("Aceptar");
	JButton cancelButton = new JButton("Cancel");
	JComboBox<Marca> comboBoxMarca = new JComboBox<Marca>();
	JComboBox<Modelo> comboBoxModelo = new JComboBox<Modelo>();

	/**
	 * Create the dialog.
	 */
	public CocheGUI() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setModal(true);
		setResizable(false);
		textFieldMatricula = new JTextField();
		textFieldMatricula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldMatricula.setForeground(Color.BLACK);
			}
		});
		textFieldMatricula.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				textFieldMatricula.setText(Coche.estandarizarMatricula(textFieldMatricula.getText()));
				if (!Coche.esMatriculaValida(textFieldMatricula.getText())) {
					textFieldMatricula.setForeground(Color.RED);

				} else {
					textFieldMatricula.setForeground(Color.BLACK);
				}

			}
		});

		textFieldMatricula.setBounds(153, 13, 200, 22);
		contentPanel.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);

		JLabel lblMatrcula = new JLabel("Matr\u00EDcula");
		lblMatrcula.setBounds(86, 16, 56, 16);
		contentPanel.add(lblMatrcula);

		btnRojo.setSelected(true);
		btngroupColor.add(btnRojo);
		btnRojo.setBounds(79, 54, 65, 25);
		contentPanel.add(btnRojo);

		btngroupColor.add(btnAzul);
		btnAzul.setBounds(182, 54, 65, 25);
		contentPanel.add(btnAzul);

		btngroupColor.add(btnPlata);
		btnPlata.setBounds(288, 54, 65, 25);
		contentPanel.add(btnPlata);

		

		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cambiarModelo();
			}
		});
		comboBoxMarca.setModel(new DefaultComboBoxModel<Marca>(Marca.values()));
		comboBoxMarca.setBounds(86, 99, 79, 22);
		contentPanel.add(comboBoxMarca);

		comboBoxModelo.setModel(new DefaultComboBoxModel<Modelo>(Modelo.values()));
		comboBoxModelo.setBounds(236, 99, 117, 22);
		contentPanel.add(comboBoxModelo);

		btnAtras.setBounds(86, 152, 43, 36);
		contentPanel.add(btnAtras);

		btnSiguiente.setBounds(310, 152, 43, 36);
		contentPanel.add(btnSiguiente);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{

				aceptarButton.setActionCommand("OK");
				buttonPane.add(aceptarButton);
				getRootPane().setDefaultButton(aceptarButton);
			}
			{

				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		inicializar();
	}

	/**
	 * Inicializa el diálogo
	 */
	void inicializar() {
		textFieldMatricula.setText("");
		btnRojo.setSelected(true);
		comboBoxMarca.setSelectedItem(Marca.SEAT);
		cambiarModelo();
	}

	/**
	 * Cambia el comboBox del modelo dependiendo de la marca
	 */
	protected void cambiarModelo() {
		Marca marcaSeleccionada = (Marca) comboBoxMarca.getSelectedItem();
		ArrayList<Modelo> arrayList = new ArrayList<Modelo>();
		for (Modelo modelo : Modelo.values()) {
			if (!modelo.getMarca().equals(marcaSeleccionada))
				continue;
			arrayList.add(modelo);
		}
		comboBoxModelo.setModel(new DefaultComboBoxModel(arrayList.toArray()));
	}

	/**
	 * Devuelve el color elegido
	 * 
	 * @return Color
	 */
	Colores getColorSeleccionado() {
		if (btnRojo.isSelected()) {
			return Colores.ROJO;
		}
		if (btnAzul.isSelected()) {
			return Colores.AZUL;
		}
		return Colores.PLATA;

	}

	/**
	 * Habilita los radioButtons de color
	 * 
	 * @param habilitado
	 */
	protected void habilitarBotonesColor(boolean habilitado) {
		btnAzul.setEnabled(habilitado);
		btnRojo.setEnabled(habilitado);
		btnPlata.setEnabled(habilitado);
	}

	/**
	 * Muestra los botones de movimiento
	 * 
	 * @param habilitado
	 */
	protected void mostrarBotonesMovimiento(boolean habilitado) {
		btnAtras.setVisible(habilitado);
		btnSiguiente.setVisible(habilitado);
	}

	/**
	 * Habilita los comboBox
	 * 
	 * @param habilitado
	 */
	protected void habilitarComboBoxes(boolean habilitado) {
		comboBoxMarca.setEnabled(habilitado);
		comboBoxModelo.setEnabled(habilitado);
	}

	/**
	 * Habilita el textField de matrícula para la escritura
	 * 
	 * @param habilitado
	 */
	protected void habilitarTextFieldMatricula(boolean habilitado) {
		textFieldMatricula.setEnabled(habilitado);
	}

	
	/**
	 * Muestra un coche
	 * 
	 * @param coche
	 *            Coche a mostrar
	 */
	void mostrarCoche(Coche coche) {
		textFieldMatricula.setText(coche.getMatricula());
		// comboBoxModelo.addItem(coche.getModelo());		
		// comboBoxMarca.addItem(coche.getModelo().getMarca());
		comboBoxMarca.setSelectedItem(coche.getModelo().getMarca());
		comboBoxModelo.setSelectedItem(coche.getModelo());
		setColorCoche(coche);
	}

	// /**
	// * Muestra un coche seguún la matricula
	// * @param matricula
	// */
	// void mostrarCoche(String matricula) {
	// try {
	// textFieldMatricula.setText(Entorno.getConcesionario().mostrarCoche(matricula).getMatricula());
	// comboBoxModelo.setSelectedItem(Entorno.getConcesionario().mostrarCoche(matricula).getModelo().name());
	// setMarcaCoche(Entorno.getConcesionario().mostrarCoche(matricula));
	// setColorCoche(Entorno.getConcesionario().mostrarCoche(matricula));
	// } catch (CocheNoExisteException | ConcesionarioVacioException e) {
	// JOptionPane.showMessageDialog(null, e.getMessage(), null,
	// JOptionPane.ERROR_MESSAGE);
	// }
	// }

	/**
	 * Selecciona el color del coche
	 * 
	 * @param coche
	 */
	private void setColorCoche(Coche coche) {
		if (coche.getColor() == Colores.ROJO) {
			btnRojo.setSelected(true);
		} else if (coche.getColor() == Colores.AZUL) {
			btnAzul.setSelected(true);
		} else {
			btnPlata.setSelected(true);
		}
	}

	/**
	 * Comprueba si hay coches en ambos lados del iterador y habilita o
	 * deshabilita los botones de siguiente y atras en caso de que haya o no
	 * 
	 * @param concesionario
	 *            Concesionario
	 * @throws ConcesionarioVacioException
	 */
	
}

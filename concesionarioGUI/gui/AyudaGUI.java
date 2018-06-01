package concesionarioGUI.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Ventana de ayuda
 * @author Chema
 * @version 1.0
 */
public class AyudaGUI extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AyudaGUI() {
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextArea txtrFAyuda = new JTextArea();
		txtrFAyuda.setEditable(false);
		txtrFAyuda.setFont(new Font("Gadugi", Font.PLAIN, 12));
		txtrFAyuda.setLineWrap(true);
		txtrFAyuda.setText("F1 - Ayuda\t\r\nF2- Acerca de...\r\nCTRL + N = Crear un nuevo concesionario\r\nCTRL + O = Abrir un concesionario existente\r\nCTRL + G = Guardar concesionario\r\nCTRL +SHIFT + G = Guardar concesionario como...\r\nCTRL + A = A\u00F1adir un coche al concesionario\r\nCTRL + E = Eliminar un coche del concesionario\r\nCTRL + M = Mostrar concesionario\r\nCTRL + SHIFT + M = Mostrar concesionario por color\r\nCTRL + B = Buscar coche en el concesionario\r\n");
		txtrFAyuda.setBounds(84, 31, 293, 196);
		txtrFAyuda.setBackground(contentPanel.getBackground());
		contentPanel.add(txtrFAyuda);
		
		JButton button = new JButton("Cerrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setActionCommand("Cancel");
		button.setBounds(174, 238, 83, 23);
		contentPanel.add(button);
	}
}

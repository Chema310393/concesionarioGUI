package concesionarioGUI.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AcercaDeGUI extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();



	/**
	 * Create the dialog.
	 */
	public AcercaDeGUI() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setResizable(false);
		setModal(true);
		JTextArea txtrAutorJosMara = new JTextArea();
		txtrAutorJosMara.setFont(new Font("Gadugi", Font.PLAIN, 12));
		txtrAutorJosMara.setBackground(contentPanel.getBackground());
		txtrAutorJosMara.setEditable(false);
		txtrAutorJosMara.setText("Autor: Jos\u00E9 Mar\u00EDa Romero Ruiz\r\n1\u00BA Desarrollo de aplicaciones web\r\nVersi\u00F3n 1.0");
		txtrAutorJosMara.setBounds(112, 76, 220, 72);
		contentPanel.add(txtrAutorJosMara);
		{
			JButton btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCerrar.setBounds(177, 226, 80, 23);
			contentPanel.add(btnCerrar);
			btnCerrar.setActionCommand("Cancel");
		}
	}
}

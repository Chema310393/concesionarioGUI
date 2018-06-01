package concesionarioGUI.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import concesionarioGUI.concesionario.*;
import concesionarioGUI.concesionario.excepciones.*;

public class NuevoGUI extends CocheGUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public NuevoGUI() {
		super();
		setTitle("Nuevo");
		mostrarBotonesMovimiento(false);
		aceptarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Entorno.getConcesionario().darAlta((Modelo)
					// comboBoxModelo.getSelectedItem(),
					// getColorSeleccionado(), textFieldMatricula.getText());
					Entorno.darAlta((Modelo) comboBoxModelo.getSelectedItem(), getColorSeleccionado(),
							textFieldMatricula.getText());
					inicializar();

				} catch (ModeloNoValidoException | ColorNoValidoException | MatriculaNoValidaException
						| ElCocheYaExisteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

}

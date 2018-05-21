package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import concesionario.Entorno;

import concesionario.excepciones.CocheNoExisteException;
import concesionario.excepciones.ConcesionarioVacioException;
import concesionario.excepciones.MatriculaNoValidaException;

public class EliminarGUI extends MostrarGUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 * 
	 * @throws ConcesionarioVacioException
	 */
	public EliminarGUI() throws ConcesionarioVacioException {
		super();
		setTitle("Eliminar");
		aceptarButton.setText("Eliminar");

		aceptarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Entorno.getConcesionario().darBaja(textFieldMatricula.getText());
				} catch (MatriculaNoValidaException | ConcesionarioVacioException | CocheNoExisteException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

}

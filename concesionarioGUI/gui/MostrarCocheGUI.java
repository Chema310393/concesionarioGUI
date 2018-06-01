package concesionarioGUI.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import concesionarioGUI.concesionario.*;
import concesionarioGUI.concesionario.excepciones.*;


public class MostrarCocheGUI extends MostrarGUI {	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public MostrarCocheGUI() throws ConcesionarioVacioException {
		habilitarTextFieldMatricula(true);		
		mostrarBotonesMovimiento(false);
		inicializar();
		aceptarButton.setVisible(true);
		aceptarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mostrarCoche(Entorno.mostrarCoche(textFieldMatricula.getText()));
				} catch (CocheNoExisteException | ConcesionarioVacioException | MatriculaNoValidaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

}

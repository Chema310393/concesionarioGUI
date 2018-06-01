package concesionarioGUI.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

import javax.swing.JOptionPane;

import concesionarioGUI.concesionario.*;
import concesionarioGUI.concesionario.excepciones.*;

public class MostrarGUI extends CocheGUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ListIterator<Coche> iterador;
	/**
	 * Create the dialog.
	 * @throws ConcesionarioVacioException 
	 */
	public MostrarGUI() throws ConcesionarioVacioException {
		super();
		setTitle("Mostrar");
		habilitarTextFieldMatricula(false);
		habilitarComboBoxes(false);
		habilitarBotonesColor(false);
		iterador = Entorno.getIterador();
		habilitarMovimiento();
		mostrarCoche(iterador.next());
		aceptarButton.setVisible(false);
		cancelButton.setText("Salir");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mostrarAnterior();
				} catch (ConcesionarioVacioException e1) {
					JOptionPane.showMessageDialog(null, "El concesionario está vacío", null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mostrarSiguiente();
				} catch (ConcesionarioVacioException e1) {
					JOptionPane.showMessageDialog(null, "El concesionario está vacío", null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Metodo que muestra el siguiente coche del concesionario.
	 * 
	 * @throws ConcesionarioVacioException
	 */
	protected void mostrarSiguiente() throws ConcesionarioVacioException {

		if (iterador.hasNext()) {
			coche = iterador.next();
			mostrarCoche(coche);
		}
		habilitarMovimiento();
		// if(!iterador.hasNext()){
		// iterador.previous();
		// }
		// mostrarCoche(Entorno.getConcesionario().getCoche(1));
		// mostrarConcesionario(concesionario.getCoche(++indice),
		// concesionario);
	}

	/**
	 * Metodo que muestra el coche anterior del concesionario.
	 * 
	 * @throws ConcesionarioVacioException
	 */
	protected void mostrarAnterior() throws ConcesionarioVacioException {
		if (iterador.hasPrevious()) {
			mostrarCoche(iterador.previous());
		}
		habilitarMovimiento();
		// if(!iterador.hasPrevious()){
		// iterador.next();
		// }
		// mostrarConcesionario(concesionario.getCoche(--indice),
		// concesionario);
	}

	void habilitarMovimiento() throws ConcesionarioVacioException {

		if (Entorno.numeroCochesConcesionario() != 1) {
			if (!iterador.hasNext()) {
				btnSiguiente.setEnabled(false);
				iterador.previous();
			} else {
				btnSiguiente.setEnabled(true);
			}

			if (!iterador.hasPrevious()) {
				btnAtras.setEnabled(false);
				iterador.next();
			} else {
				btnAtras.setEnabled(true);
			}
		} else {
			btnSiguiente.setEnabled(false);
			btnAtras.setEnabled(false);
		}

	}
}

package concesionarioGUI.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import concesionarioGUI.concesionario.*;
import concesionarioGUI.concesionario.excepciones.*;

public class MostrarColorGUI extends MostrarGUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public MostrarColorGUI() throws ConcesionarioVacioException {
		habilitarBotonesColor(true);
		habilitarTextFieldMatricula(false);
		//ChangeListener cambioColor = null;
		elegirColor();
		aceptarButton.setVisible(true);
		aceptarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elegirColor();
			}
		});
		

//		cambioColor = new ChangeListener() {
//			public void stateChanged(ChangeEvent e) {
//				try {
//					Entorno.setConcesionarioColor(getColorSeleccionado());
//					iterador = Entorno.getConcesionarioColor().iterator();
//					habilitarMovimiento(Entorno.getConcesionarioColor());
//					mostrarCoche(Entorno.getConcesionarioColor().getCoche(0));
//				} catch (ConcesionarioVacioException e1) {
//					JOptionPane.showMessageDialog(null, "No hay coches de ese color en el concesionario", null,
//							JOptionPane.ERROR_MESSAGE);
//				}
//			}
//		};
//		btnRojo.addChangeListener(cambioColor);
//		btnAzul.addChangeListener(cambioColor);
//		btnPlata.addChangeListener(cambioColor);
	}
	
	/**
	 * Actua según el color elegido
	 */
	private void elegirColor(){
		try {
			Entorno.setConcesionarioColor(getColorSeleccionado());
			iterador = Entorno.getConcesionarioColor().iterator();
			habilitarMovimiento();
			mostrarCoche(Entorno.getConcesionarioColor().getCoche(0));
		} catch (ConcesionarioVacioException e1) {
			JOptionPane.showMessageDialog(null, "No hay coches de ese color en el concesionario", null,
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	void habilitarMovimiento(){
		
	}

}

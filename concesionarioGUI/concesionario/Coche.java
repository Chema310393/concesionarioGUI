/**
 * 
 */
package concesionarioGUI.concesionario;

import java.io.Serializable;
import java.util.regex.*;

import concesionarioGUI.concesionario.excepciones.*;

/**
 * @author Chema
 *
 */
public class Coche implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Pattern PATRONMATRICULA = Pattern.compile("^\\d{4}[ -]?[B-Z&&[^EIOUQ]]{3}$");
	private Modelo modelo;
	private Colores color;
	private String matricula;

	Coche(Modelo modelo, Colores color, String matricula)
			throws ModeloNoValidoException, ColorNoValidoException, MatriculaNoValidaException {
		setMatricula(matricula);
		setModelo(modelo);
		setColor(color);

	}

	public Coche(String matricula) throws MatriculaNoValidaException {
		setMatricula(matricula);
	}

	private void setModelo(Modelo modelo) throws ModeloNoValidoException {
		if (modelo == null)
			throw new ModeloNoValidoException("El modelo no es válido.");
		this.modelo = modelo;

		// try {
		// this.modelo=modelo;
		// } catch (NullPointerException e) {
		// throw new ModeloNoValidoException("El modelo no es válido.");
		// }
	}

	private void setColor(Colores color) throws ColorNoValidoException {
		if (color == null)
			throw new ColorNoValidoException("El color no es válido");
		this.color = color;

	}

	private void setMatricula(String matricula) throws MatriculaNoValidaException {
		String matriculaDefecto = estandarizarMatricula(matricula);
		if (!esMatriculaValida(matriculaDefecto))
			throw new MatriculaNoValidaException("La matrícula no es válida");
		this.matricula = matriculaDefecto;

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Coche other = (Coche) o;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/**
	 * Transforma la matrícula en un formato corto en caso de que sea necesario
	 * 
	 * @param matricula
	 * @return
	 */
	public static String estandarizarMatricula(String matricula) {
		matricula=matricula.toUpperCase();
		return matricula.replaceAll("[ -]", "");
	}

	/**
	 * Comprueba que la matrícula sea válida
	 * 
	 * @param matricula
	 * @return True si la matrícula es válida
	 */
	public static boolean esMatriculaValida(String matricula) {
		Matcher matcher = PATRONMATRICULA.matcher(matricula);
		return matcher.find();
	}

	public String getMatricula() {
		return matricula;
	}

	public Colores getColor() {
		return color;
	}

	public Modelo getModelo() {
		return modelo;
	}

	@Override
	public String toString() {
		return getModelo() + " - " + getColor() + " - " + getMatricula();
	}

}

package concesionarioGUI.concesionario;

import java.io.File;
import java.io.IOException;
import java.util.ListIterator;

import concesionarioGUI.concesionario.excepciones.*;

public class Entorno {
	private static Concesionario concesionario = new Concesionario();
	private static Concesionario concesionarioColor = new Concesionario();
	private static File file = null;
	private static boolean modificado = false;

	private static Concesionario getConcesionario() {
		return concesionario;
	}

	private static void setConcesionario(Concesionario concesionario) {
		Entorno.concesionario = concesionario;
	}

	public static File getFile() {
		return file;
	}

	private static void setFile(File file) {
		Entorno.file = file;
	}

	private static void setModificado(boolean modificado) {
		Entorno.modificado = modificado;
	}

	public static boolean isModificado() {
		return modificado;
	}

	/**
	 * Crea un concesionario con los coches del color indicado
	 * 
	 * @param color
	 *            Color de los coches
	 * @throws ConcesionarioVacioException
	 */
	public static void setConcesionarioColor(Colores color) throws ConcesionarioVacioException {
		Entorno.concesionarioColor = new Concesionario(concesionario, color);
	}

	public static Concesionario getConcesionarioColor() {
		return concesionarioColor;
	}

	public static void darAlta(Modelo modelo, Colores colores, String matricula) throws ModeloNoValidoException,
			ColorNoValidoException, MatriculaNoValidaException, ElCocheYaExisteException {
		getConcesionario().darAlta(modelo, colores, matricula);
		setModificado(true);
	}

	public static void darBaja(String matricula)
			throws MatriculaNoValidaException, ConcesionarioVacioException, CocheNoExisteException {
		getConcesionario().darBaja(matricula);
		setModificado(true);
	}

	public static Coche mostrarCoche(String matricula)
			throws CocheNoExisteException, ConcesionarioVacioException, MatriculaNoValidaException {
		return getConcesionario().mostrarCoche(matricula);

	}

	public static void guardarComo(File file) throws IOException {
		Entorno.setFile(file);
		Fichero.guardar(Entorno.getFile(), Entorno.getConcesionario());
		setModificado(false);
	}

	public static void guardar() throws IOException {
		Fichero.guardar(getFile(), getConcesionario());
		Entorno.setModificado(false);
	}

	public static void abrir(File file) throws ClassNotFoundException, IOException {
		Entorno.setFile(file);
		Entorno.setConcesionario((Concesionario) Fichero.abrir(getFile()));
		Entorno.setModificado(false);

	}

	public static void nuevo() {
		setConcesionario(new Concesionario());
		setFile(null);
	}
	
	public static int numeroCochesConcesionario() throws ConcesionarioVacioException{
		return getConcesionario().contarCoches();
	}

	public static ListIterator<Coche> getIterador() {
		return getConcesionario().iterator();
	}

}

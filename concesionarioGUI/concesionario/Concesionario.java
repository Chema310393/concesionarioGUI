/**
 * 
 */
package concesionarioGUI.concesionario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;
import concesionarioGUI.concesionario.excepciones.*;

/**
 * @author Chema
 *
 */
public class Concesionario implements Serializable, Iterable<Coche> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Coche> garaje = new ArrayList<Coche>();
	

	public Concesionario(){}
	
	public Concesionario(Concesionario concesionario, Colores color) throws ConcesionarioVacioException{
		garaje=concesionario.mostrarPorColor(color);
	}
	
	
	/**
	 * Da de alta un coche
	 * 
	 * @param modelo
	 *            Modelo del coche
	 * @param color
	 *            Color del coche
	 * @param matricula
	 *            Matrícula del coche
	 * @throws ModeloNoValidoException
	 * @throws ColorNoValidoException
	 * @throws MatriculaNoValidaException
	 * @throws ElCocheYaExisteException
	 */
	public void darAlta(Modelo modelo, Colores color, String matricula)
			throws ModeloNoValidoException, ColorNoValidoException, MatriculaNoValidaException, ElCocheYaExisteException {
		//matricula=Coche.estandarizarMatricula(matricula);
		if (garaje.contains(new Coche(matricula)))
			throw new ElCocheYaExisteException("Ese coche ya existe en este concesionario");
		garaje.add(new Coche(modelo, color, matricula));

	}

	/**
	 * Da de baja un coche
	 * 
	 * @param matricula
	 *            Matrícula del coche que se desea eliminar
	 * @return Si se ha eliminado o no
	 * @throws MatriculaNoValidaException
	 * @throws ConcesionarioVacioException
	 * @throws CocheNoExisteException 
	 */
	public boolean darBaja(String matricula) throws MatriculaNoValidaException, ConcesionarioVacioException, CocheNoExisteException {
		if (garaje.isEmpty())
			throw new ConcesionarioVacioException("El concesionario está vacío");
		//matricula=Coche.estandarizarMatricula(matricula);
		cocheExiste(matricula);
		return garaje.remove(new Coche(matricula));
	}

	private boolean cocheExiste(String matricula) throws MatriculaNoValidaException, CocheNoExisteException {
		if(!garaje.contains(new Coche(matricula)))
			throw new CocheNoExisteException("El coche no existe en este concesionario");
		return true;
	}

	@Override
	public String toString() {
		String cadena = "";
		for (Coche coche : garaje) {
			cadena += "\n" + coche;
		}
		return cadena;
	}

//	/**
//	 * Busca un coche en el garaje
//	 * 
//	 * @param matricula
//	 *            Matrícula del coche
//	 * @return True si el coche está en el garaje
//	 */
//	private boolean buscarCoche(String matricula) {
//		
//		for (Coche coche : garaje) {
//			if (coche.getMatricula().equals(matricula))
//				return true;
//		}
//		return false;
//	}
	
	/**
	 * Muestra el coche cuya matrícula coincida con la seleccionada
	 * 
	 * @param matricula
	 *            Matrícula del coche
	 * @throws CocheNoExisteException
	 * @throws ConcesionarioVacioException
	 * @throws MatriculaNoValidaException 
	 */
	public Coche mostrarCoche(String matricula) throws CocheNoExisteException, ConcesionarioVacioException, MatriculaNoValidaException {
		if (garaje.isEmpty())
			throw new ConcesionarioVacioException("El concesionario está vacío");
		matricula = Coche.estandarizarMatricula(matricula);
		if(cocheExiste(matricula))
			return getCoche(garaje.indexOf(new Coche(matricula)));
		return null;
	}
	
	/**
	 * Devuelve un coche
	 * @param indice Indice del coche
	 * @return Coche en el indice indicado
	 */
	public Coche getCoche(int indice){
		if(isEmpty()){
			return null;
		}
		if(indice<0 || indice>garaje.size()-1){
			return null;
		}
		return garaje.get(indice);
	}

	/**
	 * Cuenta los coches del concesionario
	 * 
	 * @return Número de coches del concesionario
	 * @throws ConcesionarioVacioException
	 */
	public int contarCoches() throws ConcesionarioVacioException {
		if (garaje.isEmpty())
			throw new ConcesionarioVacioException("El concesionario está vacío");
		return garaje.size();
	}

	/**
	 * Recoje todos los coches del color añadido y los devuelve. En caso de no
	 * haber ninguno, también lo dice.
	 * 
	 * @param color
	 *            Color del coche
	 * @return Cadena con los coches de ese color
	 * @throws ConcesionarioVacioException 
	 */
	public ArrayList<Coche> mostrarPorColor(Colores color) throws ConcesionarioVacioException {
		if(isEmpty())
			throw new ConcesionarioVacioException("El concesionario está vacío");
		
		ArrayList<Coche> cochesColor = new ArrayList<Coche>();
		for (Coche coche : garaje) {
			if (coche.getColor().equals(color))
				cochesColor.add(coche);
		}
		if(cochesColor.isEmpty())
			throw new ConcesionarioVacioException("No existen coches de ese color");
		return cochesColor;
	}

	/**
	 * Indica si el concesionario está vacío
	 * @return Si el concesionario está vacío
	 */
	public boolean isEmpty() {

		return garaje.isEmpty();
	}
	 
	@Override
	public ListIterator<Coche> iterator() {
		return garaje.listIterator();
	}
}

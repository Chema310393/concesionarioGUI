package concesionarioGUI.concesionario;
import java.io.*;

public class Fichero implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Guarda un objeto en un archivo
	 * @param file Archivo en el que se guardará
	 * @param objeto Objeto que se guardará
	 * @throws IOException
	 */
	public static void guardar(File file, Object objeto) throws IOException {
		file = comprobarExtension(file);
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
			out.writeObject(objeto);
		}
	}

	/**
	 * Comprueba que la extensión del documento sea obj y en caso de que no lo sea se lo añade
	 * @param file Archivo a comprobar
	 * @return Archivo con terminación válida
	 */
	private static File comprobarExtension(File file) {
		String path = file.getPath();
		if (!path.endsWith(".obj"))
			return new File(path + ".obj");
		return new File(path);
	}

	/**
	 * 
	 * @param file
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static Object abrir(File file) throws ClassNotFoundException, IOException {
		file = comprobarExtension(file);
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
			return in.readObject();
		}
	}

	/**
	 * Comprueba si el archivo existe
	 * @param file Archivo a combrobar
	 * @return existe o no
	 */
	public static boolean fileExist(File file) {
		file = comprobarExtension(file);
		return file.exists();
	}

}

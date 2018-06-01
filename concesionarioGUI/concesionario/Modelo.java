package concesionarioGUI.concesionario;
import java.io.Serializable;

public enum Modelo implements Serializable{
	CORDOBA(Marca.SEAT), TOLEDO(Marca.SEAT), IBIZA(Marca.SEAT), SERIE1(Marca.BMW), SERIE2(Marca.BMW), SERIE3(Marca.BMW), SERIE5(Marca.BMW);
	private static int ARRAYLENGTH = Modelo.values().length;
	private Marca marca;

	Modelo(Marca marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return name();
	}

	public Marca getMarca(){
		return this.marca;
	}
//	private int getStringArray(){
//		String[] array= new String[ARRAYLENGTH];
//		for(int i=0; i<ARRAYLENGTH; i++){
//			array[i]=Modelo.toArray()[i].toString();
//		}
//		return array;
//	}
	
	public static String[] getStringArray(){
		String[] array= new String[ARRAYLENGTH];
		for(int i=0; i<ARRAYLENGTH; i++){
			array[i]=Modelo.values()[i].toString();
		}
		return array;
	}
	
	
}

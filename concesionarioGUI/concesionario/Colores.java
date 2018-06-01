package concesionarioGUI.concesionario;
import java.io.Serializable;

public enum Colores implements Serializable{
	ROJO, AZUL, PLATA;
	
	private static int ARRAYLENGTH = Colores.values().length;
	
	@Override
	public String toString(){
		return name();
	}
	
	public static String[] getStringArray(){
		String[] array= new String[ARRAYLENGTH];
		for(int i=0; i<ARRAYLENGTH; i++){
			array[i]=Colores.values()[i].toString();
		}
		return array;
	}
	
	
}

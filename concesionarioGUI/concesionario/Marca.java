package concesionarioGUI.concesionario;
import java.io.Serializable;

public enum Marca implements Serializable{
	SEAT, BMW;
	private static int ARRAYLENGTH = Marca.values().length;
	@Override
	public String toString(){
		return name();
	}
	
	public static String[] getStringArray(){
		String[] array= new String[ARRAYLENGTH];
		for(int i=0; i<ARRAYLENGTH; i++){
			array[i]=Marca.values()[i].toString();
		}
		return array;
	}
	
	
}

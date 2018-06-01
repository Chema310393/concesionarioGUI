package concesionarioGUI.concesionario;//package concesionario;
//
//import static org.junit.Assert.*;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//public class TestCoche {
//
//	Coche coche;
//
//	@Test
//	public void testCoche1() {
//		
//		String[] matriculasInvalidas={"8888UPR","14527RTY", "1452 ETY", "POTE 452", " ", "123DFG", "1234FERT" };
//		
//		for (String matriculaInvalida:matriculasInvalidas) {
//			try {
//				new Coche(Modelo.CORDOBA, Color.AZUL, matriculaInvalida);
//				fail();
//			} catch (ModeloNoValidoException | ColorNoValidoException e) {
//				fail();
//			} catch (MatriculaNoValida e) {
//				System.err.println(matriculaInvalida +" "+ e.getMessage());
//			} 
//		}
//	}
//}

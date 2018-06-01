package concesionarioGUI.gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.*;
import concesionarioGUI.concesionario.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.KeyStroke;
import java.awt.event.*;

/**
 * Clase principal de la GUI
 * 
 * @author Chema
 * @version 1.0
 */
public class PrincipalGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFileChooser fileChooser = new JFileChooser();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalGUI frame = new PrincipalGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarPrograma();
			}
		});
		
		setTitle("Concesionario");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 631, 519);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("Archivo");
		menuBar.add(mnFile);

		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionarGuardado();
//				Entorno.setConcesionario(new Concesionario());
//				Entorno.setFile(null);
				Entorno.nuevo();
			}
		});
		mnFile.add(mntmNuevo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					gestionarAbrir();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		mnFile.add(mntmAbrir);

		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarArchivo();
			}
		});
		mnFile.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					guardarComo();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e + "" + "\nNo se ha encontrado el archivo", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		mnFile.add(mntmGuardarComo);

		JMenu mnCoches = new JMenu("Coches");
		menuBar.add(mnCoches);

		JMenuItem mntmAadir = new JMenuItem("A\u00F1adir");
		mntmAadir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoGUI nuevoGui = new NuevoGUI();
				nuevoGui.setVisible(true);
			}
		});
		mnCoches.add(mntmAadir);

		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EliminarGUI eliminarGui = new EliminarGUI();
					eliminarGui.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnCoches.add(mntmEliminar);

		JSeparator separator_6 = new JSeparator();
		mnCoches.add(separator_6);

		JMenuItem mntmBuscarCoche = new JMenuItem("Mostrar concesionario");
		mntmBuscarCoche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mntmBuscarCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MostrarGUI mostrar = new MostrarGUI();
					mostrar.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnCoches.add(mntmBuscarCoche);

		JMenuItem mntmMostrarConcesionarioPor = new JMenuItem("Mostrar concesionario por color");
		mntmMostrarConcesionarioPor
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmMostrarConcesionarioPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MostrarColorGUI mostrar = new MostrarColorGUI();
					mostrar.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnCoches.add(mntmMostrarConcesionarioPor);

		JMenuItem mntmMostrarCoche = new JMenuItem("Mostrar coche");
		mntmMostrarCoche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mntmMostrarCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MostrarCocheGUI mostrarCoche = new MostrarCocheGUI();
					mostrarCoche.setVisible(true);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnCoches.add(mntmMostrarCoche);

		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		JMenuItem mntmVerAyuda = new JMenuItem("Ver ayuda");
		mntmVerAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaGUI ayuda = new AyudaGUI();
				ayuda.setVisible(true);
			}
		});
		mntmVerAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnAyuda.add(mntmVerAyuda);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcercaDeGUI acercaDe = new AcercaDeGUI();
				acercaDe.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	/**
	 * Da la opción de guardar en caso de cerrar el programa
	 */
	private void cerrarPrograma() {
		int guarda = gestionarGuardado();
		if (guarda == JOptionPane.YES_OPTION || guarda == JOptionPane.NO_OPTION) {
			dispose();
		}
	}

	/**
	 * Guarda el concesionario en un archivo
	 */
	protected void guardarArchivo() {
		try {
			if (Entorno.getFile() != null) {
//				Fichero.guardar(Entorno.getFile(), Entorno.getConcesionario());
//				Entorno.setModificado(false);
				Entorno.guardar();
			} else {
				guardarComo();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e + "" + "\nNo se ha encontrado el archivo", "Error",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	/**
	 * Guarda
	 * 
	 * @throws IOException
	 */
	private void guardarComo() throws IOException {
		fileChooser.showSaveDialog(this);
		if (fileChooser.getSelectedFile() != null) {
			Entorno.guardarComo(fileChooser.getSelectedFile());
//			Entorno.setFile(fileChooser.getSelectedFile());
//			Fichero.guardar(Entorno.getFile(), Entorno.getConcesionario());
//			Entorno.setModificado(false);
			setTitle("Concesionario " + Entorno.getFile().getName());
		}

	}

	/**
	 * Comprueba si el concesionario está modificado y guarda en caso afirmativo
	 */
	int gestionarGuardado() {
		int respuesta = 0;
		if (Entorno.isModificado()) {
			respuesta = JOptionPane.showConfirmDialog(contentPane, "Desea guardar el archivo?");
			if (respuesta == JOptionPane.YES_OPTION) {
				guardarArchivo();
			}
		}
		return respuesta;
	}

	/**
	 * Metodo que gestiona el guardado de archivos antes de abrir.
	 * 
	 * @throws IOException
	 */
	private void gestionarAbrir() throws IOException {
		gestionarGuardado();
		abrirArchivo();

	}

	/**
	 * Abre un archivo con concesionario
	 * 
	 * @return Concesionario
	 */
	protected void abrirArchivo() {
		try {
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(null, "obj"));
			fileChooser.showOpenDialog(this);
			if (fileChooser.getSelectedFile() != null) {
				Entorno.abrir(fileChooser.getSelectedFile());
//				Entorno.setFile(fileChooser.getSelectedFile());
//				Entorno.setConcesionario((Concesionario) Fichero.abrir(Entorno.getFile()));
//				Entorno.setModificado(false);
				setTitle("Concesionario " + Entorno.getFile().getName());
			}
		} catch (IOException | ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, ex + "" + "\nNo se ha encontrado el archivo", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}

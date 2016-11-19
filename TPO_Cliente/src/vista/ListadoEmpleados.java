package vista;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.EventQueue;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Dimension;

import businessDelegate.BusinessDelegate;
import dto.EmpleadoDTO;
import exceptions.EmpleadoException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListadoEmpleados extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4770879800019694174L;
	private JTable tblEmpleados;
	private String header[] = new String[] {"Id",
											"Nombre",
											"Cuit",
											"Rol",
											"Sucursal"};
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoEmpleados frame = new ListadoEmpleados();
					frame.setVisible(true);
					Dimension d = new Dimension();
					d.setSize(700,400);
					frame.setSize(d); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ListadoEmpleados() {
		getContentPane().setBackground(new Color(118,184,82));
		setTitle("Listado empleados");
		getContentPane().setLayout(null);
		
		tblEmpleados = new JTable();
		tblEmpleados.setColumnSelectionAllowed(true);
		tblEmpleados.setCellSelectionEnabled(true);
		tblEmpleados.setEnabled(false);
		
		final DefaultTableModel dtm = new DefaultTableModel(0, 0);
		dtm.setColumnIdentifiers(header);
		dtm.addRow(header);
		tblEmpleados.setModel(dtm);
		
		JScrollPane scrollPane = new JScrollPane(tblEmpleados);
		scrollPane.setBounds(20, 36, 633, 215);
		scrollPane.setVisible(true);
		getContentPane().add(scrollPane);
		
		List<EmpleadoDTO> empleados = new ArrayList<EmpleadoDTO>();
		try {
			empleados = new BusinessDelegate().getBusinessService().getEmpleados();
		} catch (RemoteException | EmpleadoException e) {
			e.printStackTrace();
		}
		
		for(EmpleadoDTO e : empleados){
			dtm.addRow(new Object[] {e.getNumero(),
									 e.getNombre(),
									 e.getCuit(),
									 e.getRolEmpleado().getDescripcion(),
									 e.getSucursal().getNombre()});
		}
	}
	
}

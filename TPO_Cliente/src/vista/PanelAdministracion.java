package vista;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import businessDelegate.BusinessDelegate;
import dto.EmpleadoDTO;
import dto.EmpresaSeguroDTO;
import exceptions.EmpleadoException;
import exceptions.EmpresaSeguroException;

import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

/**
 * Vista que se encarga del área de administración.
 * Realiza las siguientes operaciones
 * - Dar de alta y baja a todos los empleados y directivos de la empresa.
 * - Registrar las novedades de los vehículos y lleva el control del estado de cada operación de 
 * mantenimiento.
 * - Actualizar y gestionar las listas de precios de los transportes y carries.
 * - Seleccionar las compañías de seguridad paraacompañar a los vehículos cuando sea necesario 
 * manteniendo los precios de las mismas.
 * - Llevar un registro de las compañías de seguros, donde figura el tipo de seguro que brinda, 
 * sobre qué tipo de mercaderías y las tarifas asociadas los mismos.
 * @author Daniel PC
 *
 */

public class PanelAdministracion extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3327786882089806661L;
	private JTable mantenimientosVehiculo;
	private JTextField txtPrecioServicioEmpSeg;
	private JTable table;
	private JTable tblListadoCarries;
	private JTextField txtPrecioCarrier;
	private JTable tblEmpresasAseguradoras;
	private String headerEmpresasAseg[] = new String[] {"Id",
														"Nombre",
														"Tipo de seguro",
														"Mercaderias aseguradas"};
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAdministracion frame = new PanelAdministracion();
					frame.setVisible(true);
					Dimension d = new Dimension();
					d.setSize(700,500);
					frame.setSize(d); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public PanelAdministracion() {
		getContentPane().setBackground(new Color(118,184,82)); //RGB de hexa: #76b852
		setTitle("Panel de administraci\u00F3n");
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(141,194,111)); //RGB de hexa: #8DC26F
		tabbedPane.setBounds(21, 21, 622, 385);
		getContentPane().add(tabbedPane);
		
		JPanel ABMEmpleados = new JPanel();
		tabbedPane.addTab("ABM Empleados", null, ABMEmpleados, null);
		ABMEmpleados.setLayout(null);
		
		JButton btnAltaEmpleado = new JButton("Alta empleado");
		btnAltaEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaEmpleado altaEmpleado = new AltaEmpleado();
				altaEmpleado.setVisible(true);
				altaEmpleado.setLocation(50, 50);
				Dimension d = new Dimension();
				d.setSize(700,600);
				altaEmpleado.setSize(d); 
			}
		});
		btnAltaEmpleado.setBounds(240, 35, 167, 35);
		ABMEmpleados.add(btnAltaEmpleado);
		
		JButton btnModificacionEmpleado = new JButton("Modificaci\u00F3n empleado");
		btnModificacionEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificaEmpleado modificaEmpleado = new ModificaEmpleado();
				modificaEmpleado.setVisible(true);
				modificaEmpleado.setLocation(50, 50);
				Dimension d = new Dimension();
				d.setSize(700,600);
				modificaEmpleado.setSize(d);
			}
		});
		btnModificacionEmpleado.setBounds(186, 105, 274, 35);
		ABMEmpleados.add(btnModificacionEmpleado);
		
		JButton btnBajaEmpleado = new JButton("Baja empleado");
		btnBajaEmpleado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EliminaEmpleado eliminaEmpleado = new EliminaEmpleado();
				eliminaEmpleado.setVisible(true);
				eliminaEmpleado.setLocation(50, 50);
				Dimension d = new Dimension();
				d.setSize(700,600);
				eliminaEmpleado.setSize(d);	
			}
		});
		btnBajaEmpleado.setBounds(229, 175, 189, 35);
		ABMEmpleados.add(btnBajaEmpleado);
		
		JButton btnListadoEmpleados = new JButton("Listado empleados");
		btnListadoEmpleados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListadoEmpleados listadoEmpleados = new ListadoEmpleados();
				listadoEmpleados.setVisible(true);
				listadoEmpleados.setLocation(50, 50);
				Dimension d = new Dimension();
				d.setSize(700,400);
				listadoEmpleados.setSize(d);		
			}
		});
		btnListadoEmpleados.setBounds(215, 245, 216, 35);
		ABMEmpleados.add(btnListadoEmpleados);
		
		JPanel EmpresasSeguros = new JPanel();
		tabbedPane.addTab("Empresas Seguros", null, EmpresasSeguros, null);
		EmpresasSeguros.setLayout(null);
		
		tblEmpresasAseguradoras = new JTable();
		tblEmpresasAseguradoras.setBounds(31, 88, 565, 208);
		EmpresasSeguros.add(tblEmpresasAseguradoras);
		
		final DefaultTableModel dtmEmpresasAseguradoras = new DefaultTableModel(0, 0);
		dtmEmpresasAseguradoras.setColumnIdentifiers(headerEmpresasAseg);
		tblEmpresasAseguradoras.setModel(dtmEmpresasAseguradoras);
		
		JScrollPane scrollPane = new JScrollPane(tblEmpresasAseguradoras);
		scrollPane.setBounds(20, 36, 576, 215);
		scrollPane.setVisible(true);
		EmpresasSeguros.add(scrollPane);
		
		List<EmpresaSeguroDTO> empresasAseguradoras = new ArrayList<EmpresaSeguroDTO>();
		try {
			empresasAseguradoras = new BusinessDelegate().getBusinessService().getListadoAseguradoras();
		} catch (RemoteException | EmpresaSeguroException e) {
			e.printStackTrace();
		}

		for(EmpresaSeguroDTO e : empresasAseguradoras){
			dtmEmpresasAseguradoras.addRow(new Object[] {e.getId(),
														 e.getNombre(),
														 e.getTipoSeguro(),
														 e.getMercaderiasAseguradas()});
		}

		JPanel Carries = new JPanel();
		tabbedPane.addTab("Carries", null, Carries, null);
		Carries.setLayout(null);
		
		JLabel lblCarries = new JLabel("Carries:");
		lblCarries.setBounds(53, 35, 72, 26);
		Carries.add(lblCarries);
		
		JComboBox listadoCarries = new JComboBox();
		listadoCarries.setBounds(159, 32, 316, 32);
		Carries.add(listadoCarries);
		
		JLabel lblDatos_1 = new JLabel("Listado:");
		lblDatos_1.setBounds(53, 181, 92, 32);
		Carries.add(lblDatos_1);
		
		tblListadoCarries = new JTable();
		tblListadoCarries.setBounds(31, 302, 565, -65);
		Carries.add(tblListadoCarries);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(53, 110, 92, 26);
		Carries.add(lblPrecio);
		
		txtPrecioCarrier = new JTextField();
		txtPrecioCarrier.setBounds(159, 107, 186, 32);
		Carries.add(txtPrecioCarrier);
		txtPrecioCarrier.setColumns(10);
		
		JPanel MantenimientoVehiculos = new JPanel();
		tabbedPane.addTab("Mantenimiento Vehiculos", null, MantenimientoVehiculos, null);
		MantenimientoVehiculos.setLayout(null);
		
		JComboBox listadoVehiculos = new JComboBox();
		listadoVehiculos.setBounds(285, 18, 209, 32);
		MantenimientoVehiculos.add(listadoVehiculos);
		
		JLabel lblVehiculos = new JLabel("Vehiculos");
		lblVehiculos.setBounds(139, 21, 92, 26);
		MantenimientoVehiculos.add(lblVehiculos);
		
		mantenimientosVehiculo = new JTable();
		mantenimientosVehiculo.setBounds(36, 304, 560, -115);
		MantenimientoVehiculos.add(mantenimientosVehiculo);
		
		JLabel lblListadoDeMantenimientos = new JLabel("Listado de mantenimientos:");
		lblListadoDeMantenimientos.setBounds(21, 147, 279, 26);
		MantenimientoVehiculos.add(lblListadoDeMantenimientos);
		
		JButton btnAgregarMantenimiento = new JButton("Agregar mantenimiento");
		btnAgregarMantenimiento.setBounds(176, 91, 263, 35);
		MantenimientoVehiculos.add(btnAgregarMantenimiento);
		
		JPanel EmpresasSeguridad = new JPanel();
		tabbedPane.addTab("Empresas Seguridad", null, EmpresasSeguridad, null);
		EmpresasSeguridad.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Empresas de seguridad:");
		lblNewLabel.setBounds(47, 32, 245, 26);
		EmpresasSeguridad.add(lblNewLabel);
		
		JComboBox listadoEmpresasSeguridad = new JComboBox();
		listadoEmpresasSeguridad.setBounds(306, 29, 290, 32);
		EmpresasSeguridad.add(listadoEmpresasSeguridad);
		
		JLabel lblPrecioDelServicio = new JLabel("Precio del servicio:");
		lblPrecioDelServicio.setBounds(47, 103, 175, 26);
		EmpresasSeguridad.add(lblPrecioDelServicio);
		
		txtPrecioServicioEmpSeg = new JTextField();
		txtPrecioServicioEmpSeg.setBounds(306, 100, 186, 32);
		EmpresasSeguridad.add(txtPrecioServicioEmpSeg);
		txtPrecioServicioEmpSeg.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(215, 171, 141, 35);
		EmpresasSeguridad.add(btnGuardar);

	}
}

package vista;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import businessDelegate.BusinessDelegate;
import dto.EmpleadoDTO;
import dto.EmpresaSeguroDTO;
import dto.MantenimientoDTO;
import dto.RolEmpleadoDTO;
import dto.VehiculoDTO;
import exceptions.EmpleadoException;
import exceptions.EmpresaSeguroException;
import exceptions.MantenimientoException;
import exceptions.VehiculoException;
import util.Formato;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

/**
 * Vista que se encarga del área de administración.
 * Realiza las siguientes operaciones
 * - Dar de alta y baja a todos los empleados y directivos de la empresa.
 * - Llevar un registro de las compañías de seguros, donde figura el tipo de seguro que brinda, 
 * sobre qué tipo de mercaderías y las tarifas asociadas los mismos.
 * - Registrar las novedades de los vehículos y lleva el control del estado de cada operación de 
 * mantenimiento.
 * - Actualizar y gestionar las listas de precios de los transportes y carries.
 * - Seleccionar las compañías de seguridad para acompañar a los vehículos cuando sea necesario 
 * manteniendo los precios de las mismas.
 * @author Daniel PC
 *
 */

public class PanelAdministracion extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3327786882089806661L;
	private JTable tblMantenimientosVeh;
	private JTextField txtPrecioServicioEmpSeg;
	private JTable table;
	private JTable tblListadoCarries;
	private JTextField txtPrecioCarrier;
	private JTable tblEmpresasAseguradoras;
	private String headerEmpresasAseg[] = new String[] {"Id",
														"Nombre",
														"Tipo de seguro",
														"Mercaderias aseguradas"};
	private String headerMantenimientoVehiculo[] = new String[] {"Fecha",
																 "Tipo de mantenimiento",
																 "Ultimo Kilometraje"};
	
	private JTextField txtTipoMantenimientoVeh;
	private JTextField txtUltimoKilometrajeVeh;
	private DefaultTableModel dtmMantenimientoVehiculos; 
	private VehiculoDTO vehiculoSelecccionado;
	private List<MantenimientoDTO> mantenimientos;
	private JLabel lblMensajeMantenimientoVeh;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAdministracion frame = new PanelAdministracion();
					frame.setVisible(true);
					Dimension d = new Dimension();
					d.setSize(700,620);
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
		tabbedPane.setBounds(21, 21, 622, 521);
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
		
		JPanel MantenimientoVehiculos = new JPanel();
		tabbedPane.addTab("Mantenimiento Vehiculos", null, MantenimientoVehiculos, null);
		MantenimientoVehiculos.setLayout(null);
		
		List<VehiculoDTO> vehiculos = new ArrayList<VehiculoDTO>();
		
		try {
			vehiculos = new BusinessDelegate().getBusinessService().getVehiculosDisponibles();
		} catch (RemoteException | VehiculoException e1) {
			e1.printStackTrace();
		}

		final List<VehiculoDTO> vehiculosAux = vehiculos;
		
		DefaultComboBoxModel<Object> listModelVehiculo = new DefaultComboBoxModel<Object>();
		
		HashMap<Integer,String> MapSelecVehiculos = new HashMap<>();
		MapSelecVehiculos.put(9999,"Seleccione un vehiculo");
		listModelVehiculo.addElement(MapSelecVehiculos);

		for(VehiculoDTO v:vehiculos){
			HashMap<Integer,String> MapVehiculos = new HashMap<>();
			MapVehiculos.put(v.getNumero(),v.getMarca() + " " + v.getModelo() + " - (" + v.getPatente() + ")");
			listModelVehiculo.addElement(MapVehiculos);
		}

		final JComboBox listadoVehiculos = new JComboBox<>(listModelVehiculo);
		listadoVehiculos.setBounds(123, 15, 473, 32);
		MantenimientoVehiculos.add(listadoVehiculos);
		
		listadoVehiculos.addActionListener(new ActionListener() {

			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				inicializarCamposMantVehic();
				limpiarTablaMantenimiento();
				
				Integer nroVehSel = 0;
		    	HashMap<Integer,String> vehSel = (HashMap<Integer, String>) listadoVehiculos.getSelectedItem();
		    	Iterator<Entry<Integer, String>> it = vehSel.entrySet().iterator();
		    	while (it.hasNext()) {
		    		@SuppressWarnings("rawtypes")
					Map.Entry pair = (Map.Entry)it.next();
		    		nroVehSel = (Integer) pair.getKey();
		    	}
				
				//cargamos los mantenimientos realizados al vehiculo (si tiene)
				if(!vehiculosAux.isEmpty()){
					for(VehiculoDTO v:vehiculosAux){
						if(v.getNumero() == nroVehSel){
							vehiculoSelecccionado = v;
							mantenimientos = v.getMantenimientos();
							if(!mantenimientos.isEmpty()){
								cargarTablaMantenimiento(mantenimientos);
							}
						}
					}
				}
			}
		});
		
		JLabel lblVehiculos = new JLabel("Vehiculos");
		lblVehiculos.setBounds(21, 21, 92, 26);
		MantenimientoVehiculos.add(lblVehiculos);
		
		tblMantenimientosVeh = new JTable();
		tblMantenimientosVeh.setBounds(21, 424, 575, -89);
		MantenimientoVehiculos.add(tblMantenimientosVeh);
		
		dtmMantenimientoVehiculos = new DefaultTableModel(0, 0);
		dtmMantenimientoVehiculos.setColumnIdentifiers(headerMantenimientoVehiculo);
		tblMantenimientosVeh.setModel(dtmMantenimientoVehiculos);
		
		JScrollPane scrollPaneMantenimientoVehiculos = new JScrollPane(tblMantenimientosVeh);
		scrollPaneMantenimientoVehiculos.setBounds(20, 314, 576, 118);
		scrollPaneMantenimientoVehiculos.setVisible(true);
		MantenimientoVehiculos.add(scrollPaneMantenimientoVehiculos);
		
		JLabel lblListadoDeMantenimientos = new JLabel("Listado de mantenimientos:");
		lblListadoDeMantenimientos.setBounds(21, 281, 279, 26);
		MantenimientoVehiculos.add(lblListadoDeMantenimientos);
		
		JButton btnGuardarMantenimiento = new JButton("Guardar");
		btnGuardarMantenimiento.setBounds(21, 225, 120, 35);
		MantenimientoVehiculos.add(btnGuardarMantenimiento);
		
		btnGuardarMantenimiento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String tipoMantenimiento 	= txtTipoMantenimientoVeh.getText();
				String ultimoKilometraje	= txtUltimoKilometrajeVeh.getText();

				if(tipoMantenimiento.length() > 0 && ultimoKilometraje.length() > 0){
					MantenimientoDTO m = new MantenimientoDTO(new Date(),
															  tipoMantenimiento,
															  Integer.valueOf(ultimoKilometraje));
					mantenimientos.add(m);
					
					vehiculoSelecccionado.setMantenimientos(mantenimientos);
					
					//TODO persistir mantenimiento
					boolean guardado = false;
					try {
						 guardado = new BusinessDelegate().getBusinessService().guardarMantenimientoPorVehiculo(vehiculoSelecccionado);
					} catch (RemoteException | MantenimientoException e1) {
						e1.printStackTrace();
					}
					
					if(guardado){
					//Agrega registro a la tabla
					dtmMantenimientoVehiculos.addRow(new Object[] {new SimpleDateFormat("yyyy-MM-dd").format(m.getFecha()),
															   	   m.getTipo(),
															   	   m.getUltimoKilometraje()});	
						lblMensajeMantenimientoVeh.setText("Mantenimiento guardado");
					}else{
						lblMensajeMantenimientoVeh.setText("Hubo un error");
					}
				}else{
					lblMensajeMantenimientoVeh.setText("Hay datos sin completar");
				}
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 68, 575, 2);
		MantenimientoVehiculos.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(21, 273, 575, 2);
		MantenimientoVehiculos.add(separator_1);
		
		JLabel lblTipoMantenimiento = new JLabel("Tipo mantenimiento");
		lblTipoMantenimiento.setBounds(21, 131, 197, 26);
		MantenimientoVehiculos.add(lblTipoMantenimiento);
		
		JLabel lblUltimoKilometraje = new JLabel("Ultimo Kilometraje");
		lblUltimoKilometraje.setBounds(21, 178, 184, 26);
		MantenimientoVehiculos.add(lblUltimoKilometraje);
		
		txtTipoMantenimientoVeh = new JTextField();
		txtTipoMantenimientoVeh.setBounds(227, 128, 369, 32);
		MantenimientoVehiculos.add(txtTipoMantenimientoVeh);
		txtTipoMantenimientoVeh.setColumns(10);
		
		txtUltimoKilometrajeVeh = new JTextField();
		txtUltimoKilometrajeVeh.setBounds(226, 175, 92, 32);
		MantenimientoVehiculos.add(txtUltimoKilometrajeVeh);
		txtUltimoKilometrajeVeh.setColumns(10);
		
		lblMensajeMantenimientoVeh = new JLabel("");
		lblMensajeMantenimientoVeh.setBounds(162, 225, 434, 35);
		MantenimientoVehiculos.add(lblMensajeMantenimientoVeh);
		
		JLabel lblAgregarMantenimiento = new JLabel("Agregar mantenimiento:");
		lblAgregarMantenimiento.setBounds(21, 84, 236, 26);
		MantenimientoVehiculos.add(lblAgregarMantenimiento);
		
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
	
	public void cargarTablaMantenimiento(List<MantenimientoDTO> mantenimientos){
		for(MantenimientoDTO m : mantenimientos){
			dtmMantenimientoVehiculos.addRow(new Object[] {new SimpleDateFormat("yyyy-MM-dd").format(m.getFecha()),
														   m.getTipo(),
														   m.getUltimoKilometraje()});
		}
	}
	
	
	public void limpiarTablaMantenimiento(){
		int filas = dtmMantenimientoVehiculos.getRowCount() - 1;
		if(filas > 0){
			while(filas >= 0){
				dtmMantenimientoVehiculos.removeRow(filas);
				filas--;
			}
		}
	}
	
	public void inicializarCamposMantVehic(){
		txtTipoMantenimientoVeh.setText("");
		txtUltimoKilometrajeVeh.setText("");
	}
	
}

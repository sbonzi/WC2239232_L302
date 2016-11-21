package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import businessDelegate.BusinessDelegate;
import dto.EmpleadoDTO;
import dto.RolEmpleadoDTO;
import dto.SucursalDTO;
import exceptions.EmpleadoException;
import exceptions.RolEmpleadoException;
import exceptions.SucursalException;
import util.Formato;

import javax.swing.JSeparator;
import java.awt.Font;

public class AltaEmpleado extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4770879800019694174L;
	private JTextField txtCuitEmpleado_dni;
	private JTextField txtNombreYApellido;
	private JTextField txtCuitEmpleado_digInic;
	private JTextField txtCuitEmpleado_digVerif;
	private JList listadoRoles;
	private JList listadoSucursales;
	private JButton btnGuardar;
	private JLabel lblMensaje;
	private Integer nroRolSeleccionado;
	private Integer nroSucursalSeleccionada;
	private JLabel lblMensajeEmpleadoExiste;
	private JLabel lblContrasea;
	private JTextField txtPassword;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaEmpleado frame = new AltaEmpleado();
					frame.setVisible(true);
					Dimension d = new Dimension();
					d.setSize(700,650);
					frame.setSize(d); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AltaEmpleado() {
		getContentPane().setBackground(new Color(118,184,82));
		setTitle("Alta empleados");
		getContentPane().setLayout(null);
		
		JLabel lblCuit = new JLabel("Cuit:");
		lblCuit.setBounds(21, 50, 92, 26);
		getContentPane().add(lblCuit);
		
		txtCuitEmpleado_dni = new JTextField();
		txtCuitEmpleado_dni.setBounds(271, 47, 186, 32);
		getContentPane().add(txtCuitEmpleado_dni);
		//Máximos caracteres
		txtCuitEmpleado_dni.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (txtCuitEmpleado_dni.getText().length() >= 8 ){
	                e.consume();
	            }
	        }
	    });
		
		txtCuitEmpleado_digInic = new JTextField(2);
		txtCuitEmpleado_digInic.setBounds(208, 47, 56, 32);
		getContentPane().add(txtCuitEmpleado_digInic);
		//Máximos caracteres
		txtCuitEmpleado_digInic.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (txtCuitEmpleado_digInic.getText().length() >= 2 ){
	                e.consume();
	            }
	        }
	    });
		
		txtCuitEmpleado_digVerif = new JTextField();
		txtCuitEmpleado_digVerif.setBounds(462, 47, 40, 32);
		getContentPane().add(txtCuitEmpleado_digVerif);
		//Máximos caracteres
		txtCuitEmpleado_digVerif.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (txtCuitEmpleado_digVerif.getText().length() >= 1 ){
	                e.consume();
	            }
	        }
	    });
		
		JSeparator separator = new JSeparator();
		separator.setBounds(41, 131, 563, 2);
		getContentPane().add(separator);
		
		JButton btnChequear = new JButton("Chequear");
		btnChequear.setBounds(514, 46, 137, 35);
		getContentPane().add(btnChequear);
		
		/**
		 * Verifica si ya existe un empleado con el cuit cargado
		 */
		btnChequear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean existeEmpleado = false;
				String cuit = txtCuitEmpleado_digInic.getText() + 
						  	  txtCuitEmpleado_dni.getText() +
						  	  txtCuitEmpleado_digVerif.getText();
				
				if(cuit.length() == 11 && Formato.isNumeric(cuit)){
					try {
						existeEmpleado = new BusinessDelegate().getBusinessService().existeEmpleado(cuit);
						if(!existeEmpleado){
							habilitarCampos();
							lblMensajeEmpleadoExiste.setVisible(false);
							lblMensajeEmpleadoExiste.setText("");
						}else{
							lblMensajeEmpleadoExiste.setVisible(true);
							lblMensajeEmpleadoExiste.setText("Ya existe un empleado con ese CUIT");
						}
					} catch (RemoteException | EmpleadoException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
	
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido:");
		lblNombreYApellido.setBounds(21, 154, 186, 26);
		getContentPane().add(lblNombreYApellido);
		
		txtNombreYApellido = new JTextField();
		txtNombreYApellido.setBounds(208, 151, 294, 32);
		txtNombreYApellido.setEnabled(false);
		getContentPane().add(txtNombreYApellido);
		txtNombreYApellido.setColumns(10);
		
		JLabel lblRolAAsignar = new JLabel("Rol a desempe\u00F1ar");
		lblRolAAsignar.setBounds(21, 216, 186, 26);
		getContentPane().add(lblRolAAsignar);
		
		JLabel lblSucursalAsignada = new JLabel("Sucursal asignada");
		lblSucursalAsignada.setBounds(21, 337, 186, 26);
		getContentPane().add(lblSucursalAsignada);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(208, 518, 141, 35);
		btnGuardar.setEnabled(false);
		getContentPane().add(btnGuardar);
		
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String cuit = txtCuitEmpleado_digInic.getText() + 
							  txtCuitEmpleado_dni.getText() +
							  txtCuitEmpleado_digVerif.getText();
				
				String nombre = txtNombreYApellido.getText();
				EmpleadoDTO empleado = new EmpleadoDTO(cuit, nombre);
				
				//Asigna sucursal
				SucursalDTO sucursal;
				sucursal = getSucursalByNro(nroSucursalSeleccionada);
				empleado.setSucursal(sucursal);
				
				//Asigna rol
				RolEmpleadoDTO rolEmpleado = getRolEmpleadoByNro(nroRolSeleccionado); 
				empleado.setRolEmpleado(rolEmpleado);
				
				//password
				String password = txtPassword.getText();
				empleado.setPassword(password);
				
				//Crea empleado
				try {
					EmpleadoDTO empleadoCreado = new BusinessDelegate().getBusinessService().crearEmpleado(empleado);
					if(empleadoCreado != null){
						lblMensaje.setText("Empleado creado!");
						lblMensaje.setVisible(true);
						
						new Timer(1500, new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent e) {
				            	lblMensaje.setText("");
				            }
				        }).start();
					}else{
						lblMensaje.setText("Ocurrió un error.");
						lblMensaje.setVisible(true);
						
						new Timer(1500, new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent e) {
				            	lblMensaje.setText("");
				            }
				        }).start();
					}
				} catch (RemoteException | EmpleadoException e) {
					e.printStackTrace();
				}
			}
		});
		
		//Listamos los roles disponibles
		List<RolEmpleadoDTO> roles = new ArrayList<RolEmpleadoDTO>();
		try {
			roles = new BusinessDelegate().getBusinessService().getRoles();
		} catch (RemoteException | RolEmpleadoException e) {
			e.printStackTrace();
		}
		
		DefaultListModel<Object> listadoRolesEmp = new DefaultListModel<Object>();
		for(RolEmpleadoDTO r : roles){
			HashMap<Integer,String> MapRoles = new HashMap<>();
			MapRoles.put(r.getId(),r.getDescripcion());
			listadoRolesEmp.addElement(MapRoles);
		}
		
		JScrollPane scrollPaneRoles = new JScrollPane();
		listadoRoles = new JList<Object>(listadoRolesEmp);
		listadoRoles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneRoles.setBounds(208, 214, 294, 100);
		scrollPaneRoles.setVisible(true);
		scrollPaneRoles.setViewportView(listadoRoles);
		listadoRoles.setEnabled(false);
		getContentPane().add(scrollPaneRoles);
		
		listadoRoles.addListSelectionListener(new ListSelectionListener() {
			@SuppressWarnings("unchecked")
			public void valueChanged(ListSelectionEvent e) {
			    if (e.getValueIsAdjusting() == false) {
			    	HashMap<Integer,String> rolSel = (HashMap<Integer, String>) listadoRoles.getSelectedValue();
			    	Iterator<Entry<Integer, String>> it = rolSel.entrySet().iterator();
			    	while (it.hasNext()) {
			    		@SuppressWarnings("rawtypes")
						Map.Entry pair = (Map.Entry)it.next();
			    		nroRolSeleccionado = (Integer) pair.getKey();
			    	}
			    }
			}
		});
		
		//Listamos las sucursales disponibles
		List<SucursalDTO> sucursales = new ArrayList<SucursalDTO>();
		try {
			sucursales = new BusinessDelegate().getBusinessService().getSucursales();
		} catch (RemoteException | SucursalException e) {
			e.printStackTrace();
		}
		
		DefaultListModel<Object> listadoSucEmp = new DefaultListModel<Object>();
		for(SucursalDTO s : sucursales){
			HashMap<Integer,String> MapSucursales = new HashMap<>();
			MapSucursales.put(s.getNumero(),s.getNombre());
			listadoSucEmp.addElement(MapSucursales);
			
		}
		
		JScrollPane scrollPaneSucursales = new JScrollPane();
		listadoSucursales = new JList<Object>(listadoSucEmp);
		listadoSucursales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneSucursales.setBounds(208, 335, 294, 100);
		scrollPaneSucursales.setVisible(true);
		scrollPaneSucursales.setViewportView(listadoSucursales);
		listadoSucursales.setEnabled(false);
		getContentPane().add(scrollPaneSucursales);
		
		lblMensaje = new JLabel("");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMensaje.setVisible(false);
		lblMensaje.setBounds(370, 518, 274, 35);
		getContentPane().add(lblMensaje);
		
		lblMensajeEmpleadoExiste = new JLabel("");
		lblMensajeEmpleadoExiste.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMensaje.setVisible(false);
		lblMensajeEmpleadoExiste.setBounds(21, 92, 583, 35);
		getContentPane().add(lblMensajeEmpleadoExiste);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(21, 461, 169, 26);
		getContentPane().add(lblContrasea);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(208, 465, 294, 32);
		getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		listadoSucursales.addListSelectionListener(new ListSelectionListener() {
			@SuppressWarnings("unchecked")
			public void valueChanged(ListSelectionEvent e) {
			    if (e.getValueIsAdjusting() == false) {
			    	HashMap<Integer,String> sucSel = (HashMap<Integer, String>) listadoSucursales.getSelectedValue();
			    	Iterator<Entry<Integer, String>> it = sucSel.entrySet().iterator();
			    	while (it.hasNext()) {
			    		@SuppressWarnings("rawtypes")
						Map.Entry pair = (Map.Entry)it.next();
			    		nroSucursalSeleccionada = (Integer) pair.getKey();
			    	}
			    }
			}
		});	
	}
	
	public void habilitarCampos(){
		txtNombreYApellido.setEnabled(true);
		listadoRoles.setEnabled(true);
		listadoSucursales.setEnabled(true);
		btnGuardar.setEnabled(true);
	}
	
	public void deshabilitarCampos(){
		txtNombreYApellido.setEnabled(false);
		listadoRoles.setEnabled(false);
		listadoSucursales.setEnabled(false);
		btnGuardar.setEnabled(false);
	}
	
	public RolEmpleadoDTO getRolEmpleadoByNro(int nroRolEmpleado) {
		RolEmpleadoDTO rolEmpleado = null;
		List<RolEmpleadoDTO> rolesEmpleado;
		try {
			rolesEmpleado = new BusinessDelegate().getBusinessService().getRoles();
			for(RolEmpleadoDTO r:rolesEmpleado){
				if(r.getId() == nroRolEmpleado){
					rolEmpleado = r;
					break;
				}
			}
		} catch (RemoteException | RolEmpleadoException e) {
			e.printStackTrace();
		}

		return rolEmpleado;
	}
	
	public List<SucursalDTO> getSucursales() {
		List<SucursalDTO> sucursales = null;
		try {
			sucursales = new BusinessDelegate().getBusinessService().getSucursales();
		} catch (RemoteException | SucursalException e) {
			e.printStackTrace();
		}
		return sucursales;
	}
	
	public SucursalDTO getSucursalByNro(int nroSucursal) {
		SucursalDTO sucursal = null;
		List<SucursalDTO> sucursales = this.getSucursales();
		for(SucursalDTO s:sucursales){
			if(s.getNumero() == nroSucursal){
				sucursal = s;
				break;
			}
		}
		return sucursal;
	}
}

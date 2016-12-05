package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import dao.ViajeDAO;
import util.Constantes;
import util.GenerarArchivoXML;


@Entity
@Table(name="Viaje")
public class Viaje implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8798508345826579597L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@OneToMany(mappedBy="viaje",cascade = CascadeType.ALL)
	private List<Envio> envios = new ArrayList<Envio>();
	
	private String latitud;
	private String longitud;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_Vehiculo")
	private Vehiculo vehiculoDesignado;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_EstadoViaje")
	private EstadoViaje estadoViaje;
	
	@Column(name = "fechaSalida", columnDefinition="DATE")
	@Type(type="date")
	private Date fechaSalida;
	
	@Column(name = "fechaLlegada", columnDefinition="DATE")
	@Type(type="date")
	private Date fechaLlegada;
	
	public Viaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Viaje(List<Envio> envios,
				 Vehiculo vehiculoDesignado) {
		super();
		this.envios = envios;
		this.vehiculoDesignado = vehiculoDesignado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Envio> getEnvios() {
		return envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public Vehiculo getVehiculoDesignado() {
		return vehiculoDesignado;
	}

	public void setVehiculoDesignado(Vehiculo vehiculoDesignado) {
		this.vehiculoDesignado = vehiculoDesignado;
	}

	public EstadoViaje getEstadoViaje() {
		return estadoViaje;
	}

	public void setEstadoViaje(EstadoViaje estadoViaje) {
		this.estadoViaje = estadoViaje;
	}
	
	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	
	/**
	 * Calcula si el vehiculo asignado tiene capacidad para cargar más envios
	 */
	public boolean tengoCapacidadEnVehiculoAsignado(Envio envio){
		boolean res = false;
		
		if(vehiculoDesignado.getTara() >= envio.calcularPesoTotalCargas()){
			res = true;
		}
		return res;
	}
	
	/**
	 * Asigna un envio al vehiculo del viaje
	 */
	public boolean agregarEnvioAVehiculoAsignado(Envio envio){
		envios.add(envio);
		return estaCompletoElVehiculo();
	}
	
	/**
	 * Indica si el vehiculo llegó al 70% o más de su capacidad
	 */
	public boolean estaCompletoElVehiculo(){
		boolean res = false;
		float pesoActualEnvios = 0;
		
		for(Envio envio:this.envios){
			pesoActualEnvios =  pesoActualEnvios + envio.calcularPesoTotalCargas();
		}
		
		if((this.vehiculoDesignado.getTara() * 0.2) <= pesoActualEnvios){
			res = true;
		}
		return res;
	}
	
	/**
	 * Asigna el estado del viaje
	 */
	public void asignarEstado(int estado){
		this.estadoViaje.setId(estado);
	}
	
	/**
	 * Delega la tarea de persistencia al objeto que implementa el patrón DAO
	 */
	public boolean despachar(){
		boolean res = false;
		if(ViajeDAO.getInstancia().crearViaje(this) != null){
			res = true;
		}
		return res;
	}
	
	/**
	 * Controla que el horario de salida y llegado planeados estén dentro de los determinados
	 * @return boolean 
	 * @param String tipoControlViaje Indica si se está controlando la salida o llegada de un envio
	 */
	public boolean estoyEnDiaYHorarioPactado(String tipoControlViaje){
		Date fechaActual= new Date();
		if(tipoControlViaje.equalsIgnoreCase(Constantes.tipo_control_viaje_salida)){
			if(this.getFechaSalida().after(fechaActual)){
				System.out.println("El viaje planificado con fecha de salida: " + this.getFechaSalida() + " está demorado");
			}
		}else{
			if(this.getFechaLlegada().after(fechaActual)){
				System.out.println("El viaje planificado con fecha de llegada: " + this.getFechaLlegada() + " está demorado");
			}
		}
		return true;
	}
	
	/**
	 * Envia un mensaje con una frecuencia de 5 minutos con formato XML con los datos:
	 * - nro de vehiculo
	 * - fecha y hora
	 * - coordenadas de posicion del vehiculo realizando el viaje
	 * El mensaje devuelto se utiliza para informar a los clientes el estado de su envio en cada
	 * momento y controlar que el vehiculo no se salió de la ruta planeada
	 * @return
	 */
	public void enviarMensaje(){
    	final int nroVehiculo			= this.getVehiculoDesignado().getId();
		final Date fecha				= new Date();
		final String latitud			= this.getLatitud();
		final String longitud			= this.getLongitud();

		Timer t = new Timer();
		t.schedule(new TimerTask() {
		    @Override
		    public void run() {
				new GenerarArchivoXML(nroVehiculo,
									  fecha,
									  latitud,
									  longitud);
		    }
		}, 0, Constantes.tiempo_delay_envio_mje_xml);
	}
	
	/**
	 * Asigna al viaje el mejor camino para llegar a cada sucursal destino
	 * @return List<Ruta> listado de rutas con mejor rendimiento en tiempo y gastos
	 */
	/*
	public List<Ruta> determinarMejorCamino(){
		List<Ruta> rutas = new ArrayList<Ruta>();
		
		//Contiene un mapa de rutas hacia las demás sucursales (adyacentes)
		Sucursal sucursalOrigen = this.getSucursalOrigen();
		rutas = sucursalOrigen.getRutas();
	
		//Calculamos la mejor ruta a pasar por cada sucursal (queremos minimizar el tiempo y gasto)
		List<Sucursal> sucursalesDestino = this.getSucursalesDestino();
		
		//Aplicamos algoritmo de caminos minimos
		List<Sucursal> sucursales				= new ArrayList<Sucursal>();
		int distanciaEntreSucursales[] 			= new int[sucursales.size()];
		boolean sucursalVisitada[]				= new boolean[sucursales.size()];
		int sucursalPrevia[]					= new int[sucursales.size()];
		Sucursal sucursalActual					= new Sucursal();
		PriorityQueue<Sucursal> colaDePriSuc 	= new PriorityQueue<Sucursal>(); 
		
		//Inicializo componentes
		for(Sucursal sucursal:sucursales){
			distanciaEntreSucursales[sucursal.getId()] 	= (int) Double.POSITIVE_INFINITY;
			sucursalVisitada[sucursal.getId()]			= false;
			sucursalPrevia[sucursal.getId()]			= -1;
		}
		
		//Partiendo de la sucursal origen, su distancia es 0 por estar en el mismo lugar
		colaDePriSuc.offer(sucursalOrigen);
		distanciaEntreSucursales[sucursalOrigen.getId()] = 0;
		
		//Recorremos la cola de prioridad de sucursales
		while(!colaDePriSuc.isEmpty()){
			
			//Obtenemos la primer sucursal del tope
			sucursalActual = colaDePriSuc.peek();
			
			//Eliminamos la primer sucursal del tope
			colaDePriSuc.remove();
			
			//Si la sucursal ya fué visitada, no la evalúo, continuo con el resto del listado
			if(sucursalVisitada[sucursalActual.getId()]){
				continue;
			}
			
			//Como el tope es la sucursal origen, la marcamos como visitada
			sucursalVisitada[sucursalActual.getId()] = true;
			
			//Se evaluan las sucursales adyacentes, en éste caso se evaluan las rutas de la sucursal origen 
			Sucursal sucursalAdyacente;
			Float costoViaje;
			int duracionViaje;
			
			//Por cada ruta hacia una sucursal adyacente
			for(Ruta r:rutas){
				sucursalAdyacente 	= r.getSucursalDestino();
				costoViaje 			= r.getCostoViaje();
				duracionViaje		= r.getDuracionViaje();
			
				//Verificamos si la sucursal no fué visitada aún
				if(!sucursalVisitada[sucursalAdyacente.getId()]){
					if(distanciaEntreSucursales[sucursalActual.getId()] + costoViaje < distanciaEntreSucursales[sucursalAdyacente.getId()]){
						distanciaEntreSucursales[sucursalAdyacente.getId()] = (int) (distanciaEntreSucursales[sucursalActual.getId()] + costoViaje);
						sucursalPrevia[sucursalAdyacente.getId()] 			= sucursalActual.getId(); 
						colaDePriSuc.add(sucursalAdyacente);
					}
				}
			
			}
		}	
		
		return rutas;
	}
	*/

	
}

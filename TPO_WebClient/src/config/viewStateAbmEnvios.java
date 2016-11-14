package config;

public class viewStateAbmEnvios {

	 
		private String divParticularDisplay;
	    private String divSeleccionClienteDisplay;
		private String ctlSearchClienteDisplay;
		private String ctlNewClienteDisplay;
		private String divBuscarClienteParticularDisplay;
		private String divNuevoClienteParticularDisplay;
		private String ctlClienteEnvioDisplay;
		private String divCargasParticularDisplay;
		private String ctlCargasDisplay;
		private String divDestinatarioDisplay;
		private String ctlDestinatarioEnvioDisplay;
		private String divGuardarDisplay;
		private String error;
	
     
	    public String getDivParticularDisplay() {
			return divParticularDisplay;
		}
		public String getDivSeleccionClienteDisplay() {
			return divSeleccionClienteDisplay;
		}
		public String getCtlSearchClienteDisplay() {
			return ctlSearchClienteDisplay;
		}
		public String getCtlNewClienteDisplay() {
			return ctlNewClienteDisplay;
		}
		public String getDivBuscarClienteParticularDisplay() {
			return divBuscarClienteParticularDisplay;
		}
		public String getDivNuevoClienteParticularDisplay() {
			return divNuevoClienteParticularDisplay;
		}
		public String getCtlClienteEnvioDisplay() {
			return ctlClienteEnvioDisplay;
		}
		public String getDivCargasParticularDisplay() {
			return divCargasParticularDisplay;
		}
		public String getCtlCargasDisplay() {
			return ctlCargasDisplay;
		}
		public String getDivDestinatarioDisplay() {
			return divDestinatarioDisplay;
		}
		public String getCtlDestinatarioEnvioDisplay() {
			return ctlDestinatarioEnvioDisplay;
		}
		public String getDivGuardarDisplay() {
			return divGuardarDisplay;
		}
		public String getError() {
			return error;
		}
		public String getErrorDisplay() {
			return errorDisplay;
		}

		private String errorDisplay;
		
		public viewStateAbmEnvios(String divParticularDisplay, String divSeleccionClienteDisplay,
				String ctlSearchClienteDisplay, String ctlNewClienteDisplay, String divBuscarClienteParticularDisplay,
				String divNuevoClienteParticularDisplay, String ctlClienteEnvioDisplay,
				String divCargasParticularDisplay, String ctlCargasDisplay, String divDestinatarioDisplay,
				String ctlDestinatarioEnvioDisplay, String divGuardarDisplay, String errorDisplay, String error) {
			super();
			this.divParticularDisplay = divParticularDisplay;
			this.divSeleccionClienteDisplay = divSeleccionClienteDisplay;
			this.ctlSearchClienteDisplay = ctlSearchClienteDisplay;
			this.ctlNewClienteDisplay = ctlNewClienteDisplay;
			this.divBuscarClienteParticularDisplay = divBuscarClienteParticularDisplay;
			this.divNuevoClienteParticularDisplay = divNuevoClienteParticularDisplay;
			this.ctlClienteEnvioDisplay = ctlClienteEnvioDisplay;
			this.divCargasParticularDisplay = divCargasParticularDisplay;
			this.ctlCargasDisplay = ctlCargasDisplay;
			this.divDestinatarioDisplay = divDestinatarioDisplay;
			this.ctlDestinatarioEnvioDisplay = ctlDestinatarioEnvioDisplay;
			this.divGuardarDisplay = divGuardarDisplay;
			this.errorDisplay = errorDisplay;
			this.error = error;
		}	
}

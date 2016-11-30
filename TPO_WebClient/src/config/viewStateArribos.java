package config;

public class viewStateArribos {

	 
		private String divFiltroArribos;
	    private String divGrillaArribos;
		private String divErrorArribos;
		private String error;
		
		public String getDivFiltroArribos() {
			return divFiltroArribos;
		}
		public void setDivFiltroArribos(String divFiltroArribos) {
			this.divFiltroArribos = divFiltroArribos;
		}
		public String getDivGrillaArribos() {
			return divGrillaArribos;
		}
		public void setDivGrillaArribos(String divGrillaArribos) {
			this.divGrillaArribos = divGrillaArribos;
		}
		public String getDivErrorArribos() {
			return divErrorArribos;
		}
		public void setDivErrorArribos(String divErrorArribos) {
			this.divErrorArribos = divErrorArribos;
		}
		public String getError() {
			return error;
		}
		public void setError(String error) {
			this.error = error;
		}
		
		public viewStateArribos(String divFiltroArribos, String divGrillaArribos, String divErrorArribos,
				String error) {
			super();
			this.divFiltroArribos = divFiltroArribos;
			this.divGrillaArribos = divGrillaArribos;
			this.divErrorArribos = divErrorArribos;
			this.error = error;
		}   
}

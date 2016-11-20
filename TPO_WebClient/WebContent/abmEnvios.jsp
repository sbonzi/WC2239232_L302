<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import= "dto.ParticularDTO"%>
<%@ page import= "dto.CargaDTO"%>
<%@ page import= "java.util.List"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page import= "config.viewStateAbmEnvios"%>
<%@ page import= "java.util.Iterator"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema de gestión de envios | ENVIOS</title>
    <script type="text/javascript">
        function mostrarDivParticular() {
            divParticular.style.display = "";
            divSeleccionCliente.style.display = "none";
        }
        function nuevoCliente() {
        	ctlSearchCliente.style.display = "none";
            ctlNewCliente.style.display = "";
            divBuscarClienteParticular.style.display = "";
            divNuevoClienteParticular.style.display = "none";
            msgErrorCtlClienteParticular.innerHtml="";
            msgErrorCtlClienteParticular.style.display = "none";
            
        }
        function buscarCliente() {
        	ctlSearchCliente.style.display = "";
            ctlNewCliente.style.display = "none";
            divBuscarClienteParticular.style.display = "none";
            divNuevoClienteParticular.style.display = "";
            msgErrorCtlClienteParticular.innerHtml="";
            msgErrorCtlClienteParticular.style.display = "none";
        }
         function setCliente() {
        	ctlClienteEnvio.style.display = "";
            ctlNewCliente.style.display = "none";
            ctlSearchCliente.style.display = "none";
            divBuscarClienteParticular.style.display = "none";
            divNuevoClienteParticular.style.display = "none";
            divCargasParticular.style.display = "";
        }
        function setCarga() {
        	ctlCargas.style.display = "";
        	divDestinatario.style.display = "";
        }
        function setDestinatario()
        {
        	ctlDestinatarioEnvio.style.display = "";
        	divGuardar.style.display = "";
        }
        function setEnvio()
        {
        	alert("ENVIO CARGADO");
        }
    </script>
	<link rel="stylesheet" type="text/css" href="css/pages.css">
	<link rel="stylesheet" type="text/css" href="css/menu.css">
	<link rel="stylesheet" type="text/css" href="css/grids.css">
</head>
<body>
	<ul>
	  <li><a href="home.jsp">Home</a></li>
	  <li><a class="active" href="abmEnvios.jsp">ABM Envio</a></li>
	  <li><a href="abmCliente.html">ABM Cliente</a></li>
	  <li><a href="abmVehiculo.html">ABM Vehìculo</a></li>
	  <li><a href="abmSucursal.html">ABM Sucursal</a></li>
	  <li style="float:right"><a class="active" href="login?action=out" method=GET>Exit</a></li>
	</ul>
	<% viewStateAbmEnvios viewState = (viewStateAbmEnvios)request.getAttribute("viewState");
		if (viewState == null)
		{
			 viewState = new viewStateAbmEnvios("none",	 //divParticular
						"",  //divSeleccionCliente
						"",  //ctlSearchCliente
					"none",  //ctlNewCliente
					"none",  //divBuscarClienteParticular
						"",  //divNuevoClienteParticular
					"none",  //ctlClienteEnvio
					"none",  //divCargasParticular
					"none",  //ctlCargas
					"none",  //divDestinatario
					"none",  //ctlDestinatarioEnvio
					"none", //divGuardar
					"none", //errorDisplay
					""); //error
		}
	%>
	<div class="control-page" id="divSeleccionCliente" style="display:<%=viewState.getDivSeleccionClienteDisplay()%>">
	    <div class="control-form">
	    	<form class="login-form" id="formSeleccionCliente">
	    		<p class="boxTitle">Tipo de Cliente</p>
	     		<input id="btnEmpresa" type="button" style="cursor: pointer" value="Empresa" />
	            <input id="btnParticular" type="button" style="cursor: pointer" value="Particular" onclick="mostrarDivParticular();"/>
	        </form>
	    </div>
    </div>
    <div class="normal-page">
	    <div id="divParticular" style="display:<%=viewState.getDivParticularDisplay()%>">
	    		<table style="width: 100%">
	    			<tr>
		    			<td>
		    				<div>
				    			<form class="normal-form">
				    				<table style="width:100%">
						    			<tr>
						    				<td colspan="3">
						    					<p class="boxTitle">Solicitud de envío para un cliente particular</p>
						    				</td>
						    				<td style="float:right">
						    					<div id="divNuevoClienteParticular" style="display:<%=viewState.getDivNuevoClienteParticularDisplay()%>">
						    						<input id="btnNuevoClienteParticular" style="cursor: pointer" type="button" value="Nuevo Cliente" onclick='nuevoCliente();' />
						    					</div>
						    					<div id="divBuscarClienteParticular" style="display:<%=viewState.getDivBuscarClienteParticularDisplay()%>">
						    						<input id="btnBuscarClienteParticular" style="cursor: pointer" type="button" value="Buscar Cliente" onclick='buscarCliente();' />
						    					</div>
						   					</td>
						   				</tr>
					   				</table>
				   				</form>
			   				</div>
		   				</td>
	    			</tr>
	    			<tr id="ctlSearchCliente" style="display:<%=viewState.getCtlSearchClienteDisplay()%>">
	    				<td>
	    					<div>
			    				<form class="normal-form">
				    				<table style="width:100%">
					    				<tr>
						    				<td>
						    					<p class="formLabel">DNI</p>
						    				</td>
						    				<td>
						    					<input name="action" type="hidden" width="400px" value="searchClienteParticularById"/>
						    					<input name="txtDNI" type="number" width="400px"/>
						   					</td>
						    				<td align="right">
						    					<input type="submit" style="cursor: pointer" formaction="abmEnvios" value="Buscar">
						   					</td>
						   					<td>&nbsp;</td>
					   					</tr>
				   					</table>
			   					</form>
		   					</div>
	   					</td>
	    			</tr>
	    			<tr id="ctlNewCliente" style="display:<%=viewState.getCtlNewClienteDisplay()%>">
	    				<td>
	    					<div>
			    				<form class="normal-form">
				    				<table style="width:100%">
					    				<tr>
						    				<%
											ParticularDTO c = (ParticularDTO)request.getAttribute("clienteById");
											if (c == null)
												c = new ParticularDTO();	
											
											request.setAttribute("clienteById", c);
											%>
						    				<td>
						    					<p class="formLabel">DNI</p>
						    					<p class="formLabel">NOMBRE</p>
						    					<p class="formLabel">APELLIDO</p>
						    					<p class="formLabel">DOMICILIO</p>
						    				</td>
						    				<td>
						    					<input name="action" type="hidden" width="400px" value="saveClienteParticular"/>
						    					<input name="newDNI" maxlength="8" type="number" width="400px"/>
						    					<br>
						    					<input name="newNombre" type="text" width="400px"/>
						    					<br>
						    					<input name="newApellido" type="text" width="400px"/>
						    					<br>
						    					<input name="newDomicilio" type="text" width="400px"/>
						   					</td>
						    				<td style="vertical-align: bottom;" align="right">
						    					<input type="submit" style="cursor: pointer" formaction="abmEnvios" value="Guardar" onclick="validateNewCliente();">
						   					</td>
						   					<td>&nbsp;</td>
	   									</tr>
				   					</table>
			   					</form>
		   					</div>
	   					</td>
	    			</tr>
	    			<tr><td style="width:100% "><label id="msgErrorCtlClienteParticular" class="message" style="display:<%=viewState.getErrorDisplay()%>"><%=viewState.getError()%></label></td></tr>
	    			<tr id="ctlClienteEnvio" style="display:<%=viewState.getCtlClienteEnvioDisplay()%>">
	    				<td>
	    					<table class="grid-table">
		    					<thead>
							    	<tr>
							    		<th scope="col"><%=c.getNumDoc()%></th>
							    		<th scope="col"><%=c.getNombre()%></th>
							    		<th scope="col"><%=c.getDomicilio()%></th>
						    		</tr>
					    		</thead>
	    					</table>
	    				</td>
	    			</tr>
	    	</table>
	    </div>
	    <div id="divCargasParticular" style="display:<%=viewState.getDivCargasParticularDisplay()%>">
	    	<form class="normal-form">
	    		<table style="width: 100%">
	    			<tr>
	    				<td>
	    					<p class="boxTitle">CARGAS</p>
	    					<input name="action" type="hidden" width="400px" value="addCargaParticular"/>
	    				</td>
	    			</tr>
	    			<tr id="ctlNewCarga">
	    				<td>
	    					<table>
	    						<tr>
	    							<td><p class="formLabel" style="width: 170px">ALTO(Cm)</p></td>
	    							<td><input name="txtNewAlto" type="number" width="70px"/></td>
	    							<td><p class="formLabel" style="width: 200px">APILABLE</p></td>
	    							<td><input name="txtNewApilable" type="checkbox"/></td>
	    							<td><p class="formLabel">QUIMICO TOXICO</p></td>
	    							<td><input name="txtNewQuimicoToxico" type="checkbox" width="400px"/></td>
	    						</tr>
	    						<tr>
	    							<td><p class="formLabel" style="width: 170px">ANCHO (Cm)</p></td>
	    							<td><input name="txtNewAncho" type="number" width="70px"/></td>
	    							<td><p class="formLabel" style="width: 200px">MAX APILABLE (Kg)</p></td>
	    							<td><input name="txtNewMaxApilable" type="number" width="100px"/></td>
	    							<td><p class="formLabel">INFLAMABLE</p></td>
	    							<td><input name="txtNewInflamable" type="checkbox" width="400px"/></td>
	    						</tr>
	    						<tr>
	    							<td><p class="formLabel" style="width: 170px">PROFUNDIDAD (Cm)</p></td>
	    							<td><input name="txtNewProfundidad" type="number" width="70px"/></td>
	    							<td><p class="formLabel" style="width: 200px">A GRANEL</p></td>
	    							<td><input name="txtNewAgranel" type="checkbox"/></td>
	    							<td><p class="formLabel">NOTA MANIP</p></td>
	    							<td><input name="txtNewNotaManip" type="text" width="400px"/></td>
	    						</tr>
	    						<tr>
	    							<td><p class="formLabel" style="width: 170px">VOLUMEN (mL)</p></td>
	    							<td><input name="txtNewVolumen" type="number" width="70px"/></td>
	    							<td><p class="formLabel" style="width: 200px">REFRIGERADO</p></td>
	    							<td><input name="txtNewRefrigerado" type="checkbox"/></td>
	    							<td><p class="formLabel">TIPO</p></td>
	    							<td><input name="txtNewTipo" type="text" width="400px"/></td>
	    						</tr>
	    						<tr>
	    							<td><p class="formLabel" style="width: 170px">PESO (Kg)</p></td>
	    							<td><input name="txtNewPeso" type="number" width="70px"/></td>
	    							<td><p class="formLabel" style="width: 200px">TEMP. REFRIGERADO (°C)</p></td>
	    							<td><input name="txtNewTempRefrigerado" type="number" width="100px"/></td>
	    							<td colspan="2"  style="vertical-align: bottom;" align="right">
	    								<input type="submit" style="cursor: pointer" formaction="abmEnvios" value="Agregar Carga">
	    							</td>
	    						</tr>
	  						</table>
	   					</td>
	    			</tr>
	    			<tr><td style="width:100% "><label id="msgErrorCtlAddCarga" class="message" style="display:<%=viewState.getErrorDisplay()%>"><%=viewState.getError()%></label></td></tr>
	    			<%
	    			List<CargaDTO> cargasAgregadas = (List<CargaDTO>)request.getAttribute("cargasAgregadas");
	    								
					if (cargasAgregadas == null)
						cargasAgregadas = new ArrayList<CargaDTO>();
					
					request. setAttribute("cargasAgregadas",cargasAgregadas);
					
					%>
	    			<tr id="ctlCargas" style="display:<%=viewState.getCtlCargasDisplay()%>">
	    				<td colspan="2">
	    					<table class="grid-table">
		    					<thead>
							    	<tr>
							    		<th scope="col">ALTO</th>
							    		<th scope="col">ANCHO</th>
							    		<th scope="col">PROFUNDIDAD</th>
							    		<th scope="col">VOLUMEN</th>
							    		<th scope="col">PESO</th>
							    		<th scope="col">APILABLE</th>
							    		<th scope="col">MAX AP.</th>
							    		<th scope="col">A GRANEL</th>
							    		<th scope="col">REFRIGERADO</th>
							    		<th scope="col">TEMP REF.</th>
							    		<th scope="col">QUIM/TOX</th>
							    		<th scope="col">INFLAMABLE</th>
							    		<th scope="col">TIPO</th>
							    		<th scope="col">NOTA MANIP</th>
						    		</tr>
					    		</thead>
					    		<tfoot>
					    			<tr>
					    				<th scope="row">Total</th>
					    				<td colspan="4"><%=cargasAgregadas.size() + " Cargas"%></td>
					   				</tr>
					 			</tfoot>
					 			<tbody>
					 				<%
					 				CargaDTO aux;
					 				for(Iterator<CargaDTO> i = cargasAgregadas.iterator(); i.hasNext();)
					 				{
					 					aux = i.next();
									%>
					 				<tr>
					 					<td><%=aux.getAlto().toString()%></td>
					 					<td><%=aux.getAncho().toString()%></td>
					 					<td><%=aux.getProfundidad().toString()%></td>
					 					<td><%=aux.getVolumen().toString()%></td>
							    		<td><%=aux.getPeso().toString()%></td>
							    		<td><%=aux.isApilable()%></td>
							    		<td><%=aux.getMaximoApilable()%></td>
							    		<td><%=aux.isCargaAGranel()%></td>
							    		<td><%=aux.isRefrigerado()%></td>
							    		<td><%=aux.getTempRefrigerado()%></td>
							    		<td><%=aux.isEsQuimicoToxico()%></td>
							    		<td><%=aux.isEsInflamable()%></td>
							    		<td><%=aux.getTipo().toString()%></td>
							    		<td><%=aux.getNotasManipulacion().toString()%></td>
					 				</tr>
					 				<% } %>
								</tbody>
	    					</table>
	    				</td>
	    			</tr>
	    		</table>
	    	</form>
	    </div>
	    <div id="divDestinatario" style="display:<%=viewState.getDivDestinatarioDisplay()%>">
	    	<form class="normal-form">
	    		<table style="width: 100%">
	    			<tr>
	    				<td>
	    					<p class="boxTitle">DESTINATARIO</p>
	    					<input name="action" type="hidden" width="400px" value="addDestinatarioParticular"/>
	    				</td>
	    			</tr>
	    			<tr id="ctlNewCarga">
	    				<td>
	    					<table>
	    						<tr>
	    							<td><p class="formLabel" style="width: 170px">NOMBRE</p></td>
	    							<td><input name="txtNewNombreDestinatario" type="text" width="100px"/></td>
	    							<td><p class="formLabel" style="width: 200px">DOMICILIO</p></td>
	    							<td><input name="txtNewDomicilioDestinatario" type="text" width="100px"/></td>
	    							<td><p class="formLabel">COD. POSTAL</p></td>
	    							<td><input name="txtNewCodPostalDestinatario" type="number" width="70px"/></td>
	    						</tr>
	    						<tr>
	    							<td><p class="formLabel" style="width: 170px">PAIS</p></td>
	    							<td><input name="txtNewPaisDestinatario" type="number" width="100px"/></td>
	    							<td><p class="formLabel" style="width: 200px">PROVINCIA</p></td>
	    							<td><input name="txtNewProvinciaDestinatario" type="number" width="100px"/></td>
	    							<td><p class="formLabel">PISO</p></td>
	    							<td><input name="txtNewPisoDestinatario" type="number" width="70px"/></td>
	    						</tr>
	    						<tr>
	    							<td><p class="formLabel" style="width: 170px">DEPARTAMENTO</p></td>
	    							<td><input name="txtNewDtoDestinatario" type="number" width="100px"/></td>
	    							<td><p class="formLabel" style="width: 200px">NRO. DOCUMENTO</p></td>
	    							<td><input name="txtNewNumDocDestinatario" type="number" width="100px"/></td>
	    							<td><p class="formLabel">AUTORIZANTES</p></td>
	    							<td><input name="txtNewAutorizantesDestinatario" type="text" width="400px"/></td>
	    						</tr>
	    						<tr>
	    							<td colspan="6"  style="vertical-align: bottom;" align="right">
	    								<input type="submit" style="cursor: pointer" formaction="abmEnvios" value="Agregar Destinatario">
	    							</td>
	    						</tr>
	  						</table>
	   					</td>
	    			</tr>
	    			<tr id="ctlDestinatarioEnvio" style="display:<%=viewState.getCtlDestinatarioEnvioDisplay()%>; width:100%">
	    				<td>
	    					<table class="grid-table">
		    					<thead>
							    	<tr>
							    		<th scope="col">LARA PEREYRA</th>
							    		<th scope="col">JUAN B JUSTO 4806</th>
							    		<th scope="col">1882</th>
							    		<th scope="col">ARGENTINA</th>
							    		<th scope="col">BUENOS AIRES</th>
							    		<th scope="col">-</th>
							    		<th scope="col">-</th>
							    		<th scope="col">35942387</th>
							    		<th scope="col">LUIS PEREYRA</th>
						    		</tr>
					    		</thead>
	    					</table>
	    				</td>
	    			</tr>
    			</table>
	    	</form>
	    </div>
	    <div id="divGuardar"  style="display:<%=viewState.getDivGuardarDisplay()%>">
		    <table class="grid-table">
		    	<tr>
		    		<td style="vertical-align: bottom;" align="right">
		    			<!-- <input id="btnGuardarClienteParticular" style="cursor: pointer" type="button" value="Guardar" onclick="AbmEnvio?action=saveClienteParticular" method="POST"/> -->
		    			<input id="btnGuardarEnvio" style="cursor: pointer" type="button" value="CONFIRMAR ENVIO" onclick="setEnvio();"/>
		   			</td>
		   		</tr>
			</table>
	    </div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import= "dto.ParticularDTO"%>
<%@ page import= "dto.CargaDTO"%>
<%@ page import= "dto.SucursalDTO"%>
<%@ page import= "dto.DestinatarioDTO"%>
<%@ page import= "dto.ProvinciaDTO"%>
<%@ page import= "dto.PaisDTO"%>
<%@ page import= "java.util.List"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page import= "config.viewStateAbmEnvios"%>
<%@ page import= "businessDelegate.BusinessDelegate"%>
<%@ page import= "exceptions.SucursalException"%>
<%@ page import= "exceptions.PaisException"%>
<%@ page import= "exceptions.ProvinciaException"%>
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
    </script>
	<link rel="stylesheet" type="text/css" href="css/pages.css">
	<link rel="stylesheet" type="text/css" href="css/menu.css">
	<link rel="stylesheet" type="text/css" href="css/grids.css">
</head>
<body>
	<ul>
	  <li><a href="home.jsp">Home</a></li>
	  <li><a class="active" href="abmEnvios.jsp">ABM Envio</a></li>
	  <li><a href="arribos.jsp">Arribos</a></li>
	  <li style="float:right"><a class="active" href="login?action=out" method=GET>Exit</a></li>
	</ul>
	<% 
		
		if(request.getSession() == null || request.getSession().getAttribute("usuario") == null)
			response.sendRedirect("/TPO_WebClient/login.jsp");		
	
		viewStateAbmEnvios viewState = (viewStateAbmEnvios)request.getAttribute("viewState");
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
					"none",
					"none", //errorDisplay
					""); //error
		}
		
		 if(request.getSession().getAttribute("sucursales")==null)
	        {
	        	List<SucursalDTO> sucursales = new ArrayList<SucursalDTO>();
				try 
				{
					sucursales = new BusinessDelegate().getBusinessService().getSucursales();
					request.getSession().setAttribute("sucursales", sucursales);
					request.setAttribute("sucursales", sucursales);
				} 
				catch (SucursalException e) 
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
							"none",
	 	    				"", //divErrorArribos
	 	    				"HA OCURRIDO UN ERROR AL OBTENER LAS SUCURSALES"); //error
				}
	        }
	        else
	        {
	        	request.setAttribute("sucursales", request.getSession().getAttribute("sucursales"));
	        }
		 
		 List<PaisDTO> paises = new ArrayList<PaisDTO>();
		 
		 if(request.getSession().getAttribute("paises")==null)
	        {
				try 
				{
					paises = new BusinessDelegate().getBusinessService().getPaises();
					request.getSession().setAttribute("paises", paises);
					request.setAttribute("paises", paises);
				} 
				catch (PaisException e) 
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
							"none",
	 	    				"", //divErrorArribos
	 	    				"HA OCURRIDO UN ERROR AL OBTENER LOS PAISES"); //error
				}
	        }
	        else
	        {
	        	request.setAttribute("paises", request.getSession().getAttribute("paises"));
	        }
		 
		 if(request.getSession().getAttribute("provincias")==null && paises.size() > 0)
	        {
	        	List<ProvinciaDTO> provincias = new ArrayList<ProvinciaDTO>();
				try 
				{
					provincias = new BusinessDelegate().getBusinessService().getProvincias(paises.get(0));
					request.getSession().setAttribute("provincias", provincias);
					request.setAttribute("provincias", provincias);
				} 
				catch (ProvinciaException e) 
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
							"none",
	 	    				"", //divErrorArribos
	 	    				"HA OCURRIDO UN ERROR AL OBTENER LAS PROVINCIAS"); //error
				}
	        }
	        else
	        {
	        	request.setAttribute("provincias", request.getSession().getAttribute("provincias"));
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
	    							<td>
	    								<input name="txtNewPaisDestinatario" type="number" width="100px"/>
				    					<select name="cmbPAIS">
				    					<option value="0" selected>(please select:)</option>
				    					<%
											List<PaisDTO> p = (List<PaisDTO>)request.getAttribute("paises");
											if(p != null)
											{
								 				for(PaisDTO pais: p)
								 				{
										%>
											<option value="<%=pais.getId()%>"><%=pais.getDescripcion()%></option>
										<%
												}
											}
										%>
										</select>
	    							</td>
	    							<td><p class="formLabel" style="width: 200px">PROVINCIA</p></td>
	    							<td>
	    								<input name="txtNewProvinciaDestinatario" type="number" width="100px"/>
				    					<select name="cmbPAIS">
				    					<option value="0" selected>(please select:)</option>
				    					<%
											List<ProvinciaDTO> pr = (List<ProvinciaDTO>)request.getAttribute("provincias");
											if(pr != null)
											{
								 				for(ProvinciaDTO provincia: pr)
								 				{
										%>
											<option value="<%=provincia.getId()%>"><%=provincia.getDescripcion()%></option>
										<%
												}
											}
										%>
										</select>
	    							</td>
	    							<td><p class="formLabel">PISO</p></td>
	    							<td><input name="txtNewPisoDestinatario" type="number" width="70px"/></td>
	    						</tr>
	    						<tr>
	    							<td><p class="formLabel" style="width: 170px">DEPARTAMENTO</p></td>
	    							<td><input name="txtNewDtoDestinatario" type="number" width="100px"/></td>
	    							<td><p class="formLabel" style="width: 200px">NRO. DOCUMENTO</p></td>
	    							<td><input name="txtNewNumDocDestinatario" maxlength="8" type="number" width="100px"/></td>
	    							<td><p class="formLabel">AUTORIZANTES</p></td>
	    							<td><input name="txtNewAutorizantesDestinatario" type="text" width="400px"/></td>
	    						</tr>
	    						<tr>
	    							<td><p class="formLabel" style="width: 170px">SUCURSAL DESTINO</p></td>
	    							<td>
	    								<input name="txtSucursalDestino" type="number" width="100px"/>
				    					<select name="cmbSUCDESTINO">
				    					<option value="0" selected>(please select:)</option>
				    					<%
											List<SucursalDTO> s = (List<SucursalDTO>)request.getAttribute("sucursales");
											if(s != null)
											{
								 				for(SucursalDTO sucursal: s)
								 				{
										%>
											<option value="<%=sucursal.getNumero()%>"><%=sucursal.getNombre()%></option>
										<%
												}
											}
										%>
										</select>
	    							</td>
	    							<td colspan="4"  style="vertical-align: bottom;" align="right">
	    								<input type="submit" style="cursor: pointer" formaction="abmEnvios" value="Agregar Destinatario">
	    							</td>
	    						</tr>
	  						</table>
	   					</td>
	    			</tr>
    			</table>
	    	</form>
	    </div>
	    <div id="ctlDestinatarioEnvio" style="display:<%=viewState.getCtlDestinatarioEnvioDisplay()%>">
	    	<table style="width: 100%">
    			<%
					DestinatarioDTO d = (DestinatarioDTO)request.getAttribute("destinatario");
					if (d == null)
					{
						d = new DestinatarioDTO();
						d.setPais(new PaisDTO());
						d.setProvincia(new ProvinciaDTO());
					}
					
					SucursalDTO sles = (SucursalDTO)request.getAttribute("sucDestino");
					if(sles == null)
					{
						sles = new SucursalDTO();
					}
				%>
    			
    			<tr>
    				<td>
    					<table class="grid-table">
	    					<thead>
						    	<tr>
						    		<th scope="col"><%=d.getNombre()%></th>
						    		<th scope="col"><%=d.getDomicilio()%></th>
						    		<th scope="col"><%=d.getCodigoPostal()%></th>
						    		<th scope="col"><%=d.getPais().getDescripcion()%></th>
						    		<th scope="col"><%=d.getProvincia().getDescripcion()%></th>
						    		<th scope="col"><%=d.getPiso()%></th>
						    		<th scope="col"><%=d.getDepartamento()%></th>
						    		<th scope="col"><%=d.getNroDocumento()%></th>
						    		<th scope="col"><%=d.getPersonasAutorizadas()%></th>
						    		<th scope="col"><%="Destino: " + sles.getNombre()%></th>
					    		</tr>
				    		</thead>
    					</table>
    				</td>
    			</tr>
	    	</table>
	    </div>
	    <div id="divGuardar"  style="display:<%=viewState.getDivGuardarDisplay()%>">
	    	<form class="normal-form">
			    <table class="grid-table">
			    	<tr>
			    		<td style="vertical-align: bottom;" align="right">
			    			<input name="action" type="hidden" width="400px" value="saveEnvioParticular"/>
			    			<input type="submit" style="cursor: pointer" formaction="abmEnvios" value="CONFIRMAR ENVIO">
			   			</td>
			   		</tr>
				</table>
			</form>
	    </div>
	    <div id="divFinalizadoParticular"  style="display:<%=viewState.getDivFinalizadoParticularDisplay()%>">
	    	<form class="normal-form">
			    <table class="grid-table">
			    	<tr>
			    		<td style="vertical-align: bottom;" align="right">
			    			<input type="submit" style="cursor: pointer" value="GENERAR OTRO ENVIO" formaction="abmEnvios.jsp">
			    			<input type="submit" style="cursor: pointer" value="SALIR" formaction="home.jsp">
			   			</td>
			   		</tr>
				</table>
			</form>
	    </div>
	</div>
</body>
</html>
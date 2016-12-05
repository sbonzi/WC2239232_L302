<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import= "config.viewStateArribos"%>
<%@ page import= "dto.SucursalDTO"%>
<%@ page import= "dto.VehiculoDTO"%>
<%@ page import= "dto.EstadoEnvioDTO"%>
<%@ page import= "java.util.Iterator"%>
<%@ page import= "java.util.List"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page import= "businessDelegate.BusinessDelegate"%>
<%@ page import= "exceptions.SucursalException"%>
<%@ page import= "exceptions.EstadoEnvioException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehiculos por sucursales</title>
	<link rel="stylesheet" type="text/css" href="css/pages.css">
	<link rel="stylesheet" type="text/css" href="css/menu.css">
	<link rel="stylesheet" type="text/css" href="css/grids.css">
</head>
<body>
	<ul>
	  <li><a href="home.jsp">Home</a></li>
	  <li><a href="abmEnvios.jsp">ABM Envio</a></li>
	  <li><a href="arribos.jsp">Arribos</a></li>
	  <li><a class="active" href="vehiculosPorSucursales.jsp">Vehiculos por sucursales</a></li>
	  <li style="float:right"><a class="active" href="login?action=out" method=GET>Exit</a></li>
	</ul>
		<% 
		
		if(request.getSession() == null || request.getSession().getAttribute("usuario") == null)
			response.sendRedirect("/TPO_WebClient/login.jsp");	
	
		viewStateArribos viewState = (viewStateArribos)request.getAttribute("viewState");
		if (viewState == null)
		{
			 viewState = new viewStateArribos("", //divFiltroArribos
											  "none", //divGrillaArribos
											  "none", //divErrorArribos
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
					viewState = new viewStateArribos("", //divFiltroArribos
							 	    				 "none", //divGrillaArribos
							 	    				 "", //divErrorArribos
							 	    				 "HA OCURRIDO UN ERROR AL OBTENER LAS SUCURSALES"); //error
				}
	        }
	        else
	        {
	        	request.setAttribute("sucursales", request.getSession().getAttribute("sucursales"));
	        }
	%>
	
	<div class="normal-page">
   		<table style="width: 100%">
   			<tr>
    			<td>
    				<form class="normal-form">
   						<p class="boxTitle">Vehiculos por sucursal</p>
   					</form>
   				</td>
   			</tr>
   			<tr id="divFiltroArribos" style="display:<%=viewState.getDivFiltroArribos()%>">
   				<td>
   					<div>
	    				<form class="normal-form">
		    				<table style="width:100%">
			    				<tr>
				    				<td align="left">
				    					<input name="action" type="hidden" width="400px" value="filterVehiculos"/>
				    					<p class="formLabel">SUCURSAL</p>
				    				</td>
				    				<td align="left">
				    					<select name="cmbSUC">
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
				   					<td align="right">
				   						<input type="submit" style="cursor: pointer" formaction="vehiculosPorSucursales" value="FILTRAR">
				   					</td>
			   					</tr>
		   					</table>
	   					</form>
   					</div>
  				</td>
   			</tr>
   			<tr id="divGrillaArribos" style="display:<%=viewState.getDivGrillaArribos()%>">
   				<td>
   					<div>
	    				<form class="normal-form">
		    				<table style="width:100%" class="grid-table">
		    					<thead>
							    	<tr>
							    		<th scope="col">ID VEHICULO</th>
							    		<th scope="col">MARCA</th>
							    		<th scope="col">MODELO</th>
							    		<th scope="col">KILOMETRAJE</th>
							    		<th scope="col">PATENTE</th>
							    		<th scope="col">TARA</th>
							    		<th scope="col">DISPONIBLE</th>
						    		</tr>
					    		</thead>
			    				<%
			    				VehiculoDTO aux;
			    				List<VehiculoDTO> e = (List<VehiculoDTO>)request.getAttribute("vehiculos");
								if(e != null)
								{
					 				for(Iterator<VehiculoDTO> i = e.iterator(); i.hasNext();)
					 				{
					 					aux = i.next();
					 					
					 					String habilitado = (aux.isHabilitadoParaUtilizar() == true)?"SI":"NO";
									%>
									<tr>
					 					<td><%=aux.getNumero()%></td>
					 					<td><%=aux.getMarca()%></td>
					 					<td><%=aux.getModelo()%></td>
					 					<td><%=aux.getKilometraje()%></td>
					 					<td><%=aux.getPatente()%></td>
					 					<td><%=aux.getTara()%></td>
					 					<td><%=habilitado%></td>
					 				</tr>
				    				<% } 
								}%>
		   					</table>
	   					</form>
   					</div>
  				</td>
   			</tr>
   			<tr><td style="width:100% "><label id="msgErrorCtlClienteParticular" class="message" style="display:<%=viewState.getDivErrorArribos()%>"><%=viewState.getError()%></label></td></tr>
    	</table>
	</div>
</body>
</html>
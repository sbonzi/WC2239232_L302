<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import= "config.viewStateArribos"%>
<%@ page import= "dto.SucursalDTO"%>
<%@ page import= "dto.EnvioDTO"%>
<%@ page import= "dto.EstadoEnvioDTO"%>
<%@ page import= "java.util.Iterator"%>
<%@ page import= "java.util.List"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page import= "businessDelegate.BusinessDelegate"%>
<%@ page import= "exceptions.SucursalException"%>
<%@ page import= "exceptions.EstadoEnvioException"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema de gestión de envios | ARRIBOS</title>
	<link rel="stylesheet" type="text/css" href="css/pages.css">
	<link rel="stylesheet" type="text/css" href="css/menu.css">
	<link rel="stylesheet" type="text/css" href="css/grids.css">
</head>
<body>
	<ul>
	  <li><a href="home.jsp">Home</a></li>
	  <li><a href="abmEnvios.jsp">ABM Envio</a></li>
	  <li><a class="active" href="arribos.jsp">Arribos</a></li>
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
		 
		 if(request.getSession().getAttribute("estadosEnvios")==null)
	        {
	        	List<EstadoEnvioDTO> estados = new ArrayList<EstadoEnvioDTO>();
				try 
				{
					estados = new BusinessDelegate().getBusinessService().getEstadosEnvios();
					request.getSession().setAttribute("estadosEnvios", estados);
					request.setAttribute("estadosEnvios", estados);
				} 
				catch (EstadoEnvioException e) 
				{
					viewState = new viewStateArribos("", //divFiltroArribos
	 	    				"none", //divGrillaArribos
	 	    				"", //divErrorArribos
	 	    				"HA OCURRIDO UN ERROR AL OBTENER LOS ESTADOS DE LOS ENVIOS"); //error
				}
	        }
	        else
	        {
	        	request.setAttribute("estadosEnvios", request.getSession().getAttribute("estadosEnvios"));
	        }
	%>
	
	<div class="normal-page">
   		<table style="width: 100%">
   			<tr>
    			<td>
    				<form class="normal-form">
   						<p class="boxTitle">ARRIBOS</p>
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
				    					<input name="action" type="hidden" width="400px" value="filterEnvios"/>
				    					<p class="formLabel">SUCURSAL DESTINO</p>
				    				</td>
				    				<td align="left">
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
				   					<td align="left">
				    					<p class="formLabel">ESTADO ENVIO</p>
				    				</td>
				    				<td align="left">
				    					<select name="cmbESTADO">
				    					<option value="0" selected>(please select:)</option>
				    					<%
											List<EstadoEnvioDTO> es = (List<EstadoEnvioDTO>)request.getAttribute("estadosEnvios");
											if(es != null)
											{
								 				for(EstadoEnvioDTO estado: es)
								 				{
										%>
											<option value="<%=estado.getId()%>"><%=estado.getDescripcion()%></option>
										<%
												}
											}
										%>
										</select>
				   					</td>
				   					<td align="right">
				   						<input type="submit" style="cursor: pointer" formaction="arribos" value="FILTRAR">
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
		    				<table style="width:100%">
			    				<%
								EnvioDTO aux;
			    				List<EnvioDTO> e = (List<EnvioDTO>)request.getAttribute("envios");
								if(e != null)
								{
					 				for(Iterator<EnvioDTO> i = e.iterator(); i.hasNext();)
					 				{
					 					aux = i.next();
									%>
									<tr>
					 					<td><%=aux.getIdEnvio()%></td>
					 					<td><%=aux.getSucursalOrigen().getNombre()%></td>
					 					<td><%=aux.getSucursalDestino().getNombre()%></td>
					 					<td><%=aux.getEstado().getDescripcion()%></td>
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
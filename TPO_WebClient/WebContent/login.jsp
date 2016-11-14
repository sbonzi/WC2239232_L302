<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de gestión de envios | LOGIN</title>
	<link rel="stylesheet" type="text/css" href="css/login.css">
    <script type="text/javascript">
    	$('.message a').click(function(){
   		$('form').animate({height: "toggle", opacity: "toggle"}, "slow");
		});
    </script>
</head>
<body>
<div class="login-page">
  <div class="form">
    <form class="login-form" action="login" method=POST>
      <input type="text" placeholder="name" name="user" value="usuario"/>
      <input type="password" placeholder="password" name="password" value="contraseña"/>
      <button type="submit">login</button>
    </form>
  </div>
</div>
</body>
</html>
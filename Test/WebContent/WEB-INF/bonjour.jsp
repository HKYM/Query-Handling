<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title> Bienvenue à notre plateforme !!</title>
</head>
<body>
	<h2>Veuillez vous connectez !!</h2>
	
	

	<form method="post" action="accueil">
        <p>
			<label for="identifiant">Identifiant : </label>
		
			<input name="identifiant" type="text" />
		</p>
		<p>
			<label for="mp">Mot de passe : </label>
		
			<input name="mp" type="password" />
		</p>
			<input name="Valider" type="submit" value="Se connecter"/>

 
	</form>
</body>
</html>
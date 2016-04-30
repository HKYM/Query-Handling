<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Créer un utilisateur</title>
	<link rel="stylesheet" type="text/css" href="bootstrap.css">
 	<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

	<jsp:include page="header.jsp" />
	
	<div id="content" class='container col-md-8 col-md-offset-2'>
		<form  method="POST" action="addUser">
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="firstName">Prénom:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="firstName" id="firstName">
		    </div>
		  </div>
		  <br>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="lastName">Nom:</label>
		    <div class="col-sm-10"> 
		      <input type="text" class="form-control" id="lastName" name="lastName">
		    </div>
		  </div>
		  <br>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="groups">Groupes:</label>
		    <div class="col-sm-10"> 
		      <input type="text" class="form-control" id="groups" name="groups">
		    </div>
		  </div>
		  <br>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="image">Photo (lien):</label>
		    <div class="col-sm-10"> 
		      <input type="text" class="form-control" id="image" name="image">
		    </div>
		  </div>
		  <br>
		  <div class="form-group"> 
		    <div class="col-sm-offset-2 col-sm-10 center-block">
		      <button type="submit" class="btn btn-lg btn-success center-block">Créer l'utilisateur</button>
		    </div>
		  </div>
		</form>
	</div>
	
	<jsp:include page="footer.jsp" />
	
</body>
</html>
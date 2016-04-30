 <!DOCTYPE html>
 <%@page import="java.util.List"%>
 <%@page import="com.inpt.model.User"%>
<html>
 <head>
 	<title>Tous les utilisateurs</title>
 	<link rel="stylesheet" type="text/css" href="bootstrap.css">
 	<link rel="stylesheet" type="text/css" href="styles.css">
 </head>
 <body>
 	
 	<jsp:include page="header.jsp" />

 	<div id='content' class="container">
		<h2>Liste des utilisateurs</h2>
		<br>
		<a class='btn btn-success' style='margin-bottom:10px;' href='create.jsp'>Créer un nouvel uilisateur</a>
		<div class='row userlist'>
			<div class='col-md-8 col-md-offset-2'>
				<%
				
				List<User> a = (List<User>) request.getAttribute("allusers");
				for(User u : a){
					out.println("<div class='col-md-4 row text-center panel well' style='margin-left:5px;margin-right:5px;'>"+
									"<div class='col-md-12'>"+
										u.getfirstName()+" " + u.getlastName()+
									"</div>"+
									"<div class='col-md-12'>"+
										"<a class='btn btn-primary' style='margin-bottom:10px;' href='edit.jsp?id="+u.getId()+"'>Modifier</a>"+
										"<br>"+
										"<a class='btn btn-danger' href='delete.jsp?id="+u.getId()+"'>Supprimer</a>"+
									"</div>"+
								"</div>");
				}
			
				%>
			</div>
			
			
		</div>
 	</div>

	<jsp:include page="footer.jsp" />

 </body>
 </html>
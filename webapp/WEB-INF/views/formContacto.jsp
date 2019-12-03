<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">    
		<meta name="author" content="">
		<spring:url value="/resources" var="urlPublic" />
		<spring:url value="/peliculas/save" var="urlForm" />
		
		<link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css">
		<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
		<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	</head>

   <body>

      <!-- Fixed navbar -->
      <nav class="navbar navbar-inverse navbar-fixed-top">
         <div class="container">
            <div class="navbar-header">
               <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
               </button>
               <a class="navbar-brand" href="#">My CineSite</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
               <ul class="nav navbar-nav">
                  <li><a href="#">Acerca</a></li>
                  <li><a href="#">Login</a></li>            
               </ul>
            </div><!--/.nav-collapse -->
         </div>
      </nav>

      <div class="container theme-showcase" role="main">

         <h3 class="blog-title text-center"><span class="label label-success">Contacto</span></h3><br>  
		
		
		${contacto}		
         <form:form class="form-horizontal" method="post" modelAttribute="contacto"> <%--contacto es el nombre de la instancia de modelo --%>
            <div class="form-group">
               <label for="nombre" class="col-sm-2 control-label">Nombre</label>
               <div class="col-sm-10">
                  <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" required="required">
               </div>
            </div>
            <div class="form-group">
               <label for="email" class="col-sm-2 control-label">Email</label>
               <div class="col-sm-10">
                  <input type="email" class="form-control" name="email" id="email" placeholder="Email" required="required">
               </div>
            </div>

            <div class="form-group">
               <label for="genero" class="col-sm-2 control-label">G�neros Favoritos</label>
               <div class="col-sm-10">
                  <select id="genero" name="generos" multiple="multiple" class="form-control">
                     <option value="Accion">Accion</option>
                     <option value="Aventura">Aventura </option>
                     <option value="Clasicas">Clasicas</option>                  
                     <option value="Comedia Romantica">Comedia Romantica</option>                  
                     <option value="Drama">Drama</option>                  
                     <option value="Terror">Terror</option>                  
                     <option value="Infantil">Infantil</option>                  
                     <option value="Accion y Aventura">Accion y Aventura</option>                  
                     <option value="Romantica">Romantica</option>                  
                  </select> 
               </div>
            </div>

            <div class="form-group">
               <label class="col-sm-2 control-label">Tu experiencia en el sitio</label>
               <div class="col-sm-10">
                  <label><input type="radio" name="rating" value="1">Muy Mala</label>
                  <label><input type="radio" name="rating" value="2">Mala</label>
                  <label><input type="radio" name="rating" value="3">Regular</label>
                  <label><input type="radio" name="rating" value="4">Buena</label>
                  <label><input type="radio" name="rating" value="5">Muy Buena</label>
               </div>
            </div>

            <div class="form-group">
               <label class="col-sm-2 control-label">Te gustar�a recibir notificaciones de:</label>
               <div class="col-sm-10">
                  <label><input type="checkbox" name="notificaciones" value="Estrenos">Estrenos</label>
                  <label><input type="checkbox" name="notificaciones" value="Promociones">Promociones</label>
                  <label><input type="checkbox" name="notificaciones" value="Noticias" >Noticias</label>
                  <label><input type="checkbox" name="notificaciones" value="Preventas">Preventas</label>
               </div>
            </div>

            <div class="form-group">
               <label class="col-sm-2 control-label">Comentarios:</label>
               <div class="col-sm-10">
                  <textarea class="form-control" name="comentarios" id="comentarios" rows="5"></textarea>
               </div>
            </div>

            <div class="form-group">
               <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-success">Enviar</button>
               </div>
            </div>

         </form:form>

         <hr class="featurette-divider">

         <!-- FOOTER -->
         <footer>        
            <p class="pull-right"><a href="#">Back to top</a></p>
            <p>&copy; 2017 My CineSite, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
         </footer>

      </div> <!-- /container -->

      <!-- Bootstrap core JavaScript
      ================================================== -->
      <!-- Placed at the end of the document so the pages load faster -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
      <script src="bootstrap/js/bootstrap.min.js"></script> 		
   </body>
</html>

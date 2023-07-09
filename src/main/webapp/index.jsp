<!-- 
Document   : index.jsp
	Create on  : 30.05.2023
	Author     : Dolzhenko A.
-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">

<meta charset="UTF-8">

<!-- Настройка viewport -->
 <meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">


<title>Управление персоналом</title>

</head>
<body>
	<div class="container-fluid">
	<jsp:include page="/views/header.jsp" />
	<div class="container">
		<br><br><br>
		 	<div class="list-group text-center py-3 px-3">
				<h2>Функции системы</h2>
				<ul class="list-group list-group-flush">
					<li class="list-group-item list-group-item-primary">
					<a href="/persons/person">Сотрудники1</a>
					<li class="list-group-item list-group-item-info">
					<a href="/demopersons/role">Должности1</a>
				</ul>
		   </div>
		<br><br>
	</div>
	 <jsp:include page="/views/footer.jsp" />
</div>


<!-- jQuery -->
<!--  <script src="js/jquery-3.6.4.js"></script>-->
<!-- Bootstrap JS + Popper JS --> 
<script defer src="js/bootstrap.bundle.min.js"></script> 

<!--  
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
-->

<!-- После подключения jQuery, Popper и Bootstrap JS -->

<!-- 
<script>
    $(function () {
        $('[data-toggle="popover"]').popover({trigger:'hover'});
    });
</script>
 --> 
</body>
</html>

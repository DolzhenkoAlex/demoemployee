<%-- 
	Document   : role.jsp
	Create on  : 30.05.2023
	Author     : Dolzhenko A.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="domain.Role"%>

<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Должности</title>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Roles</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- jQuery -->
<script defer src="js/jquery-3.6.4.js"></script>
<!-- Bootstrap JS + Popper JS -->
<script defer src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="/views/header.jsp" />
		<div class="container-fluid">
			<div class="row justify-content-start ">
				<div class="col-8 border bg-light px-4">
					<h3>Список должностей1</h3>
					<table class="table">
						<thead>
							<th scope="col">Код</th>
							<th scope="col">Должность</th>
							<th scope="col">Редактировать</th>
							<th scope="col">Удалить</th>
						</thead>
						<tbody>
							<c:forEach var="role" items="${roles}">
								<tr>
									<td>${role.getId()}</td>
									<td>${role.getNamerole()}</td>
									<td width="20"><a
										href="<c:url value="/editrole?id=${role.getId()}" />"
										role="button" class="btn btn-outline-primary"> <img
											alt="Редактировать" src="images/icon-edit.png"></a></td>
									<td width="20"><a
										href="<c:url value="/deleterole?id=${role.getId()}" />"
										role="button" class="btn btn-outline-primary"> 
										<img alt="Удалить" src="images/icon-delete.png"
											onclick="return confirm('Удалить должность с кодом: '+${role.getId()}+'?')">
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-4 border px-4">
					<form method="POST" action="">
						<h3>Новая должность</h3>
						<div class="mb-3">
							<br> <label for="inputRole" class="col-sm-3 col-form-label">Должность</label>
							<div class="col-sm-6">
								<input type="text" name="inputRole" class="form-control"
									id="personRole" />
							</div>
						</div>
						<p>
							<br> <br> <br>
							<button type="submit" class="btn btn-primary">Добавить</button>
							<br>
						</p>
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="/views/footer.jsp" />
	</div>

	<!-- Button trigger modal -->
	<br>
	<button type="button" class="btn btn-primary" data-bs-toggle="modal"
		data-bs-target="#deleteModal">Launch demo modal</button>

	<!-- Modal -->
	<div class="modal fade" id="deleteModal" tabindex="-1"
		aria-labelledby="deleteModalLable" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="deleteModalLable">Удаление должности</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">Должность в кодом ${role.getId()} удалить?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Отменить</button>
					<button type="button" class="btn btn-primary">Удалить</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
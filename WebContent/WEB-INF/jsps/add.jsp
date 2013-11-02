<%@ include file="menu.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<form action="Add" method="post">
		<table id="formTable" class="formTable">
			<tr>
				<td>Nimi:</td>
				<td><input id="nameBox" name="name" /></td>
			</tr>
			<tr>
				<td>Kood:</td>
				<td><input id="codeBox" name="code" /></td>
			</tr>
			<tr>
				<td>Ülemüksus:</td>
				<td>
					<select id="superUnitCode" name="superUnitCode">
						<option value="" selected="selected"></option>
						<c:forEach var="each" items="${unitList}">
							<option value="${each.id}">${each.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right" colspan="2"><br /> <input id="addButton"
					type=submit value="Lisa" /></td>
			</tr>
		</table>
	</form>
</body>
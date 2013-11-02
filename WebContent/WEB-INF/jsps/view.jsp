<%@ include file="menu.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<form action="Add" method="post">
		<table id="formTable" class="formTable">
			<tr>
				<td>Nimi:</td>
				<td><input id="nameBox" name="name" value="${unit.name}" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>Kood:</td>
				<td><input id="codeBox" name="code" value="${unit.code}" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>Ülemüksus:</td>
				<td><select id="superUnitCode" name="superUnitCode" disabled="disabled">
						<option value="${superUnitCode}">${superUnitName}</option>
				</select></td>
			</tr>
 			<tr>
				<td>Alamüksused:</td>
				<td>
					<c:forEach items="${subUnits}" var="each">
						<span id="sub_${each}">${each}</span>
					</c:forEach>
				</td>
			</tr>
			<tr> 
				<td align="right" colspan="2">
					<br />
					<a id="backLink" href="Search">Tagasi</a>
				</td>
			</tr>
		</table>
	</form>
</body>

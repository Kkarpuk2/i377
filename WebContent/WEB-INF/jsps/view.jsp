<%@ include file="menu.jsp"%>
<body>
	<form:form action="add" method="post" commandName="viewForm">
		<table id="formTable" class="formTable">
			<tr>
				<td>Nimi:</td>
				<td><form:input id="nameBox" name="name" value="${name}" disabled="${'true'}" path="unit.name"/></td>
			</tr>
			<tr>
				<td>Kood:</td>
				<td><form:input id="codeBox" name="code" value="${code}" disabled="${'true'}" path="unit.code"/></td>
			</tr>
			<tr>
				<td>Ülemüksus:</td>
				<td><form:select id="superUnitCode" name="superUnitCode" disabled="${'true'}" path="superUnitCode">
						<option value="${superUnitCode}">${superUnitName}</option>
				</form:select></td>
			</tr>
 			<tr>
				<td>Alamüksused:</td>
				<td>
					<c:forEach items="${viewForm.subUnitCodes}" var="each">
						<span id="sub_${each}">${each}</span>
					</c:forEach>
				</td>
			</tr>
			<tr> 
				<td align="right" colspan="2">
					<br />
					<a id="backLink" href="search">Tagasi</a>
				</td>
			</tr>
		</table>
	</form:form>
</body>

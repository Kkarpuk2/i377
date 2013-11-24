<%@ include file="menu.jsp"%>
<body>
	<form:form action="search" method="post" commandName="searchForm">
		<form:input id="searchStringBox" value="" name="searchString" path="searchString"/> 
		<input id="filterButton" type="submit" value="Filtreeri" /> 
		<br /><br />
	</form:form>
	<table id="listTable" class="listTable">
		<thead>
			<tr>
				<th scope="col">Nimi</th>
				<th scope="col">Kood</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${searchResults}">
				<tr>
					<td>
						<div id="row_${item.code}">
							<a id="view_${item.code}" href="view/${item.code}">${item.name}</a>
						</div>
					</td>
					<td>
						${item.code}
					</td>
					<td>		
						<a id="delete_${item.code}" href="delete/${item.code}">Kustuta</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
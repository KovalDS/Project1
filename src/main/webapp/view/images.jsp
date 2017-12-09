<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <body>
		<table border = "1">
			<tr>
				<th>Image id</th>
				<th>Hash code</th>
				<th>Type</th>
				<th>Size</th>
				<th>Tag</th>
				<th>Date of creation</th>
				<th>Length</th>
			</tr>
			<c:forEach items = "${allImages}" var = "image">
			<tr>
				<td>${image.id}</td>
				<td>${image.hash}</td>
				<td>${image.type}</td>
				<td>${image.size}</td>
				<td>${image.tag}</td>
				<td>${image.dateOfCreation}</td>
				<td>${image.length}</td>
				<td><input type = "checkbox" ></td>
			</tr>
			</c:forEach>
		</table>
		<input type = "submit" value = "Create slide show" name = "param">
    </body>
</html>

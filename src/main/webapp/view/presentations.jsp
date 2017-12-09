<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <body>
		<table border = "1">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<thImages</th>
			</tr>
			<c:forEach items = "${allPresentations}" var = "presentation">
                <tr>
                    <td>${presentation.id}</td>
                    <td>${presentation.hash}</td>
                    <td>
                        <c:forEach items = "${presentation.images}" var = "image">
                            <div>${image.id}</div>
                            <div>${image.hash}</div>
                        </c:forEach>
                    </td>
                </tr>
			</c:forEach>
		</table>
    </body>
</html>

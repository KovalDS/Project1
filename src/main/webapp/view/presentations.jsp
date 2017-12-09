<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <body>
		<table border = "1">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Images</th>
			</tr>
			<c:forEach items = "${allPresentations}" var = "presentation">
                <tr>
                    <td>${presentation.id}</td>
                    <td>${presentation.hash}</td>
                    <td>
                        <table border = 1>
                        	<tr>
                        		<th>Image id</th>
                        		<th>Image hash</th>
                        	</tr>
                            <c:forEach items = "${presentation.images}" var = "image">
                                <tr>
                                    <td>${image.id}</td>
                                    <td>${image.hash}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                </tr>
			</c:forEach>
		</table>
    </body>
</html>

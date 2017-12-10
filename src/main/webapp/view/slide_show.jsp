<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <body>
        <form form action = "slide_show" method = "GET">
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
                </tr>
                </c:forEach>
            </table>
            <div>${message}</div>
            <input type = "hidden" value = "${presentation.id}" name = "presentation">
            <input type = "submit" value = "Get total size" name = "param">
		</form>
    </body>
</html>

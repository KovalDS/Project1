<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <body>
        <div>${message}</div>
        <form action = "slide_show" method = "GET">
            <input type = "checkbox" name = "sort" value = "Sort by size">
            <input type = "checkbox" name = "sort" value = "Sort by date">
            <input type = "checkbox" name = "sort" value = "Sort by tag">
            <input type = "hidden" name = "param" value = "Show all images">
            <input type = "submit">
        </form>
        <form action = "slide_show" method = "GET">
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
                    <td><input type = "checkbox" name = "images" value = "${image.id}"></td>
                </tr>
                </c:forEach>
            </table>
            <input type = "text" name = "presentation_name" required>
            <input type = "submit" value = "Create slide show" name = "param">
		</form>
    </body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <body>
        <div>${message}</div>
        <form action = "slide_show" method = "GET">
            <div>
                <input type = "radio" name = "sort" value = "Sort by size" id = "size">
                <label for = "size">Sort by size</label>
            </div>
            <div>
                <input type = "radio" name = "sort" value = "Sort by date" id = "date">
                <label for = "date">Sort by date</label>
            </div>
            <div>
                <input type = "radio" name = "sort" value = "Sort by tag" id = "tag">
                <label for = "tag">Sort by tag</label>
            </div>
            <input type = "hidden" name = "param" value = "Show all images">
            <input type = "submit" value = "Sort">
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

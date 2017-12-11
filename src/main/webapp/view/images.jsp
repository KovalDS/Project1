<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <title>Presentation</title>
        <script>
            function setDateRequired() {
                document.getElementById("date_input1").required = true;
                document.getElementById("date_input2").required = true;

                document.getElementById("size_input1").required = false;
                document.getElementById("size_input2").required = false;
                document.getElementById("tag_input").required = false;
            }
            function setSizeRequired() {
                document.getElementById("size_input1").required = true;
                document.getElementById("size_input2").required = true;

                document.getElementById("date_input1").required = false;
                document.getElementById("date_input2").required = false;
                document.getElementById("tag_input").required = false;
            }
            function setTagRequired() {
                document.getElementById("tag_input").required = true;

                document.getElementById("date_input1").required = false;
                document.getElementById("date_input2").required = false;
                document.getElementById("size_input1").required = false;
                document.getElementById("size_input2").required = false;
            }
        </script>
    </head>

    <body>
        <h2>All images</h2>
        <div>${message}</div>
        <form action = "slide_show" method = "GET">
            <div style = "float : left">
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
            </div>
            <div>
                <input type = "radio" name = "search" value = "Find between size" id = "size" onclick = "setSizeRequired()">
                <label for = "size">Find by size</label>
                <input type = "number" name = "lower_bound" id = "size_input1">
                <input type = "number" name = "higher_bound" id = "size_input2">
            </div>
            <div>
                <input type = "radio" name = "search" value = "Find between date" id = "date" onclick = "setDateRequired()">
                <label for = "date">Find by date</label>
                <input type = "date" name = "first_date" id = "date_input1">
                <input type = "date" name = "second_date" id = "date_input2">
            </div>
            <div>
                <input type = "radio" name = "search" value = "Find by tag" id = "tag" onclick = "setTagRequired()">
                <label for = "tag">Find by tag</label>
                <input type = "text" name = "tag" id = "tag_input">
            </div>
            <input type = "hidden" name = "param" value = "Show all images">
            <input type = "submit" value = "Submit">
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

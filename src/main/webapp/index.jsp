<html>
    <body>
		<form action = "slide_show" method = "GET">
			<input type = "submit" value = "Create Slide Show" name = "param">
			<input type = "submit" value = "Show Presentation" name = "param">
			
		</form>
		
		<form action = "slide_show" method = "GET">
			<div>
				<input type = "date" name = "first_date">
				<input type = "date" name = "second_date">
				<input type = "submit" value = "Find by date" name = "param">
			</div>
		</form>
		<form action = "slide_show" method = "GET">
			<div>
				<input type = "number" name = "lower_bound">
				<input type = "number" name = "higher_bound">
				<input type = "submit" value = "Find by size" name = "param">
			</div>
		</form>
		<form action = "slide_show" method = "GET">
			<div>
				<input type = "text" name = "tag">
				<input type = "submit" value = "Find by tag" name = "param">
			</div>
		</form>
		<form action = "slide_show" method = "GET">
			<input type = "submit" value = "Sort by date" name = "param">
			<input type = "submit" value = "Sort by size" name = "param">
			<input type = "submit" value = "Sort by tag" name = "param">
		</form>
		${message}
    </body>
</html>

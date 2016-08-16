<html>
<head>
<title>redis demo</title>
<style type="text/css">
.div-set {
	float: left;
	max-width: 460px;
	margin: 0;
	padding: 1em;
}
</style>
</head>
<body>
	<header>
		<h2>Spring-Redis Demo</h2>
	</header>

	<div class="div-set">
		<div>
			<p>String</p>
			<form action="string" method="post">
				<input type="text" name="key" placeholder="key"> <input
					type="text" name="value" placeholder="value"> <input
					type="submit" value="Set">
			</form>
		</div>

		<div>
			<p>hash</p>
			<form action="hash" method="post">
				<input type="text" name="key" placeholder="key"> <input
					type="text" name="field" placeholder="field"> <input
					type="text" name="value" placeholder="value"> <input
					type="submit" value="Set">
			</form>
		</div>
	</div>
</body>
</html>

<html>
<head>
<title>redis demo</title>
<style type="text/css">
h2 {
	text-align: center;
}

.div-set {
	float: left;
	max-width: 400px;
	margin: 0;
	padding: 4em;
	border-right: 1px solid gray;
}

.div-get {
	float: left;
	max-width: 400px;
	margin: 0;
	padding: 4em;
}

.div-result {
	float: left;
	margin: 0;
	padding: 5em;
}
</style>
</head>
<body>
	<header>
		<h2>Spring-Redis Demo</h2>
	</header>

	<div class="div-set">
		<h3>Set command</h3>
		<div>
			<p>String</p>
			<form action="string" method="post">
				<ul>
					<li><input type="text" name="key" placeholder="key"></li>
					<li><input type="text" name="value" placeholder="value"></li>
					<li><input type="submit" value="Set"></li>
				</ul>
			</form>
		</div>
		<div>
			<p>hash</p>
			<form action="hash" method="post">
				<ul>
					<li><input type="text" name="key" placeholder="key"></li>
					<li><input type="text" name="field" placeholder="field"></li>
					<li><input type="text" name="value" placeholder="value"></li>
					<li><input type="submit" value="Set"></li>
				</ul>
			</form>
		</div>

		<div>
			<p>Account Object</p>
			<form action="account" method="post">
				<ul>
					<li><input type="text" name="id" placeholder="id"></li>
					<li><input type="text" name="name" placeholder="name"></li>
					<li><input type="password" name="password"
						placeholder="password"></li>
					<li><input type="submit" value="Set"></li>
				</ul>
			</form>
		</div>
		<div>
			<p>[Optional] Account Object (Byte Array)</p>
			<form action="account-byte" method="post">
				<ul>
					<li><input type="text" name="id" placeholder="id"></li>
					<li><input type="text" name="name" placeholder="name"></li>
					<li><input type="password" name="password"
						placeholder="password"></li>
					<li><input type="submit" value="Set"></li>
				</ul>
			</form>
		</div>
	</div>

	<div class="div-get">
		<h3>Get Command</h3>
		<div>
			<p>String</p>
			<form action="string" method="get">
				<ul>
					<li><input type="text" name="key" placeholder="key"></li>
					<li><input type="submit" value="Get"></li>
				</ul>
			</form>
		</div>
		<div>
			<p>hash</p>
			<form action="hash" method="get">
				<ul>
					<li><input type="text" name="key" placeholder="key"></li>
					<li><input type="text" name="field" placeholder="field"></li>
					<li><input type="submit" value="Get"></li>
				</ul>
			</form>
		</div>
		<div>
			<p>Account Object</p>
			<form action="account" method="get">
				<ul>
					<li><input type="text" name="id" placeholder="id"></li>
					<li><input type="submit" value="Get"></li>
				</ul>
			</form>
		</div>

		<div>
			<p>[Optional] Account Object (Byte Array)</p>
			<form action="account-byte" method="get">
				<ul>
					<li><input type="text" name="id" placeholder="id"></li>
					<li><input type="submit" value="Get"></li>
				</ul>
			</form>
		</div>
	</div>

	<div class="div-result">
		<h3>Get Result</h3>
		<h4>${type}</h4>
		<span>${textResult}</span>

	</div>
</body>
</html>

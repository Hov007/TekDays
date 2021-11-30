<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

	<link href='https://fonts.googleapis.com/css?family=Josefin+Sans' rel='stylesheet' type='text/css'>
  		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
		<g:layoutHead/>

	</head>
	<body>
		<div id="grailsLogo" role="banner"><a href="/TekDays/"><asset:image style="height:200px; width: 930px" src="7.png" alt="TekDays"/></a>

		</div>
	<g:loginToggle/>

	<div class="nav-wrapper">
		<div class="sl-nav">

			<ul>
				<li><b>Language:</b> <i class="fa fa-angle-down" aria-hidden="true"></i>
					<div class="triangle"></div>
					<ul>
						<li><i class="sl-flag flag-de"><div></div></i> <span class="active">
							<a href="${createLink(controller: controllerName, action: actionName)}?lang=hy">
								Arm</a>
						</span></li>
						<li><i class="sl-flag flag-usa"><div></div></i> <span>
							<a href="${createLink(controller: controllerName, action: actionName)}?lang=en">
								Eng</a>
						</span></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>

		<g:layoutBody/>

		<div class="footer" role="contentinfo"></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>

	</body>
</html>

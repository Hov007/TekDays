<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>TekDays - The Community is the Conference!</title>
</head>

<body>

<g:organizerEvents/>
<g:volunteerEvents/>
<div id="welcome">
    <br/>

    <h3 id="textTitles">Welcome to TekDays.com</h3>
    <br>

    <div class="container">
        <p>TekDays.com is a site dedicated to assisting individuals and
        communities to organize technology conferences. To bring great
        minds with common interests and passions together for the good
        of greater geekdom!</p>
        <br>
    </div>
</div>
<span class="buttons"></span>
<br>
<div class="homeCell">
    <h3 id="textTitles">Find a Tek Event</h3>
    <br>

    <div class="container">
        <p>See if there's a technical event in the works that strikes your
        fancy. If there is, you can volunteer to help or just let the
        organizers know that you'd be interested in attending.
        Everybody has a role to play.</p>
        <br>
    </div>

    <span class="buttons">
        <g:link controller="tekEvent" action="index"><i class="fa fa-search">Search</i></g:link>
    </span>
    &nbsp;
</div>

<div class="homeCell">
    <h3 id="textTitles">Organize a Tek Event</h3>
    <br>

    <div class="container">
        <p>If you don't see anything that suits your interest and location,
        then why not get the ball rolling. It's easy to get started and
        there may be others out there ready to get behind you to make it
        happen.</p>
        <br>
    </div>

    <span class="buttons">
        <g:link controller="tekEvent" action="create"><i class="fa fa-users" aria-hidden="true">Organize</i></g:link>
    </span>
    &nbsp;
</div>


<div class="homeCell">
    <h3 id="textTitles">Sponsor a Tek Event</h3>
    <br>
    <div class="container">
    <p>If you are part of a business or organization that is involved in
    technology then sponsoring a tek event would be a great way to
    let the community know that you're there and you're involved.</p>
    <br>
    </div>
    <span class="buttons">
        <g:link controller="sponsor" action="create"><i class="fas fa-hand-holding-usd"
                                                        aria-hidden="true">Sponsor</i></g:link>
    </span>
    %{--    &nbsp;--}%
</div>
</body>
</html>
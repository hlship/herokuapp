# Tapestry Heroku App #

This is a basic [Tapestry 5.3](http://tapestry.apache.org) application, a modified version of the standard Tapestry Quickstart archetype, with minor
changes to allow it to deploy onto [Heroku](http://heroku.com). It is based on version **5.3-beta-30**.

The main change is support for the Maven [appassembler-maven-plugin](http://mojo.codehaus.org/appassembler/appassembler-maven-plugin/assemble-mojo.html)
plugin, which executes on Heroku after content is pushed; it obtains all dependencies and builds the shell script that launches the application.

Unlike a traditional servlet application, on Heroku your application is *not* packaged as a WAR and deployed into a
container ... instead, a script is used to launch an embedded version of [Jetty](http://www.eclipse.org/jetty/) to execute 
your application. The Java class used to start Jetty is also part of this project. 
Heroku and the Maven plugin take care of all the details for you.

Deployment requires the Heroku [Cedar stack](http://devcenter.heroku.com/articles/cedar).
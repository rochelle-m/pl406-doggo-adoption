# Dog Adoption and Care

Application where users can view dogs up for adoption/fostering, adopt/foster a dog, post about a dog available for adoption/fostering or write a post (maybe asking for help or really just anything related to dogs). Users can also choose to donate (monetarily/pet products) or volunteer for the adoption home. The application will post details about events like adoption camps. Users can also view the help section regarding locations of pet food stores, vet clinics and other doggo related information.

<br/>
<p align="center">
	<a href="https://svelte.dev/" target="_blank">
		<img src="https://raw.githubusercontent.com/github/explore/42198dc9113595ddd22cc12771bb719c8cf08b67/topics/svelte/svelte.png" width="125">
	</a>
	<a href="https://spring.io/projects/spring-boot" target="_blank">
		<img src="https://raw.githubusercontent.com/github/explore/80688e429a7d4ef2fca1e82350fe8e3517d3494d/topics/spring-boot/spring-boot.png" width="125">
	</a>	
</p>

<center>

[![Build Status](https://github.com/rochelle-m/pl406-doggo-adoption/actions/workflows/maven.yml/badge.svg)](https://github.com/rochelle-m/pl406-doggo-adoption/actions)

![versionjava](https://img.shields.io/badge/jdk-8,_11,_15-006cb8.svg?logo=java)
[![versionspringboot](https://img.shields.io/badge/dynamic/xml?color=6aad3d&url=https://raw.githubusercontent.com/rochelle-m/pl406-doggo-adoption/main/pom.xml&query=%2F%2A%5Blocal-name%28%29%3D%27project%27%5D%2F%2A%5Blocal-name%28%29%3D%27parent%27%5D%2F%2A%5Blocal-name%28%29%3D%27version%27%5D&label=springboot&logo=springboot)](https://github.com/spring-projects/spring-boot)
[![versionnodejs](https://img.shields.io/badge/dynamic/xml?color=3e863d&url=https://raw.githubusercontent.com/rochelle-m/pl406-doggo-adoption/main/pom.xml&query=%2F%2A%5Blocal-name%28%29%3D%27project%27%5D%2F%2A%5Blocal-name%28%29%3D%27build%27%5D%2F%2A%5Blocal-name%28%29%3D%27plugins%27%5D%2F%2A%5Blocal-name%28%29%3D%27plugin%27%5D%2F%2A%5Blocal-name%28%29%3D%27executions%27%5D%2F%2A%5Blocal-name%28%29%3D%27execution%27%5D%2F%2A%5Blocal-name%28%29%3D%27configuration%27%5D%2F%2A%5Blocal-name%28%29%3D%27nodeVersion%27%5D&label=nodejs&logo=node.js)](https://nodejs.org/en/)
[![versionsvelte](https://img.shields.io/badge/dynamic/json?color=f73c00&url=https://raw.githubusercontent.com/rochelle-m/pl406-doggo-adoption/main/client/package.json&query=$.devDependencies.svelte&label=svelte&logo=svelte)](https://svelte.dev/)
[![mongodb](https://img.shields.io/static/v1?label=%20&message=Mongo%20DB%20Atlas&color=b7b19a&logo=mongodb)](https://www.mongodb.com/cloud/atlas)
</center>

## Getting Started
 
- Clone this repository.
	```
	git clone https://github.com/rochelle-m/pl406-doggo-adoption
	```
 -  Create a new database in  [MongoDB Atlas](https://account.mongodb.com/account/login).
 
	>  MongoDB Atlas is a hosted MongoDB service option in the cloud which requires no installation overhead and offers a free tier to get started.
- Open the project in [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) or [Eclipse IDE](https://www.eclipse.org/downloads/).
	> _Note that you will need to have Java installed._
-  Configure App properties: Create a file to store your application properties and environment variables *src/main/resources/application.properties* 
-  [Set up Atlas Connectivity](https://docs.mongodb.com/guides/cloud/connectionstring/)
	and paste in your connection string. 
	```properties
	spring.data.mongodb.uri=
	```
- Payment processing using Stripe: Create an account on [Stripe](https://stripe.com/) and place your public and secret key pair in *application.properties*.
	```properties
	stripe.public.key=
	
	stripe.secret.key=
	```
- Your *application.properties* would look something like this (Fill in the other properties).
	```properties
	spring.data.mongodb.uri=

	spring.servlet.multipart.max-file-size=

	spring.servlet.multipart.max-request-size=

	app.jwtSecret=

	app.jwtExpirationMs=

	stripe.public.key=
	
	stripe.secret.key=

	```
-  Run the Spring Boot application.
	 ```
	mvn spring-boot:run
	```
- Visit [localhost:8080](http://localhost:8080/).


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

<br/>

<p align="center">
<a href="https://github.com/rochelle-m/pl406-doggo-adoption/actions/workflows/node.js.yml"><img src="https://github.com/rochelle-m/pl406-doggo-adoption/actions/workflows/node.js.yml/badge.svg" alt="Build Status"></a>
&nbsp;
<a href="https://github.com/rochelle-m/pl406-doggo-adoption/actions/workflows/maven.yml"><img src="https://github.com/rochelle-m/pl406-doggo-adoption/actions/workflows/maven.yml/badge.svg" alt="Build Status"></a>
</p>

## Getting Started
 
- Clone this repository.
	```
	git clone https://github.com/rochelle-m/programming-paradigms
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


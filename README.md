# Dog Adoption and Care

Application where users can view dogs up for adoption/fostering, adopt/foster a dog, post about a dog available for adoption/fostering or write a post (maybe asking for help or really just anything related to dogs). Users can also choose to donate (monetarily/pet products) or volunteer for the adoption home. The application will post details about events like adoption camps. Users can also view the help section regarding locations of pet food stores, vet clinics and other doggo related information.

<div align="center">

[![Build Status](https://github.com/rochelle-m/pl406-doggo-adoption/actions/workflows/maven.yml/badge.svg)](https://github.com/rochelle-m/pl406-doggo-adoption/actions) [![Deployed on Heroku](https://img.shields.io/badge/heroku-deployed-blueviolet.svg?logo=heroku)](https://doggo-adoption.herokuapp.com/)
<br/><br/>
![versionjava](https://img.shields.io/badge/jdk-8,_11-006cb8.svg?logo=java) [![versionspringboot](https://img.shields.io/badge/dynamic/xml?color=6aad3d&url=https://raw.githubusercontent.com/rochelle-m/pl406-doggo-adoption/main/pom.xml&query=%2F%2A%5Blocal-name%28%29%3D%27project%27%5D%2F%2A%5Blocal-name%28%29%3D%27parent%27%5D%2F%2A%5Blocal-name%28%29%3D%27version%27%5D&label=springboot&logo=springboot)](https://github.com/spring-projects/spring-boot) [![versionnodejs](https://img.shields.io/badge/dynamic/xml?color=3e863d&url=https://raw.githubusercontent.com/rochelle-m/pl406-doggo-adoption/main/pom.xml&query=%2F%2A%5Blocal-name%28%29%3D%27project%27%5D%2F%2A%5Blocal-name%28%29%3D%27build%27%5D%2F%2A%5Blocal-name%28%29%3D%27plugins%27%5D%2F%2A%5Blocal-name%28%29%3D%27plugin%27%5D%2F%2A%5Blocal-name%28%29%3D%27executions%27%5D%2F%2A%5Blocal-name%28%29%3D%27execution%27%5D%2F%2A%5Blocal-name%28%29%3D%27configuration%27%5D%2F%2A%5Blocal-name%28%29%3D%27nodeVersion%27%5D&label=nodejs&logo=node.js)](https://nodejs.org/en/) [![versionsvelte](https://img.shields.io/badge/dynamic/json?color=f73c00&url=https://raw.githubusercontent.com/rochelle-m/pl406-doggo-adoption/main/client/package.json&query=$.devDependencies.svelte&label=svelte&logo=svelte)](https://svelte.dev/) [![mongodb](https://img.shields.io/static/v1?label=%20&message=Mongo%20DB%20Atlas&color=8a8a8a&logo=mongodb)](https://www.mongodb.com/cloud/atlas)
[![versionaxios](https://img.shields.io/badge/dynamic/json?color=5a29e4&url=https://raw.githubusercontent.com/rochelle-m/pl406-doggo-adoption/main/client/package.json&query=$.devDependencies.axios&label=axios)](https://github.com/axios) [![versionrollup](https://img.shields.io/badge/dynamic/json?color=ff3333&url=https://raw.githubusercontent.com/rochelle-m/pl406-doggo-adoption/main/client/package.json&query=$.devDependencies.rollup&label=rollup)](https://rollupjs.org/guide/en/) [![versionmoment](https://img.shields.io/badge/dynamic/json?color=1f1f1f&url=https://raw.githubusercontent.com/rochelle-m/pl406-doggo-adoption/main/client/package.json&query=$.devDependencies.moment&label=moment.js)](https://momentjs.com/) [![versionmapbox](https://img.shields.io/badge/dynamic/json?color=395afa&url=https://raw.githubusercontent.com/rochelle-m/pl406-doggo-adoption/main/client/package.json&query=$.devDependencies[%27mapbox-gl%27]&label=mapbox)](https://www.mapbox.com/) [![versionsvelterouting](https://img.shields.io/badge/dynamic/json?color=f73c00&url=https://raw.githubusercontent.com/rochelle-m/pl406-doggo-adoption/main/client/package.json&query=$.devDependencies[%27svelte-routing%27]&label=svelte-routing)](https://www.npmjs.com/package/svelte-routing) [![jwt](https://img.shields.io/static/v1?label=jwt&message=0.9.1&color=d63aff)](https://www.jwt.io) [![thymeleaf](https://img.shields.io/static/v1?label=thymeleaf&message=2.5.1&color=005f0f&logo=thymeleaf)](https://www.thymeleaf.org/)
</div>

## Getting Started

- Clone this repository.
  ```
  git clone https://github.com/rochelle-m/pl406-doggo-adoption
  ```
-  Create a new database in  [MongoDB Atlas](https://account.mongodb.com/account/login).

   >  MongoDB Atlas is a hosted MongoDB service option in the cloud which requires no installation overhead and offers a free tier to get started.
- Open the project in [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) or [Eclipse IDE](https://www.eclipse.org/downloads/).
  > _Note that you will need to have Java installed._

  #### Local development
-  Configure App properties: Create a file to store your application properties and environment variables *src/main/resources/application-dev.properties*
-  [Set up Atlas Connectivity](https://docs.mongodb.com/guides/cloud/connectionstring/)
   and paste in your connection string.
   ```properties
   spring.data.mongodb.uri=
   ```
- Payment processing using Stripe: Create an account on [Stripe](https://stripe.com/) and place your public and secret key pair in *application-dev.properties*.
  ```properties
  stripe.public.key=
  
  stripe.secret.key=
  ```
- Your *application-dev.properties* would look something like this (Fill in the other properties).
  ```properties
  spring.data.mongodb.uri=

  spring.servlet.multipart.max-file-size=

  spring.servlet.multipart.max-request-size=

  app.jwtSecret=

  app.jwtExpirationMs=

  stripe.public.key=
  
  stripe.secret.key=

  ```

- In *client/* create a file *.env* and in it, enter your [Mapbox Access Token](https://docs.mapbox.com/api/overview/)
  ```properties
  API_MAPBOX_ACCESS_TOKEN=

-  First run
    ```
   mvn clean install
   ```
-  Then, run the application
    ```
   mvn spring-boot:run
   ```
- Visit [localhost:8080](http://localhost:8080/).

#### Deployment
- Set the active profile to prod in  *src/main/resources/application.properties*
  ```properties
  spring.profiles.active=prod
- Set up [Config vars](https://devcenter.heroku.com/articles/config-vars) in [Heroku](https://www.heroku.com/)
## APIs

Method |Endpoint|  Description| Authentication
|--|--|--|--|
|GET| /api/doggos/| Retrieves all dogs | ✕
|POST| /api/doggos/| Creates a new dog resource | ✓
|GET| /api/doggos/{id}| Retrieves a dog with matching id | ✕
|POST| /api/auth/signup | Creates a new user, returns [JWT](https://jwt.io/) |✕
|POST| /api/auth/signin | Authenticates the user, returns [JWT](https://jwt.io/) |✕
|POST| /api/auth/logout | Logs the user out | ✓
|PUT| /api/auth/update/{id}/{role} | Updates the user to the VOLUNTEER role | ✓
|GET| /api/checkout/{amount}| Redirects to the payment page | ✕
|POST| /api/posts/new| Creates a new post | ✓
|POST| /api/posts/comment| Creates a new comment to a post| ✓
|DELETE| /api/posts/{id}| Deletes post by id | ✓
|GET| /api/products/[category-name]| Retrieves products by category | ✕
|POST| /api/applicant/| Creates a new adoption applicant | ✓
|GET| /api/applicant/| Retrieves all applicants | ✓*
|DELETE| /api/applicant/{id}| Deletes an applicant by id | ✓

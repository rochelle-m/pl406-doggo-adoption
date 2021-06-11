<script>
  import Banner from "../utils/Banner.svelte";

  export let title = "Dog Adoption and Care · Events";

  let message = "Events";
  let imgSrc = "images/event2.jpg";
</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>


<div>
  <Banner {message} {imgSrc} />
  
</div>

<div>
<div  class="event">
<h class="title "> <b>Dog Adoption Camp</b></h><br>
<img class="logo" src="/images/camp.png" alt="doggo" />
<br>
<h class="title">5th july 2021</h><br><h class="title">Adoption Centre, Goa - 231458</h>
<br>
<br>

<a class="btn btn-primary register" href="" >Register</a>
</div>

<div  class="event">
<h class="title "> <b>Tranning Camp</b></h><br>
<img class="logo" src="/images/train.png" alt="doggo" />
<br>
<h class="title">20th july 2021 - 30th july 2021</h><br><h class="title">View ground, Goa - 231458</h>
<br>
<br>
<a class="btn btn-primary register" href="" >Register</a>
</div>

<div  class="event">
<h class="title "> <b>Pet Food Expo</b></h><br>
<img class="logo" src="/images/download.png" alt="doggo" />
<br>
<h class="title">12th july 2021 - 14th july 2021</h><br><h class="title">Doggo club, Goa - 456558</h>
<br>
<br>
<a class="btn btn-primary register" href="" >Register</a>
</div>

</div>




<style>
  h3 {
    padding: 4em 0;
  }

  .event{
    height:350px;
    border: 1px solid black;
    border-radius:15px;
    margin:10px 50px;
    padding: 20px;
  }

  .logo{
  width:180px;
  height:150px;
  }

  .title{
  font-size:23px;
  }
.register{
	color:white;
}
  
  </style>

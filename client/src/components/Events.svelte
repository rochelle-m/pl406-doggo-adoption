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
<h class="title camp"> <b>Dog Adoption Camp</b></h><br>
<img class="logo" src="/images/camp.png" alt="doggo" />
<br>
<h class="title">5th july 2021</h><br><h class="title">Adoption Centre, Goa - 231458</h>
<br>
<br>
<button class="btn btn-primary">Register </button>
</div>

<div  class="event">
<h class="title train"> <b>Tranning Camp</b></h><br>
<img class="logo" src="/images/train.png" alt="doggo" />
<br>
<h class="title">20th july 2021 - 30th july 2021</h><br><h class="title">View ground, Goa - 231458</h>
<br>
<br>
<button class="btn btn-primary">Register </button>
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

  .camp{
  color: #54e346;
  }

  .train{
  color: #fb9300;
  }

  </style>

<script>
  import Banner from "../utils/Banner.svelte";
  import { Link } from "svelte-routing";

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



<div  class="event">
<h class="title "> <b>Dog Adoption Camp</b></h><br>
<img class="logo" src="/images/camp.png" alt="doggo" />
<br>
<h class="title">20th July 2021</h><br><h class="title">Adoption Centre, Goa - 231458</h>
<br>
<br>

<Link class="btn btn-primary register" to="registerevent" >Register</Link>
</div>

<div  class="event">
<h class="title "> <b>Tranning Camp</b></h><br>
<img class="logo" src="/images/train.png" alt="doggo" />
<br>
<h class="title">20th August 2021 - 30th August 2021</h><br><h class="title">View ground, Goa - 231458</h>
<br>
<br>
<Link class="btn btn-primary register" to="registerevent" >Register</Link>
</div>

<div  class="event">
<h class="title "> <b>Pet Food Expo</b></h><br>
<img class="logo" src="/images/download.png" alt="doggo" />
<br>
<h class="title">02 August 2021 - 04th August 2021</h><br><h class="title">Doggo club, Goa - 456558</h>
<br>
<br>
<Link class="btn btn-primary register" to="registerevent" >Register</Link>
</div>



<div class="container">
<h3><b>Events Gallary</b></h3>
  <div class="row">
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary10.jpg" target="_blank">
          <img src="/images/gallary10.jpg" alt="Lights" style="width:100%" class=".img-thumbnail">
          <div class="caption">
            <p>Tranning camp, July 2018, Vasco</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary3.jpg" target="_blank" class="img-thumbnail">
          <img src="/images/gallary3.jpg" alt="Lights" style="width:100%" class=".img-thumbnail">
          <div class="caption">
            <p>Pet food exibition, Feb 2019, Ponda</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary15.jpg" target="_blank">
          <img src="/images/gallary15.jpg" alt="Lights" style="width:100%" class=".img-thumbnail">
          <div class="caption">
            <p>Dogs show, September 2019</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary7.jpg" target="_blank">
          <img src="/images/gallary7.jpg" alt="Lights" style="width:100%" class=".img-thumbnail">
          <div class="caption">
            <p>Pet food exibition 2018, Panjim</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary1.jpg" target="_blank">
          <img src="/images/gallary1.jpg" alt="Lights" style="width:100%" class=".img-thumbnail">
          <div class="caption">
            <p>Tranning camp 2018</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary2.jpg" target="_blank">
          <img src="/images/gallary2.jpg" alt="Lights" style="width:100%" class=".img-thumbnail">
          <div class="caption">
            <p>Pet food exibition, January 2018, Margao</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary13.jpg" target="_blank">
          <img src="/images/gallary13.jpg" alt="Nature" style="width:100%">
          <div class="caption">
            <p>Adoption camp, March 2019</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary8.jpg" target="_blank">
          <img src="/images/gallary8.jpg" alt="Nature" style="width:100%">
          <div class="caption">
            <p>Pet food exibition, Dec 2020, Mapusa</p>
          </div>
        </a>
      </div>
    </div> 
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary11.jpg" target="_blank">
          <img src="/images/gallary11.jpg" alt="Nature" style="width:100%">
          <div class="caption">
            <p>Adoption camp, March 2021, Porvorim</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary14.jpg" target="_blank">
          <img src="/images/gallary14.jpg" alt="Nature" style="width:100%">
          <div class="caption">
            <p>Adoption camp, January 2021, Bicholim </p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary9.jpg" target="_blank">
          <img src="/images/gallary9.jpg" alt="Nature" style="width:100%">
          <div class="caption">
            <p>Dogs Show, November 2020, Porvorim</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary6.jpg" target="_blank">
          <img src="/images/gallary6.jpg" alt="Nature" style="width:100%">
          <div class="caption">
            <p>Tranning camp, Dec 2020, Vasco</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary5.jpg" target="_blank">
          <img src="/images/gallary5.jpg" alt="Nature" style="width:100%">
          <div class="caption">
            <p>Dog food exibition,August 2020, Anjuna</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/12.jpg" target="_blank">
          <img src="/images/gallary12.jpg" alt="Fjords" style="width:100%">
          <div class="caption">
            <p>Adoption camp, March 2021, Panjim</p>
          </div>
        </a>
      </div>
    </div>
  </div>
 </div>

<style>
  h3 {
    padding: 2em 0;
    font-size:25px;
    color:orange;
  }

  .event{
    height:400px;
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
	color:black;
}
</style>


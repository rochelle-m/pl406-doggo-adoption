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



<div  class="event">
<h class="title "> <b>Dog Adoption Camp</b></h><br>
<img class="logo" src="/images/camp.png" alt="doggo" />
<br>
<h class="title">5th july 2021</h><br><h class="title">Adoption Centre, Goa - 231458</h>
<br>
<br>

<a class="btn btn-primary register" href="registerevent" >Register</a>
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



<div class="container">
<h3><b>Events Gallary</b></h3>
  <div class="row">
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary10.jpg" target="_blank">
          <img src="/images/gallary10.jpg" alt="Lights" style="width:100%" class=".img-thumbnail">
          <div class="caption">
            <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary3.jpg" target="_blank" class="img-thumbnail">
          <img src="/images/gallary3.jpg" alt="Lights" style="width:100%" class=".img-thumbnail">
          <div class="caption">
            <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary15.jpg" target="_blank">
          <img src="/images/gallary15.jpg" alt="Lights" style="width:100%" class=".img-thumbnail">
          <div class="caption">
            <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary7.jpg" target="_blank">
          <img src="/images/gallary7.jpg" alt="Lights" style="width:100%" class=".img-thumbnail">
          <div class="caption">
            <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary1.jpg" target="_blank">
          <img src="/images/gallary1.jpg" alt="Lights" style="width:100%" class=".img-thumbnail">
          <div class="caption">
            <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary2.jpg" target="_blank">
          <img src="/images/gallary2.jpg" alt="Lights" style="width:100%" class=".img-thumbnail">
          <div class="caption">
            <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary13.jpg" target="_blank">
          <img src="/images/gallary13.jpg" alt="Nature" style="width:100%">
          <div class="caption">
            <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary8.jpg" target="_blank">
          <img src="/images/gallary8.jpg" alt="Nature" style="width:100%">
          <div class="caption">
            <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
          </div>
        </a>
      </div>
    </div> 
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary11.jpg" target="_blank">
          <img src="/images/gallary11.jpg" alt="Nature" style="width:100%">
          <div class="caption">
            <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary14.jpg" target="_blank">
          <img src="/images/gallary14.jpg" alt="Nature" style="width:100%">
          <div class="caption">
            <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary9.jpg" target="_blank">
          <img src="/images/gallary9.jpg" alt="Nature" style="width:100%">
          <div class="caption">
            <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary6.jpg" target="_blank">
          <img src="/images/gallary6.jpg" alt="Nature" style="width:100%">
          <div class="caption">
            <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/gallary5.jpg" target="_blank">
          <img src="/images/gallary5.jpg" alt="Nature" style="width:100%">
          <div class="caption">
            <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="/images/12.jpg" target="_blank">
          <img src="/images/gallary12.jpg" alt="Fjords" style="width:100%">
          <div class="caption">
            <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
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


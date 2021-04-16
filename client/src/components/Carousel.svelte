<div id="demo" class="carousel slide" data-ride="carousel">

  
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
    <li data-target="#demo" data-slide-to="3"></li>
  </ul>
  
  <!-- The slideshow -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="images/dog10.jpg" alt="dog10" width="100%" >
      	<div class="carousel-caption">
		    <h3>will you be my hooman? ♡</h3>
		    <br>
		    <form action="#adopt">
    				<input type="submit" value="Adopt" />
			</form>
  		</div>
  		
    </div>
    <div class="carousel-item">
      <img src="images/dog14.jpg" alt="dog14" width="100%" >
      <div class="carousel-caption">
		    <h3>text for foster</h3>
		    <br>
		     <form action="#foster">
    				<input type="submit" value="Foster" />
			</form>
  		</div>
    </div>
    <div class="carousel-item">
      <img src="images/dog3.jpg" alt="dog3" width="100%" >
      <div class="carousel-caption">
		    <h3>text for volunteer</h3>
		    <br>
		     <form action="#volunteer">
    				<input type="submit" value="Volunteer" />
			</form>
  		</div>
    </div>
    <div class="carousel-item">
      <img src="images/dog12.jpg" alt="dog1" width="100%" id="item4" >
      <div class="carousel-caption">
		    <h3>text for donate</h3>
		    <br>
		     <form action="#donate">
    				<input type="submit" value="Donate" />
			</form>
  		</div>
    </div>
    
  </div>  
  
  
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>
<style>
 .carousel-caption
 {
 	font-weight: bold;
    transform: translate(20%, -95%);
    position: absolute;
    right: 0px;
    height: fit-content;
    top: 55%;
 } 

 #item4 {
   filter: brightness(50%);
 }
</style>
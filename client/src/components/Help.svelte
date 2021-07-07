<script>
  import Banner from "../utils/Banner.svelte";
  import Map from '../utils/Map.svelte';
  import Marker from '../utils/Marker.svelte';

  export let title = "Dog Adoption and Care · Pet Food";

  let message = "Help";
  let imgSrc = "images/petfood.png";
</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<div>
 	<Banner {message} {imgSrc} />
 	


	<div class="card-deck main">  
		<div class="card border-info mb-3 " style="max-width: 18rem;">
	  		<div class="card-header">79 The Pet Stop</div>
	  		<div class="card-body text-info">
			   <p class="card-text">Mapusa, Goa</p>
			   <p class="card-text">Opens 8AM </p>
			   <p class="card-text">091587 97979</p>
			   <p class="card-text">In-store shopping</p>
			</div>
		</div>

		<div class="card border-info mb-3 " style="max-width: 18rem;">
	  		<div class="card-header">PAWFECT PET SHOP</div>
	  		<div class="card-body text-info">
			   <p class="card-text">Panjim, Goa</p>
			   <p class="card-text">Opens 10AM </p>
			   <p class="card-text">In-store shopping</p>
			</div>
		</div>

		<div class="card border-info mb-3" style="max-width: 18rem;">
	  		<div class="card-header">L.N Pet Shop</div>
	  		<div class="card-body text-info">
			   <p class="card-text">Varca, Goa</p>
			   <p class="card-text">Opens 9AM </p>
			   <p class="card-text">In-store shopping</p>
			</div>
		</div>

		<div class="card border-info mb-3" style="max-width: 18rem;">
	  		<div class="card-header">Mandovi Pet medical</div>
	  		<div class="card-body text-info">
			   <p class="card-text">Panaji, Goa</p>
			   <p class="card-text">Opens 9AM </p>
			   <p class="card-text">094044 44449</p>
			   <p class="card-text">In-store shopping</p>
			</div>
		</div>
	</div>

	<div class="card-deck main">
		<div class="card border-info mb-3" style="max-width: 18rem;">
	  		<div class="card-header">Pet World</div>
	  		<div class="card-body text-info">
			   <p class="card-text">Panaji, Goa</p>
			   <p class="card-text">Opens 9AM </p>
			   <p class="card-text"> 098230 85566</p>
			   <p class="card-text">In-store shopping</p>
			</div>
		</div>

		<div class="card border-info mb-3" style="max-width: 18rem;">
	  		<div class="card-header">79 The Pet Stop</div>
	  		<div class="card-body text-info">
			   <p class="card-text">Margao, Goa</p>
			   <p class="card-text">Opens 8AM </p>
			   <p class="card-text">091587 97979</p>
			   <p class="card-text">In-store shopping</p>
			</div>
		</div>

		<div class="card border-info mb-3" style="max-width: 18rem;">
	  		<div class="card-header">One Stop Over</div>
	  		<div class="card-body text-info">
			   <p class="card-text">Pet store</p>
			   <p class="card-text">Caranzalem, Goa</p>
			   <p class="card-text">070209 16008</p>
			   <p class="card-text">In-store shopping</p>
			</div>
		</div>

		<div class="card border-info mb-3" style="max-width: 18rem;">
	  		<div class="card-header">FOUR TAILS PET FOOD & ACCESSORIES</div>
	  		<div class="card-body text-info">
			   <p class="card-text">Raia, Goa</p>
			   <p class="card-text">Opens 9AM </p>
			   <p class="card-text">081045 02931</p>
			   <p class="card-text">In-store shopping</p>
			</div>
		</div>
	</div>

	<div class="card-deck main">
		<div class="card border-info mb-3" style="max-width: 18rem;">
	  		<div class="card-header">Happy Paws Pet Store</div>
	  		<div class="card-body text-info">
			   <p class="card-text">Navelim, Goa</p>
			   <p class="card-text">Opens 9AM </p>
			   <p class="card-text">In-store shopping</p>
			</div>
		</div>

		<div class="card border-info mb-3" style="max-width: 18rem;">
	  		<div class="card-header">79 The Pet Shop</div>
	  		<div class="card-body text-info">
			   <p class="card-text">Nova Cidade Commercial Complex</p>
			   <p class="card-text">Penha de França, Goa</p>
			   <p class="card-text">In-store shopping</p>
			</div>
		</div>	

		<div class="card border-info mb-3" style="max-width: 18rem;">
	  		<div class="card-header">Mascot Pet Lifestyle Store</div>
	  		<div class="card-body text-info">
			   <p class="card-text">Margao, Goa</p>
			   <p class="card-text">Opens 9AM </p>
			   <p class="card-text"> 075076 47687</p>
			   <p class="card-text">In-store shopping</p>
			</div>
		</div>

	</div>

	<div>
		<div class="card-deck main">  
		<div class="card border-info mb-3 " style="max-width: 18rem;">
	  		<div class="card-header"><b>VETERINARY CLINIC</b></div>
	  		<div class="card-body text-info">
			   <p class="card-text">Behind Monginis, At Coquiero circle, next to TATA Motors, Govekar Nagar, Alto Porvorim, Goa 403501</p>
			   <p class="card-text">9:30 AM - 9:30 PM  </p>
			</div>
		</div>

		<div class="card border-info mb-3 " style="max-width: 18rem;">
	  		<div class="card-header"><b>PetZone Goa Veterinary Clinic</b></div>
	  		<div class="card-body text-info">
			   <p class="card-text">Udayan Apartments, Edapally - Panvel Hwy, Sangolda, Goa 403511</p>
			   <p class="card-text">9 AM - 6 PM</p>
			   <p class="card-text">081081 42687</p>
			   <p class="card-text"><b>Sunday Closed</b></p>
			</div>
		</div>

		<div class="card border-info mb-3" style="max-width: 18rem;">
	  		<div class="card-header"><b>PETLAND VETERINARY CLINIC</b></div>
	  		<div class="card-body text-info">
			   <p class="card-text">ST MARYS COLONY, MIRAMAR, beside TRINITY HOSPITAL, Panaji, Goa 403001</p>
			   <p class="card-text">9:30 AM - 1 PM</p>
			   <p class="card-text">098906 97636</p>
			   <p class="card-text"><b>Sunday Closed</b></p>
			</div>
		</div>

		<div class="card border-info mb-3" style="max-width: 18rem;">
	  		<div class="card-header"><b>Estibeiro Pet Clinic</b></div>
	  		<div class="card-body text-info">
			   <p class="card-text">Church Street, Defence Colony, Alto Porvorim, Penha de França, Goa 403521</p>
			   <p class="card-text">8 AM - 12:30 PM </p>
			   <p class="card-text"><b>Sunday Closed</b></p>
			   <p class="card-text"><b>Monday Closed</b></p>
			</div>
		</div>
	</div>

	<div class="helpline">
 	<div class="card border-info mb-3" style="max-width: 30rem;">
	  		<div class="card-header">Pet Helpline Number</div>
	  		<div class="card-body text-info">
			   <p class="card-text">If uou need to report a situation involving an animal in immediate danger, please call our emergency number:</p>
			   <p class="card-text"><b>(0)9820122602<b> </p>
			   <p class="card-text">If animal is injured, please remain with the animal until help is secured.</p>
			</div>
			</div>
		</div>
	</div>
	</div>
	
	<div class="p-4">
	    <Map lat={15.49} lon={73.8} zoom={11.0}>
	      <Marker lat={15.5166} lon={73.7689} label="Happy Paws" type="vet"/>
	      <Marker lat={15.4650} lon={73.8657} label="Happy Paws" type="shop"/>
	    </Map>
  	</div>



<style>
  .main{
  padding: 30px 60px;
  }

  .helpline{
margin-right:20%;
margin-left:30%;
 width: auto;
 padding-top: 2em;

  }
</style>

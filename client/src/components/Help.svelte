<script>
  import Banner from "../utils/Banner.svelte";
  import Map from '../utils/Map.svelte';
  import Marker from '../utils/Marker.svelte';

  export let title = "Dog Adoption and Care · Help";

  let message = "Help";
  let imgSrc = "images/help.jpg";
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
			   <p class="card-text">Shop no. 5-6, Ecoterre House, St Joaquim Road, next to Maxsan Fitness, Borda, Margao, Goa 403601</p>
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
	      <Marker lat={15.481711159796705} lon={73.81428593082853} label="Mandovi Pet medical" type="shop"/>
	      <Marker lat={15.588449704691707} lon={73.81297477337098} label="79 The Pet Stop" type="shop"/>
	      <Marker lat={15.288692303449519} lon={73.98157515871377} label="Mascot Pet Lifestyle Store" type="shop"/>
	      <Marker lat={15.284131694204675} lon={73.97235851486901} label="79 The Pet Sto" type="shop"/>
	      <Marker lat={15.54603974611285} lon={73.79517212729048} label="Happy Paws Pet Store" type="shop"/>
	      <Marker lat={15.29638646695722} lon={73.99035604674032} label="FOUR TAILS PET FOOD & ACCESSORIES"/>
	      <Marker lat={15.480103826001836} lon={73.81264761745565} label="One Stop Over"/>
	      <Marker lat={15.488946182462858} lon={73.8186007403112} label="79 The Pet Stop" type="shop"/>
	      <Marker lat={15.482488851558575} lon={73.8138375719653} label="Pet World" type="shop"/>
	      <Marker lat={15.49453522443819} lon={73.93495564044075} label="PAWFECT PET SHOP" type="shop"/>
	      <Marker lat={15.233395769270082} lon={73.94343283006128} label="L.N PET SHOP" type="shop"/>

	      <Marker lat={15.540531145753283} lon={73.82587445888315} label="VETERINARY CLINIC" type="vet"/>
	      <Marker lat={15.55719747583739} lon={73.81666401147676} label="PetZone Goa Veterinary Clinic" type="vet"/>
	      <Marker lat={15.491282234762144} lon={73.81119234240045} label="PETLAND VETERINARY CLINIC" type="vet"/>
	      <Marker lat={15.542162652792271} lon={73.82542504307868} label="Estibeiro Pet Clinic" type="vet"/>
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

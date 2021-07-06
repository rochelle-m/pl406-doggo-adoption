<script>
  import Banner from "../utils/Banner.svelte";

  export let title = "Dog Adoption and Care · Pet Food";

  let message = "Pet Food";
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
</div>

<style>
  .main{
  padding:30px 80px;
  }
</style>

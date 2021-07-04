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
   
</div>

<style>
  
</style>

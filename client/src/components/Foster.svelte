<script>
  import Banner from "../utils/Banner.svelte";

	export let title = "Dog Adoption and Care · Foster";

  let message = "Foster";
  let imgSrc = "images/banner/foster.jpg";
</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<div>
  <Banner {message} {imgSrc} />
</div>

<style>
  
</style>

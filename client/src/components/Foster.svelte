<script>
  import Banner from "../utils/Banner.svelte";

	export let title = "Foster · Dog Adoption and Care";

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

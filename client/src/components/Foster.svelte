<script>
  import Banner from "./Banner.svelte";

	export let title = "Dog Adoption and Care · Foster";

  let message = "Foster";
  let imgSrc = "images/foster.jpg";
</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<div>
  <Banner {message} {imgSrc} />
  <h3>⧛ Under construction ⌂ ⧛</h3>
</div>

<style>
  h3 {
    padding: 4em 0;
  }
</style>

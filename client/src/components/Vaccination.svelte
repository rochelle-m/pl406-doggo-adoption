<script>
  import Banner from "../utils/Banner.svelte";

  export let title = "Dog Adoption and Care · Vaccination";

  let message = "Vaccination Centre";
  let imgSrc = "images/vaccine.jpg";
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

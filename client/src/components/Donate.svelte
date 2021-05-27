<script>
  import Banner from "../utils/Banner.svelte";

   export let title = "Dog Adoption and Care · Donate";

  let message = "Donate";
  let imgSrc = "images/donate.jpg";
</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<div>
  <Banner {message} {imgSrc} />
  <small> All donations are exempted under the 80g certificate. </small>
  <h3>⧛ Under construction ⌂ ⧛</h3>
</div>

<style>
  h3 {
    padding: 4em 0;
  }
</style>

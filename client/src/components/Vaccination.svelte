<script>
  import Banner from "./Banner.svelte";
  let message = "Vaccination Centre";
  let imgSrc = "images/vaccine.jpg";
</script>

<div>
  <Banner {message} {imgSrc} />
  <h3>⧛ Under construction ⌂ ⧛</h3>
</div>

<style>
  h3 {
    padding: 4em 0;
  }
</style>

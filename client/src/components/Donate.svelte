<script>
  import Banner from "./Banner.svelte";
  let message = "Donate";
  let imgSrc = "images/donate.jpg";
</script>

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

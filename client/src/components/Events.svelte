<script>
  import Banner from "../utils/Banner.svelte";

  export let title = "Dog Adoption and Care · Events";

  let message = "Events";
  let imgSrc = "images/event2.jpg";
</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>


<div>
  <Banner {message} {imgSrc} />
  <h3>⧛ Under construction ⌂ ⧛</h3>
</div>

<div>
<h>hello<h>
</div>

<style>
  h3 {
    padding: 4em 0;
  }
</style>

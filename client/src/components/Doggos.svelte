<script>
  import {onMount} from "svelte";
  import Banner from "./Banner.svelte";
  import Doggo from "../utils/Doggo.svelte"

  export let title = "Dog Adoption and Care · Adopt";

  let doggos = []
  const URL = `http://localhost:5001/api/doggos`

  onMount(async function () {
    const response = await fetch(URL)
    doggos = await response.json();
  })

  let message = "Adopt";
  let imgSrc = "images/dog11.jpg";
</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<div>
  <Banner {message} {imgSrc} />
  <h3>⧛ Under construction ⌂ ⧛</h3>
  <div class="d-flex flex-wrap justify-content-around">
    {#each doggos as doggo}
      <Doggo src={doggo.primaryImg} {doggo}>
        <p slot="name">{doggo.name}</p>
        <p slot="description">{doggo.description}</p>
        <p slot="remarks">{doggo.remarks}</p>
      </Doggo>
      {:else}
        <p>Loading... pawtience</p>
    {/each }

  </div>
</div>

<style>
  h3 {
    padding: 1em 0;
  }
</style>

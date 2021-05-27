<script>
  import { onMount } from "svelte";
  import Banner from "../utils/Banner.svelte";
  import Doggo from "../utils/Doggo.svelte";
  import Loading from "../utils/Loading.svelte";
  import BeforeYouAdopt from "../utils/BeforeYouAdopt.svelte";

  export let title = "Dog Adoption and Care · Adopt";

  let doggos = [];
  let error = "";
  const URL = `http://localhost:5001/api/doggos/`;
  let show = false;

  onMount(async function () {
    try {
      const response = await fetch(URL);
      doggos = await response.json();

      setTimeout(() => {
        show = true;
      }, 1500);
    } catch (err) {
      error = err.message;
    }
  });

  let message = "Adopt";
  let imgSrc = "images/dog11.jpg";
</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<div>
  <Banner {message} {imgSrc} />
  <div class="d-flex flex-wrap justify-content-around spacing">
    {#each doggos as doggo}
      {#if !doggo.isAdopted && !doggo.isFostered}
        <Doggo src={doggo.primaryImg} {doggo}>
          <p slot="name">{doggo.name}</p>
          <p slot="description">{doggo.description}</p>
          <p slot="remarks">{doggo.remarks}</p>
        </Doggo>
      {/if}
    {:else}
      <Loading message={error} />
    {/each}
  </div>
</div>

<BeforeYouAdopt {show} />

<style>
  .spacing {
    margin-top: 40px;
  }
</style>

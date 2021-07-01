<script>
  import Doggo from "../utils/Doggo.svelte";
  const URL = `/api/doggos/`;
  import Loading from "./Loading.svelte";
  import { Link } from "svelte-routing";

  async function getDoggos() {
    const res = await fetch(URL);
    const doggos = await res.json();

    if (res.ok) {
      return doggos.slice(0, 3);
    } else {
      throw new Error("Some error occured ");
    }
  }

  let promise = getDoggos();
</script>

<div class="my-5 text-center container">
  <div class="row mb-2" />
  <div class="d-flex justify-content-center">
    {#await promise}
      <Loading />
    {:then doggos}
      {#each doggos as doggo}
        {#if !doggo.isAdopted && !doggo.isFostered}
          <Doggo src={doggo.primaryImg} {doggo}>
            <p slot="name">{doggo.name}</p>
            <p slot="breed">{doggo.breed}</p>
            <p slot="description">{doggo.description}</p>
          </Doggo>
        {/if}
      {/each}
      <div class="d-flex align-items-center justify-content-center">
        <h5>
          <Link to="adopt" class="nav-link">See more</Link>
        </h5>
      </div>
    {:catch _}
      <p class="my-4">{'Some error occured.'}</p>
    {/await}
  </div>
</div>

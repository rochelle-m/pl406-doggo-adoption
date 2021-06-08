<script>
  import Doggo from "../utils/Doggo.svelte";
  import { onMount } from "svelte";

  let allDoggos = [];
  let first3 = []; 
  let error = "";
  const URL = `http://localhost:5001/api/doggos/`;

  onMount(async function () {
    try {
      const response = await fetch(URL);
      allDoggos = await response.json();

      first3 = allDoggos.slice(0, 3);

    } catch (err) {
      error = err.message;
    }
  });

</script>

<div class="my-5 text-center container">
  <div class="row mb-2">
    
  </div>
  <div class="d-flex justify-content-center">
          {#each first3 as doggo}
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
              <a href="adopt" class="nav-link">See more</a>
            </h5>
          </div>
    </div>
</div>

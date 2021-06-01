<script>
  import Doggo from "../utils/Doggo.svelte";
  import { onMount } from "svelte";

  let allDoggos = [];
  let first3 = []; 
  let next3 = [];
  let error = "";
  const URL = `http://localhost:5001/api/doggos/`;

  onMount(async function () {
    try {
      const response = await fetch(URL);
      allDoggos = await response.json();

      first3 = allDoggos.slice(0, 3);
      next3 = allDoggos.slice(3, 6);

    } catch (err) {
      error = err.message;
    }
  });

</script>

<div class="my-5 text-center container">
  <div class="row mb-2">
    <div class="col text-center">
      <h5>Adopt</h5>
      <a href="adopt" class="nav-link">See more</a>
    </div>
  </div>
  <div class="row d-flex align-items-center">
    <div class="col-1 d-flex align-items-center justify-content-center">
      <a href="#carouselIndicators" role="button" data-slide="prev">
        <div class="carousel-nav-icon">
            <i class="fas fa-angle-left text-dark"></i>
        </div>
      </a>
    </div>
    <div class="col-10">
      <div
        id="carouselIndicators"
        class="carousel slide"
        data-ride="carousel"
        data-interval="false"
      >

        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="row">
              {#each first3 as doggo}
                {#if !doggo.isAdopted && !doggo.isFostered}
                  <Doggo src={doggo.primaryImg} {doggo}>
                    <p slot="name">{doggo.name}</p>
                    <p slot="breed">{doggo.breed}</p>
                    <p slot="description">{doggo.description}</p>
                  </Doggo>
                {/if}
              {/each}
            </div>
          </div>
          <div class="carousel-item">
            <div class="row">
              {#each next3 as doggo}
                {#if !doggo.isAdopted && !doggo.isFostered}
                  <Doggo src={doggo.primaryImg} {doggo}>
                    <p slot="name">{doggo.name}</p>
                    <p slot="breed">{doggo.breed}</p>
                    <p slot="description">{doggo.description}</p>
                  </Doggo>
                {/if}
              {:else}
                  <p>{error}</p>
              {/each}
              
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-1 d-flex align-items-center justify-content-center">
      <a href="#carouselIndicators" data-slide="next">
        <div class="carousel-nav-icon">
            <i class="fas fa-angle-right text-dark"></i>
        </div>
      </a>
    </div>
  </div>
</div>

<style>
  .carousel-nav-icon i {
    font-size: xx-large;
  }
</style>

<script>
  import { fly } from "svelte/transition";
  export let show = true;

  const dismiss = () => {
    show = false;
  };

  const ARROW_DOWN = "▾";
  const ARROW_UP = "▴";

  const expand = (event) => {
    const arrow = event.target;
    const main = document.getElementById("before-you-adopt");

    if(arrow.innerHTML == ARROW_UP) {
        arrow.innerHTML = ARROW_DOWN
        main.style.bottom = "5vh"
    }
    else {
        arrow.innerHTML = ARROW_UP
        main.style.bottom = "-75vh"
    }
  };
</script>

{#if show}
  <div
    id="before-you-adopt"
    in:fly={{ y: 100, duration: 2000 }}
    out:fly={{ y: 100, duration: 1000 }}
  >
    <div class="card mb-3 w-75">
      <div class="card-header text-white">
        <h6 class="d-inline float-left">Before You Adopt</h6>
        <span
          class="float-right px-1"
          title="Dismiss"
          style="cursor:pointer;"
          on:click={dismiss}
        >
          ×
        </span>
        <span
          class="float-right px-4"
          title="Dismiss"
          style="cursor:pointer;"
          on:click={expand}
        >
          {ARROW_UP}
        </span>
      </div>
      <div class="card-body" style="height:70vh">
        <h5 class="card-title">...</h5>
        <p class="card-text">Lorem ipsum</p>
      </div>
    </div>
  </div>
{/if}

<style>
  .card-header {
    background-color: #302121e6;
  }

  #before-you-adopt {
    display: grid;
    place-items: center;
    position: fixed;
    width: 100%;
    transition: 0.4s linear;
    bottom: -75vh;
    z-index: 399;
  }

  .card {
    box-shadow: 10px 10px 10px #333;
  }
</style>

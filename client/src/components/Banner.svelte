<script>
  import { fade, fly } from "svelte/transition";
  export let message;
  export let imgSrc;
</script>

<div
  class="d-flex justify-content-center"
  in:fly={{ y: -100, duration: 2500 }}
  out:fade
>
  <img src={imgSrc} alt="banner" />
  <h2>{message}</h2>
</div>

<style>
  h2 {
    position: absolute;
    z-index: 10;
    top: 18vw;
    text-align: center;
    display: block;
    text-transform: uppercase;
    padding-bottom: 0.4em;
    border-bottom: 1px solid rgb(255, 254, 254);
    color: white;
  }

  img {
    filter: brightness(40%);
    width: 100%;
    height: 32vmax;
  }
</style>

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
  <div class="banner-title">
    <h2>{message}</h2>
    <nav aria-label="breadcrumb">
      <ol class="breadcrumb bg-transparent">
        <li class="breadcrumb-item"><a href="/" class="text-white">Home</a></li>
        <li class="breadcrumb-item active text-white" aria-current="page">{message}</li>
      </ol>
    </nav>
  </div>
</div>

<style>
  .banner-title {
    position: absolute;
    z-index: 10;
    top: 15vw;
    text-align: center;
    display: block;
    color: white;
  }

  .banner-title h2  {
    text-transform: uppercase;
    padding-bottom: 0.4em;
    border-bottom: 1px solid rgb(255, 254, 254);
  }

  img {
    filter: brightness(40%);
    width: 100%;
    height: 32vmax;
  }
</style>

<script>
  export let message;
  const title = "404 · Dog Adoption and Care";
  import { fade } from "svelte/transition";
</script>

<div class="x-container pt-5" in:fade>
  <div class="rounded">
    <h2 class="mt-5 text-white">{message}</h2>
    <img class="w-50" src="/images/icons/doberman.png" alt="" />
  </div>
</div>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<style>
  .x-container {
    background: #311c1c95;
  }
</style>

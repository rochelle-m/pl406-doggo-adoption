<script>
  export let src;
  export let doggo;
</script>

<article class="border rounded-lg m-2 mx-3 w-20">
  <h4>
    <slot name="name" />
  </h4>

  <img {src} alt="" />

  <div>
    <slot name="description" />
  </div>

  <div>
    <slot name="remarks" />
  </div>
</article>

<style>
  img {
    width: 100%;
    height: 25vh;
  }
  article {
    box-shadow: 1px 1px 2px silver;
  }
  .w-20 {
    width: 20vw;
    min-width: 10em;
  }
</style>

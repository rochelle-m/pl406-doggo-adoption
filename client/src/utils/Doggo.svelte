<script>
  export let src;
  export let doggo;

  let handleError = (el) => {
    el.target.error = null;
    el.target.src = "/images/icons/logo-w.png";
  };
</script>

<article class="border rounded-lg m-2 mx-3 w-20 card">
  <img class="card-img-top" {src} on:error={handleError} alt={doggo.name} />

  <div class="card-body">
    <h4 class="card-title">
      <slot name="name" />
    </h4>

    <p class="card-text text-secondary">
      <slot name="breed" />
    </p>

    <p class="card-text">
      <slot name="description" />
    </p>

    <p class="list-group list-group-flush">
      <slot name="remarks" />
    </p>
  </div>

  <div class="card-footer">
    <a href="/" class="card-link">Adopt</a>
    <a href="/" class="card-link">Foster</a>
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

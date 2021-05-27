<script>
  export let src;
  export let doggo;
</script>

<article class="border rounded-lg m-2 mx-3 w-20 card">


  <img class="card-img-top
  " src="/images/volunteer.jpg" alt="" />

  <div class="card-body">

    <h2 class="card-title">
      <slot name="name" />
    </h2>

    <p class="card-text">
      <slot name="description" />
    </p>

    <h class="list-group list-group-flush">
     <slot name="remarks" />
    </h>
     
  </div>

  <div class="card-body">
    <a href="#" class="card-link">Adopt</a>
    <a href="#" class="card-link">Foster</a>
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

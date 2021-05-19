<script>
  import Banner from "./Banner.svelte";

  export let title = "Dog Adoption and Care · Donate";

  let message = "Donate";
  let imgSrc = "images/donate.jpg";
</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<div>
  <Banner {message} {imgSrc} />

  <div class="d-flex justify-content-around mt-4 row container" style="margin: auto">
    <div class="col-sm-4">
      <div class="card border-dark mb-3">
        <div class="card-header">
          <span class="d-inline-block">Donate Items</span>
          <span class="d-inline-block btn float-right">
            <i class="fas fa-box-open" />
          </span>
        </div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="card border-dark mb-3">
        <div class="card-header">
          <span class="d-inline-block">Make a monetary donation</span>
          <span class="d-inline-block btn float-right">
            <i class="far fa-credit-card" />
          </span>
        </div>
      </div>
    </div>
  </div>

  <small> All donations are exempted under the 80g certificate. </small>
</div>

<style>

</style>

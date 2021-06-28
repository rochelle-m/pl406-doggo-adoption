<script>
  import { Link } from "svelte-routing"
</script>

<style>
  img {
    filter: sepia(90%);
    width: 50%;
  }

  h3 + p {
    text-align: center;
    margin-top: 2em;
  }
</style>


<div class="container p-2 my-4">
  <div class="row d-flex justify-content-around">
    <div class="col-md-4">
      <h2>Unsure about adopting?</h2>
      <h3 class="text-muted mt-3">You can foster</h3>
      <p class="mt-5">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
        tempor incididunt ut labore et dolore magna aliqua.
      </p>
      <Link to="/foster">
        <button class="btn">Foster</button>
      </Link>
    </div>

    <img src="/images/taxi-social-distancing.png" alt="dog" />
  </div>
</div>

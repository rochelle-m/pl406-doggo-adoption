<script>
  import { Link } from "svelte-routing"
</script>

<style>
  img {
    filter: sepia(90%);
    width: 50%;
  }

  h4 + p {
    text-align: center;
    margin-top: 2em;
  }
</style>


<div class="container p-2 my-4">
  <div class="row d-flex justify-content-around">
    <div class="col-md-4">
      <h3>Unsure about adopting?</h3>
      <h4 class="text-muted mt-3">You can foster</h4>
      <p class="mt-5">
        Our team will guide you with any queries you may have
      </p>
      <Link to="/foster">
        <button class="btn">Foster</button>
      </Link>
    </div>

    <img src="/images/taxi-social-distancing.png" alt="dog" />
  </div>
</div>

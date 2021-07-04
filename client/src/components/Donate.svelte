<script>
  import Banner from "../utils/Banner.svelte";
  import DonationBasket from "../utils/DonationBasket.svelte";
  import { user } from "../stores/user";

  export let title = "Dog Adoption and Care · Donate";

  const message = "Donate";
  const imgSrc = "images/donate.jpg";

  let isStaff = false;

  user.subscribe((n) => {
    if (n) {
      isStaff = n.roles.some((role) => role == "ROLE_STAFF");
    }
  });

  let message1 = isStaff ? "Add Items" : "Donate Items";
  let message2 = isStaff ? "View Donations" : "Make a monetary donation";
</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<div>
  <Banner {message} {imgSrc} />

  <div
    class="d-flex justify-content-around mt-4 row container"
    style="margin: auto"
  >
    <div class="col-sm-4">
      <div class="card border-dark mb-3">
        <div class="card-header">
          <span class="d-inline-block"> {message1} </span>
          <span class="d-inline-block btn float-right">
            <i class="fas fa-box-open" />
          </span>
        </div>
      </div>
    </div>
    <div class="col-sm-4">
      <div
        class="card border-dark mb-3"
        data-toggle="modal"
        data-target="#payment"
        style="cursor: pointer;"
      >
        <div class="card-header">
          <span class="d-inline-block">{message2}</span>
          <span class="d-inline-block btn float-right">
            <i class="far fa-credit-card" />
          </span>
        </div>
      </div>
    </div>
  </div>

  <div
    class="modal fade"
    id="payment"
    tabindex="-1"
    role="dialog"
    aria-labelledby="exampleModalCenterTitle"
    aria-hidden="true"
  >
    <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLongTitle">
            Choose your payment amount
          </h5>
          <button
            type="button"
            class="close"
            data-dismiss="modal"
            aria-label="Close"
          >
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body" id="modal-body">
          <a href="/api/checkout/299" class="nav-link">
            <div class="card mb-3">
              <div class="card-header">₹ 299</div>
            </div>
          </a>
          <a href="/api/checkout/499" class="nav-link">
            <div class="card mb-3">
              <div class="card-header">₹ 499</div>
            </div>
          </a>
        </div>
      </div>
    </div>
  </div>

  <div class="container">
    {#if isStaff}
      <DonationBasket />
    {:else}
      <p> items here </p>
    {/if}
  </div>
  <small> All donations are exempted under the 80g certificate. </small>
</div>

<script>
  import { Link } from "svelte-routing";
  import { user } from "../stores/user";
  import { openModal } from "../stores/store";
  import AdoptionForm from "../components/AdoptionForm.svelte";

  export let src;
  export let doggo;

  let handleError = (el) => {
    el.target.error = null;
    el.target.src = "/images/icons/logo-w.png";
  };

  let isStaff = false;
  let isLoggedIn = false;

  user.subscribe((n) => {
    if (n) {
      isStaff = n.roles.some((role) => role == "ROLE_STAFF");
      isLoggedIn = n.isLoggedIn;
    }
  });

  let currentUser = {};
    user.subscribe((updatedUser) => {
      if (updatedUser) {
        currentUser = updatedUser;
      }
  });
   let doggos = [];
    let error = "";
    const URL = `/api/doggos/$(doggo.id}`;
  async function deleteDog() {
          const response = await fetch(URL, {
              method: 'DELETE',
              headers: {
              Authorization: token,
                  Authorization: currentUser.type + " " + currentUser.token
              }
          });
          const resData = 'resource deleted...';
      }
  }

</script>

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

  .fa {
    position: absolute;
    background: #333;
    padding: 8px;
    color: white;
    border-radius: 4px;
    opacity: 0.7;
  }

  .fa:hover {
    opacity: 0.9;
  }

  [class*="gear"] {
    right: 0em;
    cursor: pointer;
  }

  [class*="home"],
  [class*="marker"] {
    left: 0em;
  }

  @media (min-width: 576px) {
    .modal-dialog {
      max-width: 700px;
      margin: 1rem auto;
    }
  }
</style>

<article class="border rounded-lg m-2 mx-3 w-20 card">
  {#if isStaff}
    <i
      class="fa fa-gear"
      data-toggle="modal"
      data-target="#delete"
      aria-hidden="true" />

    <div
      class="modal fade"
      id="delete"
      tabindex="-1"
      role="dialog"
      aria-labelledby="exampleModalCenterTitle"
      aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLongTitle">
              Settings ·
              {doggo.name}
            </h5>
            <button
              type="button"
              class="close"
              data-dismiss="modal"
              aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="btn-group">
              <button type="button" class="btn-secondary mr-2">Mark as adopted</button>
              <button type="button" class="btn-secondary mr-2">Mark as fosted</button>
              <button type="button" on:click={()=>deleteDog()} class="btn-danger mr-2">Delete</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  {/if}

  {#if doggo?.location}
    <i class="fa fa-map-marker" style="text-transform: capitalize"> &nbsp; {doggo.location}</i>
  {:else}
    <i class="fa fa-home icon" aria-hidden="true" title="In Adoption Home" />
  {/if}

  <img class="card-img-top" {src} on:error={handleError} alt={doggo?.name} />

  <div class="card-body">
    <h4 class="card-title">
      <slot name="name" />
    </h4>

    <p class="card-text text-secondary" style="text-transform: lowercase">
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
    {#if isLoggedIn}
     <span data-toggle="modal" data-target="#adopt" class="pointer">Adopt</span>
     <a href="/" class="card-link">Foster</a>
    {:else}
        <div class="text-right">
          <button class="mt-4" on:click={() => openModal('login')}>Login
            to adopt/foster</button>
        </div>
    {/if}
  </div>
</article>

<div
  class="modal fade"
  id="adopt"
  tabindex="-1"
  role="dialog"
  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
       <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLongTitle">
           Adopt {doggo.name}
          </h5>
          <button
            type="button"
            class="close"
            data-dismiss="modal"
            aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
         </div>
         <div class="modal-body" id="exampleModalLongTitle">
              <AdoptionForm {doggo} />
        </div>
       </div>
  </div>
</div>

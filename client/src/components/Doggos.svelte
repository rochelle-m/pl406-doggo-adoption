<script>
  import { onMount } from "svelte";
  import Banner from "../utils/Banner.svelte";
  import Doggo from "../utils/Doggo.svelte";
  import Loading from "../utils/Loading.svelte";
  import BeforeYouAdopt from "../utils/BeforeYouAdopt.svelte";
  import { navigate } from "svelte-routing";
  import { user } from "../stores/user";
  import { openModal } from "../stores/store";
  import NewDoggo from "../components/Post.svelte";
  import { Link } from "svelte-routing";

  let isStaff = false;
  let currentUser = {};
  let openAddDogDialog = false;

  user.subscribe((n) => {
    if (n) {
      isStaff = n.roles.some((role) => role == "ROLE_STAFF");
      currentUser = n;
    }
  });

  export let title = "Dog Adoption and Care · Adopt";

  let doggos = [];
  let doggosToDisplay = []
  let error = "";
  const URL = `/api/doggos/`;
  let show = false;

  onMount(async function () {
    try {
      const response = await fetch(URL);
      doggos = await response.json();
      doggosToDisplay = doggos
      setTimeout(() => {
        show = true;
      }, 1500);
    } catch (_) {
      error = "Some error occured";
    }
  });

  let message = "Adopt";
  let imgSrc = "images/dog11.jpg";

  const showLoginDialog = () => {
    openModal("login");
  };

  let search = ""

  let handleChange = function () {
    doggosToDisplay = doggos.filter(doggo => doggo.location?.toLowerCase().startsWith(search.toLowerCase()))
  }

</script>

<style>
  .add {
    color: #302121;
  }

  .fab-container {
    display: flex;
    flex-direction: column;
    justify-content: flex-end;
    align-items: center;
    user-select: none;
    position: fixed;
    bottom: 30px;
    z-index: 999;
    right: 30px;
  }

  .fab {
    position: relative;
    height: 70px;
    width: 70px;
    background-color: pink;
    border-radius: 50%;
    z-index: 2;
  }

  .fab::before {
    content: " ";
    position: absolute;
    bottom: 0;
    right: 0;
    height: 35px;
    width: 35px;
    background-color: inherit;
    border-radius: 0 0 10px 0;
    z-index: -1;
  }

  .fab-content .material-icons {
    font-size: 32px;
  }
</style>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<div>
  <Banner {message} {imgSrc} />

   {#if isStaff}
          <Link to="applicant-list" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">View all applications</Link>
   {/if}
  <div class="input-group mt-2 px-4">
    <input
      type="search" placeholder="Search location"
      class="form-control"
      bind:value={search}
      aria-describedby="inputGroupPrepend3"
      on:input={handleChange}
      required />
     <span
      class="input-group-text pointer"
      id="inputGroupPrepend3"
      ><i class="fas fa-search" />
    </span>
  </div>

  <div class="d-flex flex-wrap justify-content-around my-4">
    {#each doggosToDisplay as doggo}
      {#if !Boolean(doggo.adopted || doggo.fostered)}
        <Doggo src={doggo.primaryImg} {doggo}>
          <p slot="name">{doggo.name}</p>
          <p slot="breed">{doggo.breed}</p>
          <p slot="description">{doggo.description}</p>
          {doggo.name}
        </Doggo>
      {:else if isStaff}
        <Doggo src={doggo.primaryImg} {doggo}>
          <p slot="name">{doggo.name + "*"}</p>
          <p slot="breed">{doggo.breed}</p>
          <p slot="description">{doggo.description}</p>
        </Doggo>
      {/if}
    {:else}
      <Loading message={error} />
    {/each}
  </div>
</div>

<BeforeYouAdopt {show} />

<div class="fab-container">
  {#if currentUser.isLoggedIn}
    <div class="fab shadow" data-toggle="modal" data-target="#post">
      <div class="fab-content">
        <span class="material-icons">
          <i class="fa fa-plus add" aria-hidden="true" />
          <i class="fas fa-dog add" />
        </span>
      </div>
    </div>
  {:else}
    <div class="fab shadow" on:click={showLoginDialog}>
      <div class="fab-content">
        <span class="material-icons">
          <i class="fa fa-plus add" aria-hidden="true" />
          <i class="fas fa-dog add" />
        </span>
      </div>
    </div>
  {/if}
</div>

  <div
    class="modal fade"
    id="post"
    tabindex="-1"
    role="dialog"
    aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLongTitle">
            Put a dog up for adoption
          </h5>
          <button
            type="button"
            class="close"
            data-dismiss="modal"
            aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body" id="modal-body">
          <NewDoggo />
        </div>
      </div>
    </div>
  </div>

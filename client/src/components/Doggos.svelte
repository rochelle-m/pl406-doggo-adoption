<script>
  import { onMount } from "svelte";
  import Banner from "../utils/Banner.svelte";
  import Doggo from "../utils/Doggo.svelte";
  import Loading from "../utils/Loading.svelte";
  import BeforeYouAdopt from "../utils/BeforeYouAdopt.svelte";
  import { Link } from "svelte-routing";
  import { user } from "../stores/user";
  import { openModal } from "../stores/store";

  let isStaff = false;
  let currentUser = {};
  let openAddDogDialog = false;

  user.subscribe((n) => {
    if (n) {
      isStaff = n.roles.some((role) => role == "ROLE_STAFF");
      currentUser = n;

      currentUser.isLoggedIn &&
        openAddDogDialog &&
        window.open("/post", "_self");
    }
  });

  export let title = "Dog Adoption and Care · Adopt";

  let doggos = [];
  let error = "";
  const URL = `/api/doggos/`;
  let show = false;

  onMount(async function () {
    try {
      const response = await fetch(URL);
      doggos = await response.json();

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
    openAddDogDialog = true;
  };
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
  <div class="d-flex flex-wrap justify-content-around my-4">
    {#each doggos as doggo}
      {#if !doggo.isAdopted && !doggo.isFostered}
        <Doggo src={doggo.primaryImg} {doggo}>
          <p slot="name">{doggo.name}</p>
          <p slot="breed">{doggo.breed}</p>
          <p slot="description">{doggo.description}</p>
        </Doggo>
      {:else if isStaff}
        <Doggo src={doggo.primaryImg} {doggo}>
          <p slot="name">{doggo.name}</p>
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
  {#if !currentUser.isLoggedIn}
    <Link to="post">
      <div class="fab shadow">
        <div class="fab-content">
          <span class="material-icons">
            <i class="fa fa-plus add" aria-hidden="true" />
            <i class="fas fa-dog add" />
          </span>
        </div>
      </div>
    </Link>
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

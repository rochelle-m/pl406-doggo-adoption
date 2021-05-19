<script>
  import Banner from "./Banner.svelte";
  import { openModal } from "../stores/store";
  import { user } from "../stores/user";

  export let title = "Dog Adoption and Care · Volunteer";

  let message = "Volunteer";
  let imgSrc = "images/volunteer.jpg";

  let isVolunteer

  user.subscribe(n => {
    if (n) {
      isVolunteer = n.isLoggedIn && n.roles.some(role => role == "ROLE_VOLUNTEER")
    }
  })
  
</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<div>
  <Banner {message} {imgSrc} />
  {#if !isVolunteer}
  <h4 class="py-3">Register as a volunteer</h4>
  <div class="container d-flex justify-content-center flex-sm-wrap mb-4">

    <div class="card border m-2" on:click={() => openModal("signup", "Caretaker")}>
      <div class="card-body">
        <div>
          <i class="fas fa-hand-holding-heart float-left md-2" />
        </div>
        <br/>
        <h5 class="card-title float-left pt-3">Caretaker</h5>
        <p class="card-text">Assist with daily activities - feeding dogs, bathing dogs and maintaining a clean shelter.</p>
      </div>
    </div>

    <div class="card border m-2" on:click={() => openModal("signup", "Driver")}>
      <div class="card-body">
        <div>
          <i class="fas fa-truck float-left md-2"/>
        </div>
        <br/>
        <h5 class="card-title float-left pt-3">Driver</h5>
        <p class="card-text ">Transport dogs to and from the shelter and run other errands.</p>
      </div>
    </div>

    <div class="card border m-2" on:click={() => openModal("signup", "Photographer")}>
      <div class="card-body">
        <div>
          <i class="fas fa-camera-retro float-left md-2"/>
        </div>
        <br/>
        <h5 class="card-title float-left pt-3">Photographer</h5>
        <p class="card-text ">Capture the most amazing dog pictures to help them find their home.</p>
      </div>
    </div>

    <div class="card border m-2" on:click={() => openModal("signup", "Promoter")}>
      <div class="card-body">
        <div>
          <i class="fas fa-user-tag float-left md-2"/>
        </div>
        <br/>
        <h5 class="card-title float-left pt-3">Promoter</h5>
        <p class="card-text ">Gather support for the shelter and assist with events.</p>
      </div>
    </div>
  </div>
  {/if}
</div>

<style>
  .card {
    box-shadow: 0 6px 10px rgba(0,0,0,.1), 0 0 6px rgba(0,0,0,.04);
    transition: .3s transform linear;
    cursor: pointer;
    max-width: 18vw; 
    min-width:8em;
  }

  .card:hover{
    transform: scale(1.01);
    box-shadow: 0 10px 16px rgba(0,0,0,.12), 0 4px 8px rgba(0,0,0,.05);
  }

  i {
    font-size: larger;
  }

  .card-text {
    display: inline-block;
    text-align: left;
    color: #666;
    font-size: 1.4vw;
  }

  .card-title {
    font-size: 1.8vw;
  }

  @media (max-width: 589px) {  
    div.container {
      flex-direction: column;
    }

    .card {
      max-width: 80vw;
    }
  }
</style>

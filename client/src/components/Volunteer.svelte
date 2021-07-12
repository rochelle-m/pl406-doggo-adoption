<script>
  import Banner from "../utils/Banner.svelte";
  import { openModal } from "../stores/store";
  import { user } from "../stores/user";
  import { update } from "../modules/auth";

  export let title = "Dog Adoption and Care · Volunteer";

  let message = "Volunteer";
  let imgSrc = "images/banner/volunteer.jpg";

  let isVolunteer = false
  let isLoggedIn = false

  user.subscribe(n => {
    if (n) {
      isVolunteer = n.roles.some(role => role == "ROLE_VOLUNTEER")
      isLoggedIn = n.isLoggedIn
    }
  })

  const handleClick = async(role) => {
    isLoggedIn ? await update(role) : openModal("signup", role)
  }
  
</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<div>
  <Banner {message} {imgSrc} />
  {#if !isVolunteer}
  <h4 class="py-3">Register as a volunteer</h4>
  <div class="container d-flex justify-content-center flex-sm-wrap mb-4">

    <div class="card border m-2" >
      <div class="card-body">
        <div>
          <img src="/images/icons/icons8-dog-heart-64.png" class="float-left md-2" alt=""/>
        </div>
        <br/>
        <h5 class="card-title float-left pt-3">Caretaker</h5>
        <p class="card-text">Assist with daily activities - feeding dogs, bathing dogs and maintaining a clean shelter.</p>
      </div>
      <div class="footer">
        
        <button on:click={() => handleClick("Caretaker")} class="btn">Volunteer</button>
      </div>
    </div>

    <div class="card border m-2">
      <div class="card-body">
        <div>
          <img src="/images/icons/icons8-driver-50.png" class="float-left md-2" alt=""/>
        </div>
        <br/>
        <h5 class="card-title float-left pt-3">Driver</h5>
        <p class="card-text ">Transport dogs to and from the shelter and run other errands.</p>
      </div>
      <div class="footer">
        <button on:click={() => handleClick("Driver")} class="btn">Volunteer</button>
      </div>
    </div>

    <div class="card border m-2">
      <div class="card-body">
        <div>
          <img src="/images/icons/icons8-photographer.png" class="float-left md-2" alt=""/>
        </div>
        <br/>
        <h5 class="card-title float-left pt-3">Photographer</h5>
        <p class="card-text ">Capture the most amazing dog pictures to help them find their home.</p>
      </div>
      <div class="footer">
        <button on:click={() => handleClick("Photographer")} class="btn">Volunteer</button>
      </div>
    </div>

    <div class="card border m-2">
      <div class="card-body">
        <div>
          <img 
            src="/images/icons/noun_Business Promotion_2389771.png" 
            class="float-left md-2 w-25" alt=""/>
        </div>
        <br/>
        <h5 class="card-title float-left pt-3">Promoter</h5>
        <p class="card-text ">Gather support for the shelter and assist with events.</p>
      </div>
      <div class="footer">
        <button on:click={() => handleClick("Promoter")} class="btn">Volunteer</button>
      </div>
    </div>
  </div>
  {/if}
</div>

<style>
  .card {
    box-shadow: 0 6px 10px rgba(0,0,0,.1), 0 0 6px rgba(0,0,0,.04);
    transition: .3s transform linear;
    max-width: 18vw; 
    min-width:8em;
  }

  .card:hover{
    transform: scale(1.01);
    box-shadow: 0 10px 16px rgba(0,0,0,.12), 0 4px 8px rgba(0,0,0,.05);
  }

  .card-text {
    display: inline-block;
    text-align: left;
    color: #666;
    font-size: 1.4vw;
  }

  .card-title {
    font-size: 1.8vw;
    clear: left;
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

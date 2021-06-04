<script>
  import { fly } from "svelte/transition";
  export let show = true;

  const dismiss = () => {
    show = false;
  };

  const ARROW_DOWN = "▾";
  const ARROW_UP = "▴";

  const expand = (event) => {
    const arrow = event.target;
    const main = document.getElementById("before-you-adopt");

    if(arrow.innerHTML == ARROW_UP) {
        arrow.innerHTML = ARROW_DOWN
        main.style.bottom = "5vh"
    }
    else {
        arrow.innerHTML = ARROW_UP
        main.style.bottom = "-75vh"
    }
  };

  let imgSrc = "/images/beforeadopt.jpeg";
</script>

{#if show}
  <div
    id="before-you-adopt"
    in:fly={{ y: 100, duration: 2000 }}
    out:fly={{ y: 100, duration: 1000 }}
  >
    <div class="card mb-3 w-75">
      <div class="card-header text-white">
        <h6 class="d-inline float-left">Before You Adopt</h6>
        <span
          class="float-right px-1"
          title="Dismiss"
          style="cursor:pointer;"
          on:click={dismiss}
        >
          ×
        </span>
        <span
          class="float-right px-4"
          title="Dismiss"
          style="cursor:pointer;"
          on:click={expand}
        >
          {ARROW_UP}
        </span>
      </div>
      <div class="card-body" style="height:70vh">
        <h5 class="card-title"><b>Adopt responsibly or save lives while you foster !</b></h5>
        <p class="card-text">We feel so blessed when people reach out to adopt indie!</p>
        <img src={imgSrc} alt="doggo" />
        <p class="card-text">We try to understand sudden surges in adoptions and fostering of our rescues to ensure happy homes for them.</p>
        <p class="card-text">When it comes to adopting we request you to understand the commitment and responsibilities of bringng an animal home before looking for one to adopt.</p>
        <p class="card-text">While you may be working from home, the animal will be with you. When circumtances eventually go back to normal, who will be caring for your pet while you are at work all day?</p>
        <p class="card-text">All animals need a certain level of time, care and love. Its huge responsibility to have a pet at home, young, growing or old. All we request you is think of these situations not just for now but taking into account the future too.</p>
        <p class="card-text">If you are not confident about the future, there is always the option of fostering which allows you to have pet with you while you are able to dedicate the required time and attention and it also saves the foster pets life.</p>
      </div>
    </div>
  </div>
{/if}

<style>
  .card-header {
    background-color: #302121e6;
  }

  #before-you-adopt {
    display: grid;
    place-items: center;
    position: fixed;
    width: 100%;
    transition: 0.4s linear;
    bottom: -75vh;
    z-index: 399;
  }

  .card {
    box-shadow: 10px 10px 10px #333;
  }

  img{
  height:100px;
  width:100px;
  border-radius:50px;
  }
</style>

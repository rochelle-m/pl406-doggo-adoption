<script>
  import Loading from "./Loading.svelte"

  import { close, volunteerRole } from "../stores/store";
  import { logOn } from "../modules/auth";
  import { fade } from "svelte/transition";

  export let token;
  let tokens = Object.keys(logOn);
  let currentIndex = tokens.findIndex((i) => i == token);
  let current = logOn[tokens[currentIndex]];

  let email;
  let username;
  let password;
  let message = ""
  let loading = false;
  let volunteer = null

  volunteerRole.subscribe(n => {
    volunteer = n
  })

  let change = () => {
    email = username = password = message = ""
    currentIndex ^= 1;
    current = logOn[tokens[currentIndex]];
  };

  let sendRequest = async function () {
    loading = true

    let roles = volunteer ? ["volunteer"] : ["user"]
    let status = await current.request({
      email,
      username,
      password,
      roles
    }, volunteer);
    if(status) {
      close()
    }
    else {
      message = current.title + " failed"
    }
    loading = false
  }
   
</script>

<div class="modal" in:fade out:fade>
  <div class="backdrop" on:dblclick={close} />
  <div class="content-wrapper">
    <div class="content">
      <div class="close" on:click={close}>×</div>
      <div class="img-bg">
        <img src={current.banner} alt="banner" />
      </div>
      <h2 class="message">
        {#if volunteer} 
          <small style="font-size: 1vw;">{volunteer}</small>
          <br/>
        {/if}
        {current.title}
      </h2>
      <div class="container">
        {#if !loading}
        <form on:submit|preventDefault={sendRequest}>
          {#if message}
          <div class="alert alert-warning" role="alert">
            {message}
          </div>
          {/if}
          {#if currentIndex}
            <div class="form-group">
              <label for="email">Email</label>
              <input
                bind:value={email}
                type="email"
                class="form-control"
                id="email"
                required
              />
            </div>
          {/if}

          <div class="form-group">
            <label for="username">Username</label>
            <input
              bind:value={username}
              type="text"
              class="form-control"
              id="username"
              required
            />
          </div>

          <div class="form-group">
            <label for="password">Password</label>
            <input
              bind:value={password}
              type="password"
              class="form-control"
              id="password"
              required
            />
          </div>

          <div class="form-group text-center">
            <button type="submit">
              <span id="load" />
              {current.title}
            </button>
            {#if !volunteer}
            <span class="d-block mt-2" on:click={change}>
              <u>{current.alt}</u>
            </span>
            {/if}
          </div>
        </form>
        {:else} 
          <Loading alt={current.title + " in progress"}/>
        {/if}
      </div>
    </div>
  </div>
</div>

<style>
  div.modal {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  div.backdrop {
    position: absolute;
    width: 100%;
    height: 100%;
    background-color: rgba(50, 50, 50, 0.5);
  }

  div.content-wrapper {
    z-index: 10;
    width: 40vw;
    border-radius: 0.3rem;
    background-color: white;
    overflow: hidden;
  }

  div.content {
    max-height: 95vh;
    overflow: auto;
  }

  form .form-group {
    text-align: left;
  }

  form {
    margin-top: -20px;
  }

  h2.message {
    position: relative;
    z-index: 10;
    top: -15vh;
    font-size: 5vmin;
    margin: auto;
    width: fit-content;
    text-align: center;
    display: block;
    padding-bottom: 10px;
    text-transform: uppercase;
    border-bottom: 1px solid rgb(255, 254, 254);
    color: white;
  }

  div.close {
    position: relative;
    left: -1em;
    top: 10px;
    cursor: pointer;
    font-size: 2vw;
    margin-bottom: -50px;
    color: white;
    z-index: 1033;
  }

  div.img-bg {
    width: inherit;
    height: 28vh;
    background: gray;
  }

  img {
    filter: brightness(40%);
    width: 100%;
    height: 28vh;
  }

  div > span {
    cursor: pointer;
  }

   @media (max-width: 792px) {  
    div.content-wrapper {
      width: 55vw;
    }
  }
</style>

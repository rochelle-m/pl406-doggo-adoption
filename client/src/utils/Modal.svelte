<script>
  import { close } from "../stores/store";
  import { user } from "../stores/user";

  import formContent from "../modules/forms";
  import post from "../modules/request";
  import { fade } from "svelte/transition";

  export let token;
  let tokens = Object.keys(formContent);
  let currentIndex = tokens.findIndex((i) => i == token);
  let current = formContent[tokens[currentIndex]];
  let baseUrl = `http://localhost:5001/api/auth/`;

  let errors = {
    username: "",
    password: "",
    email: "",
  };

  let email;
  let username;
  let password;
  
  let message = ""

  let change = () => {
    email = username = password = message = ""
    currentIndex ^= 1;
    current = formContent[tokens[currentIndex]];
  };


  let sendRequest = async function () {
    document
      .getElementById("load")
      .classList.add("spinner-grow", "spinner-grow-sm");

    let data = {
      email,
      password,
      username,
      roles: ["user"]
    };

    const url = baseUrl + current.endpoint;

    const response = await post(url, data);

    if (response.ok){
      message = ""
      if(current.endpoint == "signin")
        user.add(await response.json())  
      close()
    }
    else {
      message = current.title + " failed"
    }

    document
      .getElementById("load")
      .classList.remove("spinner-grow", "spinner-grow-sm");
  };
</script>

<div class="modal" in:fade out:fade>
  <div class="backdrop" on:dblclick={close} />
  <div class="content-wrapper">
    <div class="content">
      <div class="close" on:click={close}>×</div>

      <div class="img-bg">
        <img src={current.banner} alt="banner" />
      </div>
      <h2 class="message">{current.title}</h2>
      <div class="container">
        <form on:submit|preventDefault={sendRequest}>
        <div class="status text-danger">{message}</div>
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
              <small id="emailError" class="text-warning">
                {errors["email"]}
              </small>
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
            <small id="usernameError" class="text-warning">
              {errors["username"]}</small
            >
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
            <small id="passwordError" class="text-warning">
              {errors["password"]}
            </small>
          </div>

          <div class="form-group text-center">
            <button type="submit">
              <span class="" id="load" />
              {current.title}
            </button>
            <span class="d-block mt-2" on:click={change}>
              <u>{current.alt}</u>
            </span>
          </div>
        </form>
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
    max-width: 40vw;
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
</style>

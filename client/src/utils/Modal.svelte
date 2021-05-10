<script>
  import { login, signup } from "../stores/store";
  export let message;

  let imgSrc = "/images/dog13.jpg";
  let showSignUp = message == "Sign up";

  let alt = showSignUp ? "Login" : "Sign up";
  let endpoint = showSignUp ? "signup" : "signin";
  let url = `http://localhost:5001/api/${endpoint}/`;

  let errors = {
    username: "",
    password: "",
    email: "",
  };

  let close = () => {
    login.update((_) => false);
    signup.update((_) => false);
  };

  let change = () => {
    showSignUp = !showSignUp;

    if (showSignUp) {
      endpoint = "signup";
      message = "Sign up";
      alt = "Login";
    } else {
      endpoint = "signin";
      message = "Login";
      alt = "Sign up";
    }
    url = `http://localhost:5001/api/${endpoint}/`;
    console.log(url);
  };

  let email = "";
  let username = "";
  let password = "";

  let sendRequest = function (event) {
    event.preventDefault();
    // display loading, disable button ...
    // send request
    // get result => suspend loading
  };
</script>

<div class="modal">
  <div class="backdrop" />
  <div class="content-wrapper">
    <div class="content">
      <div class="close" on:click={close}>×</div>
      <img src={imgSrc} alt="banner" />
      <h2 class="message">{message}</h2>
      <div class="container">
        <form>
          {#if showSignUp}
            <div class="form-group">
              <label for="email">Email</label>
              <input
                bind:value={email}
                type="email"
                class="form-control"
                id="email"
              />
              <small id="emailError" class="text-warning"
                >{errors["email"]}</small
              >
            </div>
          {/if}

          <div class="form-group">
            <label for="username">Username</label>
            <input
              bind:value={username}
              type="text"
              class="form-control"
              id="username"
            />
            <small id="usernameError" class="text-warning"
              >{errors["username"]}</small
            >
          </div>

          <div class="form-group">
            <label for="password">Password</label>
            <input
              bind:value={password}
              type="password"
              class="form-control"
              id="password"
            />
            <small id="passwordError" class="text-warning"
              >{errors["password"]}</small
            >
          </div>

          <div class="form-group text-center">
            <button type="submit" on:click={sendRequest}> {message}</button>
            <span class="d-block mt-2" on:click={change}> <u>{alt}</u> </span>
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
    max-width: 50vw;
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
    top: -12vw;
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

  img {
    filter: brightness(40%);
    width: 100%;
    height: 15vmax;
  }

  div > span {
    cursor: pointer;
  }
</style>

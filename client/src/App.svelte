<script>
  import { Router, Route } from "svelte-routing";
  import Home from "./components/Home.svelte";
  import Doggos from "./components/Doggos.svelte";
  import Donate from "./components/Donate.svelte";
  import Foster from "./components/Foster.svelte";
  import Volunteer from "./components/Volunteer.svelte";
  import Events from "./components/Events.svelte";
  import PetFood from "./components/PetFood.svelte";
  import Vaccination from "./components/Vaccination.svelte";
  import Footer from "./components/Footer.svelte";
  import Navbar from "./components/Navbar.svelte";

  import Modal from "./utils/Modal.svelte";
  import { login, signup } from "./stores/store";

  let showSignup, showLogin;

  login.subscribe(newValue	=>	{ showLogin = newValue});
  signup.subscribe(newValue	=>	{ showSignup = newValue});

  const openModal = (type) => {
    if (type === "login") {
      login.update((_) => true);
      signup.update((_) => false);
    }
    if (type === "signup") {
      signup.update((_) => true);
      login.update((_) => false);
    }
  };
</script>

<main>
  <Router>
    <Navbar />
    <Route path="/"><Home /></Route>
    <Route path="adopt"><Doggos /></Route>
    <Route path="donate"><Donate /></Route>
    <Route path="foster"><Foster /></Route>
    <Route path="volunteer"><Volunteer /></Route>
    <Route path="events"><Events /></Route>
    <Route path="food"><PetFood /></Route>
    <Route path="vaccination"><Vaccination /></Route>
    
    <!-- temp -->
    <button on:click={() => openModal("login")}> Login </button>
    <button on:click={() => openModal("signup")}> Signup </button>
    {#if showLogin}
    <Modal message="Login" />
    {/if}
    {#if showSignup}
    <Modal message="Sign up" />
    {/if}

    <Footer />
  </Router>
</main>

<style>
  main {
    text-align: center;
    margin: 0 auto;
  }
</style>

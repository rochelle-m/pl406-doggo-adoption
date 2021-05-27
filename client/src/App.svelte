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
  import AdoptionForm from "./components/AdoptionForm.svelte";
  import Post from "./components/Post.svelte";




  import Modal from "./utils/Modal.svelte";
  import { login, signup, openModal } from "./stores/store";

  

  let showSignup, showLogin;

  login.subscribe((newValue) => {
    showLogin = newValue;
  });
  signup.subscribe((newValue) => {
    showSignup = newValue;
  });

  import Message from "./utils/Message.svelte";

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
    <Route path="adoptionform"><AdoptionForm /></Route>
    <Route path="post"><Post /></Route>


    
    
    <!-- temp -->
    <button on:click={() => openModal("login")}> Login </button>
    <button on:click={() => openModal("signup")}> Signup </button>
    {#if showLogin}
      <Modal token="login" />
    {/if}
    {#if showSignup}
      <Modal token="signup" />
    {/if}


    <Route><Message message="Page not found" /></Route>

    <Footer />
  </Router>
</main>

<style>
  main {
    text-align: center;
    margin: 0 auto;
  }
</style>

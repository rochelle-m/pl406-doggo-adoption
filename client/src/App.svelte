<script>
  import { Router, Route } from "svelte-routing";
  import Home from "./components/Home.svelte";
  import Doggos from "./components/Doggos.svelte";
  import Donate from "./components/Donate.svelte";
  import Foster from "./components/Foster.svelte";
  import Volunteer from "./components/Volunteer.svelte";
  import Events from "./components/Events.svelte";
  import Help from "./components/Help.svelte";
  import Footer from "./utils/Footer.svelte";
  import Navbar from "./components/Navbar.svelte";
  import AdoptionForm from "./components/AdoptionForm.svelte";
  import Post from "./components/Post.svelte";
  import RegisterEvent from "./components/RegisterEvent.svelte";
  
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
    <Route path="help"><Help /></Route>
    <Route path="post"><Post /></Route>
    <Route path="adoption-form"><AdoptionForm /></Route>
    <Route path="registerevent"><RegisterEvent /></Route>
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

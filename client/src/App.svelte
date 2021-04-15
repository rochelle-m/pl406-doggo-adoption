<script>
  import { Router, Route } from "svelte-routing";
  import Home from "./components/Home.svelte";
  import Doggos from "./components/Doggos.svelte";
  import Donate from "./components/Donate.svelte";
  import Foster from "./components/Foster.svelte";
  import Volunteer from "./components/Volunteer.svelte";
  import Footer from "./components/Footer.svelte";
  import Navbar from "./components/Navbar.svelte";


</script>

<main>
  <Router>
    <Navbar />
    <Route path="/"><Home /></Route>
    <Route path="adopt"><Doggos /></Route>
    <Route path="donate"><Donate /></Route>
    <Route path="foster"><Foster /></Route>
    <Route path="volunteer"><Volunteer /></Route>
    <Footer />
  </Router>
</main>

<style>
  main {
    text-align: center;
    margin: 0 auto;
  }

</style>

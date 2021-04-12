<script>
  import { Router, Route, Link } from "svelte-routing";
  import Home from "./components/Home.svelte";
  import Doggos from "./components/Doggos.svelte";
  import Footer from "./components/Footer.svelte";
  import Navbar from "./components/Navbar.svelte";

</script>

<main>
  <Router>
    <Navbar />
    <Route path="/"><Home /></Route>
    <Route path="adopt"><Doggos /></Route>
    <Footer />
  </Router>
</main>

<style>
  main {
    text-align: center;
    margin: 0 auto;
  }

</style>

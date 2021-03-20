<script>
	import { Router, Route, Link } from "svelte-routing";
	import Home from './components/Home.svelte'
	import Footer from './components/Footer.svelte'
</script>

<main>
  <Router>
  <nav class="pt-2 pb-2">
    nav
    <!-- @S add nav items (use Link) -->
  </nav>
    <!-- add routes -->
    <Route path="/"><Home /></Route>
  </Router>
	<Footer/>
</main>

<style>
	main {
		text-align: center;
		margin: 0 auto;
	}

	@media (min-width: 640px) {
		
	}
</style>
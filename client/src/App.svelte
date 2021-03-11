<script>
	import NavigationBar from './components/NavigationBar.svelte'
	import Carousel from './components/Carousel.svelte'
	import Footer from './components/Footer.svelte'
</script>

<main>
	<NavigationBar/>
	<Carousel/>
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
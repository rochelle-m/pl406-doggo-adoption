<script>
  import Banner from "../utils/Banner.svelte";
  import Map from '../utils/Map.svelte';
	import Marker from '../utils/Marker.svelte';

  export let title = "Dog Adoption and Care · Vaccination";

  let message = "Vaccination Center";
  let imgSrc = "images/vaccine.jpg";
</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<div class="pd-2">
  <Banner {message} {imgSrc} />

  <div class="p-4">
    <Map lat={15.49} lon={73.8} zoom={11.0}>
      <Marker lat={15.5166} lon={73.7689} label="Happy Paws" type="vet"/>
      <Marker lat={15.4650} lon={73.8657} label="Happy Paws" type="shop"/>
    </Map>
  </div>
</div>


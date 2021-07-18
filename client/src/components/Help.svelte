<script>
  import Banner from "../utils/Banner.svelte";
  import Map from "../utils/Map.svelte";
  import Marker from "../utils/Marker.svelte";
  import { petShops, vetClinics } from "../stores/help";

  export let title = "Help · Dog Adoption and Care";

  const message = "Help";
  const imgSrc = "images/banner/help.jpg";
</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<Banner {message} {imgSrc} />
<div class="mx-auto container mt-4">
  <h2 class="bg-secondary-100 py-3 rounded">Pet Shops</h2>
  <div class="row d-flex justify-content-center my-2">
    {#each petShops as shop}
      <div class="col col-md-3 card m-2">
        <div class="card-header">{shop.name}</div>
        <div class="card-body text-info">
          <p class="card-text">{shop.location}</p>
          <p class="card-text">{shop.opening || ""}</p>
          <p class="card-text">{shop.contact || ""}</p>
          <p class="card-text">{shop.type}</p>
        </div>
      </div>
    {/each}
  </div>

  <h2 class="bg-secondary-100 py-3 rounded">Vet Clinics</h2>
  <div class="row d-flex justify-content-center">
    {#each vetClinics as clinic}
      <div class="col col-md-3 card m-2">
        <div class="card-header">{clinic.name}</div>
        <div class="card-body text-info">
          <p class="card-text">{clinic.location}</p>
          <p class="card-text">{clinic.opening || ""}</p>
          <p class="card-text">{clinic.contact || ""}</p>
          <p class="card-text">{clinic.misc}</p>
        </div>
      </div>
    {/each}
  </div>
</div>

<div class="p-4">
  <Map lat={15.49} lon={73.8} zoom={11.0}>
    {#each petShops as { lat, lon, name }}
      <Marker {lat} {lon} label={name} type="shop" />
    {/each}

    {#each vetClinics as { lat, lon, name }}
      <Marker {lon} {lat} label={name} type="vet" />
    {/each}
  </Map>
</div>

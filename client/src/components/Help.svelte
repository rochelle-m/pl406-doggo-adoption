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
  <h2 class="bg-secondary-100 py-2 rounded">
    <img src="/images/icons8-shop-50.png" alt="pet shop icons" />Pet Shops
  </h2>
  <div class="row d-flex justify-content-center my-2">
    {#each petShops as shop}
      <div class="col col-md-3 card m-2">
        <a href={`#${shop.name}`}>
          <div class="card-header h5 text-capitalize">{shop.name.toLowerCase()}</div>
          <div class="card-body">
            <p class="card-text">
              <i
                class="fas fa-map-marker-alt bg-secondary-100 p-1 rounded mr-1"
              />{shop.location}
            </p>
            <p class="card-text">
              <i
                class="far fa-clock bg-secondary-100 p-1 rounded mr-1"
              />{shop.opening || ""}
            </p>
            <a href={`tel:${shop.contact}`}>
              <i
                class="fas fa-phone-alt bg-secondary-100 p-1 rounded mr-1"
              />{shop.contact || "Unavailable"}
            </a>
          </div>
        </a>
      </div>
    {/each}
  </div>

  <h2 class="bg-secondary-100 py-2 rounded">
    <img src="/images/icons8-vet.png" alt="vet clinic icons" /> Vet Clinics
  </h2> 
  <div class="row d-flex justify-content-center">
    {#each vetClinics as clinic}
      <div class="col col-md-3 card m-2">
        <a href={`#${clinic.name}`}>
          <div class="card-header h5 text-capitalize">{clinic.name.toLowerCase()}</div>
          <div class="card-body">
            <p class="card-text">
              <i
                class="fas fa-map-marker-alt bg-secondary-100 p-1 rounded mr-1"
              />{clinic.location}
            </p>
            <p class="card-text">
              <i
                class="far fa-clock bg-secondary-100 p-1 rounded mr-1"
              />{clinic.opening || ""}
            </p>
            <a href={`tel:${clinic.contact}`}>
              <i
                class="fas fa-phone-alt bg-secondary-100 p-1 rounded mr-1"
              />{clinic.contact || "Unavailable"}
            </a>
            <p class="card-text">{clinic.misc || ""}</p>
          </div>
        </a>
      </div>
    {/each}
  </div>

  <h2 class="bg-secondary-100 py-2 rounded">
    <img src="/images/pale-453.png" alt="vet clinic icons" width="40" /> Pet Helpline Number
  </h2> 
  <div class="row d-flex justify-content-center">
      <div class="col col-md-8 card m-2">
      
          <div class="card-body">
            <a href={`tel:9820122602`} class="py-2 d-block">
            <p class="card-text">
              If you need to report a situation involving an animal in immediate
              danger, please call our emergency number:
            </p>
  
            <p>
              <i
                class="fas fa-phone-alt bg-secondary-100 p-1 rounded mr-1"
              />{ "9820122602"}
            </p>
              <p class="card-text">
                If animal is injured, please remain with the animal until help is
                secured.
              </p>
            </a>
          </div>
       
      </div>
  </div>
</div>

<div class="p-4">
  <Map lat={15.49} lon={73.8} zoom={11.0}>
    {#each [...petShops, ...vetClinics] as { lat, lon, name, type }}
      <div id={name}>
        <Marker {lat} {lon} label={name} {type} />
      </div>
    {/each}
  </Map>
</div>

<style>
  .card:hover {
    border: 1px solid #aaa;
    background: #eee;
  }

  a,
  a:hover {
    text-decoration: none;
    color: #333;
  }
</style>

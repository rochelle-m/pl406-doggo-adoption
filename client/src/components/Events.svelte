<script>
  import Banner from "../utils/Banner.svelte";
  import { Link } from "svelte-routing";
  import { events, gallery } from "../stores/events";

  export let title = "Events · Dog Adoption and Care";

  let message = "Events";
  let imgSrc = "images/banner/event2.jpg";
</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<div>
  <Banner {message} {imgSrc} />
</div>

<div class="container col-md-10 my-3 mx-auto">
  <h2 class="mb-4 bg-secondary-100 py-3 rounded"><img src="/images/pluto-45.png" alt="events" width="40"> Upcoming events</h2>
  <div class="event d-flex flex-wrap my-2 justify-content-center">
    {#each events as event}
      <div class="border mx-2 p-4">
        <h3 class="title ">{event.name}</h3>
        <img class="logo" src={event.src} alt={event.name} />
        <h6>{event.date}</h6>
        <p>{event.location}</p>
        <Link class="btn register" to="registerevent">Register</Link>
      </div>
    {/each}
  </div>

  <h2 class="my-4 bg-secondary-100 py-3 rounded "><img src="/images/clip-1406.png" alt="gallery" width="40"> Gallery</h2>
  <div class="event d-flex flex-wrap my-2 justify-content-center">
    {#each gallery as galleryItem}
      <div class="col-md-4">
        <div class="thumbnail p-1">
          <a href={galleryItem.img} target="_blank">
            <img
              src={galleryItem.img}
              alt={galleryItem.caption}
              style="width:100%"
              class=".img-thumbnail"
            />
            <div class="caption mt-2">
              <h6>{galleryItem.caption}</h6>
            </div>
          </a>
        </div>
      </div>
    {/each}
  </div>
</div>

<style>
  .logo {
    width: 180px;
    height: 150px;
  }

  .title {
    font-size: 23px;
  }
</style>

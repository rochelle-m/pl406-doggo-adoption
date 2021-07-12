<script>
  import { carouselItems } from "../stores/carousel";
</script>

<div id="demo" class="carousel slide" data-ride="carousel">
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active" />
    <li data-target="#demo" data-slide-to="1" />
    <li data-target="#demo" data-slide-to="2" />
    <li data-target="#demo" data-slide-to="3" />
  </ul>

  <!-- The slideshow -->
  <div class="carousel-inner">
    {#each carouselItems as item, key}
      <div class={"carousel-item" + (key ? "" : " active")}>
        <img src={item.img.src} alt={item.img.alt} width="100%" />
      </div>
    {/each}
  </div>

  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon" />
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon" />
  </a>
</div>

<style>
  img {
    filter: brightness(60%);
  }
</style>

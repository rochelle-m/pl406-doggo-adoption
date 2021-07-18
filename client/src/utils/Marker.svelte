<script>
  import { getContext } from "svelte";
  import { mapbox, key } from "./mapbox.js";

  const icons = {
    vet: "url(/images/icons8-vet.png)",
    shop: "url(/images/icons8-shop-50.png)",
  };

  const { getMap } = getContext(key);
  const map = getMap();

  export let lat;
  export let lon;
  export let label;
  export let type;

  const popup = new mapbox.Popup({ offset: 25 }).setText(label);

  var stop = document.createElement("div");
  stop.className = "marker";
  stop.style.backgroundImage = icons[type];
  stop.style.backgroundColor = "rgba(204, 204, 204, 0.5)";
  stop.style.borderRadius = "4px";
  stop.style.width = 40 + "px";
  stop.style.height = 40 + "px";
  stop.style.backgroundSize = "100%";

  new mapbox.Marker(stop).setLngLat([lon, lat]).setPopup(popup).addTo(map);
</script>

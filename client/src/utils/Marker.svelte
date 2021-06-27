<script>
	import { getContext } from "svelte";
	import { mapbox, key } from "./mapbox.js";

	const icons = {
		vet: "url(/icons8-vet.png)",
		shop: "url(/icons8-shop-50.png)",
	};

	const { getMap } = getContext(key);
	const map = getMap();

	export let lat;
	export let lon;
	export let label;
	export let type;

	const popup = new mapbox.Popup({ offset: 25 }).setText(label);

	var vet = document.createElement("div");
	vet.className = "marker";
	vet.style.backgroundImage = icons[type];
	vet.style.width = 50 + "px";
	vet.style.height = 50 + "px";
	vet.style.backgroundSize = "100%";

	new mapbox.Marker(vet).setLngLat([lon, lat]).setPopup(popup).addTo(map);
</script>

<script>
  import { onMount } from "svelte";
  import Product from "./Product.svelte";
  import { user } from "../stores/user";

  let currentUser = {}

  user.subscribe((n) => {
    if (n) currentUser = n;
  });

  const productTypes = [
    "flea",
    "food",
    "travel",
    "feed",
    "health",
    "scooper",
    "stain-removal",
  ];

  const URL = "/api/products";
  let productList = [];

  onMount(async () => {
    const responses = await Promise.all([
      ...productTypes.map((type) => fetch(`${URL}/${type}`)),
    ]);
    responses.forEach(
      async (response, i) => (productList[i] = await response.json())
    );
    console.log(productList);
  });

  let donation = {
    amount: 0,
    items: [],
  };

  const add = function ({ price, link }) {
    donation.items.push(link);
    donation.amount += +price.substring(2);
    console.log(price.substring(2), donation.items);
  };
</script>

<style>
  .fab-container {
    display: flex;
    flex-direction: column;
    justify-content: flex-end;
    align-items: center;
    user-select: none;
    position: fixed;
    bottom: 30px;
    z-index: 999;
    right: 30px;
  }

  .fab-content .material-icons {
    font-size: 2em;
    opacity: 0.6;
  }
</style>

<div>
  {#each productList as products, index}
    <h4 class="text-capitalize">{productTypes[index]}</h4>
    {#if products}
      {#each products as product}
        <Product {product} {add} />
      {/each}
    {/if}
  {/each}
</div>

<div class="fab-container">
  <a
    class="fab-content pointer"
    href="/api/checkout/{donation.amount}"
    title="Make donation">
    <span class="material-icons">
      <i class="fa fa-shopping-basket" aria-hidden="true" />
      {#if donation.amount}{donation.amount}{/if}
    </span>
  </a>
</div>

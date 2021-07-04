<script>
  import { onMount } from "svelte";
  import Product from "./Product.svelte";

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
</script>

<div>
  <h3>Create a new donation basket <i class="fa fa-shopping-basket" aria-hidden="true"></i></h3>
  
  {#each productList as products, index}
    <h4 class="text-capitalize">{productTypes[index]}</h4>
    {#if products}
      {#each products as product}
        <Product {product} />
      {/each}
    {/if}
    <button>Show more</button>
  {/each}
</div>

<script>
  import { onMount } from "svelte";
  import Banner from "./Banner.svelte";
  import Product from "../utils/Product.svelte";
  import { user } from "../stores/user";

  export let title = "Dog Adoption and Care · Donate";

  const URL = "http://localhost:5001/api/products"

  const message = "Donate";
  const imgSrc = "images/donate.jpg";

  let productList = []

  const productTypes = ["flea", "food", "travel", "feed", "health", "scooper", "stain-removal"]

  onMount(async () => {
    const responses = await Promise.all([
      ...productTypes.map(type => fetch(`${URL}/${type}`))
    ])
    responses.forEach(async (response, i) => productList[i] = await response.json())
    console.log(productList)     
  })

  let isStaff = false;

  user.subscribe(n => {
    if (n) {
      isStuff = n.roles.some(role => role == "ROLE_STUFF")
    }
  })

  let message1 = isStaff ? "Add Items" : "Donate Items"
  let message2 = isStaff ? "View Donations" : "Make a monetary donation"
</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<div>
  <Banner {message} {imgSrc} />

  <div
    class="d-flex justify-content-around mt-4 row container"
    style="margin: auto"
  >
    <div class="col-sm-4">
      <div class="card border-dark mb-3">
        <div class="card-header">
          <span class="d-inline-block"> {message1} </span>
          <span class="d-inline-block btn float-right">
            <i class="fas fa-box-open" />
          </span>
        </div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="card border-dark mb-3">
        <div class="card-header">
          <span class="d-inline-block">{message2}</span>
          <span class="d-inline-block btn float-right">
            <i class="far fa-credit-card" />
          </span>
        </div>
      </div>
    </div>
  </div>

  
  <div class="container">
    {#if !isStaff}
    {#each productList as products, index}   
      <h4 class="text-capitalize">{productTypes[index]}</h4>
      {#each products as product}
         <Product {product}/>
      {/each}
    {/each}
    {:else}
      <h1>d</h1>
    {/if}
  </div>
  <small> All donations are exempted under the 80g certificate. </small>
</div>
  
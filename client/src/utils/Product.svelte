<script>
  export let product;

  let { name, imgSrc, price, link } = product;

  link = `https://amazon.in${link}`;

  export let add;

  let class1 = "card";
  const changeColor = function () {
    class1 += " selected";
  };
</script>

<style>
  .card-horizontal {
    flex: 1 1 auto;
  }

  .selected {
    background: aliceblue;
  }
</style>

<div class="d-flex">
  <div class="container-fluid">
    <div class="col-6 mt-2">
      <div class={class1}>
        <div class="card-horizontal d-flex">
          <div class="img-square-wrapper">
            <img class="p-2" src={imgSrc} alt={name} loading="lazy" />
          </div>
          <div class="card-body">
            <h6 class="card-title">{name}</h6>
            <p class="card-text">{price}</p>
          </div>
        </div>
        <div
          class="card-footer pointer"
          on:click={() => {
            add(product);
            changeColor();
          }}>
          <small class="text-muted">Add</small>
        </div>
      </div>
    </div>
  </div>
</div>

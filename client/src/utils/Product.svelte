<script>
    export let product

    let { name, imgSrc, price, link } = product

    link = `https://amazon.in${link}`
</script>

<div>
    { name }
</div>
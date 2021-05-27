<script>
    export let message;
    export let alt;
</script>

<svg class="sprite">
  <symbol id="paw" viewbox="0 0 340 310" fill="#302121">
    <ellipse cx="25" cy="120" stroke-width="0" rx="17" ry="25" />
    <ellipse cx="70" cy="75" stroke-width="0" rx="24" ry="37" />
    <ellipse cx="125" cy="75" stroke-width="0" rx="24" ry="37" />
    <ellipse cx="170" cy="105" stroke-width="0" rx="17" ry="25" />
    <path
      stroke-width="0"
      d="M24 185.39s9.76-63.072 76.838-64.574c0 0 71.082-6.758 83.096 70.33 0 0 2.586 19.855-12.54 31.855 0 0-15.75 17.75-43.75-6.25 0 0-7.124-8.374-24.624-7.874 0 0-12.75-.125-21.5 6.625 0 0-16.375 18.376-37.75 12.75 0 0-28.29-7.72-19.77-42.86z"
    />
  </symbol>
</svg>

<div class="loading">
  <span> {message || alt || 'Loading... please have pawtience'} </span>
  {#if !message}
  <div class="load">
    <svg class="icon"><use xlink:href="#paw" /></svg>
    <svg class="icon"><use xlink:href="#paw" /></svg>
    <svg class="icon"><use xlink:href="#paw" /></svg>
  </div>
  {/if}
</div>

<style>
  .loading {
    padding: 5px;
  }

  .loading span {
    font-size: 1.2em;
  }

  .sprite {
    display: none;
  }

  .load {
    display: grid;
    place-items: center;
  }

  svg {
    transform: scale(0.4);
    margin-top: -4em;
  }

  .load svg:nth-child(2n) {
    transform: translateX(20px) scale(0.4);
    animation: walk 1s infinite linear alternate;
    animation-delay: 0.5s;
  }

  .load svg:first-child {
    animation: walk 1s infinite alternate;
    animation-delay: 1s;
    margin-top: -1em;
    transform: translateX(-20px) scale(0.4);
  }

  .load svg:last-child {
    animation: walk 1s infinite alternate;
    animation-delay: 0s;
    transform: translateX(-30px) scale(0.4);
  }

  span {
      font-size: 5vmin;
  }
  @keyframes walk {
    50%,
    100% {
      opacity: 0;
    }
    0% {
      opacity: 1;
    }
  }
</style>

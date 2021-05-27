

<div class="modal" in:fade out:fade>
  <div class="backdrop" on:dblclick={close} />
  <div class="content-wrapper">
    <div class="content">
      <div class="close" on:click={close}>×</div>
      <div class="img-bg">
        <img src="images/dog2.jpg" alt="banner" />
      </div>
      <h2 class="message">Adoption Application</h2>
      <div class="container">

<form class="content">
  <label>Name</label>
  <input type="text" /><br>
  <label>Phone number</label>
  <input type="text"  /><br>
  <label>Address</label>
  <input type="text" /><br>
  <button type="submit">
    Submit
  </button>
</form>
       
      </div>
    </div>
  </div>
</div>

<style>
  div.modal {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  div.backdrop {
    position: absolute;
    width: 100%;
    height: 100%;
    background-color: rgba(50, 50, 50, 0.5);
  }

  div.content-wrapper {
    z-index: 10;
    width: 40vw;
    border-radius: 0.3rem;
    background-color: white;
    overflow: hidden;
  }

  div.content {
    max-height: 95vh;
    overflow: auto;
  }

  form .form-group {
    text-align: left;
  }

  form {
    margin-top: -20px;
  }

  h2.message {
    position: relative;
    z-index: 10;
    top: -15vh;
    font-size: 5vmin;
    margin: auto;
    width: fit-content;
    text-align: center;
    display: block;
    padding-bottom: 10px;
    text-transform: uppercase;
    border-bottom: 1px solid rgb(255, 254, 254);
    color: white;
  }

  div.close {
    position: relative;
    left: -1em;
    top: 10px;
    cursor: pointer;
    font-size: 2vw;
    margin-bottom: -50px;
    color: white;
    z-index: 1033;
  }

  div.img-bg {
    width: inherit;
    height: 28vh;
    background: gray;
  }

  img {
    filter: brightness(40%);
    width: 100%;
    height: 28vh;
  }

  div > span {
    cursor: pointer;
  }

   @media (max-width: 792px) {  
    div.content-wrapper {
      width: 55vw;
    }
  }


</style>

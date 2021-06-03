<script>
import { fade } from "svelte/transition";

const msg = 'Add Post';

let isOpenPost = false
let name
let remark
let description

function ValidateSize(file) {

    
        if (!document.getElementById("photo").value ) {
            event.preventDefault();
            alert("Please choose a file!");
        }
        else {

        }
    }
</script>

<div id="myForm">
  <div class="modal" in:fade out:fade>
    <div class="backdrop" />
      <div class="content-wrapper">
        <div class="content">
          <div class="close" ><a href="adopt" class="close">×</a></div>
          <img src="/images/post.jpg" alt="doggo" />
          <h2 class="message">{msg}</h2>
          <div class="container">
          
            <form id="myForm">
             
            <label 
            for="name">
            <b>Name</b>
            </label>

            <input 
            type="text" 
            placeholder="Enter name" 
            name="name" 
            required
            >

            <br><br>

            <label 
            for="description">
            <b>Description</b>
            </label>

            <input 
            type="text" 
            placeholder="Describe" 
            name="description" 
            required>

            <br><br>

            <label 
            for="remark">
            <b>Remark</b>
            </label>

            <input 
            type="text" 
            placeholder="Give remark" 
            name="remark" 
            required>

            <br>
            <br>

            <label>
            <b>Choose picture to upload:</b>
            </label>
             
            <input 
            type="file" 
            name="photo"
            id="photo" 
            accept=".jpg,.jpeg,.png"
            onchange="ValidateSize(this)"
            />

            <br>
            <br>

            <button 
            type="submit" 
            class="" >
            Post
            </button>

            <br><br><br>

            </form>
            
          </div>
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
    max-width: 50vw;
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

  img {
    filter: brightness(40%);
    width: 100%;
    height: 28vh;
  }

  div > span {
    cursor: pointer;
  }

  .close{
    color:white;
  }
</style>

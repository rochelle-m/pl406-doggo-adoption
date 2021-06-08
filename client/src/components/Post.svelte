<script>
import { fade } from "svelte/transition";
import { onMount } from "svelte";
import { notesStore } from "../stores/store.js";

  let doggos = [];
  let error = "";
  const URL = `http://localhost:5001/api/doggos/`;
  let show = false;

  onMount(async function () {
    try {
      const response = await fetch(url, {
      method: 'POST', 
      headers: {
        'Content-Type': 'application/json; charset=utf-8',
        'Accept': 'application/json'
      },
      referrerPolicy: 'no-referrer',
      body: JSON.stringify(user) 
    });
      doggos = await response.json();

      setTimeout(() => {
        show = true;
      }, 1500);
    } catch (err) {
      error = err.message;
    }
  });
const msg = 'Add Post';

let isOpenPost = false
let name
let remark
let description
let breed
let location
let picture
let src = '';

  function onChange(event) {
    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();
      reader.onload = function (e) {
        src = e.target.result;
      }
      reader.readAsDataURL(event.target.files[0]);
    }
  }


  let posts = []

  let post = {
      name: '',
      remark: '',
      description: '',
      breed: '',
      location: '',
      picture: '',
      id: null
  };

  let addPost = () =>{

    const newNote = {

      id: posts.length + 1,
      name: post.name,
      remark: post.remark,
      description: post.description,
      breed: post.breed,
      location: post.location,
      picture: post.picture
    };

    notesStore.createNote(newNote);

    post = {
      id: null,
      name: '',
      remark: '',
      description: '',
      breed: '',
      location: '',
      picture: ''
  };


  };
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
            bind:value={post.name}
            type="text" 
            placeholder="Enter name" 
            name="name" 
            required
            >

            <br><br>

            <label 
            for="breed">
            <b>Breed</b>
            </label>

            <input 
            bind:value={post.breed}
            type="text" 
            placeholder="Enter dogs breed" 
            name="breed" 
            required>

            <br><br>

            <label 
            for="description">
            <b>Description</b>
            </label>

            <input 
            bind:value={post.description}
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
            bind:value={post.remark} 
            type="text" 
            placeholder="Give remark" 
            name="remark" 
            required>

            <br>
            <br>

            <label 
            for="location">
            <b>Location</b>
            </label>

            <input
            bind:value={post.location} 
            type="text" 
            placeholder="Enter dogs location" 
            name="location" 
            required>

            <br>
            <br>

            <label>
            <b>Choose picture to upload:</b>
            </label>
             
            <input 
            bind:value={post.picture}
            type="file" 
            name="photo"
            id="photo" 
            accept=".jpg,.jpeg,.png"
            
            on:change={onChange}
            />

            {#if src}
            <img class="uploadimg" {src} />
            {/if}
            <br>
            <br>

            <button 
            type="submit" 
            on:click|preventDefault = {addPost}
            class="btn btn-primary" >
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

  .uploadimg{
  width:100px;
  height:100px;
  }
</style>

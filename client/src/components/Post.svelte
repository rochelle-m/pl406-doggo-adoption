<script>
import { fade } from "svelte/transition";
import { user } from "../stores/user";
import axios from "axios";

let currentUser = {};
  user.subscribe((updatedUser) => {
    if (updatedUser) {
      currentUser = updatedUser;  
    }
});

  let doggos = [];
  let error = "";
  const URL = `/api/doggos/`;
  let show = false;

const msg = 'Add Post';


let src = '';
let image ;
  function onChange(event) {
   image = event.target.files[0];

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
      username: null
  };

  let addPost = async(event) =>{
  event.preventDefault()
  

  if(currentUser.isLoggedIn) {
    post.username= currentUser.username

       let formData = new FormData();
      
    formData.append(
      "doggo",
      new Blob([JSON.stringify(post)], {
        type: "application/json",
      })
    );
    formData.append("image", image);


    try {
      const response = await axios({
        method: "post",
        url: URL,
        data: formData,
        headers: {
          "Content-Type": "multipart/form-data",
          Authorization: currentUser.type + " " + currentUser.token,
        },
      });

      const createdPost = response.data
      
    } catch (err) {
      console.log(err);
    }

  }
  
  };
</script>

<div id="myForm">
  <div class="modal" fade>
    <div class="backdrop" />
      <div class="content-wrapper">
        <div class="content">
          <div class="close" ><a href="adopt" class="close">×</a></div>
          <img src="/images/post.jpg" alt="doggo" />
          <h2 class="message">{msg}</h2>
          <div class="container">
          <div class="modal-body mx-3">
        
            <form id="myForm" method="post">
                         
            <label 
            for="name">
            <b>Name</b>
            </label>

            <input 
            bind:value={post.name}
            type="text" 
            placeholder="Enter dog name" 
            name="name" 
            required>
            
            <br><br>

            <label 
            for="breed">
            <b>Breed</b>
            </label>

            <input 
            bind:value={post.breed}
            type="text" 
            placeholder="Enter dog breed" 
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
            bind:value={src}
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

<script>
  import { fade } from "svelte/transition";
  import { user } from "../stores/user";
  import axios from "axios";

  let currentUser = {};
  let isStaff = false;
  user.subscribe((updatedUser) => {
    if (updatedUser) {
      currentUser = updatedUser;
      isStaff = updatedUser.roles.some((role) => role == "ROLE_STAFF");
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


<form id="myForm"  method="post">
  <div class="form-group mt-2">
    <label
    class="control-label col-sm-2"
    for="name">
    <b>Name:</b>
    </label>

    <div class="col-sm-offset-2 col-sm-10">
      <input
      bind:value={post.name}
      type="text"
      placeholder="Enter dog name"
      name="name"
      required>
    </div>
  </div>

  <div class="form-group">
    <label
    class="control-label col-sm-2"
    for="breed">
    <b>Breed:</b>
    </label>

    <div class="col-sm-offset-2 col-sm-10">
      <input
      bind:value={post.breed}
      type="text"
      placeholder="Enter dog breed"
      name="breed"
      required>
    </div>
  </div>

  <div class="form-group">
    <label
    class="control-label col-sm-2"
    for="description">
    <b>Description:</b>
    </label>

    <div class="col-sm-offset-2 col-sm-10">
      <input
      bind:value={post.description}
      type="text"
      placeholder="Describe"
      name="description"
      required>
    </div>
  </div>

  <div class="form-group">
    <label
    class="control-label col-sm-2"
    for="remark">
    <b>Remark:</b>
    </label>

    <div class="col-sm-offset-2 col-sm-10">
      <input
      bind:value={post.remark}
      type="text"
      placeholder="Give remark"
      name="remark"
      required>
    </div>
  </div>

{#if !isStaff}
  <div class="form-group">
    <label
    class="control-label col-sm-2"
    for="location">
    <b>Location:</b>
    </label>

    <div class="col-sm-offset-2 col-sm-10">
      <input
      bind:value={post.location}
      type="text"
      placeholder="Enter dogs location"
      name="location"
      required>
    </div>
  </div>
  {/if}

  <div class="form-group">
    <label
    class="control-label col-sm-8">
    <b>Choose picture to upload:</b>
    </label>

    <div class="col-sm-offset-2 col-sm-10">
      <input
      bind:value={src}
      type="file"
      name="photo"
      id="photo"
      accept=".jpg,.jpeg,.png"
      on:change={onChange}
      />
     </div>
    {#if src}
    <img class="uploadimg" {src} />
    {/if}
  </div>

  <button
    type="submit"
    on:click|preventDefault = {addPost}
    class="btn btn-primary" >
    Post
  </button>

</form>


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

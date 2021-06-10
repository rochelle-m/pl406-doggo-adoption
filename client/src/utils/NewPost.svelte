<script>
  import { user } from "../stores/user";
  import moment from "moment";
  import { openModal } from "../stores/store";
  import { subscribe, update } from "../stores/posts";

  let preview = "https://mdbootstrap.com/img/Photos/Others/placeholder.jpg";
  const tags = ["adoption", "help", "foster", "food"];

  let newPost = {
    caption: null,
    selectedTags: [],
    fileInput: null,
    username: null,
    comments: [],
    time: null,
  };

  let posts = [];

  subscribe((newPosts) => {
    posts = newPosts;
  });

  let currentUser = {};

  user.subscribe((updatedUser) => {
    if (updatedUser) {
      currentUser = updatedUser;
    }
  });

  let showImageUploading = false;

  const show = () => {
    showImageUploading = !showImageUploading;
  };

  const onFileSelected = (e) => {
    let image = e.target.files[0];
    let reader = new FileReader();
    reader.readAsDataURL(image);
    reader.onload = (e) => {
      preview = e.target.result;
    };
  };

  const post = () => {
    newPost.username = currentUser.username;
    newPost.time = moment().format("LLL");

    // ! fix order of posts
    posts.push(newPost);
    update(() => posts);
    setTimeout(() => {
      newPost = {...newPost}
      newPost.selectedTags = []
      newPost.caption = ""
    }, 3000);
  };

  const handleSubmit = () => {
    if (currentUser.isLoggedIn) {
      post();
    } else {
      openModal("login");
    }
  };
</script>

<div class="card col-8 p-4 col-lg-6 my-2">
  <div class="text-left">
    <h5 class="text-left">Create a post</h5>
    <p class="text-muted">Share a thought or ask for help</p>
  </div>
  <div class="mb-3">
    <form on:submit|preventDefault={handleSubmit}>
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend3">
            <i class="far fa-closed-captioning" />
          </span>
        </div>
        <textarea
          class="form-control"
          bind:value={newPost.caption}
          placeholder="Type a caption"
          aria-describedby="inputGroupPrepend3"
          required />
        <span
          class="input-group-text pointer"
          id="inputGroupPrepend3"
          title="Add an image"
          on:click={show}><i class="fas fa-image" />
        </span>
      </div>

      {#if showImageUploading}
        <div class="input-group">
          <div class="z-depth-1-half my-4">
            <img
              src={preview}
              style="cursor:copy;"
              class="img-fluid"
              alt="example placeholder"
              title="Tap to add or change image"
              on:click={() => {
                newPost.fileInput.click();
              }} />
          </div>
          <input
            style="display:none"
            type="file"
            accept=".jpg, .jpeg, .png"
            on:change={(e) => onFileSelected(e)}
            bind:this={newPost.fileInput} />
        </div>
      {/if}

      <div class="my-2">
        {#each tags as tag}
          <div class="mx-2 d-inline">
            <label>
              <input
                type="checkbox"
                bind:group={newPost.selectedTags}
                value={tag} />
              #{tag}
            </label>
          </div>
        {/each}
      </div>

      <div class="text-right"><button class="mt-4">Post</button></div>
    </form>
  </div>
</div>

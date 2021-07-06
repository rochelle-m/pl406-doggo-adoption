<script>
  import { user } from "../stores/user";
  import moment from "moment";
  import { openModal } from "../stores/store";
  import { subscribe, update } from "../stores/posts";
  import axios from "axios";
  import { tags } from "../stores/tags";

  const URL = `/api/posts/new`;

  let preview = "https://mdbootstrap.com/img/Photos/Others/placeholder.jpg";

  let newPost = {
    caption: null,
    tags: [],
    username: null,
    createdDate: null,
  };

  let image = null;
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

  const post = async function () {
    newPost.username = currentUser.username;
    newPost.createdDate = moment().format("LLL");

    let formData = new FormData();

    formData.append(
      "post",
      new Blob([JSON.stringify(newPost)], {
        type: "application/json",
      })
    );
    formData.append("image", image?.files[0]);

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

      const createdPost = response.data;

      if (createdPost.id) {
        update((_) => [createdPost, ...posts]);
      }

      newPost = { ...newPost };
      newPost.tags = [];
      newPost.caption = "";
      preview = "https://mdbootstrap.com/img/Photos/Others/placeholder.jpg";
      showImageUploading = false;
    } catch (err) {
      console.log(err);
    }
  };

  const handleSubmit = () => {
    currentUser.isLoggedIn && post();
  };
</script>

<div class="card col-10 p-4 my-2">
  {#if currentUser.isLoggedIn}
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
                  image.click();
                }} />
            </div>
            <input
              style="display:none"
              type="file"
              accept=".jpg, .jpeg, .png"
              on:change={(e) => onFileSelected(e)}
              bind:this={image} />
          </div>
        {/if}

        <div class="my-2">
          {#each tags as tag}
            <div class="mx-2 d-inline">
              <label>
                <input type="checkbox" bind:group={newPost.tags} value={tag} />
                #{tag}
              </label>
            </div>
          {/each}
        </div>

        <div class="text-right"><button class="mt-4">Post</button></div>
      </form>
    </div>
  {:else}
    <div class="text-right">
      <button class="mt-4 col-4 btn" on:click={() => openModal('login')}>Login
        to post</button>
    </div>
  {/if}
</div>

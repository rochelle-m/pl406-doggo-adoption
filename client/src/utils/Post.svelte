<script>
  import { user } from "../stores/user";
  import { openModal } from "../stores/store";

  let tempPost = {
    username: "linda",
    time: "3 days ago",
    comments: [
      {
        username: "karen",
        comment: "Oh so cute",
      },
      {
        username: "linda",
        comment: "The goooooodest",
      },
    ],
    caption: "caption caption",
  };

  let showComments = false;
  let comment = "";

  let sendBtnVisible = comment != "";

  let currentUser = {}
  
  user.subscribe(updatedUser => {
    if (updatedUser) {
      currentUser = updatedUser
    }
  })

  const open = () => {
    showComments = true;
  };

  const favourite = function (e) {
    const element = e.target;
    if (element.classList.contains("fas")) {
      element.classList.add("far");
      element.classList.remove("fas");
    } else {
      element.classList.add("fas");
      element.classList.remove("far");
    }
  };

  let interval 
  const checkAuth = () => {
    interval = setInterval(() => {
      if (currentUser.isLoggedIn) {
        post()
      }
    }, 4000)
  }

  const post = () => {
    tempPost.comments.push({
        username: currentUser.username,
        comment,
      });
      tempPost = tempPost;
      comment = "";
      clearInterval(interval)
  }

  const postComment = () => {
    if (!currentUser.isLoggedIn) {
        openModal("login")
        checkAuth()
    }
    else {
      post()
    }
  };

  const handleChange = () => {
    sendBtnVisible = comment != "";
  };
</script>

<div class="card col-8 p-4 col-lg-6 my-2">
  <div class="mb-4 text-left">
    <div class="media-body">
      <i class="far fa-star float-right fav pointer" on:click={favourite} />
      <span class="mb-2">@ {tempPost.username}</span>
      <div class="text-muted small">{tempPost.time}</div>
    </div>
  </div>
  <img src="images/3.jpg" class="card-img-top img-fluid" alt="..." />
  <div class="card-body text-left">
    <p>{tempPost.caption}</p>
  </div>

  <div class="card-footer text-left">
    <small class="align-left pointer" on:click={open}>
      <strong> {tempPost.comments.length} </strong>
      Comments
    </small>

    {#if showComments}
      {#each tempPost.comments as comment}
        <div>
          <small>
            <strong>@{comment.username}</strong>
            <em>{comment.comment}</em>
          </small>
        </div>
      {/each}
    {/if}
  </div>
  <div class=" mb-3">
    <form on:submit|preventDefault={postComment}>
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend3"><i
              class="far fa-comment" /></span>
        </div>
        <input
          type="text"
          class="form-control"
          bind:value={comment}
          on:input={handleChange}
          placeholder="Write a comment or a query"
          aria-describedby="inputGroupPrepend3"
          required />

        {#if sendBtnVisible}
          <span
            class="input-group-text pointer"
            id="inputGroupPrepend3"
            on:click={postComment}><i class="fas fa-paper-plane" />
          </span>
        {/if}
      </div>
    </form>
  </div>
</div>


<style>
  .fav {
    color: yellow;
    font-size: x-large;
  }

  img {
    width: 400px;
    height: 300px;
    object-fit: cover;
  }
</style>
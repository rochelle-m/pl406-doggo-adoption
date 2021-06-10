<script>
  import { user } from "../stores/user";
  import { openModal } from "../stores/store";
  import moment from "moment";

  export let tempPost;

  let showComments = false;
  let comment = "";

  // get from posts
  let liked = false;

  let sendBtnVisible = comment != "";

  let currentUser = {};

  user.subscribe((updatedUser) => {
    if (updatedUser) {
      currentUser = updatedUser;
    }
  });

  const open = () => {
    showComments = true;
  };

  let interval, interval2;

  const favourite = function () {
    if (!currentUser.isLoggedIn) {
      openModal("login");
      interval2 = setInterval(() => {
        if (currentUser.isLoggedIn) {
          liked = !liked;
          clearInterval(interval2);
        }
      }, 4000);
    } else {
      liked = !liked;
    }
  };

  const checkAuth = (action) => {
    interval = setInterval(() => {
      if (currentUser.isLoggedIn) {
        action();
      }
    }, 4000);
  };

  const post = () => {
    tempPost.comments.push({
      username: currentUser.username,
      comment,
    });
    tempPost = tempPost;
    comment = "";
    clearInterval(interval);
  };

  const postComment = () => {
    if (!currentUser.isLoggedIn) {
      openModal("login");
      checkAuth(post);
    } else {
      post();
    }
  };

  const handleChange = () => {
    sendBtnVisible = comment != "";
  };
</script>

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

<div class="card col-8 p-4 col-lg-6 my-2">
  <div class="mb-4 text-left">
    <div class="media-body">
      <i
        class={liked ? 'fas fa-star float-right pointer fav' : 'far fa-star float-right pointer fav'}
        on:click={favourite} />
      <span class="mb-2">@ {tempPost.username}</span>
      <div class="text-muted small">{moment(tempPost.time).fromNow()}</div>
    </div>
  </div>

  {#if tempPost.src}
    <img src={tempPost.src} class="card-img-top img-fluid" alt="..." />
  {/if}
  <div class="card-body text-left">
    <p>{tempPost.caption}</p>
  </div>

  <div class="card-footer text-left">
    <small class="align-left pointer" on:click={open}>
      <strong> {tempPost.comments?.length} </strong>
      Comment(s)
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

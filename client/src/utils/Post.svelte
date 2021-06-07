<script>
  let tempPost = {
    username: "linda",
    time: "3 days ago",
    comments: [
      {
        username: "karen",
        comment: "Oh so cute"
      },
      {
        username: "linda",
        comment: "The goooooodest"
      }
    ],
    caption: "caption caption"
  }

  let showComments = false; 

  const open = () => {
    showComments = true
  }

  const favourite = function (e){
    const element = e.target;
    if (element.classList.contains("fas")) {
      element.classList.add("far")
      element.classList.remove("fas")
    }
    else {
      element.classList.add("fas")
      element.classList.remove("far")
    }
  }

</script>

<div class="card col-8 p-4 col-lg-6 my-2">
  <div class="mb-4 text-left">
    <div class="media-body">
      <i class="far fa-star float-right fav pointer" on:click={favourite}></i>
      <span class="mb-2">@ {tempPost.username}</span>
      <div class="text-muted small"> {tempPost.time} </div>
    </div>
  </div>
  <img src="images/3.jpg" class="card-img-top" alt="...">
  <div class="card-body text-left">
    <p> {tempPost.caption} </p>
  </div>
  
  <div class="card-footer text-left">
  
    <small class="align-left pointer" on:click={open}>
      <strong> {tempPost.comments.length} </strong> Comments
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
    <div class="input-group">
      <div class="input-group-prepend">
        <span class="input-group-text" id="inputGroupPrepend3"><i class="far fa-comment"></i></span>
      </div>
      <input type="text" class="form-control" placeholder="Write a comment or a query" aria-describedby="inputGroupPrepend3" required>
    </div>
  </div>

</div>

<style>
  .fav {
    color: yellow;
    font-size: x-large;
  }
</style>
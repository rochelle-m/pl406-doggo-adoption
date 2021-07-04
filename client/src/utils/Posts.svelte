<script>
  import Post from "./Post.svelte";
  import NewPost from "./NewPost.svelte";
  import Loading from "../utils/Loading.svelte";

  import { subscribe } from "../stores/posts";
  let posts = [];

  subscribe((newPosts) => {
    if (newPosts) posts = newPosts;
  });
</script>

<div class=" mx-5 d-flex col-lg-8 flex-column">
  <NewPost />
  {#each posts as tempPost}
    <Post {tempPost} />
  {:else}
    <Loading message={"Some error occured"} />
  {/each}
</div>

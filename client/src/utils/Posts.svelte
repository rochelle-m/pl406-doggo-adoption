<script>
  import Post from "./Post.svelte";
  import NewPost from "./NewPost.svelte";
  import Loading from "../utils/Loading.svelte";
  import { tags } from "../stores/tags";
  import { subscribe } from "../stores/posts";

  let displayedPosts = [];
  let posts = displayedPosts;

  subscribe((newPosts) => {
    if (newPosts) {
      displayedPosts = posts = newPosts;
    }
  });

  const filter = (tag) => {
    posts = displayedPosts.filter((post) => post.tags.includes(tag));
  };

  $: showing = posts.length
  $: all = displayedPosts.length
</script>

<div class=" mx-5 d-flex col-lg-8 flex-column">
  <NewPost />

  <p class="text-left mt-4"> Showing {showing} of {all} posts</p>

  {#if posts.length}
    <div class="card-body text-left">
        <small
          class="badge badge-info mr-1 pointer"
          on:click={() => {posts=displayedPosts}}>
          all
        </small>
      {#each tags as tag}
        <small
          class="badge badge-info mr-1 pointer"
          on:click={() => filter(tag)}>
          {tag}
        </small>
      {/each}
    </div>
  {/if}
  {#each posts as tempPost}
    <Post {tempPost} />
  {:else}
    <Loading message={'Some error occured'} />
  {/each}
</div>

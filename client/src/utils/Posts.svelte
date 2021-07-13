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

  let selected = "all";
  $: showing = posts.length;
  $: all = displayedPosts.length;
</script>

<div class=" mx-5 d-flex col-lg-8 flex-column">
  <NewPost />

  <p class="text-left mt-4">Showing {showing} of {all} posts</p>

  <div class="card-body text-left">
    <small
      class={"badge mr-1 pointer " +
        (selected == "all" ? "badge-info " : "badge-warning")}
      on:click={() => {
        posts = displayedPosts;
        selected = "all";
      }}
    >
      all
    </small>
    {#each tags as tag}
      <small
        class={"badge mr-1 pointer " +
          (selected == tag ? "badge-info " : "badge-warning")}
        on:click={() => {
          filter(tag);
          selected = tag;
        }}
      >
        {tag}
      </small>
    {/each}
  </div>

  {#if posts.length}
    {#each posts as tempPost}
      <Post {tempPost} />
    {:else}
      <Loading message={"Some error occured"} />
    {/each}
  {/if}
</div>

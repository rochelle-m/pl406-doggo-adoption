<script>
  import { user } from "../stores/user";
  import { logout } from "../modules/auth";

  let currentUser;

  user.subscribe((n) => {
    if (n) {
      currentUser = n;
    }
  });
</script>

<div class="card p-2">
  <div class="card-body">
    <div class="d-flex flex-column align-items-center text-center">  
        <h5>{currentUser.username}</h5>
        <p class="text-muted font-size-sm">{currentUser.email}</p>
        {#each currentUser.roles as role}
            <p class="card-text">{role.substring(role.indexOf("_") + 1)}</p>
        {/each}

        <p on:click={logout} class="nav-link text-dark pointer">
            <i class="fa fa-sign-out" aria-hidden="true" />
            <span>Logout</span>
        </p>
    </div>
  </div>
</div>

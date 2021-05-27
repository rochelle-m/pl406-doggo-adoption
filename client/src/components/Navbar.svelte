<script>
  import { Link } from "svelte-routing";
  import { user } from "../stores/user";
  import {logout} from "../modules/auth";
  import Modal from "../utils/Modal.svelte";
  import { login, signup, openModal } from "../stores/store";
  import {
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    UncontrolledDropdown,
    DropdownToggle,
    DropdownMenu,
    DropdownItem,
  } from "sveltestrap";

  let isOpen = false;
  let showSignup, showLogin;
  let username = ""
  let isLoggedIn = false
  let roles = []
  
  function handleUpdate(event) {
    isOpen = event.detail.isOpen;
  }

  login.subscribe((newValue) => {
    showLogin = newValue;
  });
  signup.subscribe((newValue) => {
    showSignup = newValue;
  });

  user.subscribe(n => {
    if (n) {
      username = n.username || ""
      isLoggedIn = n.isLoggedIn
      roles = n.roles
    }
  })
</script>

<nav class="px-3" id="navbar">
  <Navbar color="" dark expand="md">
    <NavbarBrand href="/">
      <img src="images/icons/logo-w.png" alt="logo" />
    </NavbarBrand>
    <NavbarToggler on:click={() => (isOpen = !isOpen)} />
      <Collapse {isOpen} navbar expand="md" on:update={handleUpdate}>
        <Nav class="ml-auto" navbar>
          <NavItem>
            <Link class="nav-link" to="adopt">Adopt</Link>
        </NavItem>
        <NavItem>
          <Link class="nav-link" to="foster">Foster</Link>
        </NavItem>
        <NavItem>
          <Link class="nav-link" to="volunteer">Volunteer</Link>
        </NavItem>
        <NavItem>
          <Link class="nav-link" to="donate">Donate</Link>
        </NavItem>
        <NavItem>
          <Link class="nav-link" to="events">Events</Link>
        </NavItem>
        
                
      
        <UncontrolledDropdown nav inNavbar>
          <DropdownToggle nav caret>Help</DropdownToggle>
          <DropdownMenu right>
            <DropdownItem>
              <Link class="nav-link" to="food">
                <p>Pet food</p>
              </Link>
            </DropdownItem>
            <DropdownItem>
              <Link class="nav-link" to="vaccination">
                <p>Vaccination Centre</p>
              </Link>
            </DropdownItem>
          </DropdownMenu>
        </UncontrolledDropdown>

        <UncontrolledDropdown nav inNavbar>
          <DropdownToggle nav caret>
            <i class="fa fa-user" aria-hidden="true"></i>  
            { username }  
          </DropdownToggle>
          <DropdownMenu right>
            {#if isLoggedIn}
            <DropdownItem>
              {#each roles as role}
                <p> {role.substring(role.indexOf("_") + 1)} </p>
              {/each}
              <Link on:click={logout}>
                <p>Logout</p>
              </Link>
            </DropdownItem>
            {:else}
            <DropdownItem>
                <p on:click={() => openModal("login")}>Log in</p>
            </DropdownItem>
            <DropdownItem>
                <p on:click={() => openModal("signup")}>Sign up</p>
            </DropdownItem>
            {/if}
          </DropdownMenu>
        </UncontrolledDropdown>
      </Nav>

    </Collapse>
  </Navbar>
<a class="addbtn nav-link"  href="post">Add Post</a>

</nav>

{#if showLogin}
  <Modal token="login" />
{/if}
{#if showSignup}
  <Modal token="signup" />
{/if}


<style>
  nav {
    position: fixed;
    top: 0;
    z-index: 100;
    width: 100%;
  }

  p {
    color: #302121;
    margin: 0;
  }
  
  @media (max-width: 772px) {
    nav {
      background: #302121d8;
    }
  }

.addbtn{
  width:85px;
  background-color:grey;
  color:white;
  float:right;
  font-size:12px;
  border-radius:5px;
  border:1px solid white;
}

</style>

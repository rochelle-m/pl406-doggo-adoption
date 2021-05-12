<script>
  import { Link } from "svelte-routing";
  import { user } from "../stores/user";

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

  function handleUpdate(event) {
    isOpen = event.detail.isOpen;
  }

  import Modal from "../utils/Modal.svelte";
  import { login, signup, openModal } from "../stores/store";

  let showSignup, showLogin;

  login.subscribe((newValue) => {
    showLogin = newValue;
  });
  signup.subscribe((newValue) => {
    showSignup = newValue;
  });

  let username = ""
  let isLoggedIn

  user.subscribe(n => {
    username = n.username || ""
    isLoggedIn = n.isLogged
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
              <!-- handle logout -->
              <Link>
                <p>Logout</p>
              </Link>
            </DropdownItem>
            {:else}
            <DropdownItem>
              <Link on:click={() => openModal("login")}>
                <p>Log in</p>
              </Link>
            </DropdownItem>
            <DropdownItem>
              <Link on:click={() => openModal("signup")}>
                <p>Sign up</p>
              </Link>
            </DropdownItem>
            {/if}
          </DropdownMenu>
        </UncontrolledDropdown>
      </Nav>
   </Collapse>
 </Navbar>
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
</style>

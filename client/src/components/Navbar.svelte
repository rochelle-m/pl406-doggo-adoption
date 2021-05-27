<script>
  import { Link } from "svelte-routing";

  import {
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink,
    UncontrolledDropdown,
    DropdownToggle,
    DropdownMenu,
    DropdownItem,
  } from "sveltestrap";

  let isOpen = false;

  function handleUpdate(event) {
    isOpen = event.detail.isOpen;
  }
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
                <p>Pet food</p></Link
              ></DropdownItem
            >
            <DropdownItem>
              <Link class="nav-link" to="vaccination"
                ><p>Vaccination Centre</p></Link
              ></DropdownItem
            >
          </DropdownMenu>
        </UncontrolledDropdown>
      </Nav>
    </Collapse>
  </Navbar>
<a class="addbtn nav-link"  href="post">Add Post</a>

</nav>


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
}

</style>

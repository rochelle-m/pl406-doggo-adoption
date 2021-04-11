<script>
  import { Router, Route, Link } from "svelte-routing";
  import Home from "./components/Home.svelte";
  import Doggos from "./components/Doggos.svelte";
  import Footer from "./components/Footer.svelte";

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

<main>
  <Router>
    <nav class="px-3">
      <Navbar color=" " dark expand="md">
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
              <NavLink>Foster</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="Volunteer">Volunteer</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="#Donate/">Donate</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="Event">Events</NavLink>
            </NavItem>
            <UncontrolledDropdown nav inNavbar>
              <DropdownToggle nav caret>Help</DropdownToggle>
              <DropdownMenu right>
                <DropdownItem>Pet food</DropdownItem>
                <DropdownItem>Vaccination Centre</DropdownItem>
              </DropdownMenu>
            </UncontrolledDropdown>
          </Nav>
        </Collapse>
      </Navbar>
    </nav>

    <Route path="/"><Home /></Route>
    <Route path="adopt"><Doggos /></Route>
    <Footer />
  </Router>
</main>

<style>
  main {
    text-align: center;
    margin: 0 auto;
  }

</style>

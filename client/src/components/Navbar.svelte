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
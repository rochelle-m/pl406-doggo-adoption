<script>
	import { Router, Route, Link } from "svelte-routing";
	import Home from './components/Home.svelte'
	import Footer from './components/Footer.svelte'

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
    DropdownItem
  } from 'sveltestrap';

  let isOpen = false;

  function handleUpdate(event) {
    isOpen = event.detail.isOpen;
  }


</script>

<main>
  <Router>
 
 <nav>

<Navbar color=" " dark expand="md">
  <NavbarBrand href="/">Doggo ♡</NavbarBrand>
  <NavbarToggler on:click={() => (isOpen = !isOpen)} />
  <Collapse {isOpen} navbar expand="md" on:update={handleUpdate}>
    <Nav class="ml-auto" navbar>
      <NavItem>
        <NavLink href="#Home/">Home</NavLink>
      </NavItem>
      <NavItem>
        <NavLink href="#Adopt/">Adopt</NavLink>
      </NavItem>
      <NavItem>
        <NavLink href="#Foster/">Foster</NavLink>
      </NavItem>
      <NavItem>
        <NavLink href="Volunteer">Volunteer</NavLink>
      </NavItem>
      <NavItem>
        <NavLink href="Event">Event</NavLink>
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

    <!-- add routes -->
    <Route path="/"><Home /></Route>
  </Router>
	<Footer/>
</main>

<style>
	main {
		text-align: center;
		margin: 0 auto;
	}

	@media (min-width: 640px) {
		
	}

	nav{
	  background-color:#302121;

	}
</style>
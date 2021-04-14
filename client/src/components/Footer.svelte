<script>
  import { Link } from "svelte-routing";
</script>

<footer class="py-4">
  <div class="container">
    <div class="row">
      <div class="col-md-6 item text mb-2">
        <img src="images/icons/logo-w.png" alt="logo" class="w-25" />
        <h3 class="font-weight-bold container ">Doggo</h3>
        <p class="mb-0">Adopt. Foster. Care.</p>
        <p class="mb-0">The goodest girls and boys.</p>
      </div>
      <div class="col-sm-6 col-md-3 item contact">
        <address class="col-sm-12">
          <h4 class="font-weight-bold">Address</h4>
          <small class="d-block">Goodest place</small>
          <small class="d-block">Panaji, Goa - 403001</small>
        </address>
        <div class="col-sm-12">
          <h4 class="font-weight-bold">Contact</h4>
          <ul class="px-0 list-unstyled">
            <li class="mb-1">
              <span><i class="fa fa-envelope mr-1" />
                <a href="mailto:contact@doggo.com">contact@doggo.com</a>
              </span>
            </li>
            <li class="mb-1">
              <span><i class="fas fa-phone-alt mr-1" />
                <a href="tel:+918322424919">+91 832 2424 919</a></span>
            </li>
          </ul>
        </div>
      </div>
      <div class="col-sm-6 col-md-3 item">
        <h4 class="font-weight-bold">Tags</h4>
        <ul class="widget px-0 mt-2">
          <li class="d-inline">
            <Link class="d-inline px-0" to="adopt">
              <a class="p-2 d-inline-block mb-1 rounded text-decoration-none" href="/adopt">Adopt</a>
            </Link>
          </li>
          <li class="d-inline">
            <Link class="px-0" to="">
              <a class="p-2 d-inline-block mb-1 rounded text-decoration-none" href="">Foster</a >
            </Link>
          </li>
          <li class="d-inline">
            <Link class="px-0" to="">
              <a class="p-2 d-inline-block mb-1 rounded text-decoration-none" href="">Food</a>
            </Link
            >
          </li>
          <li class="d-inline">
            <Link class="px-0" to="">
              <a class="p-2 d-inline-block mb-1 rounded text-decoration-none" href="">Vet</a>
            </Link>
          </li>
          <li class="d-inline">
            <Link class=" px-0" to="">
              <a class="p-2 d-inline-block mb-1 rounded text-decoration-none" href="">Volunteer</a>
            </Link>
          </li>
          <li class="d-inline">
            <Link class="px-0" to="">
              <a class="p-2 d-inline-block mb-1 rounded text-decoration-none" href="">Event</a>
            </Link>
          </li>
          <li class="d-inline">
            <Link class="px-0" to="">
              <a class="p-2 d-inline-block mb-1 rounded text-decoration-none" href="">Help</a>
            </Link>
          </li>
        </ul>
      </div>

      <div class="col item social pt-3 mt-2">
        <a href="#" class="rounded-circle d-inline-block mr-1">
          <i class="fab fa-facebook-f" />
        </a>
        <a href="#" class="rounded-circle d-inline-block mr-1">
          <i class="fab fa-twitter" />
        </a>
        <a href="#" class="rounded-circle d-inline-block mr-1">
          <i class="fab fa-instagram" />
        </a>
        <a href="#" class="rounded-circle d-inline-block mr-1">
          <i class="fab fa-google" />
        </a>
      </div>
    </div>
    <small class="mt-2">Dog Adoption and Care · 2021</small>
  </div>
</footer>

<style>
  footer h4 {
    font-size: 16px;
  }

  footer ul a {
    font-size: 14px;
    color: inherit;
    opacity: 0.6;
  }

  footer ul a:hover {
    opacity: 0.8;
  }

  .widget a {
    border: 1px solid rgb(116, 116, 116);
    color: #fff0f9;
    opacity: 0.6;
  }

  .widget a:hover {
    border: 1px solid rgb(156, 156, 156);
    opacity: 0.9;
  }

  span > i {
    font-size: smaller;
  }

  footer .item.social {
    border-top: 1px solid #3e3b3d;
  }

  footer .item.social > a {
    width: 35px;
    height: 35px;
    box-shadow: 0 0 0 1px rgba(255, 255, 255, 0.4);
    opacity: 0.75;
    color: rgb(255, 238, 249);
    line-height: 35px;
  }

  footer .item.social > a:hover {
    box-shadow: 0 0 0 2px rgba(255, 255, 255, 0.4);
  }

  @media (max-width: 767px) {
    footer .item:not(.social) {
      text-align: center;
      padding-bottom: 18px;
    }
  }

  @media (max-width: 767px) {
    footer .item.text {
      margin-bottom: 20px;
    }
  }

  @media (max-width: 991px) {
    footer .item.social {
      text-align: center;
      margin-top: 20px;
    }
  }
</style>

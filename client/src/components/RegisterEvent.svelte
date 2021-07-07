<script>
  import Banner from "../utils/Banner.svelte";
  import { Link } from "svelte-routing";

  export let title = "Dog Adoption and Care · Events";

  let message = "Register";
  let imgSrc = "images/register.jpg";
</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>


<div>
  <Banner {message} {imgSrc} />

    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-body">
                        <form name="my-form" method="">
                            <div class="form-group row">
                                <label for="firstname" class="col-md-4 col-form-label text-md-right">First Name</label>
                                <div class="col-md-6">
                                    <input type="text" id="full_name" class="form-control" name="firstname">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="lastname" class="col-md-4 col-form-label text-md-right">Last Name</label>
                                <div class="col-md-6">
                                    <input type="text" id="full_name" class="form-control" name="lastname">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="contact" class="col-md-4 col-form-label text-md-right">Contact No.</label>
                                <div class="col-md-6">
                                  	<input type="text" id="full_name" class="form-control" name="contact">
                                </div>
                            </div>

                            <button
                              type="submit"
                              on:click|preventDefault = {addPost}
                              class="btn btn-primary" >
                              Post
                            </button>
                        </form>
                   </div>
                </div>
            </div>
        </div>
    </div>
  
</div>
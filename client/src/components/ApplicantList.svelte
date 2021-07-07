<script>
  import { onMount } from "svelte";
  import Banner from "../utils/Banner.svelte";
  import { user } from "../stores/user";

  let currentUser = {}
  user.subscribe((n) => {
      if (n) currentUser = n;
  });

  let applicants = []
  onMount(async function () {
      try {
        const response = await fetch(`/api/applicant/`, {
          method: "get",
           headers: {
              Authorization: currentUser.type + " " + currentUser.token
           },
        });
        applicants = await response.json();


      } catch (err) {
          console.log(err)
      }
  });

</script>

<style>
    .but{
      margin-left: 80%;
      display: inline-block;
    }

    h2 {
    padding: 1em 0;
    margin-left: 30%;

    }

  </style>

  <h2>Adoption Applicants:</h2>
<div class="list-group ">
    {#each applicants as applicant}
    <a href="#" class="list-group-item list-group-item-action" aria-current="true">
    <div class="d-flex w-100 justify-content-between">
     <h5 class="mb-1">{applicant.applicantName}</h5>
    </div>
    <p class="mb-1">{applicant.dogId}</p>
    <p class="mb-1">{applicant.address}</p>
    <div class="but">
    <button type="button" class="btn btn-primary">Accept</button>
      <button type="button" class="btn btn-primary">Reject</button>
    </div>
  </a>
    {/each}

</div>
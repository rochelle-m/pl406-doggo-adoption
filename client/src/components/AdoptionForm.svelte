<script>
  import Banner from "../utils/Banner.svelte";
  import { onMount } from "svelte";
    import axios from "axios";
  export let title = "Dog Adoption and Care · Events";
  let message = "Apply for Adoption";
  let imgSrc = "images/dog2.jpg";
  import { user } from "../stores/user";

  export let doggo

  let isStaff = false;

  let currentUser = {};
    user.subscribe((updatedUser) => {
      if (updatedUser) {
        currentUser = updatedUser;
         isStaff = updatedUser.roles.some((role) => role == "ROLE_STAFF");
      }
  });

  const URL = `/api/applicant/`;

  let applicant = {
    dogId: '',
    applicantName: '',
    phoneNumber: '',
    address: '',
    occupation: '',
    ownPet: '',
    allergy: '',
    noOfAdults: '',
    noOfChildren: '',
    typeOfHome: '',
    describeHome: '',
    reasonToAdopt: '',
    haveTime:'',
    agreement: '',
    username: null
  };

  let addApplicant = async(event) =>{
  event.preventDefault()


  if(currentUser.isLoggedIn) {
    applicant.username= currentUser.username
    applicant.dogId = doggo.id

    try {
      const response = await fetch(URL, {
        method: "post",
        headers: {
          Authorization: currentUser.type + " " + currentUser.token,
           'Content-Type': 'application/json; charset=utf-8',
            'Accept': 'application/json'
        },
         body: JSON.stringify(applicant)
      });

      const createdApplicant= await response.json()
      console.log(createdApplicant)

    } catch (err) {
      console.log(err);
    }

  }

  };

let applicants = []
onMount(async function () {
    try {
      const response = await fetch(URL);
      applicants = await response.json();
      console.log(applicants)
    } catch (err) {
        console.log(err)
    }
  });


</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<div>

  <form on:submit|preventDefault={addApplicant}>
<div class="container mt-3">
    
    <div class="form-group">
      <label for="name">Applicant name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name"  bind:value={applicant.applicantName}>
    </div>
    <div class="form-group">
      <label for="phoneNumber">Phone number:</label>
     <input type="text" class="form-control" placeholder="Phone number" bind:value={applicant.phoneNumber} required  >
    </div>
     <div class="form-group">
      <label for="address">Address:</label>
       <input type="text" class="form-control" placeholder="Address" bind:value={applicant.address} required >
    </div>
     <div class="form-group">
      <label>Occupation:</label>
      <input type="text" class="form-control" placeholder="Occupation" bind:value={applicant.occupation} required> 
    </div>
    

    <label  for="ownPet">Have you previously owned pets? </label>
    <div class="form-check">
   
  <input class="form-check-input" type="radio" bind:group={applicant.ownPet} value="Yes" />
  <label class="form-check-label" for="exampleRadios1">
    Yes
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" bind:group={applicant.ownPet} value="No" />
  <label class="form-check-label" for="exampleRadios2">
    No
  </label>
</div>

 <label  for="allergy">Does anyone in the family have known allergy to dogs? </label>
    <div class="form-check">
   
  <input class="form-check-input" type="radio" bind:group={applicant.allergy} value="Yes" />
  <label class="form-check-label" for="exampleRadios1">
    Yes
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" bind:group={applicant.allergy} value="No" />
  <label class="form-check-label" for="exampleRadios2">
    No
  </label>
</div>

<div class="form-group">
       <label  for="noOfAdults">How many adults are there in your family?(18+)</label>
      <input type="number" class="form-control" placeholder="Number of Adults" bind:value={applicant.noOfAdults} required> 
    </div>


    <div class="form-group">
       <label  for="noOfChildren">How many children are there in your family? </label>
      <input type="number" class="form-control" placeholder="Number of Children" bind:value={applicant.noOfChildren} required> 
    </div>

 <label  for="typeOfHome">What type of home do you live in? </label>
    <div class="form-check">
  <input class="form-check-input" type="radio" bind:group={applicant.typeOfHome} value="House" />
  <label class="form-check-label" for="exampleRadios1">
    House
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" bind:group={applicant.typeOfHome} value="No" />
  <label class="form-check-label" for="exampleRadios2">
    Flat
  </label>
</div>
<div class="form-check">
   
  <input class="form-check-input" type="radio" bind:group={applicant.typeOfHome} value="Yes" />
  <label class="form-check-label" for="exampleRadios2">
    Bunglow
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" bind:group={applicant.typeOfHome} value="No" />
  <label class="form-check-label" for="exampleRadios4">
    Hut
  </label>
</div>

<label  for="describeHome">Please describe your household:</label>
    <div class="form-check">
  <input class="form-check-input" type="radio" bind:group={applicant.describeHome} value="Active" />
  <label class="form-check-label" for="exampleRadios1">
    Active
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" bind:group={applicant.describeHome} value="Noisy" />
  <label class="form-check-label" for="exampleRadios2">
    Noisy
  </label>
</div>
<div class="form-check">
   
  <input class="form-check-input" type="radio" bind:group={applicant.describeHome} value="Quiet" />
  <label class="form-check-label" for="exampleRadios3">
    Quiet
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" bind:group={applicant.describeHome} value="Average" />
  <label class="form-check-label" for="exampleRadios4">
    Average
  </label>
</div>

 <label  for="reasonToAdopt">Why do you want to adopt this pet? </label>
<div class="form-check ">
   <input class="form-check-input" type="checkbox" bind:group={applicant.reasonToAdopt} value="companionForSelf" /> 
  <label class="form-check-label" for="flexCheckDefault">
    Companion For Self
  </label>
</div>
<div class="form-check">
    <input class="form-check-input" type="checkbox" bind:group={applicant.reasonToAdopt} value="companionForChild" /> 
  <label class="form-check-label" for="flexCheckDefault">
    Companion For Child
  </label>
</div>
<div class="form-check ">
     <input class="form-check-input" type="checkbox" bind:group={applicant.reasonToAdopt} value="companionForOtherDog" /> Companion For Other Dog
  <label class="form-check-label" for="flexCheckDefault">
   Companion For Other Dog
  </label>
</div>
<div class="form-check ">
     <input class="form-check-input" type="checkbox" bind:group={applicant.reasonToAdopt} value="security" /> 
  <label class="form-check-label" for="flexCheckDefault">
    Security
  </label>
</div>
<div class="form-check">
     <input class="form-check-input" type="checkbox" bind:group={applicant.reasonToAdopt} value="housePet" /> 
  <label class="form-check-label" for="flexCheckDefault">
    House Pet
  </label>
</div>


<label  for="haveTime">Do you have enough time to provide adequate love and affection? </label>
    <div class="form-check">
   
  <input class="form-check-input" type="radio" bind:group={applicant.haveTime} value="Yes" />
  <label class="form-check-label" for="exampleRadios1">
    Yes
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" bind:group={applicant.haveTime} value="No" />
  <label class="form-check-label" for="exampleRadios2">
    No
  </label>
</div>

<label  for="agreement">Is everyone in agreement with the decision to adopt a dog?</label>
    <div class="form-check">
   
  <input class="form-check-input" type="radio" bind:group={applicant.agreement} value="Yes" />
  <label class="form-check-label" for="exampleRadios1">
    Yes
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" bind:group={applicant.agreement} value="No" />
  <label class="form-check-label" for="exampleRadios2">
    No
  </label>
</div>
<br>

    <button type="submit" class="btn btn-primary">Submit</button>
</div>
  </form>
</div>

<style>


h2 {
    padding: 1em 0;
    text-align: center;
  }

  form{
    background-color: #cfab95;
    padding: 2em;
  }

  button{
    margin-left: 45%;
  }

  .container{
    

       display: block;
       margin: 0 auto;
       text-align: left;
  
}

div + label {
  font-weight: 600;
}
</style>


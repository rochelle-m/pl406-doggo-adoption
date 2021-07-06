<script>
  import Banner from "../utils/Banner.svelte";

  export let title = "Dog Adoption and Care · Events";

  let message = "Apply for Adoption";
  let imgSrc = "images/dog2.jpg";

let dogId=""
let name = ""
let phoneNumber = ""
let address = ""
let occupation = ""
let ownPet = ""
let allergy = ""
let noOfAdults= ""
let noOfChildren = ""
let typeOfHome = ""
let describeHome = ""
let reasonToAdopt = ""
let haveTime = ""
let agreement = ""


</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<div>
  <Banner {message} {imgSrc} />

  <br><br>


  <h2>Adoption Application</h2>
  <form action="/action_page.php">
<div class="container">
    <div class="form-group">
      <div id="dogId">
      <label for="dogId"><b>Dog Id:</b></label>
      <input type="text" class="form-control" id="dogId"  bind:value={dogId}>
  </div>
    </div>

    <div class="form-group">
      <label for="name"><b>Name:</b></label>
      <input type="text" class="form-control" id="name" placeholder="Enter name"  bind:value={name}>
    </div>
    <div class="form-group">
      <label for="phoneNumber"><b>Phone number:</b></label>
     <input type="text" class="form-control" placeholder="Phone number" bind:value={phoneNumber} required  pattern="[789][0-9]{9}">
    </div>
     <div class="form-group">
      <label for="address"><b>Address:</b></label>
       <input type="text" class="form-control" placeholder="Address" bind:value={address} required pattern="^[a-zA-Z]+([\s][a-zA-Z]+)+$">
    </div>
     <div class="form-group">
      <label><b>Occupation:</b></label>
      <input type="text" class="form-control" placeholder="Occupation" bind:value={occupation} required> 
    </div>
    

    <label  for="ownPet"><b>Have you previously owned pets? </b></label>
    <div class="form-check">
   
  <input class="form-check-input" type="radio" bind:group={ownPet} value="Yes" />
  <label class="form-check-label" for="exampleRadios1">
    Yes
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" bind:group={ownPet} value="No" />
  <label class="form-check-label" for="exampleRadios2">
    No
  </label>
</div>

 <label  for="allergy"><b>Does anyone in the family have known allergy to dogs? </b></label>
    <div class="form-check">
   
  <input class="form-check-input" type="radio" bind:group={allergy} value="Yes" />
  <label class="form-check-label" for="exampleRadios1">
    Yes
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" bind:group={allergy} value="No" />
  <label class="form-check-label" for="exampleRadios2">
    No
  </label>
</div>

<div class="form-group">
       <label  for="noOfAdults"><b>How many adults are there in your family?(18+)</b></label>
      <input type="number" class="form-control" placeholder="Number of Adults" bind:value={noOfAdults} required> 
    </div>


    <div class="form-group">
       <label  for="noOfChildren"><b>How many children are there in your family? </b></label>
      <input type="number" class="form-control" placeholder="Number of Children" bind:value={noOfChildren} required> 
    </div>

 <label  for="typeOfHome"><b>What type of home do you live in? </b></label>
    <div class="form-check">
  <input class="form-check-input" type="radio" bind:group={typeOfHome} value="House" />
  <label class="form-check-label" for="exampleRadios1">
    House
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" bind:group={typeOfHome} value="No" />
  <label class="form-check-label" for="exampleRadios2">
    Flat
  </label>
</div>
<div class="form-check">
   
  <input class="form-check-input" type="radio" bind:group={typeOfHome} value="Yes" />
  <label class="form-check-label" for="exampleRadios2">
    Bunglow
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" bind:group={typeOfHome} value="No" />
  <label class="form-check-label" for="exampleRadios4">
    Hut
  </label>
</div>

<label  for="describeHome"><b>Please describe your household: </b></label>
    <div class="form-check">
  <input class="form-check-input" type="radio" bind:group={describeHome} value="Active" />
  <label class="form-check-label" for="exampleRadios1">
    Active
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" bind:group={describeHome} value="Noisy" />
  <label class="form-check-label" for="exampleRadios2">
    Noisy
  </label>
</div>
<div class="form-check">
   
  <input class="form-check-input" type="radio" bind:group={describeHome} value="Quiet" />
  <label class="form-check-label" for="exampleRadios3">
    Quiet
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" bind:group={describeHome} value="Average" />
  <label class="form-check-label" for="exampleRadios4">
    Average
  </label>
</div>

 <label  for="reasonToAdopt"><b>Why do you want to adopt this pet? </b></label>
<div class="form-check ">
   <input class="form-check-input" type="checkbox" bind:group={reasonToAdopt} value="companionForSelf" /> 
  <label class="form-check-label" for="flexCheckDefault">
    Companion For Self
  </label>
</div>
<div class="form-check">
    <input class="form-check-input" type="checkbox" bind:group={reasonToAdopt} value="companionForChild" /> 
  <label class="form-check-label" for="flexCheckDefault">
    Companion For Child
  </label>
</div>
<div class="form-check ">
     <input class="form-check-input" type="checkbox" bind:group={reasonToAdopt} value="companionForOtherDog" /> Companion For Other Dog
  <label class="form-check-label" for="flexCheckDefault">
   Companion For Other Dog
  </label>
</div>
<div class="form-check ">
     <input class="form-check-input" type="checkbox" bind:group={reasonToAdopt} value="security" /> 
  <label class="form-check-label" for="flexCheckDefault">
    Security
  </label>
</div>
<div class="form-check">
     <input class="form-check-input" type="checkbox" bind:group={reasonToAdopt} value="housePet" /> 
  <label class="form-check-label" for="flexCheckDefault">
    House Pet
  </label>
</div>


<label  for="haveTime"><b>Do you have enough time to provide adequate love and affection?  </b></label>
    <div class="form-check">
   
  <input class="form-check-input" type="radio" bind:group={haveTime} value="Yes" />
  <label class="form-check-label" for="exampleRadios1">
    Yes
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" bind:group={haveTime} value="No" />
  <label class="form-check-label" for="exampleRadios2">
    No
  </label>
</div>

<label  for="agreement"><b>Is everyone in agreement with the decision to adopt a dog?   </b></label>
    <div class="form-check">
   
  <input class="form-check-input" type="radio" bind:group={agreement} value="Yes" />
  <label class="form-check-label" for="exampleRadios1">
    Yes
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" bind:group={agreement} value="No" />
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


  #dogId {
    display : none;
  }
body{
margin-right: 10em;
margin-left:10em;
}

h2 {
    padding: 1em 0;
    margin-left: 30%;
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
  
}
</style>

